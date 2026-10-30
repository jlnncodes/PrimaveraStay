/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class MyPaymentsPanel extends javax.swing.JPanel {
    
    private int clientId;

    /**
     * Creates new form MyPaymentsPanel
     */
    public MyPaymentsPanel(int clientId) {
        initComponents();
        applyPaymentsDesign();
        
        this.clientId = clientId;
        
        setBackground(new java.awt.Color(244, 248, 252));

        tblMyPayments.setRowHeight(32);
        tblMyPayments.setShowVerticalLines(false);
        tblMyPayments.setShowHorizontalLines(true);
        tblMyPayments.setGridColor(
            new java.awt.Color(220, 230, 240)
        );

        tblMyPayments.getTableHeader().setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12)
        );

        tblMyPayments.getTableHeader().setBackground(
            new java.awt.Color(232, 240, 251)
        );

        tblMyPayments.getTableHeader().setForeground(
            new java.awt.Color(30, 58, 95)
        );

        tblMyPayments.setDefaultEditor(
            Object.class, null
);
        
        ClientPaymentDAO dao = new ClientPaymentDAO();

        javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel)
        tblMyPayments.getModel();

        dao.loadClientPayments(clientId, model);
        updatePaymentSummary();
    }
    
    
private void applyPaymentsDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color border = new java.awt.Color(220, 230, 240);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);

    // MAIN PANEL
    removeAll();
    setLayout(new java.awt.BorderLayout(0, 24));
    setBackground(bg);
    setBorder(javax.swing.BorderFactory.createEmptyBorder(
        30, 35, 30, 35
    ));

    // HEADING
    javax.swing.JPanel heading = new javax.swing.JPanel();
    heading.setOpaque(false);
    heading.setLayout(new javax.swing.BoxLayout(
        heading, javax.swing.BoxLayout.Y_AXIS
    ));

    lblTitle.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 28
    ));
    lblTitle.setForeground(navy);
    lblTitle.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    lblSubtitle.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.PLAIN, 15
    ));
    lblSubtitle.setForeground(muted);
    lblSubtitle.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    heading.add(lblTitle);
    heading.add(javax.swing.Box.createVerticalStrut(7));
    heading.add(lblSubtitle);

    add(heading, java.awt.BorderLayout.NORTH);

    // PAYMENT SUMMARY CARDS
    javax.swing.JPanel cards = new javax.swing.JPanel(
        new java.awt.GridLayout(1, 3, 18, 0)
    );
    cards.setOpaque(false);

    stylePaymentCard(
        pnlTotalAmount, jLabel1, lblTotalTitle,
        navy, muted, border
    );

    stylePaymentCard(
        pnlAmountPaid, lblPaidTitle, lblPaidValue,
        navy, muted, border
    );

    stylePaymentCard(
        pnlBalance, lblBalanceTitle, lblBalanceValue,
        navy, muted, border
    );

    cards.add(pnlTotalAmount);
    cards.add(pnlAmountPaid);
    cards.add(pnlBalance);

    // PAYMENT HISTORY CARD
    pnlPaymentHistory.removeAll();
    pnlPaymentHistory.setLayout(
        new java.awt.BorderLayout(0, 18)
    );
    pnlPaymentHistory.setBackground(java.awt.Color.WHITE);
    pnlPaymentHistory.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                22, 22, 22, 22
            )
        )
    );

    javax.swing.JPanel historyHeader = new javax.swing.JPanel(
        new java.awt.BorderLayout()
    );
    historyHeader.setOpaque(false);

    lblHistoryTitle.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 19
    ));
    lblHistoryTitle.setForeground(navy);

    btnSubmitPayment.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 13
    ));
    btnSubmitPayment.setBackground(blue);
    btnSubmitPayment.setForeground(java.awt.Color.WHITE);
    btnSubmitPayment.setFocusPainted(false);
    btnSubmitPayment.setBorderPainted(false);
    btnSubmitPayment.setPreferredSize(
        new java.awt.Dimension(165, 42)
    );
    btnSubmitPayment.setCursor(new java.awt.Cursor(
        java.awt.Cursor.HAND_CURSOR
    ));

    historyHeader.add(
        lblHistoryTitle, java.awt.BorderLayout.WEST
    );
    historyHeader.add(
        btnSubmitPayment, java.awt.BorderLayout.EAST
    );

    pnlPaymentHistory.add(
        historyHeader, java.awt.BorderLayout.NORTH
    );

    // TABLE
    tblMyPayments.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.PLAIN, 13
    ));
    tblMyPayments.setForeground(navy);
    tblMyPayments.setBackground(java.awt.Color.WHITE);
    tblMyPayments.setRowHeight(42);
    tblMyPayments.setShowGrid(false);
    tblMyPayments.setFillsViewportHeight(true);
    tblMyPayments.setRowSelectionAllowed(true);
    tblMyPayments.setColumnSelectionAllowed(false);
    tblMyPayments.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );
    tblMyPayments.setSelectionBackground(
        new java.awt.Color(219, 234, 254)
    );
    tblMyPayments.setSelectionForeground(navy);

    javax.swing.table.JTableHeader tableHeader =
        tblMyPayments.getTableHeader();

    tableHeader.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 13
    ));
    tableHeader.setBackground(navy);
    tableHeader.setForeground(java.awt.Color.WHITE);
    tableHeader.setPreferredSize(
        new java.awt.Dimension(0, 44)
    );
    tableHeader.setReorderingAllowed(false);

    jScrollPane1.setBorder(
        javax.swing.BorderFactory.createLineBorder(border)
    );
    jScrollPane1.getViewport().setBackground(
        java.awt.Color.WHITE
    );

    pnlPaymentHistory.add(
        jScrollPane1, java.awt.BorderLayout.CENTER
    );

    // CONTENT LAYOUT
    javax.swing.JPanel content = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 22)
    );
    content.setOpaque(false);

    cards.setPreferredSize(
        new java.awt.Dimension(0, 125)
    );

    content.add(cards, java.awt.BorderLayout.NORTH);
    content.add(
        pnlPaymentHistory, java.awt.BorderLayout.CENTER
    );

    add(content, java.awt.BorderLayout.CENTER);

    revalidate();
    repaint();
}

