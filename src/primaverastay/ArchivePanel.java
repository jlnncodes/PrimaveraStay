/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class ArchivePanel extends javax.swing.JPanel {

    /**
     * Creates new form ArchivePanel
     */
    public ArchivePanel() {
    initComponents();
    applyArchiveDesign();
    setupArchiveSearch();
    loadArchivedUnits();
}
    
    
private void applyArchiveDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    // MAIN PANEL
    removeAll();
    setLayout(new java.awt.BorderLayout(0, 0));
    setBackground(bg);
    setBorder(javax.swing.BorderFactory.createEmptyBorder(
        30, 35, 30, 35
    ));

    // HEADING
    lblTitle.setText("Archive Management");
    lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 30));
    lblTitle.setForeground(navy);

    jLabel2.setText("View and restore archived condominium units.");
    jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 15));
    jLabel2.setForeground(muted);

    javax.swing.JPanel heading = new javax.swing.JPanel();
    heading.setOpaque(false);
    heading.setLayout(new javax.swing.BoxLayout(
        heading, javax.swing.BoxLayout.Y_AXIS
    ));

    lblTitle.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
    jLabel2.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    heading.add(lblTitle);
    heading.add(javax.swing.Box.createVerticalStrut(8));
    heading.add(jLabel2);

    // SEARCH
    jLabel3.setText("Search Archived Units");
    jLabel4.setText("Record Type");

    for (javax.swing.JLabel label :
            new javax.swing.JLabel[]{jLabel3, jLabel4}) {
        label.setFont(new java.awt.Font("Segoe UI", 1, 14));
        label.setForeground(navy);
    }

    txtArchiveSearch.setFont(
        new java.awt.Font("Segoe UI", 0, 15)
    );
    txtArchiveSearch.setPreferredSize(
        new java.awt.Dimension(300, 44)
    );
    txtArchiveSearch.setBackground(java.awt.Color.WHITE);
    txtArchiveSearch.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(6, 12, 6, 12)
        )
    );

    cmbArchiveType.setFont(
        new java.awt.Font("Segoe UI", 0, 15)
    );
    cmbArchiveType.setBackground(java.awt.Color.WHITE);
    cmbArchiveType.setPreferredSize(
        new java.awt.Dimension(170, 44)
    );

    javax.swing.JPanel searchBox =
        new javax.swing.JPanel(new java.awt.BorderLayout(0, 8));
    searchBox.setOpaque(false);
    searchBox.add(jLabel3, java.awt.BorderLayout.NORTH);
    searchBox.add(txtArchiveSearch, java.awt.BorderLayout.CENTER);

    javax.swing.JPanel typeBox =
        new javax.swing.JPanel(new java.awt.BorderLayout(0, 8));
    typeBox.setOpaque(false);
    typeBox.add(jLabel4, java.awt.BorderLayout.NORTH);
    typeBox.add(cmbArchiveType, java.awt.BorderLayout.CENTER);

    javax.swing.JPanel filters =
        new javax.swing.JPanel(new java.awt.BorderLayout(18, 0));
    filters.setOpaque(false);
    filters.add(searchBox, java.awt.BorderLayout.CENTER);
    filters.add(typeBox, java.awt.BorderLayout.EAST);

    javax.swing.JPanel top = new javax.swing.JPanel();
    top.setOpaque(false);
    top.setLayout(new javax.swing.BoxLayout(
        top, javax.swing.BoxLayout.Y_AXIS
    ));

    heading.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
    filters.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    top.add(heading);
    top.add(javax.swing.Box.createVerticalStrut(28));
    top.add(filters);
    top.add(javax.swing.Box.createVerticalStrut(22));

    add(top, java.awt.BorderLayout.NORTH);

    // ARCHIVE TABLE
    tblArchive.setFont(new java.awt.Font("Segoe UI", 0, 15));
    tblArchive.setForeground(navy);
    tblArchive.setBackground(java.awt.Color.WHITE);
    tblArchive.setRowHeight(44);
    tblArchive.setFillsViewportHeight(true);
    tblArchive.setGridColor(border);
    tblArchive.setShowVerticalLines(false);
    tblArchive.setSelectionBackground(
        new java.awt.Color(219, 234, 254)
    );
    tblArchive.setSelectionForeground(navy);
    tblArchive.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    tblArchive.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_OFF
    );

    int[] widths = {90, 180, 210, 140, 190, 150};

    for (int i = 0; i < widths.length; i++) {
        tblArchive.getColumnModel().getColumn(i)
            .setPreferredWidth(widths[i]);
    }

    tblArchive.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", 1, 14)
    );
    tblArchive.getTableHeader().setBackground(navy);
    tblArchive.getTableHeader().setForeground(
        java.awt.Color.WHITE
    );
    tblArchive.getTableHeader().setPreferredSize(
        new java.awt.Dimension(0, 48)
    );
    tblArchive.getTableHeader().setReorderingAllowed(false);

    // Archived records should not be edited directly.
    tblArchive.setDefaultEditor(Object.class, null);

    jScrollPane1.setBorder(
        javax.swing.BorderFactory.createLineBorder(border)
    );
    jScrollPane1.getViewport().setBackground(
        java.awt.Color.WHITE
    );

    add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // RESTORE BUTTON
    btnRestoreUnit.setFont(
        new java.awt.Font("Segoe UI", 1, 15)
    );
    btnRestoreUnit.setBackground(blue);
    btnRestoreUnit.setForeground(java.awt.Color.WHITE);
    btnRestoreUnit.setOpaque(true);
    btnRestoreUnit.setContentAreaFilled(true);
    btnRestoreUnit.setBorderPainted(false);
    btnRestoreUnit.setFocusPainted(false);
    btnRestoreUnit.setPreferredSize(
        new java.awt.Dimension(180, 48)
    );
    btnRestoreUnit.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );

    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(
            java.awt.FlowLayout.RIGHT, 10, 5
        )
    );
    actions.setOpaque(false);
    actions.add(btnRestoreUnit);

    javax.swing.JPanel bottom =
        new javax.swing.JPanel(new java.awt.BorderLayout());
    bottom.setOpaque(false);
    bottom.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(16, 0, 0, 0)
    );
    bottom.add(actions, java.awt.BorderLayout.CENTER);

    add(bottom, java.awt.BorderLayout.SOUTH);

    TableHeaderDesign.apply(tblArchive);
    
    revalidate();
    repaint();
}


