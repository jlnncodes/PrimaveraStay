/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class AddReservationForm extends javax.swing.JFrame {
    private java.util.ArrayList<Unit> availableUnits;
    private User loggedInUser;
    private int editingReservationId = -1;
    


    /**
     * Creates new form AddReservationForm
     */
    public AddReservationForm() {
        initComponents();
        txtCheckInTime.setText("02:00 PM");
        txtCheckOutTime.setText("12:00 PM");

        txtCheckInTime.setEditable(false);
        txtCheckOutTime.setEditable(false);
        loadUnits();
        
         txtCheckInDate.getDocument().addDocumentListener(
        new javax.swing.event.DocumentListener() {

            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                calculateReservation();
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                calculateReservation();
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                calculateReservation();
            }
        }
    );

    txtCheckOutDate.getDocument().addDocumentListener(
        new javax.swing.event.DocumentListener() {

            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                calculateReservation();
            }

            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                calculateReservation();
            }

            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                calculateReservation();
            }
        });
    }
    
    private void showDatePicker(javax.swing.JTextField targetField) {

    java.time.LocalDate today = java.time.LocalDate.now();

    javax.swing.JSpinner monthSpinner = new javax.swing.JSpinner(
        new javax.swing.SpinnerDateModel()
    );

    monthSpinner.setEditor(
        new javax.swing.JSpinner.DateEditor(monthSpinner, "MMMM yyyy")
    );

    javax.swing.JPanel calendarPanel = new javax.swing.JPanel(
        new java.awt.BorderLayout(5, 5)
    );

    javax.swing.JPanel daysPanel = new javax.swing.JPanel(
        new java.awt.GridLayout(0, 7, 3, 3)
    );

    String[] dayNames = {
        "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
    };

    Runnable refreshCalendar = () -> {

        daysPanel.removeAll();

        for (String day : dayNames) {
            javax.swing.JLabel label =
                new javax.swing.JLabel(day, javax.swing.SwingConstants.CENTER);
            daysPanel.add(label);
        }

        java.util.Date selectedMonth =
            (java.util.Date) monthSpinner.getValue();

        java.time.LocalDate firstDay =
            selectedMonth.toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate()
                .withDayOfMonth(1);

        int firstDayPosition =
            firstDay.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < firstDayPosition; i++) {
            daysPanel.add(new javax.swing.JLabel(""));
        }

        int daysInMonth = firstDay.lengthOfMonth();

        for (int day = 1; day <= daysInMonth; day++) {
    
       java.time.LocalDate date = firstDay.withDayOfMonth(day);

    javax.swing.JButton dayButton =
        new javax.swing.JButton(String.valueOf(day));

    if (date.isBefore(today)) {
        dayButton.setEnabled(false);
    }

    dayButton.addActionListener(e -> {
        targetField.setText(date.toString());

        java.awt.Window window =
            javax.swing.SwingUtilities.getWindowAncestor(dayButton);

        if (window != null) {
            window.dispose();
        }
    });

    daysPanel.add(dayButton);
}

daysPanel.revalidate();
daysPanel.repaint();
};

monthSpinner.addChangeListener(e -> refreshCalendar.run());

refreshCalendar.run();

calendarPanel.add(monthSpinner, java.awt.BorderLayout.NORTH);
calendarPanel.add(daysPanel, java.awt.BorderLayout.CENTER);

javax.swing.JDialog dialog =
    new javax.swing.JDialog(this, "Select Date", true);

dialog.setContentPane(calendarPanel);
dialog.setSize(450, 350);
dialog.setLocationRelativeTo(this);
dialog.setVisible(true);
}
            
    public AddReservationForm(User loggedInUser) {
    this();
    this.loggedInUser = loggedInUser;
}