private void stylePaymentCard(
        javax.swing.JPanel card,
        javax.swing.JLabel title,
        javax.swing.JLabel value,
        java.awt.Color navy,
        java.awt.Color muted,
        java.awt.Color border) {

    card.removeAll();
    card.setLayout(
        new java.awt.BorderLayout(0, 12)
    );
    card.setBackground(java.awt.Color.WHITE);
    card.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                20, 22, 20, 22
            )
        )
    );

    title.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 12
    ));
    title.setForeground(muted);

    value.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 25
    ));
    value.setForeground(navy);

    card.add(title, java.awt.BorderLayout.NORTH);
    card.add(value, java.awt.BorderLayout.CENTER);
}

    
private void updatePaymentSummary() {

    double totalAmount = 0;
    double amountPaid = 0;
    double remainingBalance = 0;

    javax.swing.table.TableModel model = tblMyPayments.getModel();

    for (int i = 0; i < model.getRowCount(); i++) {

        totalAmount += parseMoney(model.getValueAt(i, 1));
        amountPaid += parseMoney(model.getValueAt(i, 2));
        remainingBalance += parseMoney(model.getValueAt(i, 3));
    }

    lblTotalTitle.setText(String.format("₱%,.2f", totalAmount));
    lblPaidValue.setText(String.format("₱%,.2f", amountPaid));
    lblBalanceValue.setText(String.format("₱%,.2f", remainingBalance));
}

private double parseMoney(Object value) {

    if (value == null) {
        return 0;
    }

    try {
        return Double.parseDouble(
            value.toString().replace("₱", "").replace(",", "").trim()
        );
    } catch (NumberFormatException e) {
        return 0;
    }
}


