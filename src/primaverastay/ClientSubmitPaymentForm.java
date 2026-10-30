/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class ClientSubmitPaymentForm extends javax.swing.JFrame {
private int clientId;
private int reservationId;
    /**
     * Creates new form ClientSubmitPaymentForm
     */
    public ClientSubmitPaymentForm() {
        initComponents();
        
        applyPaymentSubmissionDesign();
    }
    
    public ClientSubmitPaymentForm(int clientId, int reservationId) {
    this();

    this.clientId = clientId;
    this.reservationId = reservationId;

    txtReservationID.setText(String.valueOf(reservationId));
    loadPaymentDetails();
    
}
    
    
private void applyPaymentSubmissionDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color border = new java.awt.Color(220, 230, 240);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);

    // WINDOW
    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.BorderLayout());

    pnlMain.removeAll();
    pnlMain.setLayout(new java.awt.BorderLayout());
    pnlMain.setBackground(bg);

    // HEADER
    jPanel1.removeAll();
    jPanel1.setLayout(new java.awt.GridLayout(2, 1, 0, 3));
    jPanel1.setBackground(navy);
    jPanel1.setPreferredSize(new java.awt.Dimension(0, 82));
    jPanel1.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(14, 35, 14, 35)
    );

    lblBrandTitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 25)
    );
    lblBrandTitle.setForeground(java.awt.Color.WHITE);

    lblHeaderSubtitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13)
    );
    lblHeaderSubtitle.setForeground(
        new java.awt.Color(219, 234, 254)
    );

    jPanel1.add(lblBrandTitle);
    jPanel1.add(lblHeaderSubtitle);

    // PAYMENT CARD
    pnlPaymentDetails.removeAll();
    pnlPaymentDetails.setLayout(
        new java.awt.BorderLayout(0, 22)
    );
    pnlPaymentDetails.setBackground(java.awt.Color.WHITE);
    pnlPaymentDetails.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                28, 32, 28, 32
            )
        )
    );

    javax.swing.JPanel heading = new javax.swing.JPanel();
    heading.setOpaque(false);
    heading.setLayout(new javax.swing.BoxLayout(
        heading, javax.swing.BoxLayout.Y_AXIS
    ));

    lblPaymentTitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 23)
    );
    lblPaymentTitle.setForeground(navy);
    lblPaymentTitle.setAlignmentX(
        java.awt.Component.LEFT_ALIGNMENT
    );

    lblPaymentInstruction.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
    );
    lblPaymentInstruction.setForeground(muted);
    lblPaymentInstruction.setAlignmentX(
        java.awt.Component.LEFT_ALIGNMENT
    );

    heading.add(lblPaymentTitle);
    heading.add(javax.swing.Box.createVerticalStrut(7));
    heading.add(lblPaymentInstruction);

    pnlPaymentDetails.add(heading, java.awt.BorderLayout.NORTH);

    // FORM FIELDS
    javax.swing.JPanel fields = new javax.swing.JPanel(
        new java.awt.GridLayout(3, 2, 22, 20)
    );
    fields.setOpaque(false);

    addPaymentInput(fields, lblReservationID, txtReservationID);
    addPaymentInput(fields, lblRequiredDeposit, txtRequiredDeposit);
    addPaymentInput(fields, lblRemainingBalance, txtRemainingBalance);
    addPaymentInput(fields, lblPaymentMethod, cmbPaymentMethod);
    addPaymentInput(fields, lblAmountPaid, txtAmountPaid);
    addPaymentInput(fields, lblReferenceNumber, txtReferenceNumber);

    pnlPaymentDetails.add(fields, java.awt.BorderLayout.CENTER);

    // READ-ONLY FIELDS
    txtReservationID.setEditable(false);
    txtRequiredDeposit.setEditable(false);
    txtRemainingBalance.setEditable(false);

    txtReservationID.setBackground(bg);
    txtRequiredDeposit.setBackground(bg);
    txtRemainingBalance.setBackground(bg);

    // ACTION BUTTONS
    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 0)
    );
    actions.setOpaque(false);

    btnCancel.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );
    btnCancel.setBackground(
        new java.awt.Color(232, 240, 251)
    );
    btnCancel.setForeground(navy);
    btnCancel.setFocusPainted(false);
    btnCancel.setPreferredSize(
        new java.awt.Dimension(120, 43)
    );

    btnSubmitPayment.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );
    btnSubmitPayment.setBackground(blue);
    btnSubmitPayment.setForeground(java.awt.Color.WHITE);
    btnSubmitPayment.setFocusPainted(false);
    btnSubmitPayment.setPreferredSize(
        new java.awt.Dimension(225, 43)
    );

    actions.add(btnCancel);
    actions.add(btnSubmitPayment);

    pnlPaymentDetails.add(actions, java.awt.BorderLayout.SOUTH);

    // CENTER CARD
    javax.swing.JPanel center = new javax.swing.JPanel(
        new java.awt.GridBagLayout()
    );
    center.setBackground(bg);
    center.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(
            24, 25, 24, 25
        )
    );

    java.awt.GridBagConstraints gbc =
        new java.awt.GridBagConstraints();

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

    pnlPaymentDetails.setPreferredSize(
        new java.awt.Dimension(850, 420)
    );

    center.add(pnlPaymentDetails, gbc);

    javax.swing.JScrollPane scroll =
        new javax.swing.JScrollPane(center);
    scroll.setBorder(null);
    scroll.getVerticalScrollBar().setUnitIncrement(18);

    pnlMain.add(jPanel1, java.awt.BorderLayout.NORTH);
    pnlMain.add(scroll, java.awt.BorderLayout.CENTER);

    getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

    // IMPORTANT: CLOSING THIS FORM DOES NOT EXIT CLIENT PORTAL
    setDefaultCloseOperation(
        javax.swing.WindowConstants.DISPOSE_ON_CLOSE
    );

    setSize(1050, 680);
    setLocationRelativeTo(null);

    getContentPane().revalidate();
    getContentPane().repaint();
}

