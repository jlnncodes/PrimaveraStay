/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class ClientsForm extends javax.swing.JFrame {

    /**
     * Creates new form ClientsForm
     */
    public ClientsForm() {
    initComponents();
    applyClientsDesign();
    loadClientsTable();
}
    
    
private void applyClientsDesign() {

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
        new java.awt.BorderLayout(0, 25)
    );
    main.setBackground(bg);
    main.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(35, 40, 35, 40)
    );

    // HEADING
    jLabel1.setText("Client Management");
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30));
    jLabel1.setForeground(navy);

    javax.swing.JLabel subtitle = new javax.swing.JLabel(
        "View registered clients and their booking information."
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

    // CLIENTS TABLE
    tblClients.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 15)
    );
    tblClients.setForeground(navy);
    tblClients.setBackground(java.awt.Color.WHITE);
    tblClients.setRowHeight(44);
    tblClients.setFillsViewportHeight(true);
    tblClients.setGridColor(border);
    tblClients.setShowVerticalLines(false);
    tblClients.setSelectionBackground(
        new java.awt.Color(219, 234, 254)
    );
    tblClients.setSelectionForeground(navy);
    tblClients.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    // Horizontal scrolling when the screen is too narrow
    tblClients.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_OFF
    );

    int[] widths = {
        110, 210, 260, 170, 170, 130, 180
    };

    for (int i = 0; i < widths.length; i++) {
        tblClients.getColumnModel().getColumn(i)
            .setPreferredWidth(widths[i]);
    }

    tblClients.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", 1, 14)
    );
    tblClients.getTableHeader().setBackground(navy);
    tblClients.getTableHeader().setForeground(
        java.awt.Color.WHITE
    );
    tblClients.getTableHeader().setPreferredSize(
        new java.awt.Dimension(0, 48)
    );
    tblClients.getTableHeader().setReorderingAllowed(false);

    jScrollPane1.setBorder(
        javax.swing.BorderFactory.createLineBorder(border)
    );
    jScrollPane1.getViewport().setBackground(
        java.awt.Color.WHITE
    );

    main.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // ACTION BUTTONS
    javax.swing.JButton[] buttons = {
        btnViewClient, btnViewBookings
    };

    for (javax.swing.JButton button : buttons) {
        button.setFont(new java.awt.Font("Segoe UI", 1, 15));
        button.setForeground(java.awt.Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setPreferredSize(
            new java.awt.Dimension(190, 48)
        );
        button.setCursor(
            new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
        );
    }

    btnViewClient.setBackground(blue);
    btnViewBookings.setBackground(navy);

    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(
            java.awt.FlowLayout.RIGHT, 12, 5
        )
    );
    actions.setOpaque(false);
    actions.add(btnViewClient);
    actions.add(btnViewBookings);

    main.add(actions, java.awt.BorderLayout.SOUTH);

    getContentPane().add(main, java.awt.BorderLayout.CENTER);

    // FULLSCREEN LAPTOP / HDMI TV
    setTitle("Client Management - PrimaveraStay");
    setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
    setSize(1200, 750);
    setLocationRelativeTo(null);
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    TableHeaderDesign.apply(tblClients);
    
    getContentPane().revalidate();
    getContentPane().repaint();
}

    
private void loadClientsTable() {

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel)
        tblClients.getModel();

    ClientDAO dao = new ClientDAO();
    dao.loadClients(model);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        btnViewClient = new javax.swing.JButton();
        btnViewBookings = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Client Management");

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client ID", "Full Name", "Email", "Contact Number", "Username", "Status", "Date Registered"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblClients);

        btnViewClient.setText("View Details");
        btnViewClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewClientActionPerformed(evt);
            }
        });

        btnViewBookings.setText("View Bookings");
        btnViewBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewBookingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnViewClient)
                        .addGap(68, 68, 68)
                        .addComponent(btnViewBookings))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewBookings)
                    .addComponent(btnViewClient))
                .addContainerGap(273, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewClientActionPerformed
        int selectedRow = tblClients.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Please select a client first.");
    return;
}

int row = tblClients.convertRowIndexToModel(selectedRow);

String details =
        "CLIENT DETAILS\n\n"
        + "Client ID: " + tblClients.getModel().getValueAt(row, 0)
        + "\nFull Name: " + tblClients.getModel().getValueAt(row, 1)
        + "\nEmail: " + tblClients.getModel().getValueAt(row, 2)
        + "\nContact Number: " + tblClients.getModel().getValueAt(row, 3)
        + "\nUsername: " + tblClients.getModel().getValueAt(row, 4)
        + "\nStatus: " + tblClients.getModel().getValueAt(row, 5)
        + "\nDate Registered: " + tblClients.getModel().getValueAt(row, 6);

javax.swing.JOptionPane.showMessageDialog(
    this,
    details,
    "Client Details - PrimaveraStay",
    javax.swing.JOptionPane.INFORMATION_MESSAGE
);
    }//GEN-LAST:event_btnViewClientActionPerformed

    private void btnViewBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewBookingsActionPerformed
        int selectedRow = tblClients.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
        this, "Please select a client first.");
    return;
}

int row = tblClients.convertRowIndexToModel(selectedRow);

int clientId = Integer.parseInt(
    tblClients.getModel().getValueAt(row, 0).toString()
);

String clientName =
    tblClients.getModel().getValueAt(row, 1).toString();

ClientDAO dao = new ClientDAO();
String bookings = dao.getClientBookings(clientId);

if (bookings == null) {
    return;
}

javax.swing.JTextArea textArea =
    new javax.swing.JTextArea(bookings, 15, 45);

textArea.setEditable(false);
textArea.setCaretPosition(0);

javax.swing.JOptionPane.showMessageDialog(
    this,
    new javax.swing.JScrollPane(textArea),
    "Bookings - " + clientName,
    javax.swing.JOptionPane.INFORMATION_MESSAGE
);
    }//GEN-LAST:event_btnViewBookingsActionPerformed

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
            java.util.logging.Logger.getLogger(ClientsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnViewBookings;
    private javax.swing.JButton btnViewClient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblClients;
    // End of variables declaration//GEN-END:variables
}