public AddReservationForm(User loggedInUser, int reservationId) {
    this(loggedInUser);
    this.editingReservationId = reservationId;
    loadReservationForEditing();
}
    
    private void loadUnits() {

    cmbUnit.removeAllItems();
    cmbUnit.addItem("Select available unit");

    UnitDAO unitDAO = new UnitDAO();
    availableUnits = unitDAO.getAllActiveUnits();

    for (Unit unit : availableUnits) {
        cmbUnit.addItem(
                unit.getUnitNumber() + " - " + unit.getUnitType()
        );
    }
    }  
    private void loadReservationForEditing() {
    ReservationDAO dao = new ReservationDAO();

    java.util.Map<String, Object> data =
            dao.getReservationById(editingReservationId);

    if (data == null) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Reservation could not be found.",
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
        
        dispose();
        return;
    }

    txtGuestName.setText((String) data.get("guestName"));
    txtContactNumber.setText((String) data.get("contactNumber"));

    java.time.LocalDateTime checkIn =
            (java.time.LocalDateTime) data.get("checkIn");

    java.time.LocalDateTime checkOut =
            (java.time.LocalDateTime) data.get("checkOut");

    txtCheckInDate.setText(checkIn.toLocalDate().toString());
    txtCheckOutDate.setText(checkOut.toLocalDate().toString());

    txtCheckInTime.setText("02:00 PM");
    txtCheckOutTime.setText("12:00 PM");

    spnGuests.setValue(data.get("numberOfGuests"));

    int unitId = (Integer) data.get("unitId");

    for (int i = 0; i < availableUnits.size(); i++) {
        if (availableUnits.get(i).getUnitId() == unitId) {
            cmbUnit.setSelectedIndex(i + 1);
            break;
        }
    }

    calculateReservation();
    btnSaveReservation.setText("Update Reservation");
}
    
    private void calculateReservation() {

    try {
        String checkInText = txtCheckInDate.getText().trim();
        String checkOutText = txtCheckOutDate.getText().trim();

        if (checkInText.isEmpty() || checkOutText.isEmpty()) {
            return;
        }

        java.time.LocalDate checkIn =
                java.time.LocalDate.parse(checkInText);

        java.time.LocalDate checkOut =
                java.time.LocalDate.parse(checkOutText);

        long nights = java.time.temporal.ChronoUnit.DAYS.between(
                checkIn, checkOut
        );

        if (nights <= 0) {
            txtNumberOfNights.setText("");
            txtTotalAmount.setText("");
            txtRequiredDeposit.setText("");
            return;
        }

        if (txtPricePerNight.getText().trim().isEmpty()) {
            return;
        }

        double pricePerNight =
                Double.parseDouble(txtPricePerNight.getText());

        double totalAmount = nights * pricePerNight;
        double requiredDeposit = totalAmount * 0.30;

        txtNumberOfNights.setText(String.valueOf(nights));
        txtTotalAmount.setText(String.format("%.2f", totalAmount));
        txtRequiredDeposit.setText(String.format("%.2f", requiredDeposit));

    } catch (Exception e) {
        txtNumberOfNights.setText("");
        txtTotalAmount.setText("");
        txtRequiredDeposit.setText("");
    }
}
    
    private void refreshAvailableUnits() {

    try {
        String checkInDateText = txtCheckInDate.getText().trim();
        String checkInTimeText = txtCheckInTime.getText().trim();
        String checkOutDateText = txtCheckOutDate.getText().trim();
        String checkOutTimeText = txtCheckOutTime.getText().trim();

        if (checkInDateText.isEmpty()
                || checkInTimeText.isEmpty()
                || checkOutDateText.isEmpty()
                || checkOutTimeText.isEmpty()) {
            return;
        }

        java.time.LocalDate checkInDate =
                java.time.LocalDate.parse(checkInDateText);

        java.time.LocalDate checkOutDate =
                java.time.LocalDate.parse(checkOutDateText);

        java.time.format.DateTimeFormatter timeFormatter =
                java.time.format.DateTimeFormatter.ofPattern(
                        "h:mm a",
                        java.util.Locale.ENGLISH
                );

        java.time.LocalTime checkInTime =
                java.time.LocalTime.parse(
                        checkInTimeText.toUpperCase(),
                        timeFormatter
                );

        java.time.LocalTime checkOutTime =
                java.time.LocalTime.parse(
                        checkOutTimeText.toUpperCase(),
                        timeFormatter
                );

        java.time.LocalDateTime checkIn =
                java.time.LocalDateTime.of(checkInDate, checkInTime);

        java.time.LocalDateTime checkOut =
                java.time.LocalDateTime.of(checkOutDate, checkOutTime);

        if (!checkOut.isAfter(checkIn)) {
            return;
        }

        UnitDAO unitDAO = new UnitDAO();
        availableUnits = unitDAO.getAvailableUnits(checkIn, checkOut);

        cmbUnit.removeAllItems();
        cmbUnit.addItem("Select available unit");

        for (Unit unit : availableUnits) {
            cmbUnit.addItem(
                    unit.getUnitNumber() + " - " + unit.getUnitType()
            );
        }

    } catch (Exception e) {
        // Do nothing while the user is still typing.
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtGuestName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCheckInDate = new javax.swing.JTextField();
        txtCheckInTime = new javax.swing.JTextField();
        txtCheckOutDate = new javax.swing.JTextField();
        txtCheckOutTime = new javax.swing.JTextField();
        spnGuests = new javax.swing.JSpinner();
        cmbUnit = new javax.swing.JComboBox<>();
        txtPricePerNight = new javax.swing.JTextField();
        txtNumberOfNights = new javax.swing.JTextField();
        txtTotalAmount = new javax.swing.JTextField();
        txtRequiredDeposit = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSaveReservation = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnCheckInCalendar = new javax.swing.JButton();
        btnCheckOutCalendar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Guest Name:");

        txtGuestName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuestNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Contact Number:");

        jLabel3.setText("Check-In Date:");

        jLabel4.setText("Check-In Time:");

        jLabel5.setText("Check-Out Date:");

        jLabel6.setText("Check-Out Time:");

        jLabel7.setText("Number of Guests:");

        jLabel8.setText("Unit:");

        jLabel9.setText("Price/Night:");

        jLabel10.setText("Number of Nights:");

        jLabel11.setText("Total Amount:");

        jLabel12.setText("Deposit (30%):");

        txtCheckInTime.setEditable(false);
        txtCheckInTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheckInTimeActionPerformed(evt);
            }
        });

        txtCheckOutDate.setEditable(false);

        spnGuests.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));

        cmbUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnitActionPerformed(evt);
            }
        });

        txtPricePerNight.setEditable(false);

        txtNumberOfNights.setEditable(false);

        txtTotalAmount.setEditable(false);

        txtRequiredDeposit.setEditable(false);
        txtRequiredDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRequiredDepositActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSaveReservation.setText("Save Reservation");
        btnSaveReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveReservationActionPerformed(evt);
            }
        });

        jLabel13.setText("HH:MM AM/PM");

        jLabel14.setText("YYYY-MM-DD");

        jLabel15.setText("YYYY-MM-DD");

        jLabel16.setText("HH:MM AM/PM");

        btnCheckInCalendar.setText("📅");
        btnCheckInCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInCalendarActionPerformed(evt);
            }
        });

        btnCheckOutCalendar.setText("📅");
        btnCheckOutCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutCalendarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtGuestName)
                                                .addComponent(txtContactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                                .addComponent(spnGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtCheckInDate)
                                                .addComponent(txtCheckInTime)
                                                .addComponent(txtCheckOutDate)
                                                .addComponent(txtCheckOutTime))
                                            .addComponent(cmbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(txtPricePerNight, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(txtNumberOfNights, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtRequiredDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSaveReservation)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCheckInCalendar)
                            .addComponent(btnCheckOutCalendar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(345, 345, 345))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtGuestName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(btnCheckInCalendar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCheckInTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(btnCheckOutCalendar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCheckOutTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(spnGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9))
                    .addComponent(txtPricePerNight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNumberOfNights, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRequiredDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSaveReservation))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtGuestNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuestNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuestNameActionPerformed

    private void txtCheckInTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheckInTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckInTimeActionPerformed

    private void txtRequiredDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRequiredDepositActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRequiredDepositActionPerformed

    private void cmbUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnitActionPerformed
    int selectedIndex = cmbUnit.getSelectedIndex();

if (selectedIndex > 0 && availableUnits != null) {

    Unit selectedUnit = availableUnits.get(selectedIndex - 1);

    txtPricePerNight.setText(
            String.format("%.2f", selectedUnit.getPricePerNight())
    );

} else {
    txtPricePerNight.setText("");
}
calculateReservation();
    }//GEN-LAST:event_cmbUnitActionPerformed

    private void btnSaveReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveReservationActionPerformed
    try {
    // Basic information
    String guestName = txtGuestName.getText().trim();
    String contactNumber = txtContactNumber.getText().trim();

    // Check required fields
    if (guestName.isEmpty()
            || contactNumber.isEmpty()
            || txtCheckInDate.getText().trim().isEmpty()
            || txtCheckInTime.getText().trim().isEmpty()
            || txtCheckOutDate.getText().trim().isEmpty()
            || txtCheckOutTime.getText().trim().isEmpty()) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please complete all required fields.",
                "Missing Information",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Check selected unit
    int selectedIndex = cmbUnit.getSelectedIndex();

    if (selectedIndex <= 0 || availableUnits == null) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please select an available unit.",
                "No Unit Selected",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    Unit selectedUnit = availableUnits.get(selectedIndex - 1);

    // Number of guests
    int numberOfGuests = (Integer) spnGuests.getValue();

    // Check unit capacity
    if (numberOfGuests > selectedUnit.getCapacity()) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "This unit can only accommodate up to "
                + selectedUnit.getCapacity() + " guest(s).",
                "Guest Capacity Exceeded",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Parse dates
    java.time.LocalDate checkInDate =
            java.time.LocalDate.parse(
                    txtCheckInDate.getText().trim()
            );

    java.time.LocalDate checkOutDate =
            java.time.LocalDate.parse(
                    txtCheckOutDate.getText().trim()
            );

    // 12-hour AM/PM time format
    java.time.format.DateTimeFormatter timeFormatter =
            java.time.format.DateTimeFormatter.ofPattern(
                    "h:mm a",
                    java.util.Locale.ENGLISH
            );

    java.time.LocalTime checkInTime =
            java.time.LocalTime.parse(
                    txtCheckInTime.getText().trim().toUpperCase(),
                    timeFormatter
            );

    java.time.LocalTime checkOutTime =
            java.time.LocalTime.parse(
                    txtCheckOutTime.getText().trim().toUpperCase(),
                    timeFormatter
            );

    java.time.LocalDateTime checkIn =
            java.time.LocalDateTime.of(checkInDate, checkInTime);

    java.time.LocalDateTime checkOut =
            java.time.LocalDateTime.of(checkOutDate, checkOutTime);

    // Check schedule
    if (!checkOut.isAfter(checkIn)) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Check-out must be after check-in.",
                "Invalid Schedule",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    // Make sure a logged-in staff member exists
    if (loggedInUser == null) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Unable to identify the logged-in admin.",
                "Login Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
        return;
    }

    // Calculated amounts
    double pricePerNight = selectedUnit.getPricePerNight();

    long nights = java.time.temporal.ChronoUnit.DAYS.between(
            checkInDate,
            checkOutDate
    );

    if (nights <= 0) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Reservation must be at least one night.",
                "Invalid Dates",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    double totalAmount = nights * pricePerNight;
    double requiredDeposit = totalAmount * 0.30;

    // Save to database
    ReservationDAO reservationDAO = new ReservationDAO(); 
    if (editingReservationId != -1) {

    if (!reservationDAO.isUnitAvailableForEdit(
            selectedUnit.getUnitId(),
            checkIn,
            checkOut,
            editingReservationId)) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "This unit is already reserved for the selected dates.",
                "Unit Unavailable",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    boolean updated = reservationDAO.updateReservation(
            editingReservationId,
            guestName,
            contactNumber,
            selectedUnit.getUnitId(),
            checkIn,
            checkOut,
            numberOfGuests,
            pricePerNight,
            totalAmount,
            requiredDeposit
    );

    if (updated) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Reservation updated successfully!",
                "Update Successful",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        );
        dispose();
    } else {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Reservation could not be updated.",
                "Update Failed",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }

    return;
}
    
   // Prevent double booking for overlapping dates