private void addPaymentInput(
        javax.swing.JPanel container,
        javax.swing.JLabel label,
        javax.swing.JComponent input) {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    javax.swing.JPanel field = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 7)
    );
    field.setOpaque(false);

    label.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13)
    );
    label.setForeground(navy);

    input.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
    );
    input.setPreferredSize(
        new java.awt.Dimension(250, 40)
    );
    input.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                7, 12, 7, 12
            )
        )
    );

    field.add(label, java.awt.BorderLayout.NORTH);
    field.add(input, java.awt.BorderLayout.CENTER);

    container.add(field);
}

    
    private void loadPaymentDetails() {

    String sql =
        "SELECT r.required_deposit, r.total_amount, "
      + "COALESCE(SUM(CASE WHEN p.payment_status = 'Verified' "
      + "THEN p.amount ELSE 0 END), 0) AS amount_paid "
      + "FROM reservations r "
      + "LEFT JOIN payments p "
      + "ON r.reservation_id = p.reservation_id "
      + "WHERE r.reservation_id = ? AND r.client_id = ? "
      + "AND r.is_archived = 0 "
      + "GROUP BY r.reservation_id, "
      + "r.required_deposit, r.total_amount";

    try (java.sql.Connection conn =
            DatabaseConnection.getConnection();
         java.sql.PreparedStatement pst =
            conn.prepareStatement(sql)) {

        pst.setInt(1, reservationId);
        pst.setInt(2, clientId);

        try (java.sql.ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {

                double deposit = rs.getDouble("required_deposit");
                double total = rs.getDouble("total_amount");
                double paid = rs.getDouble("amount_paid");

                double balance = Math.max(total - paid, 0);

                txtRequiredDeposit.setText(
                    String.format("₱%,.2f", deposit));

                txtRemainingBalance.setText(
                    String.format("₱%,.2f", balance));

            } else {
                javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Reservation not found.");

                btnSubmitPayment.setEnabled(false);
            }
        }

    } catch (java.sql.SQLException e) {

        javax.swing.JOptionPane.showMessageDialog(
            this,
            "Error loading payment details: " + e.getMessage());

        btnSubmitPayment.setEnabled(false);
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
        jPanel1 = new javax.swing.JPanel();
        lblBrandTitle = new javax.swing.JLabel();
        lblHeaderSubtitle = new javax.swing.JLabel();
        pnlPaymentDetails = new javax.swing.JPanel();
        lblPaymentTitle = new javax.swing.JLabel();
        lblPaymentInstruction = new javax.swing.JLabel();
        lblReservationID = new javax.swing.JLabel();
        txtReservationID = new javax.swing.JTextField();
        lblRequiredDeposit = new javax.swing.JLabel();
        txtRequiredDeposit = new javax.swing.JTextField();
        lblRemainingBalance = new javax.swing.JLabel();
        txtRemainingBalance = new javax.swing.JTextField();
        lblPaymentMethod = new javax.swing.JLabel();
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        lblAmountPaid = new javax.swing.JLabel();
        txtAmountPaid = new javax.swing.JTextField();
        lblReferenceNumber = new javax.swing.JLabel();
        txtReferenceNumber = new javax.swing.JTextField();
        btnSubmitPayment = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(244, 248, 252));

        jPanel1.setBackground(new java.awt.Color(30, 58, 95));

        lblBrandTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBrandTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblBrandTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBrandTitle.setText("PrimaveraStay");

        lblHeaderSubtitle.setForeground(new java.awt.Color(220, 230, 240));
        lblHeaderSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHeaderSubtitle.setText("CLIENT PAYMENT SUBMISSION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBrandTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeaderSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(391, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblBrandTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHeaderSubtitle)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pnlPaymentDetails.setBackground(new java.awt.Color(255, 255, 255));

        lblPaymentTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblPaymentTitle.setForeground(new java.awt.Color(30, 58, 96));
        lblPaymentTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPaymentTitle.setText("Submit Payment");

        lblPaymentInstruction.setForeground(new java.awt.Color(107, 128, 150));
        lblPaymentInstruction.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPaymentInstruction.setText("Enter your payment details below.");

        lblReservationID.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblReservationID.setForeground(new java.awt.Color(30, 58, 95));
        lblReservationID.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReservationID.setText("Reservation ID");

        txtReservationID.setEditable(false);
        txtReservationID.setBackground(new java.awt.Color(244, 248, 252));
        txtReservationID.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtReservationID.setForeground(new java.awt.Color(30, 58, 252));
        txtReservationID.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lblRequiredDeposit.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblRequiredDeposit.setForeground(new java.awt.Color(30, 58, 95));
        lblRequiredDeposit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRequiredDeposit.setText("Required Deposit (30%)");

        txtRequiredDeposit.setEditable(false);
        txtRequiredDeposit.setBackground(new java.awt.Color(244, 248, 252));
        txtRequiredDeposit.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtRequiredDeposit.setForeground(new java.awt.Color(30, 58, 95));
        txtRequiredDeposit.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        lblRemainingBalance.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblRemainingBalance.setForeground(new java.awt.Color(30, 58, 95));
        lblRemainingBalance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRemainingBalance.setText("Remaining Balance");

        txtRemainingBalance.setEditable(false);
        txtRemainingBalance.setBackground(new java.awt.Color(244, 248, 252));
        txtRemainingBalance.setForeground(new java.awt.Color(30, 58, 95));
        txtRemainingBalance.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtRemainingBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRemainingBalanceActionPerformed(evt);
            }
        });

        lblPaymentMethod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPaymentMethod.setForeground(new java.awt.Color(30, 58, 96));
        lblPaymentMethod.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPaymentMethod.setText("Payment Method");

        cmbPaymentMethod.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        cmbPaymentMethod.setForeground(new java.awt.Color(30, 58, 95));
        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Payment Method", "GCash", "Maya", "Bank Transfer" }));

        lblAmountPaid.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblAmountPaid.setForeground(new java.awt.Color(30, 58, 95));
        lblAmountPaid.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAmountPaid.setText("Amount Paid (₱)");

        txtAmountPaid.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtAmountPaid.setForeground(new java.awt.Color(30, 58, 95));
        txtAmountPaid.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtAmountPaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountPaidActionPerformed(evt);
            }
        });

        lblReferenceNumber.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblReferenceNumber.setForeground(new java.awt.Color(30, 58, 95));
        lblReferenceNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReferenceNumber.setText("Reference Number");

        txtReferenceNumber.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtReferenceNumber.setForeground(new java.awt.Color(30, 58, 95));
        txtReferenceNumber.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        btnSubmitPayment.setBackground(new java.awt.Color(59, 130, 246));
        btnSubmitPayment.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSubmitPayment.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmitPayment.setText("Submit for Verification");
        btnSubmitPayment.setBorderPainted(false);
        btnSubmitPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmitPayment.setFocusPainted(false);
        btnSubmitPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitPaymentActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(232, 240, 251));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(30, 58, 95));
        btnCancel.setText("Cancel");
        btnCancel.setBorderPainted(false);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setFocusPainted(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPaymentDetailsLayout = new javax.swing.GroupLayout(pnlPaymentDetails);
        pnlPaymentDetails.setLayout(pnlPaymentDetailsLayout);
        pnlPaymentDetailsLayout.setHorizontalGroup(
            pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentDetailsLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaymentMethod)
                    .addComponent(lblReferenceNumber)
                    .addComponent(lblPaymentTitle)
                    .addComponent(lblPaymentInstruction, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReservationID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRequiredDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtReservationID, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRemainingBalance)
                    .addComponent(lblAmountPaid)
                    .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.Alignment.LEADING, 0, 220, Short.MAX_VALUE)
                        .addComponent(txtRemainingBalance, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtRequiredDeposit, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(pnlPaymentDetailsLayout.createSequentialGroup()
                        .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtReferenceNumber, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAmountPaid, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(50, 50, 50)
                        .addComponent(btnSubmitPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        pnlPaymentDetailsLayout.setVerticalGroup(
            pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentDetailsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblPaymentTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPaymentInstruction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReservationID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReservationID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRequiredDeposit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRequiredDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRemainingBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRemainingBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPaymentMethod)
                .addGap(18, 18, 18)
                .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAmountPaid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblReferenceNumber)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtReferenceNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnlPaymentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSubmitPayment, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPaymentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(487, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPaymentDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
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

    private void txtRemainingBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRemainingBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRemainingBalanceActionPerformed

    private void txtAmountPaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountPaidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountPaidActionPerformed

    private void btnSubmitPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitPaymentActionPerformed
        String method = cmbPaymentMethod.getSelectedItem().toString();
String amountText = txtAmountPaid.getText().trim();
String reference = txtReferenceNumber.getText().trim();

if (clientId <= 0 || reservationId <= 0) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Please select a valid reservation first.");
    return;
}

if (method.equals("Select Payment Method")) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Please select a payment method.");
    return;
}

if (amountText.isEmpty() || reference.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Please complete all payment details.");
    return;
}

double amount;

try {
    amount = Double.parseDouble(amountText);
} catch (NumberFormatException e) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Please enter a valid payment amount.");
    return;
}

