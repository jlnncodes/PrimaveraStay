/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class DashboardForm extends javax.swing.JFrame {
    private User loggedInUser;

    /**
     * Creates new form DashboardForm
     */
    public DashboardForm() {
    initComponents();
    applyAdminDashboardDesign();
    loadDashboardData();
}

public DashboardForm(User loggedInUser) {
    initComponents();
    this.loggedInUser = loggedInUser;
    applyAdminDashboardDesign();
    loadDashboardData();
}


private void applyAdminDashboardDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);

    // SIDEBAR
    sidebarPanel.removeAll();
    sidebarPanel.setLayout(new java.awt.BorderLayout());
    sidebarPanel.setBackground(navy);
    sidebarPanel.setPreferredSize(new java.awt.Dimension(240, 0));
    sidebarPanel.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(28, 18, 25, 18)
    );

    javax.swing.JPanel top = new javax.swing.JPanel();
    top.setOpaque(false);
    top.setLayout(new javax.swing.BoxLayout(
        top, javax.swing.BoxLayout.Y_AXIS
    ));

    jLabel1.setText("PrimaveraStay");
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 23));
    jLabel1.setForeground(java.awt.Color.WHITE);
    jLabel1.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    javax.swing.JLabel portal =
        new javax.swing.JLabel("ADMIN PORTAL");
    portal.setFont(new java.awt.Font("Segoe UI", 1, 11));
    portal.setForeground(new java.awt.Color(191, 219, 254));
    portal.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

    top.add(jLabel1);
    top.add(javax.swing.Box.createVerticalStrut(7));
    top.add(portal);
    top.add(javax.swing.Box.createVerticalStrut(35));

    javax.swing.JButton[] buttons = {
        btnDashboard, btnReservations, btnUnits,
        btnPayments, btnClients, btnArchive
    };

    for (javax.swing.JButton button : buttons) {
        button.setBackground(navy);
        button.setForeground(java.awt.Color.WHITE);
        button.setFont(new java.awt.Font("Segoe UI", 1, 14));
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setHorizontalAlignment(
            javax.swing.SwingConstants.LEFT
        );
        button.setMaximumSize(
            new java.awt.Dimension(Integer.MAX_VALUE, 44)
        );
        button.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 8)
        );

        top.add(button);
        top.add(javax.swing.Box.createVerticalStrut(10));
    }

    btnDashboard.setBackground(blue);

    btnLogout.setBackground(new java.awt.Color(42, 72, 108));
    btnLogout.setForeground(java.awt.Color.WHITE);
    btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 14));
    btnLogout.setFocusPainted(false);

    sidebarPanel.add(top, java.awt.BorderLayout.NORTH);
    sidebarPanel.add(btnLogout, java.awt.BorderLayout.SOUTH);

    // DASHBOARD
    dashboardPanel.removeAll();
    dashboardPanel.setLayout(new java.awt.BorderLayout(0, 28));
    dashboardPanel.setBackground(bg);
    dashboardPanel.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(38, 38, 38, 38)
    );

    javax.swing.JPanel heading = new javax.swing.JPanel();
    heading.setOpaque(false);
    heading.setLayout(new javax.swing.BoxLayout(
        heading, javax.swing.BoxLayout.Y_AXIS
    ));

    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 30));
    jLabel2.setForeground(navy);

    jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 15));
    jLabel3.setForeground(muted);

    heading.add(jLabel2);
    heading.add(javax.swing.Box.createVerticalStrut(8));
    heading.add(jLabel3);

    dashboardPanel.add(heading, java.awt.BorderLayout.NORTH);

    // SUMMARY CARDS
    javax.swing.JPanel cards =
        new javax.swing.JPanel(new java.awt.GridLayout(2, 2, 20, 20));

    cards.setOpaque(false);
    cards.setPreferredSize(new java.awt.Dimension(0, 310));

    javax.swing.JPanel[] panels = {
        pnlTotalUnits, pnlAvailableUnits,
        pnlOccupiedUnits, pnlUpcomingReservations
    };

    javax.swing.JLabel[] titles = {
        lblTotalUnitsTitle, lblAvailableUnitsTitle,
        lblOccupiedUnitsTitle, lblUpcomingReservationTitle
    };

    javax.swing.JLabel[] values = {
        lblTotalUnits, lblAvailableUnits,
        lblOccupiedUnits, lblUpcomingReservations
    };

    lblUpcomingReservationTitle.setText("UPCOMING RESERVATIONS");

    for (int i = 0; i < panels.length; i++) {
        panels[i].removeAll();
        panels[i].setLayout(new java.awt.BorderLayout(0, 12));
        panels[i].setBackground(java.awt.Color.WHITE);
        panels[i].setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(
                    new java.awt.Color(220, 230, 240)
                ),
                javax.swing.BorderFactory.createEmptyBorder(
                    25, 28, 25, 28
                )
            )
        );

        titles[i].setFont(new java.awt.Font("Segoe UI", 1, 13));
        titles[i].setForeground(muted);

        values[i].setFont(new java.awt.Font("Segoe UI", 1, 38));
        values[i].setForeground(navy);

        panels[i].add(titles[i], java.awt.BorderLayout.NORTH);
        panels[i].add(values[i], java.awt.BorderLayout.CENTER);

        cards.add(panels[i]);
    }

    javax.swing.JPanel content =
        new javax.swing.JPanel(new java.awt.BorderLayout());

    content.setOpaque(false);
    content.add(cards, java.awt.BorderLayout.NORTH);

    dashboardPanel.add(content, java.awt.BorderLayout.CENTER);

    // WINDOW
    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.BorderLayout());
    getContentPane().add(sidebarPanel, java.awt.BorderLayout.WEST);
    getContentPane().add(dashboardPanel, java.awt.BorderLayout.CENTER);

    setTitle("PrimaveraStay - Admin Dashboard");
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

    getContentPane().revalidate();
    getContentPane().repaint();
}

    private void loadDashboardData() {
    UnitDAO unitDAO = new UnitDAO();
    ReservationDAO reservationDAO = new ReservationDAO();

    int totalUnits = unitDAO.getTotalUnits();
    int availableUnits = unitDAO.getAvailableUnitsToday();
    int occupiedUnits = totalUnits - availableUnits;
    int upcomingReservations = reservationDAO.getUpcomingReservations();


    lblTotalUnits.setText(String.valueOf(totalUnits));
    lblAvailableUnits.setText(String.valueOf(availableUnits));
    lblOccupiedUnits.setText(String.valueOf(occupiedUnits));
    lblUpcomingReservations.setText(String.valueOf(upcomingReservations));
     
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JButton();
        btnReservations = new javax.swing.JButton();
        btnUnits = new javax.swing.JButton();
        btnPayments = new javax.swing.JButton();
        btnClients = new javax.swing.JButton();
        btnArchive = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        dashboardPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlTotalUnits = new javax.swing.JPanel();
        lblTotalUnitsTitle = new javax.swing.JLabel();
        lblTotalUnits = new javax.swing.JLabel();
        pnlAvailableUnits = new javax.swing.JPanel();
        lblAvailableUnitsTitle = new javax.swing.JLabel();
        lblAvailableUnits = new javax.swing.JLabel();
        pnlOccupiedUnits = new javax.swing.JPanel();
        lblOccupiedUnitsTitle = new javax.swing.JLabel();
        lblOccupiedUnits = new javax.swing.JLabel();
        pnlUpcomingReservations = new javax.swing.JPanel();
        lblUpcomingReservationTitle = new javax.swing.JLabel();
        lblUpcomingReservations = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1200, 700));

        sidebarPanel.setBackground(new java.awt.Color(31, 45, 61));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PrimaveraStay");

        btnDashboard.setBackground(new java.awt.Color(70, 116, 157));
        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(255, 255, 255));
        btnDashboard.setText("Dashboard");
        btnDashboard.setBorderPainted(false);
        btnDashboard.setFocusPainted(false);
        btnDashboard.setOpaque(true);
        btnDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardActionPerformed(evt);
            }
        });

        btnReservations.setBackground(new java.awt.Color(31, 45, 61));
        btnReservations.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReservations.setForeground(new java.awt.Color(245, 239, 225));
        btnReservations.setText("Reservations");
        btnReservations.setFocusPainted(false);
        btnReservations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReservationsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReservationsMouseExited(evt);
            }
        });
        btnReservations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservationsActionPerformed(evt);
            }
        });

        btnUnits.setBackground(new java.awt.Color(31, 45, 61));
        btnUnits.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnUnits.setForeground(new java.awt.Color(245, 239, 225));
        btnUnits.setText("Units");
        btnUnits.setFocusPainted(false);
        btnUnits.setOpaque(true);
        btnUnits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnitsActionPerformed(evt);
            }
        });

        btnPayments.setBackground(new java.awt.Color(31, 45, 61));
        btnPayments.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPayments.setForeground(new java.awt.Color(245, 239, 225));
        btnPayments.setText("Payments");
        btnPayments.setFocusPainted(false);
        btnPayments.setOpaque(true);
        btnPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentsActionPerformed(evt);
            }
        });

        btnClients.setBackground(new java.awt.Color(31, 45, 61));
        btnClients.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClients.setForeground(new java.awt.Color(245, 239, 225));
        btnClients.setText("Clients");
        btnClients.setFocusPainted(false);
        btnClients.setOpaque(true);
        btnClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientsActionPerformed(evt);
            }
        });

        btnArchive.setBackground(new java.awt.Color(31, 45, 61));
        btnArchive.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnArchive.setForeground(new java.awt.Color(245, 239, 225));
        btnArchive.setText("Archive");
        btnArchive.setFocusPainted(false);
        btnArchive.setOpaque(true);
        btnArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchiveActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebarPanelLayout = new javax.swing.GroupLayout(sidebarPanel);
        sidebarPanel.setLayout(sidebarPanelLayout);
        sidebarPanelLayout.setHorizontalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1))
                    .addGroup(sidebarPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnReservations, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(btnDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUnits, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPayments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnArchive, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        sidebarPanelLayout.setVerticalGroup(
            sidebarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebarPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClients, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnArchive, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        dashboardPanel.setBackground(new java.awt.Color(245, 247, 250));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setText("Dashboard");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Welcome to PrimaveraStay");

        lblTotalUnitsTitle.setText("TOTAL UNITS");

        lblTotalUnits.setText("6");

        javax.swing.GroupLayout pnlTotalUnitsLayout = new javax.swing.GroupLayout(pnlTotalUnits);
        pnlTotalUnits.setLayout(pnlTotalUnitsLayout);
        pnlTotalUnitsLayout.setHorizontalGroup(
            pnlTotalUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalUnitsLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(pnlTotalUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalUnitsTitle)
                    .addGroup(pnlTotalUnitsLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblTotalUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        pnlTotalUnitsLayout.setVerticalGroup(
            pnlTotalUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalUnitsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalUnitsTitle)
                .addGap(18, 18, 18)
                .addComponent(lblTotalUnits)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        lblAvailableUnitsTitle.setText("AVAILABLE TODAY");

        lblAvailableUnits.setText("6");

        javax.swing.GroupLayout pnlAvailableUnitsLayout = new javax.swing.GroupLayout(pnlAvailableUnits);
        pnlAvailableUnits.setLayout(pnlAvailableUnitsLayout);
        pnlAvailableUnitsLayout.setHorizontalGroup(
            pnlAvailableUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAvailableUnitsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(pnlAvailableUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAvailableUnitsTitle)
                    .addGroup(pnlAvailableUnitsLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblAvailableUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        pnlAvailableUnitsLayout.setVerticalGroup(
            pnlAvailableUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAvailableUnitsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvailableUnitsTitle)
                .addGap(18, 18, 18)
                .addComponent(lblAvailableUnits)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        lblOccupiedUnitsTitle.setText("OCCUPIED UNITS");

        lblOccupiedUnits.setText("0");

        javax.swing.GroupLayout pnlOccupiedUnitsLayout = new javax.swing.GroupLayout(pnlOccupiedUnits);
        pnlOccupiedUnits.setLayout(pnlOccupiedUnitsLayout);
        pnlOccupiedUnitsLayout.setHorizontalGroup(
            pnlOccupiedUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOccupiedUnitsLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlOccupiedUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOccupiedUnitsTitle)
                    .addGroup(pnlOccupiedUnitsLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblOccupiedUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        pnlOccupiedUnitsLayout.setVerticalGroup(
            pnlOccupiedUnitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOccupiedUnitsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOccupiedUnitsTitle)
                .addGap(18, 18, 18)
                .addComponent(lblOccupiedUnits)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        lblUpcomingReservationTitle.setText("UPCOMING RESERVATION");

        lblUpcomingReservations.setText("0");

        javax.swing.GroupLayout pnlUpcomingReservationsLayout = new javax.swing.GroupLayout(pnlUpcomingReservations);
        pnlUpcomingReservations.setLayout(pnlUpcomingReservationsLayout);
        pnlUpcomingReservationsLayout.setHorizontalGroup(
            pnlUpcomingReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpcomingReservationsLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(pnlUpcomingReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpcomingReservationsLayout.createSequentialGroup()
                        .addComponent(lblUpcomingReservationTitle)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpcomingReservationsLayout.createSequentialGroup()
                        .addComponent(lblUpcomingReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        pnlUpcomingReservationsLayout.setVerticalGroup(
            pnlUpcomingReservationsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpcomingReservationsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUpcomingReservationTitle)
                .addGap(18, 18, 18)
                .addComponent(lblUpcomingReservations)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addComponent(pnlTotalUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlAvailableUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlOccupiedUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlUpcomingReservations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56)
                        .addComponent(pnlTotalUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlAvailableUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlOccupiedUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlUpcomingReservations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidebarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDashboardActionPerformed

    private void btnUnitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnitsActionPerformed
        UnitsPanel unitsPanel = new UnitsPanel();

javax.swing.JFrame unitsFrame =
        new javax.swing.JFrame("PrimaveraStay - Units Management");

unitsFrame.setDefaultCloseOperation(
        javax.swing.JFrame.DISPOSE_ON_CLOSE
);

unitsFrame.setContentPane(unitsPanel);


unitsFrame.setSize(1200, 750);
unitsFrame.setLocationRelativeTo(this);
unitsFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);


unitsFrame.setVisible(true);

    }//GEN-LAST:event_btnUnitsActionPerformed

    private void btnArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchiveActionPerformed
        
ArchivePanel archivePanel = new ArchivePanel();

javax.swing.JFrame archiveFrame =
        new javax.swing.JFrame("PrimaveraStay - Archive");

archiveFrame.setDefaultCloseOperation(
        javax.swing.JFrame.DISPOSE_ON_CLOSE
);

archiveFrame.setContentPane(archivePanel);

archiveFrame.setSize(1200, 750);
archiveFrame.setLocationRelativeTo(this);
archiveFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
archiveFrame.setVisible(true);

    }//GEN-LAST:event_btnArchiveActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int choice = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Logout",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (choice == javax.swing.JOptionPane.YES_OPTION) {
    LoginForm login = new LoginForm();
    login.setLocationRelativeTo(null);
    login.setVisible(true);

    this.dispose();
}
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnReservationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservationsActionPerformed
       
        ReservationsPanel reservationsPanel =
        new ReservationsPanel(loggedInUser);

    javax.swing.JFrame reservationsFrame =
            new javax.swing.JFrame("PrimaveraStay - Reservations Management");

    reservationsFrame.setDefaultCloseOperation(
            javax.swing.JFrame.DISPOSE_ON_CLOSE
    );

    reservationsFrame.setContentPane(reservationsPanel);
    
reservationsFrame.setSize(1200, 750);
reservationsFrame.setLocationRelativeTo(this);
reservationsFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
reservationsFrame.setVisible(true);

    }//GEN-LAST:event_btnReservationsActionPerformed

    private void btnReservationsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservationsMouseEntered
        btnReservations.setContentAreaFilled(true);
        btnReservations.setBackground(new java.awt.Color(70, 116, 157));
    }//GEN-LAST:event_btnReservationsMouseEntered

    private void btnReservationsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservationsMouseExited
      btnReservations.setBackground(new java.awt.Color(31, 45, 61));
    }//GEN-LAST:event_btnReservationsMouseExited

    private void btnPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentsActionPerformed
        PaymentsPanel paymentsFrame = new PaymentsPanel(loggedInUser);
paymentsFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
paymentsFrame.setTitle("Payment Management - PrimaveraStay");
paymentsFrame.setDefaultCloseOperation(
        javax.swing.JFrame.DISPOSE_ON_CLOSE
);
paymentsFrame.setLocationRelativeTo(this);
paymentsFrame.setVisible(true);
    }//GEN-LAST:event_btnPaymentsActionPerformed

    private void btnClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientsActionPerformed
       ClientsForm clientsFrame = new ClientsForm();

clientsFrame.setTitle("Client Management - PrimaveraStay");
clientsFrame.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
clientsFrame.setDefaultCloseOperation(
        javax.swing.JFrame.DISPOSE_ON_CLOSE
);

clientsFrame.setLocationRelativeTo(this);
clientsFrame.setVisible(true);
    }//GEN-LAST:event_btnClientsActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchive;
    private javax.swing.JButton btnClients;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPayments;
    private javax.swing.JButton btnReservations;
    private javax.swing.JButton btnUnits;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblAvailableUnits;
    private javax.swing.JLabel lblAvailableUnitsTitle;
    private javax.swing.JLabel lblOccupiedUnits;
    private javax.swing.JLabel lblOccupiedUnitsTitle;
    private javax.swing.JLabel lblTotalUnits;
    private javax.swing.JLabel lblTotalUnitsTitle;
    private javax.swing.JLabel lblUpcomingReservationTitle;
    private javax.swing.JLabel lblUpcomingReservations;
    private javax.swing.JPanel pnlAvailableUnits;
    private javax.swing.JPanel pnlOccupiedUnits;
    private javax.swing.JPanel pnlTotalUnits;
    private javax.swing.JPanel pnlUpcomingReservations;
    private javax.swing.JPanel sidebarPanel;
    // End of variables declaration//GEN-END:variables
}
