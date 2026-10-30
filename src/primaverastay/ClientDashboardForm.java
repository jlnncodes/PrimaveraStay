/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class ClientDashboardForm extends javax.swing.JFrame {

    private User currentUser;
    
    /**
     * Creates new form ClientDashboardForm
     */
    public ClientDashboardForm(User user) {
    
    initComponents();

    this.currentUser = user;

    setupClientPages();
    applyDashboardDesign();
    
    
    btnDashboard.addActionListener(e -> showClientPage("Dashboard"));
    
    btnMyReservations.addActionListener(e -> {
    for (java.awt.Component component : pnlContent.getComponents()) {
        if (component instanceof MyReservationsPanel) {
            ((MyReservationsPanel) component).refreshReservations();
            break;
        }
    }

    showClientPage("My Reservations");
});
  
    
btnMyPayments.addActionListener(e -> {
    for (java.awt.Component component : pnlContent.getComponents()) {
        if (component instanceof MyPaymentsPanel) {
            ((MyPaymentsPanel) component).refreshPayments();
            break;
        }
    }

    showClientPage("My Payments");
});

    btnMyProfile.addActionListener(e -> showClientPage("My Profile"));


    setTitle("PrimaveraStay - Client Dashboard");
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);

    if (user != null) {
        lblWelcome.setText(
            "Welcome, " + user.getFullName() + "!"
        );
    }
}
    
    
private void applyDashboardDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color sidebar = new java.awt.Color(232, 240, 251);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    // MAIN WINDOW
    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.BorderLayout());

    pnlMain.removeAll();
    pnlMain.setLayout(new java.awt.BorderLayout());
    pnlMain.setBackground(bg);

    // HEADER
    pnlHeader.removeAll();
    pnlHeader.setLayout(new java.awt.BorderLayout());
    pnlHeader.setBackground(navy);
    pnlHeader.setPreferredSize(new java.awt.Dimension(0, 90));
    pnlHeader.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(
            15, 35, 15, 35
        )
    );

    javax.swing.JPanel branding = new javax.swing.JPanel();
    branding.setOpaque(false);
    branding.setLayout(new javax.swing.BoxLayout(
        branding, javax.swing.BoxLayout.Y_AXIS
    ));

    lblSystemName.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 27)
    );
    lblSystemName.setForeground(java.awt.Color.WHITE);

    javax.swing.JLabel subtitle = new javax.swing.JLabel(
        "Condo Booking & Reservation"
    );
    subtitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13)
    );
    subtitle.setForeground(new java.awt.Color(220, 230, 240));

    branding.add(lblSystemName);
    branding.add(subtitle);

    lblPortal.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );
    lblPortal.setForeground(java.awt.Color.WHITE);

    pnlHeader.add(branding, java.awt.BorderLayout.WEST);
    pnlHeader.add(lblPortal, java.awt.BorderLayout.EAST);

    // SIDEBAR
    pnlSidebar.removeAll();
    pnlSidebar.setLayout(new java.awt.BorderLayout());
    pnlSidebar.setBackground(sidebar);
    pnlSidebar.setPreferredSize(new java.awt.Dimension(255, 0));

    pnlSidebar.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(
            20, 12, 20, 12
        )
    );

    javax.swing.JPanel navigation = new javax.swing.JPanel();
    navigation.setOpaque(false);
    navigation.setLayout(new javax.swing.BoxLayout(
        navigation, javax.swing.BoxLayout.Y_AXIS
    ));

    javax.swing.JButton[] buttons = {
        btnDashboard,
        btnBrowseUnits,
        btnMyReservations,
        btnMyPayments,
        btnMyProfile,
        btnLogout
    };

    for (javax.swing.JButton button : buttons) {

        button.setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
        );

        button.setBackground(java.awt.Color.WHITE);
        button.setForeground(navy);
        button.setFocusPainted(false);
        button.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(border),
                javax.swing.BorderFactory.createEmptyBorder(
                    10, 15, 10, 10
                )
            )
        );

        button.setHorizontalAlignment(
            javax.swing.SwingConstants.LEFT
        );

        button.setCursor(
            new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
        );

        button.setMaximumSize(
            new java.awt.Dimension(Integer.MAX_VALUE, 48)
        );

        button.setPreferredSize(
            new java.awt.Dimension(220, 48)
        );

        button.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        navigation.add(button);
        navigation.add(
            javax.swing.Box.createVerticalStrut(12)
        );
    }

    pnlSidebar.add(navigation, java.awt.BorderLayout.NORTH);

    // DASHBOARD HOME PAGE
    java.awt.Component dashboardComponent = null;

    for (java.awt.Component component : pnlContent.getComponents()) {
        if (component instanceof javax.swing.JPanel
                && !(component instanceof BrowseUnitsPanel)
                && !(component instanceof MyReservationsPanel)
                && !(component instanceof MyPaymentsPanel)
                && !(component instanceof MyProfilePanel)) {

            dashboardComponent = component;
            break;
        }
    }

    if (dashboardComponent instanceof javax.swing.JPanel) {

        javax.swing.JPanel dashboard =
            (javax.swing.JPanel) dashboardComponent;

        dashboard.removeAll();
        dashboard.setLayout(new java.awt.BorderLayout(0, 25));
        dashboard.setBackground(bg);

        dashboard.setBorder(
            javax.swing.BorderFactory.createEmptyBorder(
                30, 35, 30, 35
            )
        );

        // WELCOME SECTION
        javax.swing.JPanel welcome = new javax.swing.JPanel();
        welcome.setOpaque(false);
        welcome.setLayout(new javax.swing.BoxLayout(
            welcome, javax.swing.BoxLayout.Y_AXIS
        ));

        lblWelcome.setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 28)
        );
        lblWelcome.setForeground(navy);
        lblWelcome.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        jLabel1.setFont(
            new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 15)
        );
        jLabel1.setForeground(muted);
        jLabel1.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);

        welcome.add(lblWelcome);
        welcome.add(javax.swing.Box.createVerticalStrut(8));
        welcome.add(jLabel1);

        dashboard.add(welcome, java.awt.BorderLayout.NORTH);

        // FOUR DASHBOARD CARDS
        javax.swing.JPanel cards = new javax.swing.JPanel(
            new java.awt.GridLayout(2, 2, 20, 20)
        );
        cards.setOpaque(false);

        styleClientCard(
            pnlBrowseCard, jLabel2, jLabel3,
            navy, muted, border
        );

        styleClientCard(
            pnlReservationsCard, jLabel6, jLabel7,
            navy, muted, border
        );

        styleClientCard(
            pnlPaymentCard, jLabel4, jLabel5,
            navy, muted, border
        );

        styleClientCard(
            pnlProfileCard, jLabel8, jLabel9,
            navy, muted, border
        );

        cards.add(pnlBrowseCard);
        cards.add(pnlReservationsCard);
        cards.add(pnlPaymentCard);
        cards.add(pnlProfileCard);

        javax.swing.JPanel cardWrapper =
            new javax.swing.JPanel(new java.awt.BorderLayout());

        cardWrapper.setOpaque(false);
        cardWrapper.add(cards, java.awt.BorderLayout.NORTH);

        dashboard.add(cardWrapper, java.awt.BorderLayout.CENTER);

        dashboard.revalidate();
        dashboard.repaint();
    }

    // REASSEMBLE THE WINDOW
    pnlMain.add(pnlHeader, java.awt.BorderLayout.NORTH);
    pnlMain.add(pnlSidebar, java.awt.BorderLayout.WEST);
    pnlMain.add(pnlContent, java.awt.BorderLayout.CENTER);

    getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

    // KEEP THE DASHBOARD VISIBLE FIRST
    clientPages.show(pnlContent, "Dashboard");

    getContentPane().revalidate();
    getContentPane().repaint();
}