if (!Double.isFinite(amount) || amount <= 0) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Payment amount must be greater than zero.");
    return;
}

int confirmation = javax.swing.JOptionPane.showConfirmDialog(
    this,
    "Submit this payment for administrator verification?",
    "Confirm Payment Submission",
    javax.swing.JOptionPane.YES_NO_OPTION
);

if (confirmation != javax.swing.JOptionPane.YES_OPTION) {
    return;
}

ClientPaymentDAO dao = new ClientPaymentDAO();

boolean submitted = dao.submitClientPayment(
    clientId,
    reservationId,
    amount,
    method,
    reference
);

if (submitted) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Payment submitted successfully!\n"
        + "Status: Pending Verification.\n"
        + "Your payment will count once verified by the Admin."
    );

    dispose();
} else {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Payment could not be submitted.\n"
        + "Please check the reservation, amount, and pending payments."
    );
}
    }//GEN-LAST:event_btnSubmitPaymentActionPerformed

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
            java.util.logging.Logger.getLogger(ClientSubmitPaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientSubmitPaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientSubmitPaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientSubmitPaymentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientSubmitPaymentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmitPayment;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAmountPaid;
    private javax.swing.JLabel lblBrandTitle;
    private javax.swing.JLabel lblHeaderSubtitle;
    private javax.swing.JLabel lblPaymentInstruction;
    private javax.swing.JLabel lblPaymentMethod;
    private javax.swing.JLabel lblPaymentTitle;
    private javax.swing.JLabel lblReferenceNumber;
    private javax.swing.JLabel lblRemainingBalance;
    private javax.swing.JLabel lblRequiredDeposit;
    private javax.swing.JLabel lblReservationID;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPaymentDetails;
    private javax.swing.JTextField txtAmountPaid;
    private javax.swing.JTextField txtReferenceNumber;
    private javax.swing.JTextField txtRemainingBalance;
    private javax.swing.JTextField txtRequiredDeposit;
    private javax.swing.JTextField txtReservationID;
    // End of variables declaration//GEN-END:variables
}

