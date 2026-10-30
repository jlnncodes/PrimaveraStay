/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class BrowseUnitsPanel extends javax.swing.JPanel {
    
    private int clientId;

    /**
     * Creates new form BrowseUnitsPanel
     */
    public BrowseUnitsPanel() {
    initComponents();
    buildPhotoSection();
    loadUnits();
    setupUnitSelection();
}
    
    public BrowseUnitsPanel(int clientId) {
    this();
    this.clientId = clientId;
}
    
private void loadUnits() {

    UnitDAO dao = new UnitDAO();

    javax.swing.table.DefaultTableModel model =
        new javax.swing.table.DefaultTableModel(
            new Object[]{
                "Unit ID",
                "Unit Number",
                "Unit Type",
                "Capacity",
                "Price per Night",
                "Status"
            }, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

    for (Unit unit : dao.getAllActiveUnits()) {
        model.addRow(new Object[]{
            unit.getUnitId(),
            unit.getUnitNumber(),
            unit.getUnitType(),
            unit.getCapacity(),
            unit.getPricePerNight(),
            unit.getStatus()
        });
    }

    tblUnits.setModel(model);
}
    

private javax.swing.JLabel[] photoLabels =
        new javax.swing.JLabel[3];


private void buildPhotoSection() {

    this.removeAll();
    this.setLayout(new java.awt.BorderLayout(0, 20));
    this.setBackground(new java.awt.Color(244, 248, 252));

    this.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(25, 30, 20, 30)
    );

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    // HEADER
    javax.swing.JPanel header =
        new javax.swing.JPanel(new java.awt.BorderLayout(15, 0));
    header.setOpaque(false);

    javax.swing.JPanel titles =
        new javax.swing.JPanel(new java.awt.GridLayout(2, 1, 0, 5));
    titles.setOpaque(false);

    lblTitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 26)
    );
    lblTitle.setForeground(navy);

    lblSubtitle.setText(
        "Explore our condominium units and choose your perfect stay."
    );
    lblSubtitle.setForeground(new java.awt.Color(107, 128, 150));

    titles.add(lblTitle);
    titles.add(lblSubtitle);

    javax.swing.JPanel buttons =
        new javax.swing.JPanel(
            new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 5)
        );
    buttons.setOpaque(false);

    btnRefresh.setBackground(java.awt.Color.WHITE);
    btnRefresh.setForeground(blue);
    btnRefresh.setFocusPainted(false);
    btnRefresh.setPreferredSize(new java.awt.Dimension(130, 36));
    btnRefresh.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );

    btnBookNow.setBackground(blue);
    btnBookNow.setForeground(java.awt.Color.WHITE);
    btnBookNow.setFocusPainted(false);
    btnBookNow.setPreferredSize(new java.awt.Dimension(135, 36));

    buttons.add(btnRefresh);
    buttons.add(btnBookNow);

    header.add(titles, java.awt.BorderLayout.WEST);
    header.add(buttons, java.awt.BorderLayout.EAST);

    // TABLE
    tblUnits.setRowHeight(29);
    tblUnits.setShowGrid(false);
    tblUnits.setIntercellSpacing(new java.awt.Dimension(0, 0));
    tblUnits.setFillsViewportHeight(false);

    tblUnits.setSelectionMode(
        javax.swing.ListSelectionModel.SINGLE_SELECTION
    );

    tblUnits.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13)
    );

    tblUnits.setSelectionBackground(
        new java.awt.Color(219, 234, 254)
    );
    tblUnits.setSelectionForeground(navy);

    tblUnits.setDefaultRenderer(
        Object.class,
        new javax.swing.table.DefaultTableCellRenderer() {

            @Override
            public java.awt.Component getTableCellRendererComponent(
                javax.swing.JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column
            ) {

                super.getTableCellRendererComponent(
                    table, value, isSelected, false, row, column
                );

                setBorder(
                    javax.swing.BorderFactory.createEmptyBorder(
                        0, 12, 0, 12
                    )
                );

                if (column == 2) {
                    setHorizontalAlignment(LEFT);
                } else {
                    setHorizontalAlignment(CENTER);
                }

                if (isSelected) {
                    setBackground(new java.awt.Color(219, 234, 254));
                    setForeground(navy);
                } else {
                    setBackground(
                        row % 2 == 0
                            ? java.awt.Color.WHITE
                            : new java.awt.Color(247, 250, 254)
                    );
                    setForeground(new java.awt.Color(45, 60, 75));
                }

                return this;
            }
        }
    );

    javax.swing.table.JTableHeader tableHeader =
        tblUnits.getTableHeader();

    tableHeader.setPreferredSize(new java.awt.Dimension(0, 42));
    tableHeader.setBackground(navy);
    tableHeader.setForeground(java.awt.Color.WHITE);
    tableHeader.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13)
    );
    tableHeader.setReorderingAllowed(false);

    // Give columns appropriate widths
    int[] widths = {75, 110, 220, 95, 140, 100};

    for (int i = 0; i < widths.length; i++) {
        tblUnits.getColumnModel().getColumn(i)
            .setPreferredWidth(widths[i]);
    }

    jScrollPane1.setBorder(
        javax.swing.BorderFactory.createLineBorder(border)
    );
    jScrollPane1.getViewport().setBackground(java.awt.Color.WHITE);

    // TABLE CARD
    javax.swing.JPanel tableCard =
        new javax.swing.JPanel(new java.awt.BorderLayout(0, 12));

    tableCard.setBackground(java.awt.Color.WHITE);
    tableCard.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)
    );

    javax.swing.JLabel tableTitle =
        new javax.swing.JLabel("Condominium Unit Listings");

    tableTitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 17)
    );
    tableTitle.setForeground(navy);

    tableCard.add(tableTitle, java.awt.BorderLayout.NORTH);

    // Size the table to fit the existing 10 units
    jScrollPane1.setPreferredSize(new java.awt.Dimension(900, 340));
    tableCard.add(jScrollPane1, java.awt.BorderLayout.CENTER);

    // PHOTO CARD
    javax.swing.JPanel photoPanel =
        new javax.swing.JPanel(new java.awt.BorderLayout(0, 12));

    photoPanel.setBackground(java.awt.Color.WHITE);
    photoPanel.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)
    );

    javax.swing.JLabel photoTitle =
        new javax.swing.JLabel("Unit Gallery");

    photoTitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 17)
    );
    photoTitle.setForeground(navy);

    javax.swing.JPanel photoGrid =
        new javax.swing.JPanel(new java.awt.GridLayout(1, 3, 12, 0));
    photoGrid.setOpaque(false);

    for (int i = 0; i < 3; i++) {

        javax.swing.JLabel label =
            new javax.swing.JLabel(
                "Select a unit to view Photo " + (i + 1),
                javax.swing.SwingConstants.CENTER
            );

        
label.setPreferredSize(new java.awt.Dimension(220, 190));
label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        label.setOpaque(true);
        label.setBackground(new java.awt.Color(232, 240, 251));
        label.setForeground(new java.awt.Color(107, 128, 150));

        label.setBorder(
            javax.swing.BorderFactory.createLineBorder(border)
        );

        photoLabels[i] = label;
        photoGrid.add(label);
    }

    photoPanel.add(photoTitle, java.awt.BorderLayout.NORTH);
    photoPanel.add(photoGrid, java.awt.BorderLayout.CENTER);

    // MAIN CONTENT - scrollable for smaller screens
    javax.swing.JPanel content =
        new javax.swing.JPanel();

    content.setLayout(
        new javax.swing.BoxLayout(
            content, javax.swing.BoxLayout.Y_AXIS
        )
    );

    content.setOpaque(false);

    tableCard.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
    photoPanel.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    
