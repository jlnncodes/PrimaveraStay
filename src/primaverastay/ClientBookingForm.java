/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class ClientBookingForm extends javax.swing.JFrame {
    
    private int clientId;
    private int unitId;

    /**
     * Creates new form ClientBookingForm
     */
    public ClientBookingForm() {
        initComponents();
        applyBookingDesign();
    }
    
    public ClientBookingForm(int clientId, int unitId) {
    this();

    this.clientId = clientId;
    this.unitId = unitId;
    
    loadSelectedUnit();    
    loadClientInformation();
    
    setupDatePickers();

    setTitle("PrimaveraStay - Book a Unit");
    setLocationRelativeTo(null);
    setDefaultCloseOperation(
        javax.swing.WindowConstants.DISPOSE_ON_CLOSE
    );
}
    
    
private void applyBookingDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color border = new java.awt.Color(220, 230, 240);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);

    // MAIN WINDOW
    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.BorderLayout());

    pnlMain.removeAll();
    pnlMain.setLayout(new java.awt.BorderLayout());
    pnlMain.setBackground(bg);

    // HEADER
    pnlHeader.removeAll();
    pnlHeader.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
    pnlHeader.setBackground(navy);
    pnlHeader.setPreferredSize(new java.awt.Dimension(0, 82));
    pnlHeader.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(14, 35, 14, 35)
    );

    lblTitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 25)
    );
    lblTitle.setForeground(java.awt.Color.WHITE);

    lblSubtitle.setText("Create Your Reservation");
    lblSubtitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
    );
    lblSubtitle.setForeground(new java.awt.Color(219, 234, 254));

    pnlHeader.add(lblTitle);
    pnlHeader.add(lblSubtitle);

    // BOOKING CARD
    pnlBookingDetails.removeAll();
    pnlBookingDetails.setLayout(new java.awt.BorderLayout(0, 16));
    pnlBookingDetails.setBackground(java.awt.Color.WHITE);
    pnlBookingDetails.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(22, 28, 22, 28)
        )
    );

    jLabel1.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22)
    );
    jLabel1.setForeground(navy);

    pnlBookingDetails.add(jLabel1, java.awt.BorderLayout.NORTH);

    // FORM FIELDS
    javax.swing.JPanel fields = new javax.swing.JPanel(
        new java.awt.GridLayout(5, 2, 22, 12)
    );
    fields.setOpaque(false);

    addBookingField(fields, jLabel2, txtUnitNumber);
    addBookingField(fields, jLabel13, txtPricePerNight);

    addBookingField(fields, jLabel3, txtGuestName);
    addBookingField(fields, jLabel4, txtContactNumber);

    addBookingField(fields, jLabel5, txtCheckInDate);
    addBookingField(fields, jLabel6, txtCheckOutDate);

    addBookingField(fields, jLabel7, cmbCheckInTime);
    addBookingField(fields, jLabel8, cmbCheckOutTime);

    addBookingField(fields, jLabel9, spnGuests);
    addBookingField(fields, jLabel10, txtNights);

    javax.swing.JPanel formBody = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 18)
    );
    formBody.setOpaque(false);
    formBody.add(fields, java.awt.BorderLayout.CENTER);

    // BOOKING SUMMARY
    javax.swing.JPanel summary = new javax.swing.JPanel(
        new java.awt.GridLayout(2, 2, 15, 8)
    );
    summary.setOpaque(false);
    summary.setBorder(
        javax.swing.BorderFactory.createMatteBorder(
            1, 0, 0, 0, border
        )
    );

    jLabel11.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15)
    );
    jLabel11.setForeground(navy);

    jLabel12.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15)
    );
    jLabel12.setForeground(navy);

    txtTotalAmount.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 19)
    );
    txtTotalAmount.setForeground(navy);

    txtRequiredDeposit.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 18)
    );
    txtRequiredDeposit.setForeground(blue);

    txtTotalAmount.setEditable(false);
    txtRequiredDeposit.setEditable(false);
    txtNights.setEditable(false);

    summary.add(jLabel11);
    summary.add(txtTotalAmount);
    summary.add(jLabel12);
    summary.add(txtRequiredDeposit);

    formBody.add(summary, java.awt.BorderLayout.SOUTH);
    pnlBookingDetails.add(formBody, java.awt.BorderLayout.CENTER);

    // BUTTONS
    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 0)
    );
    actions.setOpaque(false);

    btnCancel.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );
    btnCancel.setBackground(java.awt.Color.WHITE);
    btnCancel.setForeground(navy);
    btnCancel.setFocusPainted(false);
    btnCancel.setPreferredSize(new java.awt.Dimension(115, 40));

    btnSubmitReservation.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );
    btnSubmitReservation.setBackground(blue);
    btnSubmitReservation.setForeground(java.awt.Color.WHITE);
    btnSubmitReservation.setFocusPainted(false);
    btnSubmitReservation.setPreferredSize(
        new java.awt.Dimension(200, 40)
    );

    actions.add(btnCancel);
    actions.add(btnSubmitReservation);

    pnlBookingDetails.add(actions, java.awt.BorderLayout.SOUTH);

    // STYLE INPUTS
    javax.swing.JComponent[] inputs = {
        txtUnitNumber, txtPricePerNight, txtGuestName,
        txtContactNumber, txtCheckInDate, txtCheckOutDate,
        cmbCheckInTime, cmbCheckOutTime, spnGuests, txtNights
    };

    for (javax.swing.JComponent input : inputs) {
        input.setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
        );
        input.setPreferredSize(new java.awt.Dimension(250, 36));
        input.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(border),
                javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );
    }

    txtUnitNumber.setBackground(bg);
    txtPricePerNight.setBackground(bg);
    txtNights.setBackground(bg);

    txtCheckInDate.setBackground(new java.awt.Color(239, 246, 255));
    txtCheckOutDate.setBackground(new java.awt.Color(239, 246, 255));

    // CENTER FORM WITH SCROLL SUPPORT
    javax.swing.JPanel center = new javax.swing.JPanel(
        new java.awt.GridBagLayout()
    );
    center.setBackground(bg);
    center.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(18, 18, 18, 18)
    );

    java.awt.GridBagConstraints gbc =
        new java.awt.GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gbc.anchor = java.awt.GridBagConstraints.NORTH;
    gbc.insets = new java.awt.Insets(0, 0, 0, 0);

    pnlBookingDetails.setPreferredSize(
        new java.awt.Dimension(850, 620)
    );

    center.add(pnlBookingDetails, gbc);

    javax.swing.JScrollPane scroll =
        new javax.swing.JScrollPane(center);
    scroll.setBorder(null);
    scroll.getVerticalScrollBar().setUnitIncrement(18);

    pnlMain.add(pnlHeader, java.awt.BorderLayout.NORTH);
    pnlMain.add(scroll, java.awt.BorderLayout.CENTER);

    getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

    setSize(1100, 800);
    setLocationRelativeTo(null);

    getContentPane().revalidate();
    getContentPane().repaint();
}