private void setupArchiveSearch() {

    javax.swing.table.TableRowSorter<
        javax.swing.table.DefaultTableModel> sorter =
        new javax.swing.table.TableRowSorter<>(
            (javax.swing.table.DefaultTableModel)
                tblArchive.getModel()
        );

    tblArchive.setRowSorter(sorter);

    txtArchiveSearch.getDocument().addDocumentListener(
        new javax.swing.event.DocumentListener() {

            @Override
            public void insertUpdate(
                javax.swing.event.DocumentEvent e) {
                filterArchive();
            }

            @Override
            public void removeUpdate(
                javax.swing.event.DocumentEvent e) {
                filterArchive();
            }

            @Override
            public void changedUpdate(
                javax.swing.event.DocumentEvent e) {
                filterArchive();
            }
        }
    );
}

private void filterArchive() {

    String search = txtArchiveSearch.getText().trim();

    @SuppressWarnings("unchecked")
    javax.swing.table.TableRowSorter<
        javax.swing.table.DefaultTableModel> sorter =
        (javax.swing.table.TableRowSorter<
            javax.swing.table.DefaultTableModel>)
            tblArchive.getRowSorter();

    if (search.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(
            javax.swing.RowFilter.regexFilter(
                "(?i)" + java.util.regex.Pattern.quote(search)
            )
        );
    }
}

    
    private void loadArchivedUnits() {

    UnitDAO unitDAO = new UnitDAO();
    java.util.ArrayList<Unit> units = unitDAO.getArchivedUnits();

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblArchive.getModel();

    model.setRowCount(0);

    for (Unit unit : units) {

        model.addRow(new Object[]{
            unit.getUnitId(),
            unit.getUnitNumber(),
            unit.getUnitType(),
            unit.getCapacity(),
            "₱" + String.format("%.2f", unit.getPricePerNight()),
            unit.getStatus()
        });
    }
}
    
    public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(() -> {

        javax.swing.JFrame frame =
                new javax.swing.JFrame("PrimaveraStay - Archive");

        frame.setDefaultCloseOperation(
                javax.swing.JFrame.DISPOSE_ON_CLOSE
        );

        frame.setContentPane(new ArchivePanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    });
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtArchiveSearch = new javax.swing.JTextField();
        cmbArchiveType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblArchive = new javax.swing.JTable();
        btnRestoreUnit = new javax.swing.JButton();

        lblTitle.setText("Archive");

        jLabel2.setText("View and restore archived records.");

        jLabel3.setText("Search: ");

        jLabel4.setText("Record Type:");

        cmbArchiveType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Units" }));

        tblArchive.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Unit Number", "Unit Type", "Capacity", "Price per Night", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblArchive);

        btnRestoreUnit.setText("Restore Unit");
        btnRestoreUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreUnitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRestoreUnit)
                    .addComponent(jLabel2)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtArchiveSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cmbArchiveType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtArchiveSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cmbArchiveType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRestoreUnit)
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRestoreUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreUnitActionPerformed
       
int selectedRow = tblArchive.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select a unit to restore."
    );
    return;
}


int modelRow = tblArchive.convertRowIndexToModel(selectedRow);

int unitId = Integer.parseInt(
    tblArchive.getModel().getValueAt(modelRow, 0).toString()
);

String unitNumber =
    tblArchive.getModel().getValueAt(modelRow, 1).toString();

int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to restore Unit " + unitNumber + "?",
        "Confirm Restore",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (confirm == javax.swing.JOptionPane.YES_OPTION) {

    UnitDAO unitDAO = new UnitDAO();

    boolean restored = unitDAO.restoreUnit(unitId);

    if (restored) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Unit restored successfully!"
        );

        loadArchivedUnits();

    } else {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Unable to restore unit."
        );
    }
}
    }//GEN-LAST:event_btnRestoreUnitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRestoreUnit;
    private javax.swing.JComboBox<String> cmbArchiveType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblArchive;
    private javax.swing.JTextField txtArchiveSearch;
    // End of variables declaration//GEN-END:variables
}