tableCard.setPreferredSize(
    new java.awt.Dimension(900, 405)
);
tableCard.setMaximumSize(
    new java.awt.Dimension(Integer.MAX_VALUE, 405)
);

photoPanel.setPreferredSize(
    new java.awt.Dimension(900, 285)
);
photoPanel.setMaximumSize(
    new java.awt.Dimension(Integer.MAX_VALUE, 285)
);


    content.add(tableCard);
    content.add(javax.swing.Box.createVerticalStrut(15));
    content.add(photoPanel);

    javax.swing.JScrollPane mainScroll =
        new javax.swing.JScrollPane(content);

    mainScroll.setBorder(null);
    mainScroll.getVerticalScrollBar().setUnitIncrement(16);
    mainScroll.getViewport().setBackground(
        new java.awt.Color(244, 248, 252)
    );

    this.add(header, java.awt.BorderLayout.NORTH);
    this.add(mainScroll, java.awt.BorderLayout.CENTER);

    this.revalidate();
    this.repaint();
}


private void setupUnitSelection() {

    tblUnits.getSelectionModel().addListSelectionListener(e -> {

        if (!e.getValueIsAdjusting()) {

            int selectedRow = tblUnits.getSelectedRow();

            if (selectedRow >= 0) {

                int modelRow =
                    tblUnits.convertRowIndexToModel(selectedRow);

                String unitNumber =
                    tblUnits.getModel()
                        .getValueAt(modelRow, 1)
                        .toString();

                displayUnitPhotos(unitNumber);
            }
        }
    });
}


