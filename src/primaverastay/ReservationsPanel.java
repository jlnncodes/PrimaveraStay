/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class ReservationsPanel extends javax.swing.JPanel {
    
    private User loggedInUser;

    /**
     * Creates new form ReservationsPanel
     */
    
public ReservationsPanel() {
    initComponents();
    applyReservationsDesign();
    setupReservationFilters();
    loadReservationsTable();
}

public ReservationsPanel(User loggedInUser) {
    initComponents();
    this.loggedInUser = loggedInUser;
    applyReservationsDesign();
    setupReservationFilters();
    loadReservationsTable();
}


private void applyReservationsDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    setLayout(new java.awt.BorderLayout(0, 0));
    removeAll();
    setBackground(bg);
    setBorder(javax.swing.BorderFactory.createEmptyBorder(
        30, 35, 30, 35
    ));

    // HEADING
    jLabel1.setText("Reservations Management");
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30));
    jLabel1.setForeground(navy);

    jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15));
    jLabel2.setForeground(muted);

    javax.swing.JPanel heading = new javax.swing.JPanel();
    heading.setOpaque(false);
    heading.setLayout(new javax.swing.BoxLayout(
        heading, javax.swing.BoxLayout.Y_AXIS
    ));

    jLabel1.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
    jLabel2.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    heading.add(jLabel1);
    heading.add(javax.swing.Box.createVerticalStrut(8));
    heading.add(jLabel2);

    // SEARCH AND STATUS
    jLabel3.setText("Search Reservations");
    jLabel4.setText("Status");

    for (javax.swing.JLabel label :
            new javax.swing.JLabel[]{jLabel3, jLabel4}) {
        label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        label.setForeground(navy);
    }

    txtReservationSearch.setFont(
        new java.awt.Font("Segoe UI", 0, 15)
    );
    txtReservationSearch.setPreferredSize(
        new java.awt.Dimension(300, 44)
    );
    txtReservationSearch.setBackground(java.awt.Color.WHITE);
    txtReservationSearch.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(6, 12, 6, 12)
        )
    );

    cmbReservationStatus.setFont(
        new java.awt.Font("Segoe UI", 0, 15)
    );
    cmbReservationStatus.setBackground(java.awt.Color.WHITE);
    cmbReservationStatus.setPreferredSize(
        new java.awt.Dimension(180, 44)
    );

    javax.swing.JPanel searchBox =
        new javax.swing.JPanel(new java.awt.BorderLayout(0, 8));
    searchBox.setOpaque(false);
    searchBox.add(jLabel3, java.awt.BorderLayout.NORTH);
    searchBox.add(txtReservationSearch, java.awt.BorderLayout.CENTER);

    javax.swing.JPanel statusBox =
        new javax.swing.JPanel(new java.awt.BorderLayout(0, 8));
    statusBox.setOpaque(false);
    statusBox.add(jLabel4, java.awt.BorderLayout.NORTH);
    statusBox.add(cmbReservationStatus, java.awt.BorderLayout.CENTER);

    javax.swing.JPanel filters =
        new javax.swing.JPanel(new java.awt.BorderLayout(18, 0));
    filters.setOpaque(false);
    filters.add(searchBox, java.awt.BorderLayout.CENTER);
    filters.add(statusBox, java.awt.BorderLayout.EAST);

    javax.swing.JPanel top = new javax.swing.JPanel();
    top.setOpaque(false);
    top.setLayout(new javax.swing.BoxLayout(
        top, javax.swing.BoxLayout.Y_AXIS
    ));

    heading.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
    filters.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    top.add(heading);
    top.add(javax.swing.Box.createVerticalStrut(30));
    top.add(filters);
    top.add(javax.swing.Box.createVerticalStrut(22));

    add(top, java.awt.BorderLayout.NORTH);

    // RESERVATIONS TABLE
    tblReservations.setFont(
        new java.awt.Font("Segoe UI", 0, 14)
    );
    tblReservations.setForeground(navy);
    tblReservations.setBackground(java.awt.Color.WHITE);
    tblReservations.setRowHeight(43);
    tblReservations.setFillsViewportHeight(true);
    tblReservations.setGridColor(border);
    tblReservations.setShowVerticalLines(false);
    tblReservations.setSelectionBackground(
        new java.awt.Color(219, 234, 254)
    );
    tblReservations.setSelectionForeground(navy);
    tblReservations.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    // Allow all 9 columns to remain accessible on smaller screens.
    tblReservations.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_OFF
    );

    int[] widths = {65, 175, 145, 100, 135, 135, 75, 145, 120};

    for (int i = 0; i < widths.length; i++) {
        tblReservations.getColumnModel().getColumn(i)
            .setPreferredWidth(widths[i]);
    }

    tblReservations.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", 1, 14)
    );
    tblReservations.getTableHeader().setBackground(navy);
    tblReservations.getTableHeader().setForeground(
        java.awt.Color.WHITE
    );
    tblReservations.getTableHeader().setPreferredSize(
        new java.awt.Dimension(0, 48)
    );
    tblReservations.getTableHeader().setReorderingAllowed(false);

    jScrollPane1.setBorder(
        javax.swing.BorderFactory.createLineBorder(border)
    );
    jScrollPane1.getViewport().setBackground(
        java.awt.Color.WHITE
    );

    add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // ACTION BUTTONS
    btnNewReservation.setText("+ New Reservation");

    javax.swing.JButton[] buttons = {
        btnNewReservation,
        btnEditReservation,
        btnViewReservation,
        btnCancelReservation
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

    btnNewReservation.setBackground(blue);
    btnEditReservation.setBackground(navy);
    btnViewReservation.setBackground(
        new java.awt.Color(68, 103, 144)
    );
    btnCancelReservation.setBackground(muted);

    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(
            java.awt.FlowLayout.RIGHT, 10, 5
        )
    );
    actions.setOpaque(false);

    for (javax.swing.JButton button : buttons) {
        actions.add(button);
    }

    javax.swing.JPanel bottom =
        new javax.swing.JPanel(new java.awt.BorderLayout());
    bottom.setOpaque(false);
    bottom.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(16, 0, 0, 0)
    );
    bottom.add(actions, java.awt.BorderLayout.CENTER);

    add(bottom, java.awt.BorderLayout.SOUTH);

    TableHeaderDesign.apply(tblReservations);
    revalidate();
    repaint();
}


