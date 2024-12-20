package Auth;

import Dashboard.DashboardPage;
import DbConfig.CrudManager;
import common.commonMethods;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import config.DesignConstants;

public class LoginPage extends javax.swing.JFrame {
    
    public LoginPage() {
        // Initialize components

        // Custom initialization
        initComponents();
        
        commonMethods cm = new commonMethods();
        cm.resizer("src/Images/auth_bg.jpg", image);
        cm.resizer("src/Images/logo.png", logo);

        // Add component listener to handle resizing
        image.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                cm.resizer("src/Images/auth_bg.jpg", image);
            }
        });
        
        logo.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                cm.resizer("src/Images/logo.png", logo);
            }
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

        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        welcome = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        emailVal = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        passVal = new javax.swing.JPasswordField();
        loginText = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        RegisterRedirect = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login_Page");
        setBackground(new java.awt.Color(252, 252, 252));
        setMinimumSize(DesignConstants.FRAME_SIZE);

        jPanel1.setMaximumSize(DesignConstants.FRAME_SIZE);
        jPanel1.setMinimumSize(DesignConstants.FRAME_SIZE);
        jPanel1.setPreferredSize(DesignConstants.FRAME_SIZE);

        image.setForeground(new java.awt.Color(255, 255, 255));
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/auth_bg.jpg"))); // NOI18N
        image.setMaximumSize(DesignConstants.HALF_FRAME_SIZE);
        image.setMinimumSize(DesignConstants.HALF_FRAME_SIZE);
        image.setPreferredSize(DesignConstants.HALF_FRAME_SIZE);

        welcome.setBackground(new java.awt.Color(117, 184, 228));
        welcome.setFont(DesignConstants.HEADING_FONT1);
        welcome.setForeground(new java.awt.Color(76, 126, 247));
        welcome.setLabelFor(welcome);
        welcome.setText("Welcome to Health Care ");
        welcome.setPreferredSize(new java.awt.Dimension(118, 25));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logo.png"))); // NOI18N

        emailVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailValActionPerformed(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(93, 96, 97));
        emailLabel.setText("Email");

        passLabel.setFont(new java.awt.Font("Gadugi", 1, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(86, 79, 79));
        passLabel.setText("Password");

        passVal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passValActionPerformed(evt);
            }
        });

        loginText.setBackground(new java.awt.Color(117, 184, 228));
        loginText.setFont(DesignConstants.HEADING_FONT2);
        loginText.setForeground(new java.awt.Color(76, 126, 247));
        loginText.setLabelFor(welcome);
        loginText.setText("Login to your account");
        loginText.setPreferredSize(new java.awt.Dimension(118, 25));

        jLabel3.setForeground(new java.awt.Color(16, 15, 15));
        jLabel3.setText("Don't have an account? Click on");

        RegisterRedirect.setFont(DesignConstants.GLOBAL_FONT);
        RegisterRedirect.setForeground(new java.awt.Color(16, 118, 207));
        RegisterRedirect.setText("Register");
        RegisterRedirect.setBorder(DesignConstants.BOTTOM_BORDER);
        RegisterRedirect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RegisterRedirect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterRedirectMouseClicked(evt);
            }
        });

        loginBtn.setBackground(DesignConstants.PRIMARY_COLOR);
        loginBtn.setText("Login Now");
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(RegisterRedirect, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(loginBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RegisterRedirect))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginBtn)
                        .addGap(75, 75, 75)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RegisterRedirect))
                .addGap(26, 26, 26)
                .addComponent(loginBtn)
                .addContainerGap())
        );

        jLayeredPane2.setLayer(welcome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(logo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(emailVal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(emailLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(passLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(passVal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(loginText, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLayeredPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passLabel))
                                .addGap(27, 27, 27)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passVal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailVal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcome, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailVal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passVal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailValActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailValActionPerformed

    private void passValActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passValActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passValActionPerformed

    private void RegisterRedirectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterRedirectMouseClicked
        RegisterPage registerPage = new RegisterPage();
        this.setVisible(false);
        registerPage.setVisible(true);
    }//GEN-LAST:event_RegisterRedirectMouseClicked

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        
        String email = emailVal.getText();
        String pass = passVal.getText();
        
        if (email == null || email.isEmpty()
                || pass == null || pass.isEmpty()) {
            
            commonMethods.showDialogPane("error", "All fields are required");
            return;
        }
        
        boolean success = CrudManager.login(email, pass);
        
        if (success) {
//            commonMethods.showDialogPane("success", "Successfully! Login the user");
            DashboardPage dashboardPage = new DashboardPage();
            this.setVisible(false);
            dashboardPage.setVisible(success);
            System.out.println(success);
        } else {
            commonMethods.showDialogPane("error", "Invalid email or password");
        }
        
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Create and display the login page
        SwingUtilities.invokeLater(() -> {
            new LoginPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RegisterRedirect;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailVal;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginText;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passVal;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