private void displayUnitPhotos(String unitNumber) {

    for (int i = 0; i < 3; i++) {

        javax.swing.JLabel label = photoLabels[i];

        String imagePath =
            "/primaverastay/unitimages/unit"
            + unitNumber + "_" + (i + 1) + ".jpg";

        java.net.URL imageURL = getClass().getResource(imagePath);

        if (imageURL != null) {

            javax.swing.ImageIcon original =
                new javax.swing.ImageIcon(imageURL);

            int originalWidth = original.getIconWidth();
            int originalHeight = original.getIconHeight();

            if (originalWidth <= 0 || originalHeight <= 0) {
                label.setIcon(null);
                label.setText("Unable to load photo");
                continue;
            }

            int maxWidth = 340;
            int maxHeight = 180;

            double scale = Math.min(
                (double) maxWidth / originalWidth,
                (double) maxHeight / originalHeight
            );

            int newWidth = (int) (originalWidth * scale);
            int newHeight = (int) (originalHeight * scale);

            java.awt.Image scaled =
                original.getImage().getScaledInstance(
                    newWidth,
                    newHeight,
                    java.awt.Image.SCALE_SMOOTH
                );

            label.setIcon(new javax.swing.ImageIcon(scaled));
            label.setText("");

        } else {
            label.setIcon(null);
            label.setText("No Photo Available");
        }
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUnits = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        lblSubtitle = new javax.swing.JLabel();
        btnBookNow = new javax.swing.JButton();

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(30, 58, 95));
        lblTitle.setText("Available Condo Units");

        tblUnits.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Unit ID", "Unit Number", "Unit Type", "Capacity", "Price per Night", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblUnits);

        btnRefresh.setBackground(new java.awt.Color(59, 130, 246));
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh Units");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(107, 128, 150));
        lblSubtitle.setText("Browse the condo units listed in PrimaveraStay.");

        btnBookNow.setBackground(new java.awt.Color(59, 130, 246));
        btnBookNow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBookNow.setForeground(new java.awt.Color(255, 255, 255));
        btnBookNow.setText("Book Now");
        btnBookNow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBookNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookNowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSubtitle)
                        .addGap(366, 366, 366)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBookNow)))
                .addContainerGap(302, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSubtitle)
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefresh)
                        .addComponent(btnBookNow)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        
        loadUnits();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnBookNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookNowActionPerformed
        
    int selectedRow = tblUnits.getSelectedRow();

    if (selectedRow == -1) {
    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Please select a unit first."
    );
    return;
}

    // Get the selected unit ID
    int modelRow = tblUnits.convertRowIndexToModel(selectedRow);

    int unitId = Integer.parseInt(
    tblUnits.getModel().getValueAt(modelRow, 0).toString()
);

    // Open the Client Booking Form
    ClientBookingForm booking =
        new ClientBookingForm(clientId, unitId);

    booking.setVisible(true);
    }//GEN-LAST:event_btnBookNowActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBookNow;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblUnits;
    // End of variables declaration//GEN-END:variables

}