public void refreshPayments() {

    ClientPaymentDAO dao = new ClientPaymentDAO();

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel)
        tblMyPayments.getModel();

    dao.loadClientPayments(clientId, model);

    updatePaymentSummary();
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        pnlTotalAmount = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTotalTitle = new javax.swing.JLabel();
        pnlAmountPaid = new javax.swing.JPanel();
        lblPaidTitle = new javax.swing.JLabel();
        lblPaidValue = new javax.swing.JLabel();
        pnlBalance = new javax.swing.JPanel();
        lblBalanceTitle = new javax.swing.JLabel();
        lblBalanceValue = new javax.swing.JLabel();
        pnlPaymentHistory = new javax.swing.JPanel();
        lblHistoryTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMyPayments = new javax.swing.JTable();
        btnSubmitPayment = new javax.swing.JButton();

        setBackground(new java.awt.Color(244, 248, 252));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(30, 58, 95));
        lblTitle.setText("My Payments");

        lblSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(107, 128, 150));
        lblSubtitle.setText("View your payment history and balances");

        pnlTotalAmount.setBackground(new java.awt.Color(255, 255, 255));
        pnlTotalAmount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 230, 240)));

        jLabel1.setForeground(new java.awt.Color(107, 128, 150));
        jLabel1.setText("TOTAL AMOUNT");

        lblTotalTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTotalTitle.setForeground(new java.awt.Color(30, 58, 95));
        lblTotalTitle.setText("₱0.00");

        javax.swing.GroupLayout pnlTotalAmountLayout = new javax.swing.GroupLayout(pnlTotalAmount);
        pnlTotalAmount.setLayout(pnlTotalAmountLayout);
        pnlTotalAmountLayout.setHorizontalGroup(
            pnlTotalAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalAmountLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlTotalAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lblTotalTitle))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        pnlTotalAmountLayout.setVerticalGroup(
            pnlTotalAmountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalAmountLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalTitle)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlAmountPaid.setBackground(new java.awt.Color(255, 255, 255));
        pnlAmountPaid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 230, 240)));

        lblPaidTitle.setBackground(new java.awt.Color(107, 128, 150));
        lblPaidTitle.setForeground(new java.awt.Color(107, 128, 150));
        lblPaidTitle.setText("AMOUNT PAID");

        lblPaidValue.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblPaidValue.setForeground(new java.awt.Color(30, 58, 95));
        lblPaidValue.setText("₱0.00");

        javax.swing.GroupLayout pnlAmountPaidLayout = new javax.swing.GroupLayout(pnlAmountPaid);
        pnlAmountPaid.setLayout(pnlAmountPaidLayout);
        pnlAmountPaidLayout.setHorizontalGroup(
            pnlAmountPaidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAmountPaidLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlAmountPaidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPaidTitle)
                    .addComponent(lblPaidValue))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        pnlAmountPaidLayout.setVerticalGroup(
            pnlAmountPaidLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAmountPaidLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblPaidTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPaidValue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBalance.setBackground(new java.awt.Color(255, 255, 255));
        pnlBalance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 230, 240)));

        lblBalanceTitle.setForeground(new java.awt.Color(107, 128, 150));
        lblBalanceTitle.setText("REMAINING BALANCE");

        lblBalanceValue.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBalanceValue.setForeground(new java.awt.Color(30, 58, 95));
        lblBalanceValue.setText("₱0.00");

        javax.swing.GroupLayout pnlBalanceLayout = new javax.swing.GroupLayout(pnlBalance);
        pnlBalance.setLayout(pnlBalanceLayout);
        pnlBalanceLayout.setHorizontalGroup(
            pnlBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBalanceLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBalanceTitle)
                    .addComponent(lblBalanceValue))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        pnlBalanceLayout.setVerticalGroup(
            pnlBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBalanceLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblBalanceTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBalanceValue)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPaymentHistory.setBackground(new java.awt.Color(255, 255, 255));
        pnlPaymentHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 230, 240)));

        lblHistoryTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblHistoryTitle.setForeground(new java.awt.Color(30, 58, 95));
        lblHistoryTitle.setText("Payment History");

        tblMyPayments.setForeground(new java.awt.Color(30, 58, 95));
        tblMyPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation ID", "Total Amount", "Amount Paid", "Balance", "Payment Method", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMyPayments.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblMyPayments.setGridColor(new java.awt.Color(220, 230, 240));
        tblMyPayments.setRowHeight(32);
        tblMyPayments.setSelectionBackground(new java.awt.Color(232, 240, 251));
        tblMyPayments.setSelectionForeground(new java.awt.Color(30, 58, 95));
        tblMyPayments.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tblMyPayments);

        btnSubmitPayment.setBackground(new java.awt.Color(59, 130, 246));
        btnSubmitPayment.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        btnSubmitPayment.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmitPayment.setText("Submit Payment");
        btnSubmitPayment.setBorderPainted(false);
        btnSubmitPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSubmitPayment.setFocusPainted(false);
        btnSubmitPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPaymentHistoryLayout = new javax.swing.GroupLayout(pnlPaymentHistory);
        pnlPaymentHistory.setLayout(pnlPaymentHistoryLayout);
        pnlPaymentHistoryLayout.setHorizontalGroup(
            pnlPaymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentHistoryLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblHistoryTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmitPayment)
                .addGap(33, 33, 33))
            .addComponent(jScrollPane1)
        );
        pnlPaymentHistoryLayout.setVerticalGroup(
            pnlPaymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentHistoryLayout.createSequentialGroup()
                .addGroup(pnlPaymentHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPaymentHistoryLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblHistoryTitle))
                    .addGroup(pnlPaymentHistoryLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnSubmitPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pnlTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlAmountPaid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnlBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlPaymentHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(186, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSubtitle)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTotalAmount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlAmountPaid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnlPaymentHistory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitPaymentActionPerformed
     int selectedRow = tblMyPayments.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Please select a reservation from the table first."
    );
    return;
}

int modelRow = tblMyPayments.convertRowIndexToModel(selectedRow);

int reservationId = Integer.parseInt(
    tblMyPayments.getModel()
        .getValueAt(modelRow, 0).toString()
);

ClientSubmitPaymentForm paymentForm =
    new ClientSubmitPaymentForm(clientId, reservationId);

paymentForm.setLocationRelativeTo(this);
paymentForm.setVisible(true);
    }//GEN-LAST:event_btnSubmitPaymentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmitPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBalanceTitle;
    private javax.swing.JLabel lblBalanceValue;
    private javax.swing.JLabel lblHistoryTitle;
    private javax.swing.JLabel lblPaidTitle;
    private javax.swing.JLabel lblPaidValue;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotalTitle;
    private javax.swing.JPanel pnlAmountPaid;
    private javax.swing.JPanel pnlBalance;
    private javax.swing.JPanel pnlPaymentHistory;
    private javax.swing.JPanel pnlTotalAmount;
    private javax.swing.JTable tblMyPayments;
    // End of variables declaration//GEN-END:variables
}