private void addBookingField(
        javax.swing.JPanel container,
        javax.swing.JLabel label,
        javax.swing.JComponent input) {

    javax.swing.JPanel field = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 6)
    );
    field.setOpaque(false);

    label.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13)
    );
    label.setForeground(new java.awt.Color(30, 58, 95));

    field.add(label, java.awt.BorderLayout.NORTH);
    field.add(input, java.awt.BorderLayout.CENTER);

    container.add(field);
}

    
private double pricePerNight = 0;
private int unitCapacity = 0;

private void loadSelectedUnit() {

    UnitDAO dao = new UnitDAO();

    java.util.ArrayList<Unit> units =
            dao.getAllActiveUnits();

    for (Unit unit : units) {

        if (unit.getUnitId() == unitId) {

            txtUnitNumber.setText(unit.getUnitNumber());

            pricePerNight = unit.getPricePerNight();
            unitCapacity = unit.getCapacity();

            txtPricePerNight.setText(
                String.format("₱%,.2f", pricePerNight)
            );

            txtUnitNumber.setEditable(false);
            txtPricePerNight.setEditable(false);

            return;
        }
    }

    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Selected unit is unavailable or no longer active."
    );

    btnSubmitReservation.setEnabled(false);
}

    private void loadClientInformation() {

    UserDAO dao = new UserDAO();

    User client = dao.getClientById(clientId);

    if (client != null) {

        txtGuestName.setText(client.getFullName());

        txtContactNumber.setText(
                client.getContactNumber()
        );

    } else {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Unable to load client information."
        );

        btnSubmitReservation.setEnabled(false);
    }
}

        
private void setupDatePickers() {

    txtCheckInDate.setEditable(false);
    txtCheckOutDate.setEditable(false);

    txtCheckInDate.setCursor(
            new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    txtCheckOutDate.setCursor(
            new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

    txtCheckInDate.addMouseListener(
        new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                openCheckInCalendar();
            }
        });

    txtCheckOutDate.addMouseListener(
        new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                openCheckOutCalendar();
            }
        });
}

