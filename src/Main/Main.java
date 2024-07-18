package Main;

import config.GlobalTheming;
import Auth.LoginPage;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        // Initialize global theming
              GlobalTheming.applyGlobalTheming();

        // Set the Nimbus look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        // Start the application with the login page
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }
}
