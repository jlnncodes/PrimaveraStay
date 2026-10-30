/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class PaymentsPanel extends javax.swing.JFrame {

    /**
     * Creates new form PaymentsPanel
     */
    public PaymentsPanel() {
    initComponents();
    applyPaymentsDesign();
    loadPaymentsTable();
}

    private User loggedInUser;

public PaymentsPanel(User user) {
    this();
    this.loggedInUser = user;
}


private void applyPaymentsDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    // MAIN WINDOW
    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.BorderLayout());
    getContentPane().setBackground(bg);

    javax.swing.JPanel main = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 24)
    );
    main.setBackground(bg);
    main.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(35, 40, 35, 40)
    );

    // HEADER
    jLabel1.setText("Payment Management");
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30));
    jLabel1.setForeground(navy);

    javax.swing.JLabel subtitle = new javax.swing.JLabel(
        "Manage reservation payments, deposits, balances, and verification."
    );
    subtitle.setFont(new java.awt.Font("Segoe UI", 0, 15));
    subtitle.setForeground(muted);

    javax.swing.JPanel header = new javax.swing.JPanel();
    header.setOpaque(false);
    header.setLayout(new javax.swing.BoxLayout(
        header, javax.swing.BoxLayout.Y_AXIS
    ));

    jLabel1.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
    subtitle.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    header.add(jLabel1);
    header.add(javax.swing.Box.createVerticalStrut(8));
    header.add(subtitle);

    main.add(header, java.awt.BorderLayout.NORTH);

    // TABLE
    tblPayments.setFont(new java.awt.Font("Segoe UI", 0, 14));
    tblPayments.setForeground(navy);
    tblPayments.setBackground(java.awt.Color.WHITE);
    tblPayments.setRowHeight(44);
    tblPayments.setFillsViewportHeight(true);
    tblPayments.setGridColor(border);
    tblPayments.setShowVerticalLines(false);
    tblPayments.setSelectionBackground(
        new java.awt.Color(219, 234, 254)
    );
    tblPayments.setSelectionForeground(navy);
    tblPayments.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    // Keep all nine columns accessible on smaller screens.
    tblPayments.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_OFF
    );

    int[] widths = {
        105, 120, 180, 145, 160,
        145, 145, 155, 155
    };

    for (int i = 0; i < widths.length; i++) {
        tblPayments.getColumnModel().getColumn(i)
            .setPreferredWidth(widths[i]);
    }

    tblPayments.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", 1, 14)
    );
    tblPayments.getTableHeader().setBackground(navy);
    tblPayments.getTableHeader().setForeground(
        java.awt.Color.WHITE
    );
    tblPayments.getTableHeader().setPreferredSize(
        new java.awt.Dimension(0, 48)
    );
    tblPayments.getTableHeader().setReorderingAllowed(false);

    jScrollPane1.setBorder(
        javax.swing.BorderFactory.createLineBorder(border)
    );
    jScrollPane1.getViewport().setBackground(
        java.awt.Color.WHITE
    );

    main.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // BUTTONS
    javax.swing.JButton[] buttons = {
        btnRecordPayment, btnVerifyPayment, btnViewPayment
    };

    for (javax.swing.JButton button : buttons) {
        button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        button.setForeground(java.awt.Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setPreferredSize(
            new java.awt.Dimension(175, 46)
        );
        button.setCursor(
            new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
        );
    }

    btnRecordPayment.setBackground(blue);
    btnVerifyPayment.setBackground(navy);
    btnViewPayment.setBackground(muted);

    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(
            java.awt.FlowLayout.RIGHT, 12, 5
        )
    );
    actions.setOpaque(false);

    actions.add(btnRecordPayment);
    actions.add(btnVerifyPayment);
    actions.add(btnViewPayment);

    main.add(actions, java.awt.BorderLayout.SOUTH);

    getContentPane().add(main, java.awt.BorderLayout.CENTER);

    // FULLSCREEN FOR LAPTOP / HDMI TV
    setTitle("Payment Management - PrimaveraStay");
    setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    setSize(1200, 750);
    setLocationRelativeTo(null);
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    TableHeaderDesign.apply(tblPayments);
    
    getContentPane().revalidate();
    getContentPane().repaint();
}

    
    private void loadPaymentsTable() {
    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel)
            tblPayments.getModel();

    PaymentDAO dao = new PaymentDAO();
    dao.loadPayments(model);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPayments = new javax.swing.JTable();
        btnRecordPayment = new javax.swing.JButton();
        btnVerifyPayment = new javax.swing.JButton();
        btnViewPayment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Payment Management");

        tblPayments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Payment ID", "Reservation ID", "Guest Name", "Total Amount", "Required Deposit", "Amount Paid", "Balance", "Payment Method", "Payment Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPayments.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblPayments);
        tblPayments.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnRecordPayment.setText("Record Payment");
        btnRecordPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordPaymentActionPerformed(evt);
            }
        });

        btnVerifyPayment.setText("Verify Payment");
        btnVerifyPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyPaymentActionPerformed(evt);
            }
        });

        btnViewPayment.setText("View Details");
        btnViewPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPaymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btnRecordPayment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnVerifyPayment)
                .addGap(54, 54, 54)
                .addComponent(btnViewPayment)
                .addGap(655, 655, 655))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewPayment)
                    .addComponent(btnVerifyPayment)
                    .addComponent(btnRecordPayment))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecordPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordPaymentActionPerformed
        
        RecordPaymentForm form = new RecordPaymentForm(loggedInUser);

