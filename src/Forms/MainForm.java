/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.ImageIcon;

/**
 *
 * @author Adrian
 */
public class MainForm extends javax.swing.JFrame implements Runnable {
    
    int hour,second,minute;
    String userType;
    String role2 = "user";

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();       
        Date();        
        backgroundLabelLabel_scaleImg();
        Thread t=new Thread(this);//time
        t.start();//time
       // DepartmentMenuItem.setEnabled(false);
       // DesignationMenuItem.setEnabled(false);     
    }
    
    //Date  
    public void Date(){
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");    
       LocalDateTime now =LocalDateTime.now();
       DateLabel.setText("DATE: "+dtf.format(now));
    }
       
    //Image scaling Method for LoginBackgroundMainLabel
    public void backgroundLabelLabel_scaleImg() {
        ImageIcon icon = new ImageIcon("E:\\Source Code\\Java NC3\\OJT\\EmployeeManagementSystem\\src\\Resourses\\background-main.jpg");
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(backgroundLabel.getWidth(), backgroundLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        backgroundLabel.setIcon(scaledIcon);    
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
        DateLabel = new javax.swing.JLabel();
        TimeLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        ListMenuItem = new javax.swing.JMenuItem();
        DepartmentMenuItem = new javax.swing.JMenuItem();
        PositionMenuItem = new javax.swing.JMenuItem();
        EmployeeMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        LogoutMenuItem = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        AboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setPreferredSize(new java.awt.Dimension(1280, 680));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DateLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DateLabel.setForeground(new java.awt.Color(255, 255, 255));
        DateLabel.setText("Date");
        MainPanel.add(DateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, -1, -1));

        TimeLabel.setBackground(new java.awt.Color(255, 255, 255));
        TimeLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        TimeLabel.setText("Time");
        MainPanel.add(TimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 620, -1, -1));

        NameLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(255, 255, 255));
        NameLabel.setText("NAME:");
        MainPanel.add(NameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/background-main.jpg"))); // NOI18N
        backgroundLabel.setText("jLabel1");
        MainPanel.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 680));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 680));

        jMenuBar1.setBackground(new java.awt.Color(153, 153, 153));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setOpaque(true);

        jMenu1.setText("File");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        ListMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/employeelogo.png"))); // NOI18N
        ListMenuItem.setText("List");
        ListMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(ListMenuItem);

        DepartmentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/building_office_property_icon.png"))); // NOI18N
        DepartmentMenuItem.setText("Department");
        DepartmentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepartmentMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(DepartmentMenuItem);

        PositionMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/construction_contractor_builder_worker_job_icon.png"))); // NOI18N
        PositionMenuItem.setText("Position");
        PositionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositionMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(PositionMenuItem);

        EmployeeMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/esume_business_cv_work_job_icon.png"))); // NOI18N
        EmployeeMenuItem.setText("Employee");
        EmployeeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmployeeMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(EmployeeMenuItem);
        jMenu1.add(jSeparator1);

        LogoutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/power_switch_off_on_icon.png"))); // NOI18N
        LogoutMenuItem.setText("Logout");
        LogoutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(LogoutMenuItem);

        jMenuBar1.add(jMenu1);

        HelpMenu.setText("Help");

        AboutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/code_coding_development_programming_web_icon.png"))); // NOI18N
        AboutMenuItem.setText("About");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutMenuItem);

        jMenuBar1.add(HelpMenu);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        // TODO add your handling code here:
        new AboutForm().setVisible(true);
    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void LogoutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuItemActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog (null, "You're about to log out, are you sure?","Warning!",JOptionPane.YES_NO_OPTION);
        if(dialogButton == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new LoginForm().setVisible(true);         
        }else {
            remove(dialogButton);
        }
        
    }//GEN-LAST:event_LogoutMenuItemActionPerformed

    private void ListMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListMenuItemActionPerformed
        // TODO add your handling code here:
        new EmployeeListForm().setVisible(true);
    }//GEN-LAST:event_ListMenuItemActionPerformed

    private void DepartmentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepartmentMenuItemActionPerformed
        // TODO add your handling code here:          
        new DepartmentForm().setVisible(true);                 
    }//GEN-LAST:event_DepartmentMenuItemActionPerformed

    private void PositionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositionMenuItemActionPerformed
        // TODO add your handling code here:             
        new DesignationForm().setVisible(true);                       
    }//GEN-LAST:event_PositionMenuItemActionPerformed

    private void EmployeeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmployeeMenuItemActionPerformed
        // TODO add your handling code here:
        new EmployeeForm().setVisible(true);
    }//GEN-LAST:event_EmployeeMenuItemActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        if(userType.equals(role2))DepartmentMenuItem.setEnabled(false);           
        else {
            DepartmentMenuItem.setEnabled(true);           
        }
        if(userType.equals(role2))PositionMenuItem.setEnabled(false);           
        else {
            PositionMenuItem.setEnabled(true);         
        }
    }//GEN-LAST:event_jMenu1MouseClicked

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JMenuItem DepartmentMenuItem;
    private javax.swing.JMenuItem EmployeeMenuItem;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem ListMenuItem;
    private javax.swing.JMenuItem LogoutMenuItem;
    private javax.swing.JPanel MainPanel;
    public javax.swing.JLabel NameLabel;
    private javax.swing.JMenuItem PositionMenuItem;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

    @Override   
    public void run() {
        while (true){
            Calendar cal = Calendar.getInstance();
            hour = cal.get(Calendar.HOUR_OF_DAY);
            minute = cal.get(Calendar.MINUTE);
            second = cal.get(Calendar.SECOND);
            SimpleDateFormat sdf12 = new SimpleDateFormat("hh:mm:ss aa");
            Date dat = cal.getTime();
            String time12 = sdf12.format(dat);
            TimeLabel.setText("TIME: "+time12);  
        }
    }
     



}
