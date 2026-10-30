/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package primaverastay;

/**
 *
 * @author Potpot
 */
public class MyProfilePanel extends javax.swing.JPanel {

    /**
     * Creates new form MyProfilePanel
     */
    private User currentUser;

    public MyProfilePanel(User user) {
    initComponents();

    applyProfileDesign();
    
    this.currentUser = user;
    loadProfile();
}
    
    
private void applyProfileDesign() {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color blue = new java.awt.Color(59, 130, 246);
    java.awt.Color bg = new java.awt.Color(244, 248, 252);
    java.awt.Color border = new java.awt.Color(220, 230, 240);
    java.awt.Color muted = new java.awt.Color(107, 128, 150);

    // MAIN PANEL
    removeAll();
    setLayout(new java.awt.BorderLayout(0, 25));
    setBackground(bg);
    setBorder(javax.swing.BorderFactory.createEmptyBorder(
        30, 35, 30, 35
    ));

    // PAGE HEADING
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

    // PERSONAL INFORMATION CARD
    jPanel1.removeAll();
    jPanel1.setLayout(new java.awt.BorderLayout(0, 24));
    jPanel1.setBackground(java.awt.Color.WHITE);
    jPanel1.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                28, 32, 28, 32
            )
        )
    );

    jLabel1.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 21
    ));
    jLabel1.setForeground(navy);

    jPanel1.add(jLabel1, java.awt.BorderLayout.NORTH);

    // TWO-COLUMN FORM
    javax.swing.JPanel fields = new javax.swing.JPanel(
        new java.awt.GridLayout(2, 2, 24, 25)
    );
    fields.setOpaque(false);

    addProfileField(fields, jLabel2, txtFullName);
    addProfileField(fields, jLabel3, txtUsername);
    addProfileField(fields, jLabel4, txtEmail);
    addProfileField(fields, jLabel5, txtContactNumber);

    javax.swing.JPanel formWrapper = new javax.swing.JPanel(
        new java.awt.BorderLayout()
    );
    formWrapper.setOpaque(false);
    formWrapper.add(fields, java.awt.BorderLayout.NORTH);

    jPanel1.add(formWrapper, java.awt.BorderLayout.CENTER);

    // ACTION BUTTONS
    javax.swing.JPanel actions = new javax.swing.JPanel(
        new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 12, 0)
    );
    actions.setOpaque(false);

    btnChangePassword.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 13
    ));
    btnChangePassword.setBackground(navy);
    btnChangePassword.setForeground(java.awt.Color.WHITE);
    btnChangePassword.setFocusPainted(false);
    btnChangePassword.setPreferredSize(
        new java.awt.Dimension(180, 44)
    );

    btnSaveChanges.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 13
    ));
    btnSaveChanges.setBackground(blue);
    btnSaveChanges.setForeground(java.awt.Color.WHITE);
    btnSaveChanges.setFocusPainted(false);
    btnSaveChanges.setPreferredSize(
        new java.awt.Dimension(150, 44)
    );

    btnChangePassword.setCursor(new java.awt.Cursor(
        java.awt.Cursor.HAND_CURSOR
    ));
    btnSaveChanges.setCursor(new java.awt.Cursor(
        java.awt.Cursor.HAND_CURSOR
    ));

    actions.add(btnChangePassword);
    actions.add(btnSaveChanges);

    jPanel1.add(actions, java.awt.BorderLayout.SOUTH);

    // RESPONSIVE CARD CONTAINER
    javax.swing.JPanel content = new javax.swing.JPanel(
        new java.awt.BorderLayout()
    );
    content.setOpaque(false);

    jPanel1.setPreferredSize(
        new java.awt.Dimension(0, 330)
    );

    content.add(jPanel1, java.awt.BorderLayout.NORTH);

    add(content, java.awt.BorderLayout.CENTER);

    revalidate();
    repaint();
}