form.setTitle("Record Payment - PrimaveraStay");
form.setDefaultCloseOperation(
        javax.swing.JFrame.DISPOSE_ON_CLOSE
);
form.setLocationRelativeTo(this);
form.setVisible(true);
form.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        loadPaymentsTable();
    }
});
    }//GEN-LAST:event_btnRecordPaymentActionPerformed

    private void btnVerifyPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyPaymentActionPerformed
        int selectedRow = tblPayments.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Please select a payment first.");
    return;
}

int modelRow = tblPayments.convertRowIndexToModel(selectedRow);

int paymentId = Integer.parseInt(
        tblPayments.getModel().getValueAt(modelRow, 0).toString()
);

String status = tblPayments.getModel()
        .getValueAt(modelRow, 8).toString();

if (!status.equalsIgnoreCase("Pending")) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Only pending payments can be verified.");
    return;
}

int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Verify Payment ID " + paymentId + "?",
        "Confirm Payment Verification",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (confirm != javax.swing.JOptionPane.YES_OPTION) {
    return;
}

PaymentDAO dao = new PaymentDAO();

if (dao.verifyPayment(paymentId)) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Payment verified successfully!");

    loadPaymentsTable();
} else {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Payment could not be verified.");
}
    }//GEN-LAST:event_btnVerifyPaymentActionPerformed

    private void btnViewPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPaymentActionPerformed
        int selectedRow = tblPayments.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select a payment first."
    );
    return;
}

int modelRow = tblPayments.convertRowIndexToModel(selectedRow);

int paymentId = Integer.parseInt(
        tblPayments.getModel().getValueAt(modelRow, 0).toString()
);

PaymentDAO dao = new PaymentDAO();
String details = dao.getPaymentDetails(paymentId);

if (details != null) {
    javax.swing.JTextArea textArea =
            new javax.swing.JTextArea(details);

    textArea.setEditable(false);
    textArea.setFont(new java.awt.Font(
            "Monospaced", java.awt.Font.PLAIN, 13
    ));
    javax.swing.JOptionPane.showMessageDialog(
            this,
            new javax.swing.JScrollPane(textArea),
            "Payment Details - PrimaveraStay",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
}else{
     javax.swing.JOptionPane.showMessageDialog(
            this,
            "No payment details found for Payment ID: " + paymentId
     );
    }//GEN-LAST:event_btnViewPaymentActionPerformed
    }
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
            java.util.logging.Logger.getLogger(PaymentsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PaymentsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PaymentsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PaymentsPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PaymentsPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecordPayment;
    private javax.swing.JButton btnVerifyPayment;
    private javax.swing.JButton btnViewPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPayments;
    // End of variables declaration//GEN-END:variables
}