private void openCheckInCalendar() {

    BookingCalendarDialog calendar =
            new BookingCalendarDialog(this, unitId, false, null);

    calendar.setVisible(true);

    java.time.LocalDate selected = calendar.getSelectedDate();

    if (selected != null) {
        txtCheckInDate.setText(selected.toString());
        txtCheckOutDate.setText("");
        txtNights.setText("");
        txtTotalAmount.setText("");
        txtRequiredDeposit.setText("");
    }
}

private void openCheckOutCalendar() {

    if (txtCheckInDate.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Please select a Check-In Date first.");
        return;
    }

    java.time.LocalDate checkIn =
            java.time.LocalDate.parse(txtCheckInDate.getText());

    BookingCalendarDialog calendar =
            new BookingCalendarDialog(this, unitId, true, checkIn);

    calendar.setVisible(true);

    java.time.LocalDate selected = calendar.getSelectedDate();

    if (selected != null) {
        txtCheckOutDate.setText(selected.toString());
        calculateBooking();
    }
}

private void calculateBooking() {

    try {
        java.time.LocalDate checkIn =
                java.time.LocalDate.parse(txtCheckInDate.getText());

        java.time.LocalDate checkOut =
                java.time.LocalDate.parse(txtCheckOutDate.getText());

        long nights = java.time.temporal.ChronoUnit.DAYS
                .between(checkIn, checkOut);

        if (nights <= 0) return;

        double total = nights * pricePerNight;
        double deposit = total * 0.30;

        txtNights.setText(String.valueOf(nights));
        txtTotalAmount.setText(String.format("₱%,.2f", total));
        txtRequiredDeposit.setText(
                String.format("₱%,.2f", deposit));

    } catch (Exception e) {
        txtNights.setText("");
        txtTotalAmount.setText("");
        txtRequiredDeposit.setText("");
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

        pnlMain = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        pnlBookingDetails = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUnitNumber = new javax.swing.JTextField();
        txtPricePerNight = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGuestName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCheckInDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCheckOutDate = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbCheckInTime = new javax.swing.JComboBox<>();
        cmbCheckOutTime = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        spnGuests = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        txtNights = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotalAmount = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtRequiredDeposit = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSubmitReservation = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(244, 248, 252));

        pnlHeader.setBackground(new java.awt.Color(30, 58, 95));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("PrimaveraStay");

        lblSubtitle.setForeground(new java.awt.Color(219, 234, 254));
        lblSubtitle.setText("Create Reservations");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtitle)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pnlBookingDetails.setBackground(new java.awt.Color(255, 255, 255));
        pnlBookingDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 230, 240)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 58, 95));
        jLabel1.setText("Booking Details");

        jLabel2.setText("Unit Number");

        txtUnitNumber.setEditable(false);
        txtUnitNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPricePerNight.setEditable(false);
        txtPricePerNight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setText("Guest Name");

        txtGuestName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setText("Contact Number");

        txtContactNumber.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setText("Check-In Date");

        jLabel6.setText("Check-Out Date");

        jLabel7.setText("Check-In Time");

        jLabel8.setText("Check-Out Time");

        cmbCheckInTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2:00 PM" }));
        cmbCheckInTime.setEnabled(false);

        cmbCheckOutTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12:00 PM" }));
        cmbCheckOutTime.setEnabled(false);

        jLabel9.setText("Number of Guests");

        jLabel10.setText("Number of Nights");

        txtNights.setEditable(false);
        txtNights.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNightsActionPerformed(evt);
            }
        });

        jLabel11.setText("Total Amount");

        txtTotalAmount.setEditable(false);
        txtTotalAmount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel12.setText("Required Deposit");

        txtRequiredDeposit.setEditable(false);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSubmitReservation.setText("Submit Reservation");
        btnSubmitReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitReservationActionPerformed(evt);
            }
        });

        jLabel13.setText("Price per Night");

        javax.swing.GroupLayout pnlBookingDetailsLayout = new javax.swing.GroupLayout(pnlBookingDetails);
        pnlBookingDetails.setLayout(pnlBookingDetailsLayout);
        pnlBookingDetailsLayout.setHorizontalGroup(
            pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBookingDetailsLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlBookingDetailsLayout.createSequentialGroup()
                            .addComponent(spnGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNights, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlBookingDetailsLayout.createSequentialGroup()
                            .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(txtUnitNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtPricePerNight, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtGuestName)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContactNumber)
                        .addGroup(pnlBookingDetailsLayout.createSequentialGroup()
                            .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCheckInDate)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbCheckInTime, 0, 313, Short.MAX_VALUE))
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCheckOutDate)
                                .addComponent(cmbCheckOutTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlBookingDetailsLayout.createSequentialGroup()
                                    .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBookingDetailsLayout.createSequentialGroup()
                            .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtRequiredDeposit, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(txtTotalAmount))))
                    .addGroup(pnlBookingDetailsLayout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmitReservation)))
                .addContainerGap(534, Short.MAX_VALUE))
        );
        pnlBookingDetailsLayout.setVerticalGroup(
            pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBookingDetailsLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnitNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPricePerNight, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGuestName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCheckInDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbCheckOutTime, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(cmbCheckInTime))
                .addGap(18, 18, 18)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNights, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtRequiredDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(pnlBookingDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSubmitReservation))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBookingDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBookingDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNightsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNightsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNightsActionPerformed

    private void btnSubmitReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitReservationActionPerformed
        
