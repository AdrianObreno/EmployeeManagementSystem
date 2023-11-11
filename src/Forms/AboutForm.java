/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Adrian
 */
public class AboutForm extends javax.swing.JFrame {

    /**
     * Creates new form AboutForm
     */
    public AboutForm() {
        initComponents();
       // backgroundLabel_scaleImg();
        tcsdiLabel_scaleImg();
        tesdaLabel_scaleImg();
        companyLabel_scaleImg();
        backgroundLabel_scaleImg();
       
        
    }
    
    //Image scaling Method for LoginBackgroundMainLabel
    public void backgroundLabel_scaleImg() {
        ImageIcon icon = new ImageIcon("E:\\Source Code\\Java NC3\\OJT\\EmployeeManagementSystem\\src\\Resourses\\aboutBackground.jpg");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(backgroundLabel.getWidth(), backgroundLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        backgroundLabel.setIcon(scaledIcon);    
    }
    public void tcsdiLabel_scaleImg() {
        ImageIcon icon = new ImageIcon("E:\\Source Code\\Java NC3\\OJT\\EmployeeManagementSystem\\src\\Resourses\\tcsdi_png.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(tcsdiLabel.getWidth(), tcsdiLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        tcsdiLabel.setIcon(scaledIcon);    
    }
    public void tesdaLabel_scaleImg() {
        ImageIcon icon = new ImageIcon("E:\\Source Code\\Java NC3\\OJT\\EmployeeManagementSystem\\src\\Resourses\\TESDA-Logo2_png.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(tesdaLabel.getWidth(), tesdaLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        tesdaLabel.setIcon(scaledIcon);    
    }
    public void companyLabel_scaleImg() {
        ImageIcon icon = new ImageIcon("E:\\Source Code\\Java NC3\\OJT\\EmployeeManagementSystem\\src\\Resourses\\companyLogo.png");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(companyLabel.getWidth(), companyLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        companyLabel.setIcon(scaledIcon);    
    }
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        CloseLabel = new javax.swing.JLabel();
        tesdaLabel = new javax.swing.JLabel();
        companyLabel = new javax.swing.JLabel();
        tcsdiLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CloseLabel.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        CloseLabel.setText("CLOSE");
        CloseLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseLabelMouseClicked(evt);
            }
        });
        MainPanel.add(CloseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        tesdaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/TESDA-Logo2_png.png"))); // NOI18N
        tesdaLabel.setPreferredSize(new java.awt.Dimension(80, 80));
        tesdaLabel.setRequestFocusEnabled(false);
        MainPanel.add(tesdaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 50));

        companyLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/companyLogo.png"))); // NOI18N
        companyLabel.setPreferredSize(new java.awt.Dimension(80, 80));
        companyLabel.setVerifyInputWhenFocusTarget(false);
        MainPanel.add(companyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 60, 50));

        tcsdiLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/tcsdi_png.png"))); // NOI18N
        tcsdiLabel.setPreferredSize(new java.awt.Dimension(80, 80));
        MainPanel.add(tcsdiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 60, 50));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText(" This System is Designed using JAVA\n NetBeans with MySQL Workbench \n for Back-End\n Developed by: Adrian Obreno\n Developed date: October 26, 2023\n as per request of COLE and ASH, \n TCSDI's Tie up Company for JAVA \n Programming NCIII OJT \n COPYRIGHT © 2023");
        jTextArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea1.setFocusable(false);
        jTextArea1.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextArea1);

        MainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 150, 110));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/aboutBackground.jpg"))); // NOI18N
        backgroundLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MainPanel.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 200));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 200));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseLabelMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_CloseLabelMouseClicked

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
            java.util.logging.Logger.getLogger(AboutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AboutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AboutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AboutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseLabel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel companyLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel tcsdiLabel;
    private javax.swing.JLabel tesdaLabel;
    // End of variables declaration//GEN-END:variables
}