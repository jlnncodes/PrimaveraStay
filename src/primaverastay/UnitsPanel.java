/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class UnitsPanel extends javax.swing.JPanel {

    /**
     * Creates new form UnitsPanel
     */
    public UnitsPanel() {
    initComponents();
    applyUnitsDesign();
    loadUnitsTable();
        
         txtSearchUnit.getDocument().addDocumentListener(
        new javax.swing.event.DocumentListener() {

        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
            filterUnitsTable();
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            filterUnitsTable();
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            filterUnitsTable();
        }
    });
    }

    
private void applyUnitsDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    // MAIN PANEL
    this.removeAll();
    this.setLayout(new java.awt.BorderLayout());
    this.setBackground(bg);
    this.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(
            30, 35, 30, 35
        )
    );

    // TITLE
    lblUnitsTitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 30)
    );
    lblUnitsTitle.setForeground(navy);

    lblUnitsSubtitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 15)
    );
    lblUnitsSubtitle.setForeground(muted);

    javax.swing.JPanel heading = new javax.swing.JPanel();
    heading.setOpaque(false);
    heading.setLayout(new javax.swing.BoxLayout(
        heading, javax.swing.BoxLayout.Y_AXIS
    ));

    lblUnitsTitle.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
    lblUnitsSubtitle.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    heading.add(lblUnitsTitle);
    heading.add(javax.swing.Box.createVerticalStrut(7));
    heading.add(lblUnitsSubtitle);

    // SEARCH AND FILTER
    lblSearchUnit.setText("Search Units");
    lblUnitStatusFilter.setText("Status");

    javax.swing.JLabel[] labels = {
        lblSearchUnit, lblUnitStatusFilter
    };

    for (javax.swing.JLabel label : labels) {
        label.setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
        );
        label.setForeground(navy);
    }

    txtSearchUnit.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 15)
    );
    txtSearchUnit.setBackground(java.awt.Color.WHITE);
    txtSearchUnit.setForeground(navy);
    txtSearchUnit.setPreferredSize(
        new java.awt.Dimension(320, 43)
    );
    txtSearchUnit.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                7, 12, 7, 12
            )
        )
    );

    cmbUnitStatusFilter.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 15)
    );
    cmbUnitStatusFilter.setBackground(java.awt.Color.WHITE);
    cmbUnitStatusFilter.setPreferredSize(
        new java.awt.Dimension(190, 43)
    );

    javax.swing.JPanel searchGroup = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 8)
    );
    searchGroup.setOpaque(false);
    searchGroup.add(lblSearchUnit, java.awt.BorderLayout.NORTH);
    searchGroup.add(txtSearchUnit, java.awt.BorderLayout.CENTER);

    javax.swing.JPanel filterGroup = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 8)
    );
    filterGroup.setOpaque(false);
    filterGroup.add(lblUnitStatusFilter, java.awt.BorderLayout.NORTH);
    filterGroup.add(
        cmbUnitStatusFilter, java.awt.BorderLayout.CENTER
    );

    javax.swing.JPanel toolbar = new javax.swing.JPanel(
        new java.awt.BorderLayout(18, 0)
    );
    toolbar.setOpaque(false);
    toolbar.add(searchGroup, java.awt.BorderLayout.CENTER);
    toolbar.add(filterGroup, java.awt.BorderLayout.EAST);

    javax.swing.JPanel top = new javax.swing.JPanel();
    top.setOpaque(false);
    top.setLayout(new javax.swing.BoxLayout(
        top, javax.swing.BoxLayout.Y_AXIS
    ));

    heading.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
    toolbar.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    top.add(heading);
    top.add(javax.swing.Box.createVerticalStrut(30));
    top.add(toolbar);
    top.add(javax.swing.Box.createVerticalStrut(22));

    this.add(top, java.awt.BorderLayout.NORTH);

    // TABLE
    tblUnits.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 15)
    );
    tblUnits.setForeground(navy);
    tblUnits.setBackground(java.awt.Color.WHITE);
    tblUnits.setRowHeight(42);
    tblUnits.setSelectionBackground(
        new java.awt.Color(219, 234, 254)
    );
    tblUnits.setSelectionForeground(navy);
    tblUnits.setGridColor(border);
    tblUnits.setShowVerticalLines(false);
    tblUnits.setFillsViewportHeight(true);
    tblUnits.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );
    tblUnits.setAutoResizeMode(
        javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS
    );

    tblUnits.getTableHeader().setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );
    tblUnits.getTableHeader().setBackground(navy);
    tblUnits.getTableHeader().setForeground(java.awt.Color.WHITE);
    tblUnits.getTableHeader().setPreferredSize(
        new java.awt.Dimension(0, 48)
    );
    tblUnits.getTableHeader().setReorderingAllowed(false);

    jScrollPane1.setBorder(
        javax.swing.BorderFactory.createLineBorder(border)
    );
    jScrollPane1.getViewport().setBackground(
        java.awt.Color.WHITE
    );

    this.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // BUTTONS
    javax.swing.JButton[] buttons = {
        btnAddUnit, btnEditUnit, btnArchiveUnit
    };

    for (javax.swing.JButton button : buttons) {
        button.setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
        );
        button.setForeground(java.awt.Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setPreferredSize(
            new java.awt.Dimension(165, 45)
        );
        button.setCursor(
            new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
        );
    }

    btnAddUnit.setBackground(blue);
    btnEditUnit.setBackground(navy);
    btnArchiveUnit.setBackground(
        new java.awt.Color(107, 128, 150)
    );

    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(
            java.awt.FlowLayout.RIGHT, 12, 0
        )
    );
    actions.setOpaque(false);
    actions.add(btnAddUnit);
    actions.add(btnEditUnit);
    actions.add(btnArchiveUnit);

    javax.swing.JPanel bottom = new javax.swing.JPanel(
        new java.awt.BorderLayout()
    );
    bottom.setOpaque(false);
    bottom.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(
            20, 0, 0, 0
        )
    );
    bottom.add(actions, java.awt.BorderLayout.EAST);

    this.add(bottom, java.awt.BorderLayout.SOUTH);

    TableHeaderDesign.apply(tblUnits);
    this.revalidate();
    this.repaint();
}

    
    private void loadUnitsTable() {

    UnitDAO unitDAO = new UnitDAO();
 
    java.util.ArrayList<Unit> units = unitDAO.getAllUnits();

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblUnits.getModel();

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
        javax.swing.JFrame frame = new javax.swing.JFrame("PrimaveraStay - Units");

        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(new UnitsPanel());
        
        frame.setSize(1200, 750);
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    });
}
    
   private void filterUnitsTable() {

    javax.swing.table.DefaultTableModel model =
            (javax.swing.table.DefaultTableModel) tblUnits.getModel();

    javax.swing.table.TableRowSorter<
            javax.swing.table.DefaultTableModel> sorter =
            new javax.swing.table.TableRowSorter<>(model);

    tblUnits.setRowSorter(sorter);

    String searchText = txtSearchUnit.getText().trim();
    String selectedStatus =
            cmbUnitStatusFilter.getSelectedItem().toString();

    java.util.List<javax.swing.RowFilter<Object, Object>> filters =
            new java.util.ArrayList<>();

    // Search
    if (!searchText.isEmpty()) {
        filters.add(
                javax.swing.RowFilter.regexFilter(
                        "(?i)" + java.util.regex.Pattern.quote(searchText)
                )
        );
    }

    // Status
    if (!selectedStatus.equals("All")) {
        filters.add(
                javax.swing.RowFilter.regexFilter(
                        "(?i)^"
                        + java.util.regex.Pattern.quote(selectedStatus)
                        + "$",
                        5
                )
        );
    }

    if (filters.isEmpty()) {
        sorter.setRowFilter(null);
    } else {
        sorter.setRowFilter(
                javax.swing.RowFilter.andFilter(filters)
        );
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

        lblUnitsTitle = new javax.swing.JLabel();
        lblUnitsSubtitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUnits = new javax.swing.JTable();
        btnAddUnit = new javax.swing.JButton();
        btnEditUnit = new javax.swing.JButton();
        btnArchiveUnit = new javax.swing.JButton();
        lblSearchUnit = new javax.swing.JLabel();
        txtSearchUnit = new javax.swing.JTextField();
        lblUnitStatusFilter = new javax.swing.JLabel();
        cmbUnitStatusFilter = new javax.swing.JComboBox<>();

        lblUnitsTitle.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblUnitsTitle.setText("Units Management");

        lblUnitsSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblUnitsSubtitle.setText("Manage condo units, rates, capacity, and availability.");

        tblUnits.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUnits);

        btnAddUnit.setText("+ Add Unit");
        btnAddUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUnitActionPerformed(evt);
            }
        });

        btnEditUnit.setText("Edit Unit");
        btnEditUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUnitActionPerformed(evt);
            }
        });

        btnArchiveUnit.setText("Archive Unit");
        btnArchiveUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchiveUnitActionPerformed(evt);
            }
        });

        lblSearchUnit.setText("Search:");

        txtSearchUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchUnitActionPerformed(evt);
            }
        });

        lblUnitStatusFilter.setText("Status:");

        cmbUnitStatusFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Active", "Maintenance", "Inactive" }));
        cmbUnitStatusFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnitStatusFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUnitsSubtitle)
                            .addComponent(lblUnitsTitle)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(btnAddUnit)
                        .addGap(57, 57, 57)
                        .addComponent(btnEditUnit)
                        .addGap(55, 55, 55)
                        .addComponent(btnArchiveUnit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblSearchUnit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchUnit, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(lblUnitStatusFilter)
                        .addGap(18, 18, 18)
                        .addComponent(cmbUnitStatusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblUnitsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUnitsSubtitle)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearchUnit)
                    .addComponent(txtSearchUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnitStatusFilter)
                    .addComponent(cmbUnitStatusFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchiveUnit)
                    .addComponent(btnEditUnit)
                    .addComponent(btnAddUnit))
                .addGap(46, 46, 46))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUnitActionPerformed

         AddUnitForm addForm = new AddUnitForm();

    addForm.setLocationRelativeTo(this);

    addForm.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent e) {
            loadUnitsTable();
        }
    });

    addForm.setVisible(true);
    
    }//GEN-LAST:event_btnAddUnitActionPerformed

    private void txtSearchUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchUnitActionPerformed

    private void cmbUnitStatusFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnitStatusFilterActionPerformed
        filterUnitsTable();
    }//GEN-LAST:event_cmbUnitStatusFilterActionPerformed

    private void btnEditUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUnitActionPerformed
        
