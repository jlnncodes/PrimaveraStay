/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class MyReservationsPanel extends javax.swing.JPanel {

    /**
     * Creates new form MyReservationsPanel
     */
    private int clientId;

public MyReservationsPanel(int clientId) {
    initComponents();
    
    applyReservationsDesign();

    this.clientId = clientId;

    tblReservations.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    tblReservations.getTableHeader().setReorderingAllowed(false);

    loadMyReservations();
}


private void applyReservationsDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color border = new java.awt.Color(220, 230, 240);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);

    // MAIN PANEL
    removeAll();
    setLayout(new java.awt.BorderLayout(0, 22));
    setBackground(bg);
    setBorder(javax.swing.BorderFactory.createEmptyBorder(
        30, 35, 30, 35
    ));

    // TITLE AND SUBTITLE
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

    // TABLE CARD
    javax.swing.JPanel tableCard = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 15)
    );
    tableCard.setBackground(java.awt.Color.WHITE);
    tableCard.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                22, 22, 22, 22
            )
        )
    );

    javax.swing.JLabel tableTitle =
        new javax.swing.JLabel("Reservation History");

    tableTitle.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 19
    ));
    tableTitle.setForeground(navy);

    tableCard.add(tableTitle, java.awt.BorderLayout.NORTH);

    // TABLE DESIGN
    tblReservations.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.PLAIN, 14
    ));
    tblReservations.setForeground(navy);
    tblReservations.setBackground(java.awt.Color.WHITE);
    tblReservations.setRowHeight(42);
    tblReservations.setShowGrid(false);
    tblReservations.setSelectionBackground(
        new java.awt.Color(219, 234, 254)
    );
    tblReservations.setSelectionForeground(navy);
    tblReservations.setFillsViewportHeight(true);
    tblReservations.setRowSelectionAllowed(true);
    tblReservations.setColumnSelectionAllowed(false);
    tblReservations.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    javax.swing.table.JTableHeader header =
        tblReservations.getTableHeader();

    header.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 13
    ));
    header.setBackground(navy);
    header.setForeground(java.awt.Color.WHITE);
    header.setPreferredSize(new java.awt.Dimension(0, 44));
    header.setReorderingAllowed(false);

    jScrollPane1.setBorder(
        javax.swing.BorderFactory.createLineBorder(border)
    );
    jScrollPane1.getViewport().setBackground(
        java.awt.Color.WHITE
    );

    tableCard.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // ACTION BUTTONS
    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 0)
    );
    actions.setOpaque(false);

    styleReservationButton(
        btnViewDetails, blue, java.awt.Color.WHITE
    );
    styleReservationButton(
        btnCancelBooking,
        new java.awt.Color(185, 55, 65),
        java.awt.Color.WHITE
    );
    styleReservationButton(
        btnRefresh, navy, java.awt.Color.WHITE
    );

    btnViewDetails.setPreferredSize(
        new java.awt.Dimension(145, 42)
    );
    btnCancelBooking.setPreferredSize(
        new java.awt.Dimension(165, 42)
    );
    btnRefresh.setPreferredSize(
        new java.awt.Dimension(115, 42)
    );

    actions.add(btnViewDetails);
    actions.add(btnCancelBooking);
    actions.add(btnRefresh);

    tableCard.add(actions, java.awt.BorderLayout.SOUTH);

    add(tableCard, java.awt.BorderLayout.CENTER);

    revalidate();
    repaint();
}

private void styleReservationButton(
        javax.swing.JButton button,
        java.awt.Color background,
        java.awt.Color foreground) {

    button.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 13
    ));
    button.setBackground(background);
    button.setForeground(foreground);
    button.setFocusPainted(false);
    button.setCursor(new java.awt.Cursor(
        java.awt.Cursor.HAND_CURSOR
    ));
    button.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(
            10, 16, 10, 16
        )
    );
}


public void refreshReservations() {
    loadMyReservations();
}

private void loadMyReservations() {

    javax.swing.table.DefaultTableModel model =
        (javax.swing.table.DefaultTableModel)
        tblReservations.getModel();

    ReservationDAO dao = new ReservationDAO();

    dao.loadClientReservations(model, clientId);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservations = new javax.swing.JTable();
        btnViewDetails = new javax.swing.JButton();
        btnCancelBooking = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        lblTitle.setText("My Reservations");

        lblSubtitle.setText("View and manage your bookings");

        tblReservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Reservation ID", "Unit", "Check-In", "Check-Out", "Total Amount", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblReservations.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tblReservations);
        tblReservations.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnViewDetails.setText("View Details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        btnCancelBooking.setText("Cancel Booking");
        btnCancelBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelBookingActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 921, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(btnViewDetails)
                        .addGap(116, 116, 116)
                        .addComponent(btnCancelBooking)
                        .addGap(117, 117, 117)
                        .addComponent(btnRefresh))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtitle)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewDetails)
                    .addComponent(btnCancelBooking)
                    .addComponent(btnRefresh))
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        loadMyReservations();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        int row = tblReservations.getSelectedRow();

if (row == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select a reservation first."
    );
    return;
}

int modelRow = tblReservations.convertRowIndexToModel(row);

int reservationId = Integer.parseInt(
        tblReservations.getModel()
                .getValueAt(modelRow, 0).toString()
);

ReservationDAO dao = new ReservationDAO();

java.util.Map<String, Object> details =
        dao.getClientReservationDetails(reservationId, clientId);

if (details == null) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Reservation not found or access denied."
    );
    return;
}

javax.swing.JOptionPane.showMessageDialog(
        this,
        "Reservation ID: " + reservationId
        + "\nGuest: " + details.get("guestName")
        + "\nCheck-In: " + details.get("checkIn")
        + "\nCheck-Out: " + details.get("checkOut")
        + "\nTotal: PHP " + details.get("totalAmount")
        + "\nStatus: " + details.get("status"),
        "Reservation Details",
        javax.swing.JOptionPane.INFORMATION_MESSAGE
);
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnCancelBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelBookingActionPerformed
        
        
int row = tblReservations.getSelectedRow();

if (row == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select a reservation first."
    );
    return;
}

int modelRow = tblReservations.convertRowIndexToModel(row);

int reservationId = Integer.parseInt(
        tblReservations.getModel()
                .getValueAt(modelRow, 0).toString()
);

int choice = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to cancel reservation #"
        + reservationId + "?",
        "Confirm Cancellation",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (choice != javax.swing.JOptionPane.YES_OPTION) {
    return;
}

ReservationDAO dao = new ReservationDAO();

boolean success = dao.cancelClientReservation(
        reservationId, clientId
);

if (success) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Reservation cancelled successfully."
    );

    loadMyReservations();

} else {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Cancellation failed. Only pending reservations "
            + "before check-in can be cancelled."
    );
}
    }//GEN-LAST:event_btnCancelBookingActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelBooking;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblReservations;
    // End of variables declaration//GEN-END:variables
}