try {
    String guestName = txtGuestName.getText().trim();
    String contactNumber = txtContactNumber.getText().trim();

    if (guestName.isEmpty() || contactNumber.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Please complete the guest information.");
        return;
    }

    if (txtCheckInDate.getText().trim().isEmpty()
            || txtCheckOutDate.getText().trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Please select check-in and check-out dates.");
        return;
    }

    java.time.LocalDate checkInDate = java.time.LocalDate.parse(
            txtCheckInDate.getText().trim());

    java.time.LocalDate checkOutDate = java.time.LocalDate.parse(
            txtCheckOutDate.getText().trim());

    java.time.LocalDateTime checkIn = checkInDate.atTime(14, 0);
    java.time.LocalDateTime checkOut = checkOutDate.atTime(12, 0);

    if (!checkIn.isAfter(java.time.LocalDateTime.now())
            || !checkOutDate.isAfter(checkInDate)) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Please select valid future booking dates.");
        return;
    }

    int guests = (Integer) spnGuests.getValue();

    if (guests < 1 || guests > unitCapacity) {
        javax.swing.JOptionPane.showMessageDialog(
                this, "Maximum guests allowed: " + unitCapacity);
        return;
    }

    int confirm = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Submit this reservation?\n\n"
            + "Required down payment: "
            + txtRequiredDeposit.getText()
            + "\n\nCancellation policy:\n"
            + "At least 48 hours before check-in: "
            + "paid deposit is refundable.\n"
            + "Less than 48 hours before check-in: "
            + "paid deposit is nonrefundable.",
            "Confirm Reservation",
            javax.swing.JOptionPane.YES_NO_OPTION);

    if (confirm != javax.swing.JOptionPane.YES_OPTION) {
        return;
    }

    ReservationDAO dao = new ReservationDAO();

    boolean saved = dao.addClientReservation(
            clientId,
            guestName,
            contactNumber,
            unitId,
            checkIn,
            checkOut,
            guests
    );

    if (saved) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Reservation submitted successfully!\n"
                + "Status: Pending\n\n"
                + "You can view it under My Reservations.");
        dispose();
    } else {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Reservation could not be submitted.\n"
                + "Please check availability and booking details.");
    }

} catch (Exception e) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Error: " + e.getMessage());
}
    }//GEN-LAST:event_btnSubmitReservationActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
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
            java.util.logging.Logger.getLogger(ClientBookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientBookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientBookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientBookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientBookingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmitReservation;
    private javax.swing.JComboBox<String> cmbCheckInTime;
    private javax.swing.JComboBox<String> cmbCheckOutTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlBookingDetails;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JSpinner spnGuests;
    private javax.swing.JTextField txtCheckInDate;
    private javax.swing.JTextField txtCheckOutDate;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtGuestName;
    private javax.swing.JTextField txtNights;
    private javax.swing.JTextField txtPricePerNight;
    private javax.swing.JTextField txtRequiredDeposit;
    private javax.swing.JTextField txtTotalAmount;
    private javax.swing.JTextField txtUnitNumber;
    // End of variables declaration//GEN-END:variables
}