int selectedRow = tblUnits.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select a unit to edit."
    );
    return;
}
 
// Get the selected unit's information from the table
int unitId = Integer.parseInt(
        tblUnits.getValueAt(selectedRow, 0).toString()
);

String unitNumber =
        tblUnits.getValueAt(selectedRow, 1).toString();

String unitType =
        tblUnits.getValueAt(selectedRow, 2).toString();

int capacity = Integer.parseInt(
        tblUnits.getValueAt(selectedRow, 3).toString()
);

// Remove ₱ and comma before converting to double
String priceText = tblUnits.getValueAt(selectedRow, 4)
        .toString()
        .replace("₱", "")
        .replace(",", "")
        .trim();

double pricePerNight = Double.parseDouble(priceText);

String status =
        tblUnits.getValueAt(selectedRow, 5).toString();


// Open Edit Unit form
EditUnitForm editForm = new EditUnitForm(
        unitId,
        unitNumber,
        unitType,
        capacity,
        pricePerNight,
        status
);

editForm.setLocationRelativeTo(this);

// Refresh table when Edit Unit form closes
editForm.addWindowListener(new java.awt.event.WindowAdapter() {
    @Override
    public void windowClosed(java.awt.event.WindowEvent e) {
        loadUnitsTable();
    }
});