private void setupReservationFilters() {

    javax.swing.table.TableRowSorter<
        javax.swing.table.DefaultTableModel> sorter =
        new javax.swing.table.TableRowSorter<>(
            (javax.swing.table.DefaultTableModel)
                tblReservations.getModel()
        );

    tblReservations.setRowSorter(sorter);

    txtReservationSearch.getDocument().addDocumentListener(
        new javax.swing.event.DocumentListener() {

            public void insertUpdate(
                javax.swing.event.DocumentEvent e) {
                filterReservations();
            }

            public void removeUpdate(
                javax.swing.event.DocumentEvent e) {
                filterReservations();
            }

            public void changedUpdate(
                javax.swing.event.DocumentEvent e) {
                filterReservations();
            }
        }
    );

    cmbReservationStatus.addActionListener(
        e -> filterReservations()
    );
}

private void filterReservations() {

    String search = txtReservationSearch.getText().trim();

    Object selected = cmbReservationStatus.getSelectedItem();
    String status = selected == null ? "All" : selected.toString();

    java.util.List<javax.swing.RowFilter<Object, Object>> filters =
        new java.util.ArrayList<>();

    if (!search.isEmpty()) {
        filters.add(javax.swing.RowFilter.regexFilter(
            "(?i)" + java.util.regex.Pattern.quote(search)
        ));
    }

    if (!status.equals("All")) {
        filters.add(javax.swing.RowFilter.regexFilter(
            "(?i)^" + java.util.regex.Pattern.quote(status) + "$",
            8
        ));
    }

    @SuppressWarnings("unchecked")
    javax.swing.table.TableRowSorter<
        javax.swing.table.DefaultTableModel> sorter =
        (javax.swing.table.TableRowSorter<
            javax.swing.table.DefaultTableModel>)
            tblReservations.getRowSorter();

    if (filters.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(
            javax.swing.RowFilter.andFilter(filters)
        );
    }
}

    
    private void loadReservationsTable() {

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblReservations.getModel();

    ReservationDAO reservationDAO = new ReservationDAO();
    reservationDAO.loadReservations(model);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtReservationSearch = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbReservationStatus = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservations = new javax.swing.JTable();
        btnNewReservation = new javax.swing.JButton();
        btnEditReservation = new javax.swing.JButton();
        btnViewReservation = new javax.swing.JButton();
        btnCancelReservation = new javax.swing.JButton();

        jLabel1.setText("Reservations Management");

        jLabel2.setText("Manage guest bookings, schedules, and reservation status.");

        jLabel3.setText("Search:");

        jLabel4.setText("Status:");

        cmbReservationStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Pending", "Confirmed", "Checked In", "Checked Out", "Cancelled", "No Show" }));

        tblReservations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Guest Name", "Contact Number", "Unit", "Check-In", "Check-Out", "Guests", "Total Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReservations);

        btnNewReservation.setText("+ New Rservation");
        btnNewReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewReservationActionPerformed(evt);
            }
        });

        btnEditReservation.setText("Edit Reservation");
        btnEditReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditReservationActionPerformed(evt);
            }
        });

        btnViewReservation.setText("View Details");
        btnViewReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReservationActionPerformed(evt);
            }
        });

        btnCancelReservation.setText("Cancel Reservation");
        btnCancelReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelReservationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNewReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnViewReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtReservationSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmbReservationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtReservationSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbReservationStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewReservation)
                    .addComponent(btnEditReservation)
                    .addComponent(btnViewReservation)
                    .addComponent(btnCancelReservation))
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewReservationActionPerformed
AddReservationForm addForm =
        new AddReservationForm(loggedInUser);
