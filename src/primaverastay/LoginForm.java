/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class LoginForm extends javax.swing.JFrame {

    /**
     * Creates new form LoginForm
     */
    
public LoginForm() {
    initComponents();
    applyLoginDesign();
}


private void applyLoginDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    // MAIN WINDOW
    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.GridLayout(1, 2));
    getContentPane().setBackground(bg);

    // LEFT BRANDING PANEL
    jPanel1.removeAll();
    jPanel1.setLayout(new java.awt.GridBagLayout());
    jPanel1.setBackground(navy);

    javax.swing.JPanel branding = new javax.swing.JPanel();
    branding.setOpaque(false);
    branding.setLayout(new javax.swing.BoxLayout(
        branding, javax.swing.BoxLayout.Y_AXIS
    ));

    // ORIGINAL LOGO
    java.net.URL logoURL =
        getClass().getResource("/primaverastay/images/logo.png");

    if (logoURL != null) {
        javax.swing.ImageIcon original =
            new javax.swing.ImageIcon(logoURL);

        java.awt.Image scaled =
            original.getImage().getScaledInstance(
                260, -1, java.awt.Image.SCALE_SMOOTH
            );

        lblLogo.setIcon(new javax.swing.ImageIcon(scaled));
    }

    lblLogo.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );
    lblLogo.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

    jLabel2.setText("PrimaveraStay");
    jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 34));
    jLabel2.setForeground(java.awt.Color.WHITE);
    jLabel2.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

    jLabel3.setText(
        "<html><center>Condo Booking &amp;<br>"
        + "Reservation Management System</center></html>"
    );
    jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16));
    jLabel3.setForeground(new java.awt.Color(191, 219, 254));
    jLabel3.setHorizontalAlignment(
        javax.swing.SwingConstants.CENTER
    );
    jLabel3.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);

    branding.add(lblLogo);
    branding.add(javax.swing.Box.createVerticalStrut(20));
    branding.add(jLabel2);
    branding.add(javax.swing.Box.createVerticalStrut(12));
    branding.add(jLabel3);

    jPanel1.add(branding);

    // RIGHT LOGIN PANEL
    jPanel2.removeAll();
    jPanel2.setLayout(new java.awt.GridBagLayout());
    jPanel2.setBackground(bg);

    javax.swing.JPanel form = new javax.swing.JPanel();
    form.setOpaque(false);
    form.setLayout(new javax.swing.BoxLayout(
        form, javax.swing.BoxLayout.Y_AXIS
    ));
    form.setPreferredSize(new java.awt.Dimension(390, 420));

    jLabel1.setText("Welcome Back!");
    jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32));
    jLabel1.setForeground(navy);

    jLabel4.setText("Sign in to continue to PrimaveraStay");
    jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15));
    jLabel4.setForeground(muted);

    jLabel5.setText("Username");
    jLabel6.setText("Password");

    for (javax.swing.JLabel label :
            new javax.swing.JLabel[]{jLabel5, jLabel6}) {
        label.setFont(new java.awt.Font("Segoe UI", 1, 15));
        label.setForeground(navy);
    }

    for (javax.swing.JTextField field :
            new javax.swing.JTextField[]{
                txtUsername, txtPassword
            }) {

        field.setFont(new java.awt.Font("Segoe UI", 0, 16));
        field.setBackground(java.awt.Color.WHITE);
        field.setForeground(navy);
        field.setMaximumSize(
            new java.awt.Dimension(Integer.MAX_VALUE, 48)
        );
        field.setPreferredSize(new java.awt.Dimension(390, 48));
        field.setBorder(
            javax.swing.BorderFactory.createCompoundBorder(
                javax.swing.BorderFactory.createLineBorder(border),
                javax.swing.BorderFactory.createEmptyBorder(
                    8, 12, 8, 12
                )
            )
        );
    }

    chkShowPassword.setFont(
        new java.awt.Font("Segoe UI", 0, 14)
    );
    chkShowPassword.setForeground(muted);
    chkShowPassword.setOpaque(false);

    btnLogin.setText("LOGIN");
    btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 16));
    btnLogin.setBackground(blue);
    btnLogin.setForeground(java.awt.Color.WHITE);
    btnLogin.setOpaque(true);
    btnLogin.setContentAreaFilled(true);
    btnLogin.setBorderPainted(false);
    btnLogin.setFocusPainted(false);
    btnLogin.setMaximumSize(
        new java.awt.Dimension(Integer.MAX_VALUE, 50)
    );
    btnLogin.setPreferredSize(
        new java.awt.Dimension(390, 50)
    );
    btnLogin.setCursor(
        new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)
    );

    // ALIGN FORM COMPONENTS
    javax.swing.JComponent[] components = {
        jLabel1, jLabel4, jLabel5, txtUsername,
        jLabel6, txtPassword, chkShowPassword, btnLogin
    };

    for (javax.swing.JComponent component : components) {
        component.setAlignmentX(
            java.awt.Component.LEFT_ALIGNMENT
        );
    }

    form.add(jLabel1);
    form.add(javax.swing.Box.createVerticalStrut(10));
    form.add(jLabel4);
    form.add(javax.swing.Box.createVerticalStrut(38));
    form.add(jLabel5);
    form.add(javax.swing.Box.createVerticalStrut(9));
    form.add(txtUsername);
    form.add(javax.swing.Box.createVerticalStrut(22));
    form.add(jLabel6);
    form.add(javax.swing.Box.createVerticalStrut(9));
    form.add(txtPassword);
    form.add(javax.swing.Box.createVerticalStrut(12));
    form.add(chkShowPassword);
    form.add(javax.swing.Box.createVerticalStrut(30));
    form.add(btnLogin);

    jPanel2.add(form);

    getContentPane().add(jPanel1);
    getContentPane().add(jPanel2);

    // FULLSCREEN
    setTitle("PrimaveraStay - Login");
    setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    setSize(1200, 750);
    setLocationRelativeTo(null);
    setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);

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

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        chkShowPassword = new javax.swing.JCheckBox();
        btnLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(31, 43, 59));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/primaverastay/images/logo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PrimaveraStay");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html><center>Condo Booking &<br>Reservation Management System</center></html>");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(245, 247, 250));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Welcome Back!");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Sign in to continue to PrimaveraStay");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Username");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Password");

        chkShowPassword.setText("Show Password");
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkShowPassword)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel1)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(70, 70, 70)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkShowPassword)
                .addGap(55, 55, 55)
                .addComponent(btnLogin)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

    String username = txtUsername.getText().trim();
    String password = new String(txtPassword.getPassword());

    if (username.isEmpty() || password.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Please enter your username and password.",
                "Missing Information",
                javax.swing.JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    UserDAO userDAO = new UserDAO();
    User loggedInUser = userDAO.login(username, password);

    if (loggedInUser != null) {

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Welcome, " + loggedInUser.getFullName() + "!"
        );

        if (loggedInUser.getRole().equalsIgnoreCase("ADMIN")) {

            // Admin dashboard will be connected next
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "ADMIN account successfully detected."
            );
            new DashboardForm(loggedInUser).setVisible(true);
            this.dispose();

        } else if (loggedInUser.getRole().equalsIgnoreCase("CLIENT")) {

            // Client home will be connected later
            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "CLIENT account successfully detected."
            );
        }

    } else { 

        javax.swing.JOptionPane.showMessageDialog(
                this,
                "Invalid username or password.",
                "Login Failed",
                javax.swing.JOptionPane.ERROR_MESSAGE
        );
    }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
    if (chkShowPassword.isSelected()) {
    txtPassword.setEchoChar((char) 0);
    } else {
    txtPassword.setEchoChar('•');
}
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox chkShowPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
