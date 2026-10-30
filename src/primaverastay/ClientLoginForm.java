/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class ClientLoginForm extends javax.swing.JFrame {

    /**
     * Creates new form ClientLoginForm
     */
    public ClientLoginForm() {
    initComponents();
    applyLoginDesign();

    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    setLocationRelativeTo(null);
}

    
private void applyLoginDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    // MAIN BACKGROUND
    pnlBackground.removeAll();
    pnlBackground.setLayout(new java.awt.BorderLayout());
    pnlBackground.setBackground(bg);

    // HEADER
    pnlHeader.removeAll();
    pnlHeader.setLayout(new java.awt.BorderLayout(20, 0));
    pnlHeader.setBackground(navy);
    pnlHeader.setBorder(
        javax.swing.BorderFactory.createEmptyBorder(18, 40, 18, 40)
    );
    pnlHeader.setPreferredSize(new java.awt.Dimension(0, 100));

    javax.swing.JPanel branding = new javax.swing.JPanel();
    branding.setLayout(new javax.swing.BoxLayout(
        branding, javax.swing.BoxLayout.Y_AXIS
    ));
    branding.setOpaque(false);

    lblSystemName.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 28)
    );
    lblSystemName.setForeground(java.awt.Color.WHITE);

    lblSystemSubtitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
    );
    lblSystemSubtitle.setForeground(
        new java.awt.Color(220, 230, 240)
    );

    branding.add(lblSystemName);
    branding.add(lblSystemSubtitle);

    lblPortal.setForeground(java.awt.Color.WHITE);
    lblPortal.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );

    pnlHeader.add(branding, java.awt.BorderLayout.WEST);
    pnlHeader.add(lblPortal, java.awt.BorderLayout.EAST);

    // LOGIN CARD
    pnlLoginCard.removeAll();
    pnlLoginCard.setLayout(new java.awt.GridBagLayout());
    pnlLoginCard.setBackground(java.awt.Color.WHITE);

    pnlLoginCard.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                30, 40, 30, 40
            )
        )
    );

    pnlLoginCard.setPreferredSize(
        new java.awt.Dimension(540, 540)
    );

    lblWelcome.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 30)
    );
    lblWelcome.setForeground(navy);
    lblWelcome.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );

    lblSubtitle.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
    );
    lblSubtitle.setForeground(muted);
    lblSubtitle.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );

    lblEmail.setForeground(navy);
    lblEmail.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );

    lblPassword.setForeground(navy);
    lblPassword.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );
    lblPassword.setText("Password");

    // TEXT FIELDS
    txtEmail.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
    );
    txtPassword.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14)
    );

    txtEmail.setPreferredSize(
        new java.awt.Dimension(440, 44)
    );
    txtPassword.setPreferredSize(
        new java.awt.Dimension(440, 44)
    );

    javax.swing.border.Border fieldBorder =
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12)
        );

    txtEmail.setBorder(fieldBorder);
    txtPassword.setBorder(fieldBorder);

    // SIGN IN BUTTON
    btnLogin.setText("Sign In");
    btnLogin.setBackground(blue);
    btnLogin.setForeground(java.awt.Color.WHITE);
    btnLogin.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15)
    );
    btnLogin.setFocusPainted(false);
    btnLogin.setPreferredSize(
        new java.awt.Dimension(440, 48)
    );
    btnLogin.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );

    // SHOW PASSWORD
    chkShowPassword.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13)
    );
    chkShowPassword.setForeground(navy);
    chkShowPassword.setOpaque(false);

    // REGISTER LINK
    lblRegister.setForeground(blue);
    lblRegister.setFont(
        new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14)
    );
    lblRegister.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );
    lblRegister.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );


    // LAYOUT
    java.awt.GridBagConstraints gbc =
        new java.awt.GridBagConstraints();

    gbc.gridx = 0;
    gbc.weightx = 1;
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;

    gbc.gridy = 0;
    gbc.insets = new java.awt.Insets(0, 0, 8, 0);
    pnlLoginCard.add(lblWelcome, gbc);

    gbc.gridy = 1;
    gbc.insets = new java.awt.Insets(0, 0, 30, 0);
    pnlLoginCard.add(lblSubtitle, gbc);

    gbc.gridy = 2;
    gbc.insets = new java.awt.Insets(0, 0, 8, 0);
    pnlLoginCard.add(lblEmail, gbc);

    gbc.gridy = 3;
    gbc.insets = new java.awt.Insets(0, 0, 20, 0);
    pnlLoginCard.add(txtEmail, gbc);

    gbc.gridy = 4;
    gbc.insets = new java.awt.Insets(0, 0, 8, 0);
    pnlLoginCard.add(lblPassword, gbc);

    gbc.gridy = 5;
    gbc.insets = new java.awt.Insets(0, 0, 12, 0);
    pnlLoginCard.add(txtPassword, gbc);

    javax.swing.JPanel options =
        new javax.swing.JPanel(new java.awt.BorderLayout());

    options.setOpaque(false);
    options.add(
        chkShowPassword,
        java.awt.BorderLayout.WEST
    );

    gbc.gridy = 6;
    gbc.insets = new java.awt.Insets(0, 0, 28, 0);
    pnlLoginCard.add(options, gbc);

    gbc.gridy = 7;
    gbc.insets = new java.awt.Insets(0, 0, 20, 0);
    pnlLoginCard.add(btnLogin, gbc);

    gbc.gridy = 8;
    gbc.insets = new java.awt.Insets(0, 0, 0, 0);
    pnlLoginCard.add(lblRegister, gbc);

    // CENTER LOGIN CARD
    javax.swing.JPanel center =
        new javax.swing.JPanel(new java.awt.GridBagLayout());

    center.setBackground(bg);
    center.add(pnlLoginCard);

    pnlBackground.add(
        pnlHeader,
        java.awt.BorderLayout.NORTH
    );
    pnlBackground.add(
        center,
        java.awt.BorderLayout.CENTER
    );

    pnlBackground.revalidate();
    pnlBackground.repaint();
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBackground = new javax.swing.JPanel();
        pnlLoginCard = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        chkShowPassword = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();
        lblRegister = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        pnlHeader = new javax.swing.JPanel();
        lblSystemName = new javax.swing.JLabel();
        lblSystemSubtitle = new javax.swing.JLabel();
        lblPortal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlBackground.setBackground(new java.awt.Color(244, 248, 252));

        pnlLoginCard.setBackground(new java.awt.Color(255, 255, 255));
        pnlLoginCard.setForeground(new java.awt.Color(107, 128, 150));

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(30, 58, 95));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWelcome.setText("Welcome Back!");

        lblSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(107, 128, 150));
        lblSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubtitle.setText("Sign in to your client account");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(30, 58, 95));
        lblEmail.setText("Email Address");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(30, 58, 95));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(30, 58, 95));
        lblPassword.setText("Pasword");

        chkShowPassword.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        chkShowPassword.setForeground(new java.awt.Color(30, 58, 95));
        chkShowPassword.setText("Show Password");
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(59, 130, 246));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Sign In");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblRegister.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(59, 130, 246));
        lblRegister.setText("Register");
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlLoginCardLayout = new javax.swing.GroupLayout(pnlLoginCard);
        pnlLoginCard.setLayout(pnlLoginCardLayout);
        pnlLoginCardLayout.setHorizontalGroup(
            pnlLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginCardLayout.createSequentialGroup()
                .addGroup(pnlLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLoginCardLayout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(lblWelcome))
                    .addGroup(pnlLoginCardLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addGroup(pnlLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(chkShowPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(282, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginCardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pnlLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginCardLayout.createSequentialGroup()
                        .addComponent(lblSubtitle)
                        .addGap(468, 468, 468))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginCardLayout.createSequentialGroup()
                        .addComponent(lblRegister)
                        .addGap(477, 477, 477))))
        );
        pnlLoginCardLayout.setVerticalGroup(
            pnlLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLoginCardLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblWelcome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(32, 32, 32)
                .addComponent(lblEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkShowPassword)
                .addGap(34, 34, 34)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRegister)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        pnlHeader.setBackground(new java.awt.Color(30, 58, 95));

        lblSystemName.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblSystemName.setForeground(new java.awt.Color(255, 255, 255));
        lblSystemName.setText("PrimaveraStay");

        lblSystemSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSystemSubtitle.setForeground(new java.awt.Color(220, 230, 240));
        lblSystemSubtitle.setText("Condo Booking & Reservation");

        lblPortal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPortal.setForeground(new java.awt.Color(255, 255, 255));
        lblPortal.setText("CLIENT PORTAL");

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSystemSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSystemName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPortal)
                .addGap(37, 37, 37))
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderLayout.createSequentialGroup()
                .addGroup(pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblSystemName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSystemSubtitle))
                    .addGroup(pnlHeaderLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblPortal)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBackgroundLayout = new javax.swing.GroupLayout(pnlBackground);
        pnlBackground.setLayout(pnlBackgroundLayout);
        pnlBackgroundLayout.setHorizontalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBackgroundLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(pnlLoginCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        pnlBackgroundLayout.setVerticalGroup(
            pnlBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBackgroundLayout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlLoginCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
       if (chkShowPassword.isSelected()) {
    txtPassword.setEchoChar((char) 0);
} else {
    txtPassword.setEchoChar('\u2022');
}
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
    
    String email = txtEmail.getText().trim();
    String password = new String(txtPassword.getPassword());

if (email.isEmpty() || password.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please enter your email and password."
    );
    return;
}

UserDAO dao = new UserDAO();
User user = dao.loginClient(email, password);

if (user != null && "CLIENT".equalsIgnoreCase(user.getRole())) {

    javax.swing.JOptionPane.showMessageDialog(
        this,
        "Welcome, " + user.getFullName() + "!"
);

ClientDashboardForm dashboard = new ClientDashboardForm(user);
dashboard.setVisible(true);
this.dispose();

    // We will connect the dashboard here.

} else {
    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Invalid client credentials or inactive account."
    );
}
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        
        RegisterForm register = new RegisterForm();
        register.setLocationRelativeTo(null);
        register.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblRegisterMouseClicked

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
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientLoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPortal;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblSystemName;
    private javax.swing.JLabel lblSystemSubtitle;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlBackground;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlLoginCard;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}


