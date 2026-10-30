/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class RegisterForm extends javax.swing.JFrame {

    /**
     * Creates new form RegisterForm
     */
    public RegisterForm() {
    initComponents();
    applyRegisterDesign();

    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);
}
    
    
private void applyRegisterDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    // STYLE TEXT FIELDS
    javax.swing.text.JTextComponent[] fields = {
        txtFullName, txtEmail, txtContactNumber,
        txtUsername, txtPassword, txtConfirmPassword
    };

    for (javax.swing.text.JTextComponent field : fields) {
        field.setFont(new java.awt.Font("Segoe UI", 0, 14));
        field.setBackground(java.awt.Color.WHITE);
        field.setForeground(navy);
        field.setPreferredSize(new java.awt.Dimension(300, 43));
        field.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(border),
                javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)
            )
        );
    }

    javax.swing.JLabel[] labels = {
        jLabel2, jLabel3, jLabel4,
        jLabel5, jLabel6, jLabel7
    };

    for (javax.swing.JLabel label : labels) {
        label.setFont(new java.awt.Font("Segoe UI", 1, 13));
        label.setForeground(navy);
    }

    lblRegisterTtile.setFont(
        new java.awt.Font("Segoe UI", 1, 29)
    );
    lblRegisterTtile.setForeground(navy);
    lblRegisterTtile.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );

    jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14));
    jLabel1.setForeground(muted);
    jLabel1.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );

    chkShowPassword.setOpaque(false);
    chkShowConfirmPassword.setOpaque(false);
    chkShowPassword.setForeground(navy);
    chkShowConfirmPassword.setForeground(navy);

    btnCreateAccount.setText("CREATE ACCOUNT");
    btnCreateAccount.setBackground(blue);
    btnCreateAccount.setForeground(java.awt.Color.WHITE);
    btnCreateAccount.setFont(
        new java.awt.Font("Segoe UI", 1, 15)
    );
    btnCreateAccount.setFocusPainted(false);
    btnCreateAccount.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );
    btnCreateAccount.setPreferredSize(
        new java.awt.Dimension(600, 46)
    );

    lblSignIn.setForeground(blue);
    lblSignIn.setFont(new java.awt.Font("Segoe UI", 1, 14));
    lblSignIn.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );

    jLabel9.setForeground(muted);
    jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14));

    // REBUILD REGISTRATION CARD
    pnlRegisterCard.removeAll();
    pnlRegisterCard.setLayout(new java.awt.GridBagLayout());
    pnlRegisterCard.setBackground(java.awt.Color.WHITE);
    pnlRegisterCard.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(25, 35, 25, 35)
        )
    );

    java.awt.GridBagConstraints gbc =
        new java.awt.GridBagConstraints();

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.weightx = 1;
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gbc.insets = new java.awt.Insets(0, 0, 5, 0);
    pnlRegisterCard.add(lblRegisterTtile, gbc);

    gbc.gridy++;
    gbc.insets = new java.awt.Insets(0, 0, 25, 0);
    pnlRegisterCard.add(jLabel1, gbc);

    // TWO COLUMN FIELDS
    javax.swing.JLabel[][] fieldLabels = {
        {jLabel2, jLabel3},
        {jLabel4, jLabel5},
        {jLabel6, jLabel7}
    };

    javax.swing.text.JTextComponent[][] inputs = {
        {txtFullName, txtEmail},
        {txtContactNumber, txtUsername},
        {txtPassword, txtConfirmPassword}
    };

    for (int row = 0; row < 3; row++) {

        for (int col = 0; col < 2; col++) {

            gbc.gridx = col;
            gbc.gridy = 2 + row * 2;
            gbc.gridwidth = 1;
            gbc.weightx = 0.5;
            gbc.insets = new java.awt.Insets(
                0, col == 0 ? 0 : 10, 6, col == 0 ? 10 : 0
            );

            pnlRegisterCard.add(fieldLabels[row][col], gbc);

            gbc.gridy = 3 + row * 2;
            gbc.insets = new java.awt.Insets(
                0, col == 0 ? 0 : 10, 18, col == 0 ? 10 : 0
            );

            pnlRegisterCard.add(inputs[row][col], gbc);
        }
    }

    // PASSWORD CHECKBOXES
    gbc.gridy = 8;
    gbc.gridx = 0;
    gbc.gridwidth = 1;
    gbc.insets = new java.awt.Insets(0, 0, 18, 10);
    pnlRegisterCard.add(chkShowPassword, gbc);

    gbc.gridx = 1;
    gbc.insets = new java.awt.Insets(0, 10, 18, 0);
    pnlRegisterCard.add(chkShowConfirmPassword, gbc);

    // CREATE ACCOUNT BUTTON
    gbc.gridx = 0;
    gbc.gridy = 9;
    gbc.gridwidth = 2;
    gbc.insets = new java.awt.Insets(0, 0, 18, 0);
    pnlRegisterCard.add(btnCreateAccount, gbc);

    // SIGN IN LINK
    javax.swing.JPanel signInRow = new javax.swing.JPanel(
        new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 7, 0)
    );
    signInRow.setOpaque(false);
    signInRow.add(jLabel9);
    signInRow.add(lblSignIn);

    gbc.gridy = 10;
    gbc.insets = new java.awt.Insets(0, 0, 0, 0);
    pnlRegisterCard.add(signInRow, gbc);

    // CENTER THE CARD
    pnlRegister.removeAll();
    pnlRegister.setLayout(new java.awt.GridBagLayout());
    pnlRegister.setBackground(bg);

    pnlRegisterCard.setPreferredSize(
        new java.awt.Dimension(760, 565)
    );

    pnlRegister.add(pnlRegisterCard);

    // REBUILD FULL WINDOW
    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.BorderLayout());

    javax.swing.JPanel header = new javax.swing.JPanel(
        new java.awt.BorderLayout()
    );
    header.setBackground(navy);
    header.setPreferredSize(new java.awt.Dimension(0, 95));
    header.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(15, 40, 15, 40)
    );

    javax.swing.JLabel systemName = new javax.swing.JLabel(
        "<html><b>PrimaveraStay</b><br>"
        + "<span style='font-size:11px'>"
        + "Condo Booking &amp; Reservation</span></html>"
    );
    systemName.setFont(new java.awt.Font("Segoe UI", 1, 24));
    systemName.setForeground(java.awt.Color.WHITE);

    javax.swing.JLabel portal = new javax.swing.JLabel(
        "CLIENT REGISTRATION"
    );
    portal.setForeground(java.awt.Color.WHITE);
    portal.setFont(new java.awt.Font("Segoe UI", 1, 14));

    header.add(systemName, java.awt.BorderLayout.WEST);
    header.add(portal, java.awt.BorderLayout.EAST);

    getContentPane().add(header, java.awt.BorderLayout.NORTH);
    getContentPane().add(pnlRegister, java.awt.BorderLayout.CENTER);

    // KEEP THE FORM USABLE ON SMALLER SCREENS
    javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(
        pnlRegister
    );
    scroll.setBorder(null);
    scroll.getVerticalScrollBar().setUnitIncrement(16);

    getContentPane().remove(pnlRegister);
    getContentPane().add(scroll, java.awt.BorderLayout.CENTER);

    getContentPane().revalidate();
    getContentPane().repaint();
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBranding = new javax.swing.JPanel();
        lblBrandingImage = new javax.swing.JLabel();
        pnlRegister = new javax.swing.JPanel();
        pnlRegisterCard = new javax.swing.JPanel();
        lblRegisterTtile = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnCreateAccount = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblSignIn = new javax.swing.JLabel();
        chkShowPassword = new javax.swing.JCheckBox();
        chkShowConfirmPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBranding.setBackground(new java.awt.Color(45, 73, 104));

        lblBrandingImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/primaverastay/images/primavera_bgg.png"))); // NOI18N

        javax.swing.GroupLayout pnlBrandingLayout = new javax.swing.GroupLayout(pnlBranding);
        pnlBranding.setLayout(pnlBrandingLayout);
        pnlBrandingLayout.setHorizontalGroup(
            pnlBrandingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBrandingImage, javax.swing.GroupLayout.PREFERRED_SIZE, 480, Short.MAX_VALUE)
        );
        pnlBrandingLayout.setVerticalGroup(
            pnlBrandingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBrandingImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pnlRegister.setBackground(new java.awt.Color(244, 247, 250));

        pnlRegisterCard.setBackground(new java.awt.Color(255, 255, 255));

        lblRegisterTtile.setBackground(new java.awt.Color(35, 55, 75));
        lblRegisterTtile.setFont(new java.awt.Font("Georgia", 1, 30)); // NOI18N
        lblRegisterTtile.setForeground(new java.awt.Color(35, 55, 75));
        lblRegisterTtile.setText("Create an Account");
        lblRegisterTtile.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblRegisterTtileAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(110, 120, 130));
        jLabel1.setText("Create your account to start booking your stay.");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 65, 75));
        jLabel2.setText("Full Name");

        txtFullName.setBackground(new java.awt.Color(250, 252, 255));
        txtFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullNameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(55, 66, 75));
        jLabel3.setText("Email Address");

        txtEmail.setBackground(new java.awt.Color(250, 252, 255));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(55, 65, 75));
        jLabel4.setText("Contact Number");

        txtContactNumber.setBackground(new java.awt.Color(250, 252, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(55, 65, 75));
        jLabel5.setText("Username");

        txtUsername.setBackground(new java.awt.Color(250, 252, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(55, 65, 75));
        jLabel6.setText("Password");

        txtPassword.setBackground(new java.awt.Color(250, 252, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(55, 65, 75));
        jLabel7.setText("Confirm Password");

        txtConfirmPassword.setBackground(new java.awt.Color(250, 252, 255));

        btnCreateAccount.setBackground(new java.awt.Color(66, 105, 145));
        btnCreateAccount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCreateAccount.setForeground(new java.awt.Color(225, 255, 255));
        btnCreateAccount.setText("CREATE ACCOUNT");
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(110, 120, 130));
        jLabel9.setText("Already have an account?");

        lblSignIn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblSignIn.setForeground(new java.awt.Color(49, 82, 116));
        lblSignIn.setText("Sign In");
        lblSignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignInMouseClicked(evt);
            }
        });

        chkShowPassword.setText("Show Password");
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        chkShowConfirmPassword.setText("Show Password");
        chkShowConfirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowConfirmPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlRegisterCardLayout = new javax.swing.GroupLayout(pnlRegisterCard);
        pnlRegisterCard.setLayout(pnlRegisterCardLayout);
        pnlRegisterCardLayout.setHorizontalGroup(
            pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(lblRegisterTtile, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName)
                            .addComponent(txtEmail)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txtContactNumber)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUsername)
                            .addComponent(btnCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterCardLayout.createSequentialGroup()
                                .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                                            .addComponent(txtPassword)
                                            .addGap(18, 18, 18))
                                        .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(164, 164, 164)))
                                    .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                                        .addComponent(chkShowPassword)
                                        .addGap(135, 135, 135)))
                                .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkShowConfirmPassword)
                                    .addComponent(jLabel7)
                                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSignIn)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlRegisterCardLayout.setVerticalGroup(
            pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRegisterCardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblRegisterTtile)
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkShowPassword)
                    .addComponent(chkShowConfirmPassword))
                .addGap(18, 18, 18)
                .addComponent(btnCreateAccount)
                .addGap(18, 18, 18)
                .addGroup(pnlRegisterCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSignIn)
                    .addComponent(jLabel9))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlRegisterLayout = new javax.swing.GroupLayout(pnlRegister);
        pnlRegister.setLayout(pnlRegisterLayout);
        pnlRegisterLayout.setHorizontalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(pnlRegisterCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        pnlRegisterLayout.setVerticalGroup(
            pnlRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRegisterLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(pnlRegisterCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBranding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBranding, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegisterTtileAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblRegisterTtileAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRegisterTtileAncestorAdded

    private void txtFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullNameActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed

String fullName = txtFullName.getText().trim();
String email = txtEmail.getText().trim();
String contact = txtContactNumber.getText().trim();
String username = txtUsername.getText().trim();
String password = new String(txtPassword.getPassword());
String confirmPassword = new String(txtConfirmPassword.getPassword());

if (fullName.isEmpty() || email.isEmpty() || username.isEmpty()
        || password.isEmpty() || confirmPassword.isEmpty()) {

    javax.swing.JOptionPane.showMessageDialog(this,
            "Please fill in all required fields.");
    return;
}

if (!password.equals(confirmPassword)) {
    javax.swing.JOptionPane.showMessageDialog(this,
            "Passwords do not match.");
    return;
}

UserDAO userDAO = new UserDAO();

if (userDAO.registerClient(
        fullName,
        email,
        contact,
        username,
        password)) {

    javax.swing.JOptionPane.showMessageDialog(this,
            "Account created successfully!");

    User newClient = userDAO.login(username, password);

    if (newClient != null) {
    new ClientDashboardForm(newClient).setVisible(true);
    this.dispose();
}
    
} else {
    javax.swing.JOptionPane.showMessageDialog(this,
            "Registration failed. Email or username may already exist.");
}
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
    if (chkShowPassword.isSelected()) {
    txtPassword.setEchoChar((char) 0);
} else {
    txtPassword.setEchoChar('\u2022');
}
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    private void chkShowConfirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowConfirmPasswordActionPerformed
    if (chkShowConfirmPassword.isSelected()) {
    txtConfirmPassword.setEchoChar((char) 0);
} else {
    txtConfirmPassword.setEchoChar('\u2022');
}
    }//GEN-LAST:event_chkShowConfirmPasswordActionPerformed

    private void lblSignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignInMouseClicked
        
        ClientLoginForm login = new ClientLoginForm();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblSignInMouseClicked

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
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JCheckBox chkShowConfirmPassword;
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblBrandingImage;
    private javax.swing.JLabel lblRegisterTtile;
    private javax.swing.JLabel lblSignIn;
    private javax.swing.JPanel pnlBranding;
    private javax.swing.JPanel pnlRegister;
    private javax.swing.JPanel pnlRegisterCard;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

