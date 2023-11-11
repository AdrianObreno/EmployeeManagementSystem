/*
 * Main Class
 */
package EmployeeManagementSystem;

import Forms.LoginForm;
import Forms.SplashForm;
import javax.swing.JOptionPane;

/**
 *
 * @author Adrian
 */
public class Main {
    public static void main(String[] args) {
        SplashForm sp = new SplashForm();
        sp.setVisible(true);

        try {
            for(int i=0; i<=100; i++) {
                Thread.sleep(60);
                sp.PercentLbl.setText(i + "%");
                
                if(i == 10) sp.LoadingLbl.setText("Turning on Modules...");
                if(i == 20) sp.LoadingLbl.setText("Loading Modules...");
                if(i == 50) sp.LoadingLbl.setText("Connecting to Database...");
                if(i == 70) sp.LoadingLbl.setText("Connection Successful...");
                if(i == 80) sp.LoadingLbl.setText("Launching Application...");
                
                sp.ProgressBar.setValue(i);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        sp.setVisible(false);
        new LoginForm().setVisible(true);
    }
}