private void styleClientCard(
        javax.swing.JPanel card,
        javax.swing.JLabel title,
        javax.swing.JLabel description,
        java.awt.Color navy,
        java.awt.Color muted,
        java.awt.Color border) {

    card.removeAll();
    card.setLayout(new java.awt.BorderLayout(0, 12));
    card.setBackground(java.awt.Color.WHITE);

    card.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                25, 25, 25, 25
            )
        )
    );

    title.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20)
    );
    title.setForeground(navy);

    description.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
    );
    description.setForeground(muted);

    card.add(title, java.awt.BorderLayout.NORTH);
    card.add(description, java.awt.BorderLayout.CENTER);

    card.setPreferredSize(new java.awt.Dimension(300, 160));
}

    
private java.awt.CardLayout clientPages;


private void setupClientPages() {

    clientPages = new java.awt.CardLayout();

    // Keep the original dashboard panel
    javax.swing.JPanel dashboardPage = new javax.swing.JPanel();
    dashboardPage.setLayout(new java.awt.BorderLayout());

    // Move existing dashboard components into the dashboard page
    java.awt.Component[] components = pnlContent.getComponents();

    for (java.awt.Component component : components) {
        pnlContent.remove(component);
    }

    dashboardPage.setLayout(null);

    for (java.awt.Component component : components) {
        dashboardPage.add(component);
    }

    // Set up page navigation
    pnlContent.setLayout(clientPages);

    pnlContent.add(dashboardPage, "Dashboard");
    pnlContent.add(
    new BrowseUnitsPanel(currentUser.getUserId()),
    "Browse Units"
    );

    pnlContent.add(
        
    new MyReservationsPanel(currentUser.getUserId()),
    "My Reservations"
    );
    
    pnlContent.add(
            
    new MyPaymentsPanel(currentUser.getUserId()),
    "My Payments"
    );
    
    pnlContent.add(
    new MyProfilePanel(currentUser),
    "My Profile"
    );

    clientPages.show(pnlContent, "Dashboard");

    pnlContent.revalidate();
    pnlContent.repaint();
}