if (!reservationDAO.isUnitAvailable(
        selectedUnit.getUnitId(), checkIn, checkOut)) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "This unit is already reserved for the selected dates. "
            + "Please choose another unit or different dates.",
            "Unit Unavailable",
            javax.swing.JOptionPane.WARNING_MESSAGE
    );

    return;
}
    boolean saved = reservationDAO.addReservation(
            guestName,
            contactNumber,
            selectedUnit.getUnitId(),
            checkIn,
            checkOut,
            numberOfGuests,
            pricePerNight,
            totalAmount,
            requiredDeposit,
            loggedInUser.getUserId()
    );

    if (saved) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Reservation saved successfully!\n"
                + "Status: Pending\n"
                + "Required Deposit: ₱"
                + String.format("%.2f", requiredDeposit),
                "Reservation Saved",
                javax.swing.JOptionPane.INFORMATION_MESSAGE
        );

        dispose();

    } else {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Reservation could not be saved.",
                "Save Failed",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }

} catch (java.time.format.DateTimeParseException e) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please use the correct date and time format.\n\n"
            + "Date: YYYY-MM-DD\n"
            + "Time: 1:00 PM",
            "Invalid Date or Time",
            javax.swing.JOptionPane.WARNING_MESSAGE
    );

} catch (Exception e) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "An error occurred while saving the reservation.",
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE
    );

    e.printStackTrace();
}
    }//GEN-LAST:event_btnSaveReservationActionPerformed

    private void btnCheckInCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInCalendarActionPerformed
showDatePicker(txtCheckInDate);
    }//GEN-LAST:event_btnCheckInCalendarActionPerformed

    private void btnCheckOutCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutCalendarActionPerformed
showDatePicker(txtCheckOutDate);    }//GEN-LAST:event_btnCheckOutCalendarActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddReservationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddReservationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCheckInCalendar;
    private javax.swing.JButton btnCheckOutCalendar;
    private javax.swing.JButton btnSaveReservation;
    private javax.swing.JComboBox<String> cmbUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner spnGuests;
    private javax.swing.JTextField txtCheckInDate;
    private javax.swing.JTextField txtCheckInTime;
    private javax.swing.JTextField txtCheckOutDate;
    private javax.swing.JTextField txtCheckOutTime;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtGuestName;
    private javax.swing.JTextField txtNumberOfNights;
    private javax.swing.JTextField txtPricePerNight;
    private javax.swing.JTextField txtRequiredDeposit;
    private javax.swing.JTextField txtTotalAmount;
    // End of variables declaration//GEN-END:variables
}