addForm.setLocationRelativeTo(null);

addForm.addWindowListener(new java.awt.event.WindowAdapter() {

    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        loadReservationsTable();
    }
});
addForm.setVisible(true);
    }//GEN-LAST:event_btnNewReservationActionPerformed

    private void btnViewReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReservationActionPerformed
        int selectedRow = tblReservations.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Please select a reservation first.",
        "No Reservation Selected",
        javax.swing.JOptionPane.WARNING_MESSAGE
    );
    return;
}

int modelRow = tblReservations.convertRowIndexToModel(selectedRow);
javax.swing.table.TableModel model = tblReservations.getModel();

String details =
        "Reservation ID: " + model.getValueAt(modelRow, 0)
        + "\nGuest Name: " + model.getValueAt(modelRow, 1)
        + "\nContact Number: " + model.getValueAt(modelRow, 2)
        + "\nUnit: " + model.getValueAt(modelRow, 3)
        + "\nCheck-In: " + model.getValueAt(modelRow, 4)
        + "\nCheck-Out: " + model.getValueAt(modelRow, 5)
        + "\nNumber of Guests: " + model.getValueAt(modelRow, 6)
        + "\nTotal Amount: PHP " + model.getValueAt(modelRow, 7)
        + "\nStatus: " + model.getValueAt(modelRow, 8);

javax.swing.JOptionPane.showMessageDialog(
        this,
        details,
        "Reservation Details",
        javax.swing.JOptionPane.INFORMATION_MESSAGE
);
    }//GEN-LAST:event_btnViewReservationActionPerformed

    private void btnEditReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditReservationActionPerformed
        int selectedRow = tblReservations.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Please select a reservation to edit."
    );
    return;
}

int modelRow = tblReservations.convertRowIndexToModel(selectedRow);

int reservationId = Integer.parseInt(
    tblReservations.getModel().getValueAt(modelRow, 0).toString()
);

AddReservationForm editForm =
        new AddReservationForm(loggedInUser, reservationId);

editForm.setTitle("Edit Reservation - PrimaveraStay");
editForm.setLocationRelativeTo(this);

editForm.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        loadReservationsTable();
    }
});

editForm.setVisible(true);
    }//GEN-LAST:event_btnEditReservationActionPerformed

    private void btnCancelReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelReservationActionPerformed
    int selectedRow = tblReservations.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select a reservation to cancel."
    );
    return;
}

int modelRow = tblReservations.convertRowIndexToModel(selectedRow);

int reservationId = Integer.parseInt(
        tblReservations.getModel().getValueAt(modelRow, 0).toString()
);

String status = tblReservations.getModel()
        .getValueAt(modelRow, 8).toString();

if (status.equalsIgnoreCase("Cancelled")) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "This reservation is already cancelled."
    );
    return;
}

int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to cancel Reservation #" + reservationId + "?",
        "Confirm Cancellation",
        javax.swing.JOptionPane.YES_NO_OPTION,
        javax.swing.JOptionPane.WARNING_MESSAGE
);

if (confirm != javax.swing.JOptionPane.YES_OPTION) {
    return;
}

ReservationDAO dao = new ReservationDAO();

boolean cancelled = dao.cancelReservation(reservationId);

if (cancelled) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Reservation cancelled successfully!"
    );
    loadReservationsTable();
} else {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Unable to cancel reservation.",
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE
    );
}
    }//GEN-LAST:event_btnCancelReservationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelReservation;
    private javax.swing.JButton btnEditReservation;
    private javax.swing.JButton btnNewReservation;
    private javax.swing.JButton btnViewReservation;
    private javax.swing.JComboBox<String> cmbReservationStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblReservations;
    private javax.swing.JTextField txtReservationSearch;
    // End of variables declaration//GEN-END:variables
}