private void addProfileField(
        javax.swing.JPanel container,
        javax.swing.JLabel label,
        javax.swing.JTextField input) {

    java.awt.Color navy = new java.awt.Color(30, 58, 95);
    java.awt.Color border = new java.awt.Color(220, 230, 240);

    javax.swing.JPanel field = new javax.swing.JPanel(
        new java.awt.BorderLayout(0, 8)
    );
    field.setOpaque(false);

    label.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.BOLD, 13
    ));
    label.setForeground(navy);

    input.setFont(new java.awt.Font(
        "Segoe UI", java.awt.Font.PLAIN, 14
    ));
    input.setForeground(navy);
    input.setBackground(java.awt.Color.WHITE);
    input.setPreferredSize(
        new java.awt.Dimension(250, 42)
    );
    input.setBorder(
        javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(border),
            javax.swing.BorderFactory.createEmptyBorder(
                8, 12, 8, 12
            )
        )
    );

    field.add(label, java.awt.BorderLayout.NORTH);
    field.add(input, java.awt.BorderLayout.CENTER);

    container.add(field);
}
    
    private void loadProfile() {

    txtFullName.setText(currentUser.getFullName());
    txtUsername.setText(currentUser.getUsername());
    txtEmail.setText(currentUser.getEmail());
    txtContactNumber.setText(currentUser.getContactNumber());

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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContactNumber = new javax.swing.JTextField();
        btnSaveChanges = new javax.swing.JButton();
        btnChangePassword = new javax.swing.JButton();

        lblTitle.setText("My Profile");

        lblSubtitle.setText("Manage your personal information");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Personal Information");

        jLabel2.setText("Full Name");

        jLabel3.setText("Username");

        jLabel4.setText("Email Address");

        jLabel5.setText("Contact Number");

        btnSaveChanges.setText("Save Changes");
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });

        btnChangePassword.setText("Change Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel4))
                        .addGap(135, 135, 135)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(txtUsername)
                            .addComponent(txtContactNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
                .addContainerGap(308, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveChanges)
                .addGap(18, 18, 18)
                .addComponent(btnChangePassword)
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtContactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChanges)
                    .addComponent(btnChangePassword))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtitle)
                    .addComponent(lblTitle)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(405, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtitle)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        
        String fullName = txtFullName.getText().trim();
String username = txtUsername.getText().trim();
String email = txtEmail.getText().trim();
String contact = txtContactNumber.getText().trim();

if (fullName.isEmpty() || username.isEmpty()
        || email.isEmpty() || contact.isEmpty()) {

    javax.swing.JOptionPane.showMessageDialog(
            this, "Please complete all fields.");
    return;
}

if (!email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Please enter a valid email address.");
    return;
}

if (!contact.matches("09\\d{9}")) {
    javax.swing.JOptionPane.showMessageDialog(
            this, "Please enter a valid 11-digit Philippine mobile number.");
    return;
}

UserDAO dao = new UserDAO();

// Check duplicates only when username or email changes
if (!username.equals(currentUser.getUsername())
        && dao.usernameExists(username)) {

    javax.swing.JOptionPane.showMessageDialog(
            this, "Username is already taken.");
    return;
}

if (!email.equals(currentUser.getEmail())
        && dao.emailExists(email)) {

    javax.swing.JOptionPane.showMessageDialog(
            this, "Email is already registered.");
    return;
}

// Prepare updated information without changing currentUser yet
User updatedUser = new User();

updatedUser.setUserId(currentUser.getUserId());
updatedUser.setFullName(fullName);
updatedUser.setUsername(username);
updatedUser.setEmail(email);
updatedUser.setContactNumber(contact);

if (dao.updateClientProfile(updatedUser)) {

    currentUser.setFullName(fullName);
    currentUser.setUsername(username);
    currentUser.setEmail(email);
    currentUser.setContactNumber(contact);

    javax.swing.JOptionPane.showMessageDialog(
            this, "Profile updated successfully!");

} else {

    javax.swing.JOptionPane.showMessageDialog(
            this, "Unable to update profile. Please try again.");
}
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        
        javax.swing.JPasswordField txtCurrent =
        new javax.swing.JPasswordField(18);

javax.swing.JPasswordField txtNew =
        new javax.swing.JPasswordField(18);

javax.swing.JPasswordField txtConfirm =
        new javax.swing.JPasswordField(18);

Object[] fields = {
    "Current Password:", txtCurrent,
    "New Password:", txtNew,
    "Confirm New Password:", txtConfirm
};

int result = javax.swing.JOptionPane.showConfirmDialog(
        this,
        fields,
        "Change Password",
        javax.swing.JOptionPane.OK_CANCEL_OPTION,
        javax.swing.JOptionPane.PLAIN_MESSAGE
);

if (result != javax.swing.JOptionPane.OK_OPTION) {
    return;
}

String currentPassword =
        new String(txtCurrent.getPassword());

String newPassword =
        new String(txtNew.getPassword());

String confirmPassword =
        new String(txtConfirm.getPassword());

// VALIDATION
if (currentPassword.isEmpty()
        || newPassword.isEmpty()
        || confirmPassword.isEmpty()) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Please complete all password fields."
    );
    return;
}

if (newPassword.length() < 8) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "New password must contain at least 8 characters."
    );
    return;
}

if (!newPassword.equals(confirmPassword)) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "New passwords do not match."
    );
    return;
}

if (currentPassword.equals(newPassword)) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "New password must be different from your current password."
    );
    return;
}

// UPDATE DATABASE
UserDAO dao = new UserDAO();

boolean updated = dao.changeClientPassword(
        currentUser.getUserId(),
        currentPassword,
        newPassword
);

if (updated) {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Password changed successfully!"
    );

} else {

    javax.swing.JOptionPane.showMessageDialog(
            this,
            "Current password is incorrect or password update failed."
    );
}
    }//GEN-LAST:event_btnChangePasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtContactNumber;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