editForm.setVisible(true);
    }//GEN-LAST:event_btnEditUnitActionPerformed

    private void btnArchiveUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchiveUnitActionPerformed
   
int selectedRow = tblUnits.getSelectedRow();

if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please select a unit to archive."
    );
    return;
}

int unitId = Integer.parseInt(
        tblUnits.getValueAt(selectedRow, 0).toString()
);

String unitNumber =
        tblUnits.getValueAt(selectedRow, 1).toString();

int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to archive Unit " + unitNumber + "?",
        "Confirm Archive",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (confirm == javax.swing.JOptionPane.YES_OPTION) {

    UnitDAO unitDAO = new UnitDAO();

    boolean archived = unitDAO.archiveUnit(unitId);

    if (archived) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Unit archived successfully!"
        );

        loadUnitsTable();

    } else {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Unable to archive unit."
        );
    }
}
    }//GEN-LAST:event_btnArchiveUnitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUnit;
    private javax.swing.JButton btnArchiveUnit;
    private javax.swing.JButton btnEditUnit;
    private javax.swing.JComboBox<String> cmbUnitStatusFilter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearchUnit;
    private javax.swing.JLabel lblUnitStatusFilter;
    private javax.swing.JLabel lblUnitsSubtitle;
    private javax.swing.JLabel lblUnitsTitle;
    private javax.swing.JTable tblUnits;
    private javax.swing.JTextField txtSearchUnit;
    // End of variables declaration//GEN-END:variables
}