private void showClientPage(String pageName) {

    clientPages.show(pnlContent, pageName);

    pnlContent.revalidate();
    pnlContent.repaint();
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
        pnlHeader = new javax.swing.JPanel();
        lblSystemName = new javax.swing.JLabel();
        lblPortal = new javax.swing.JLabel();
        pnlSidebar = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JButton();
        btnBrowseUnits = new javax.swing.JButton();
        btnMyReservations = new javax.swing.JButton();
        btnMyPayments = new javax.swing.JButton();
        btnMyProfile = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        pnlContent = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pnlBrowseCard = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pnlPaymentCard = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlReservationsCard = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlProfileCard = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setBackground(new java.awt.Color(244, 248, 252));

        pnlHeader.setBackground(new java.awt.Color(30, 58, 95));

        lblSystemName.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblSystemName.setForeground(new java.awt.Color(255, 255, 255));
        lblSystemName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSystemName.setText("PrimaveraStay");

        lblPortal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPortal.setForeground(new java.awt.Color(255, 255, 255));
        lblPortal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPortal.setText("CLIENT PORTAL");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lblSystemName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPortal)
                .addGap(47, 47, 47))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSystemName)
                    .addComponent(lblPortal))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlSidebar.setBackground(new java.awt.Color(232, 240, 251));

        btnDashboard.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnDashboard.setForeground(new java.awt.Color(30, 58, 95));
        btnDashboard.setText("Dashboard");
        btnDashboard.setFocusPainted(false);
        btnDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDashboard.setIconTextGap(12);

        btnBrowseUnits.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnBrowseUnits.setForeground(new java.awt.Color(30, 58, 95));
        btnBrowseUnits.setText("Browse Units");
        btnBrowseUnits.setFocusPainted(false);
        btnBrowseUnits.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBrowseUnits.setIconTextGap(12);
        btnBrowseUnits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseUnitsActionPerformed(evt);
            }
        });

        btnMyReservations.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnMyReservations.setForeground(new java.awt.Color(30, 58, 95));
        btnMyReservations.setText("My Reservations");
        btnMyReservations.setFocusPainted(false);
        btnMyReservations.setFocusTraversalPolicyProvider(true);
        btnMyReservations.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMyReservations.setIconTextGap(12);

        btnMyPayments.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnMyPayments.setForeground(new java.awt.Color(30, 58, 95));
        btnMyPayments.setText("My Payments");
        btnMyPayments.setFocusPainted(false);
        btnMyPayments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        btnMyProfile.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnMyProfile.setForeground(new java.awt.Color(30, 58, 95));
        btnMyProfile.setText("My Profile");
        btnMyProfile.setFocusPainted(false);
        btnMyProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnMyProfile.setIconTextGap(12);

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(30, 58, 95));
        btnLogout.setText("Logout");
        btnLogout.setFocusPainted(false);
        btnLogout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLogout.setIconTextGap(12);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSidebarLayout = new javax.swing.GroupLayout(pnlSidebar);
        pnlSidebar.setLayout(pnlSidebarLayout);
        pnlSidebarLayout.setHorizontalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSidebarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMyProfile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMyPayments, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDashboard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBrowseUnits, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMyReservations, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        pnlSidebarLayout.setVerticalGroup(
            pnlSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSidebarLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBrowseUnits, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMyReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMyPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMyProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pnlContent.setBackground(new java.awt.Color(244, 248, 252));

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(30, 58, 95));
        lblWelcome.setText("Welcome to PrimaveraStay!");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 58, 95));
        jLabel1.setText("Find your perfect stay and manage your bookings.");

        pnlBrowseCard.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 58, 95));
        jLabel2.setText("Browse Units");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(107, 128, 150));
        jLabel3.setText("Explore available condo units");

        javax.swing.GroupLayout pnlBrowseCardLayout = new javax.swing.GroupLayout(pnlBrowseCard);
        pnlBrowseCard.setLayout(pnlBrowseCardLayout);
        pnlBrowseCardLayout.setHorizontalGroup(
            pnlBrowseCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBrowseCardLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnlBrowseCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        pnlBrowseCardLayout.setVerticalGroup(
            pnlBrowseCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBrowseCardLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlPaymentCard.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 58, 95));
        jLabel4.setText("My Payments");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(107, 128, 150));
        jLabel5.setText("View your payment history");

        javax.swing.GroupLayout pnlPaymentCardLayout = new javax.swing.GroupLayout(pnlPaymentCard);
        pnlPaymentCard.setLayout(pnlPaymentCardLayout);
        pnlPaymentCardLayout.setHorizontalGroup(
            pnlPaymentCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentCardLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlPaymentCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPaymentCardLayout.setVerticalGroup(
            pnlPaymentCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaymentCardLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pnlReservationsCard.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 58, 95));
        jLabel6.setText("My Reservations");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(107, 128, 150));
        jLabel7.setText("View your booking details");

        javax.swing.GroupLayout pnlReservationsCardLayout = new javax.swing.GroupLayout(pnlReservationsCard);
        pnlReservationsCard.setLayout(pnlReservationsCardLayout);
        pnlReservationsCardLayout.setHorizontalGroup(
            pnlReservationsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReservationsCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlReservationsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        pnlReservationsCardLayout.setVerticalGroup(
            pnlReservationsCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReservationsCardLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pnlProfileCard.setBackground(new java.awt.Color(255, 255, 255));
        pnlProfileCard.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 58, 95));
        jLabel8.setText("My Profile");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(107, 128, 150));
        jLabel9.setText("Manage account information");

        javax.swing.GroupLayout pnlProfileCardLayout = new javax.swing.GroupLayout(pnlProfileCard);
        pnlProfileCard.setLayout(pnlProfileCardLayout);
        pnlProfileCardLayout.setHorizontalGroup(
            pnlProfileCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfileCardLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlProfileCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        pnlProfileCardLayout.setVerticalGroup(
            pnlProfileCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProfileCardLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContentLayout = new javax.swing.GroupLayout(pnlContent);
        pnlContent.setLayout(pnlContentLayout);
        pnlContentLayout.setHorizontalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnlBrowseCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPaymentCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlReservationsCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlProfileCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        pnlContentLayout.setVerticalGroup(
            pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContentLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlReservationsCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBrowseCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlProfileCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlPaymentCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseUnitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseUnitsActionPerformed
    
        showClientPage("Browse Units");
    }//GEN-LAST:event_btnBrowseUnitsActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
     int choice = javax.swing.JOptionPane.showConfirmDialog(
        this,
        "Are you sure you want to logout?",
        "Confirm Logout",
        javax.swing.JOptionPane.YES_NO_OPTION
);

if (choice == javax.swing.JOptionPane.YES_OPTION) {

    currentUser = null;

    ClientLoginForm login = new ClientLoginForm();
    login.setVisible(true);

    this.dispose();
}
    }//GEN-LAST:event_btnLogoutActionPerformed

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
            java.util.logging.Logger.getLogger(ClientDashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientDashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientDashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientDashboardForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientLoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseUnits;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMyPayments;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnMyReservations;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblPortal;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlBrowseCard;
    private javax.swing.JPanel pnlContent;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPaymentCard;
    private javax.swing.JPanel pnlProfileCard;
    private javax.swing.JPanel pnlReservationsCard;
    private javax.swing.JPanel pnlSidebar;
    // End of variables declaration//GEN-END:variables
}

