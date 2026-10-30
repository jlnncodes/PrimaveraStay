
package primaverastay;

import java.awt.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.*;
import java.sql.*;

public class BookingCalendarDialog extends JDialog {

    private final int unitId;
    private final boolean checkOutMode;
    private final LocalDate checkInDate;
    private LocalDate selectedDate;
    private YearMonth displayedMonth;
    private final JPanel daysPanel = new JPanel(new GridLayout(0, 7, 5, 5));
    private final JLabel lblMonth = new JLabel("", SwingConstants.CENTER);
    private final java.util.List<LocalDate[]> bookedRanges = new ArrayList<>();

    public BookingCalendarDialog(
            Frame owner, int unitId,
            boolean checkOutMode, LocalDate checkInDate) {

        super(owner, "Select Date", true);

        this.unitId = unitId;
        this.checkOutMode = checkOutMode;
        this.checkInDate = checkInDate;
        this.displayedMonth = YearMonth.now();

        setSize(460, 430);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        loadBookedDates();
        createCalendar();
        refreshCalendar();
    }

    private void loadBookedDates() {

        String sql = "SELECT check_in, check_out FROM reservations "
                + "WHERE unit_id = ? AND is_archived = 0 "
                + "AND reservation_status IN "
                + "('Pending', 'Confirmed', 'Checked In') "
                + "AND check_out > NOW()";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, unitId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LocalDate start = rs.getTimestamp("check_in")
                            .toLocalDateTime().toLocalDate();
                    LocalDate end = rs.getTimestamp("check_out")
                            .toLocalDateTime().toLocalDate();

                    bookedRanges.add(new LocalDate[]{start, end});
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Unable to load availability: " + e.getMessage());
            dispose();
            throw new IllegalStateException(
                    "Unable to load booking availability", e);
        }
    }

    private boolean isBooked(LocalDate date) {
        for (LocalDate[] range : bookedRanges) {
            if (!date.isBefore(range[0]) && date.isBefore(range[1])) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidDate(LocalDate date) {

        if (date.isBefore(LocalDate.now())) return false;

        if (!checkOutMode) {
            return !isBooked(date);
        }

        if (checkInDate == null || !date.isAfter(checkInDate)) {
            return false;
        }

        // All occupied nights between check-in and check-out
        // must be available.
        for (LocalDate d = checkInDate;
                d.isBefore(date); d = d.plusDays(1)) {
            if (isBooked(d)) return false;
        }

        return true;
    }

    private void createCalendar() {

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(244, 248, 252));

        JButton previous = new JButton("<");
        JButton next = new JButton(">");

        previous.addActionListener(e -> {
            displayedMonth = displayedMonth.minusMonths(1);
            refreshCalendar();
        });

        next.addActionListener(e -> {
            displayedMonth = displayedMonth.plusMonths(1);
            refreshCalendar();
        });

        lblMonth.setFont(new Font("Segoe UI", Font.BOLD, 17));
        lblMonth.setForeground(new Color(30, 58, 95));

        header.add(previous, BorderLayout.WEST);
        header.add(lblMonth, BorderLayout.CENTER);
        header.add(next, BorderLayout.EAST);

        daysPanel.setBackground(Color.WHITE);

        JPanel content = new JPanel(new BorderLayout(5, 10));
        content.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        content.setBackground(Color.WHITE);

        content.add(header, BorderLayout.NORTH);
        content.add(daysPanel, BorderLayout.CENTER);

        JLabel legend = new JLabel(
                "Red = Booked     Blue = Available     Gray = Past");
        legend.setForeground(new Color(107, 128, 150));
        content.add(legend, BorderLayout.SOUTH);

        add(content);
    }

    private void refreshCalendar() {

        daysPanel.removeAll();

        lblMonth.setText(displayedMonth.format(
                DateTimeFormatter.ofPattern("MMMM yyyy")));

        String[] weekdays = {
            "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };

        for (String day : weekdays) {
            JLabel label = new JLabel(day, SwingConstants.CENTER);
            label.setFont(new Font("Segoe UI", Font.BOLD, 12));
            daysPanel.add(label);
        }

        int offset = displayedMonth.atDay(1)
                .getDayOfWeek().getValue() - 1;

        for (int i = 0; i < offset; i++) {
            daysPanel.add(new JLabel(""));
        }

        for (int day = 1; day <= displayedMonth.lengthOfMonth(); day++) {

            LocalDate date = displayedMonth.atDay(day);
            JButton button = new JButton(String.valueOf(day));
            button.setFocusPainted(false);
            button.setOpaque(true);

            if (isBooked(date)) {
                button.setBackground(new Color(254, 226, 226));
                button.setForeground(new Color(185, 28, 28));
            } else if (isValidDate(date)) {
                button.setBackground(new Color(219, 234, 254));
                button.setForeground(new Color(30, 58, 95));
            } else {
                button.setBackground(new Color(235, 235, 235));
                button.setForeground(Color.GRAY);
            }

            button.setEnabled(isValidDate(date));

            button.addActionListener(e -> {
                selectedDate = date;
                dispose();
            });

            daysPanel.add(button);
        }

        daysPanel.revalidate();
        daysPanel.repaint();
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }
}

