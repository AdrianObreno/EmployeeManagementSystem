/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Adrian
 */
public class DepartmentForm extends javax.swing.JFrame {

    /**
     * Creates new form DepartmentForm
     */
    private Connection conn;
    private DefaultTableModel tableModel;

    public DepartmentForm() {
        initComponents();
        initDatabaseConnection();
        initTableModel();
        updateTableData();
    }    
    private void initDatabaseConnection() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/sql_workbench?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "adrian024");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error connecting to the database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }   
     private void initTableModel() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Dept ID");
        tableModel.addColumn("Department Code");
        tableModel.addColumn("Department");
        DeptInfoTable.setModel(tableModel);
    }
    private void updateTableData() {
        try {
            String query = "SELECT * FROM departmentdb";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            tableModel.setRowCount(0); // Clear existing rows from the table
            while (resultSet.next()) {
                String deptID = resultSet.getString("deptID");
                String deptCode = resultSet.getString("deptCode");
                String deptName = resultSet.getString("deptName");
                tableModel.addRow(new Object[]{deptID, deptCode, deptName});
            }
            TotalRecordInDbLabel.setText("Total Record(s) in database are: " + tableModel.getRowCount());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error updating table data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     private void clearFields() {
        DeptCodeTF.setText("");
        DeptNameTF.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        DeptInfoTable = new javax.swing.JTable();
        CloseFormBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        UpdateTableBtn = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        CreateNewBtn = new javax.swing.JButton();
        DeptNameLabel = new javax.swing.JLabel();
        DeptNameTF = new javax.swing.JTextField();
        DeptCodeTF = new javax.swing.JTextField();
        DeptCodeLabel = new javax.swing.JLabel();
        FormTitle = new javax.swing.JLabel();
        TotalRecordInDbLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DeptInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dept ID", "Department Code", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DeptInfoTable.setShowGrid(true);
        jScrollPane1.setViewportView(DeptInfoTable);
        if (DeptInfoTable.getColumnModel().getColumnCount() > 0) {
            DeptInfoTable.getColumnModel().getColumn(0).setResizable(false);
            DeptInfoTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            DeptInfoTable.getColumnModel().getColumn(1).setResizable(false);
            DeptInfoTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            DeptInfoTable.getColumnModel().getColumn(2).setResizable(false);
            DeptInfoTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        MainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 380, 140));

        CloseFormBtn.setBackground(new java.awt.Color(255, 102, 102));
        CloseFormBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        CloseFormBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/power_switch_off_on_icon.png"))); // NOI18N
        CloseFormBtn.setToolTipText("close");
        CloseFormBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseFormBtnActionPerformed(evt);
            }
        });
        MainPanel.add(CloseFormBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 40, 30));

        DeleteBtn.setBackground(new java.awt.Color(102, 255, 102));
        DeleteBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/8664938_trash_can_delete_remove_icon.png"))); // NOI18N
        DeleteBtn.setToolTipText("delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        MainPanel.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 40, 30));

        UpdateTableBtn.setBackground(new java.awt.Color(255, 204, 102));
        UpdateTableBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        UpdateTableBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/9104167_save_download_server_cloud_storage_icon.png"))); // NOI18N
        UpdateTableBtn.setToolTipText("refresh table");
        UpdateTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateTableBtnActionPerformed(evt);
            }
        });
        MainPanel.add(UpdateTableBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 40, 30));

        SaveBtn.setBackground(new java.awt.Color(255, 153, 255));
        SaveBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        SaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/134229_cloud_guardar_save_store_up_icon.png"))); // NOI18N
        SaveBtn.setToolTipText("save to database");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });
        MainPanel.add(SaveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 40, 30));

        CreateNewBtn.setBackground(new java.awt.Color(102, 204, 255));
        CreateNewBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        CreateNewBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/4781840_+_add_circle_create_expand_icon.png"))); // NOI18N
        CreateNewBtn.setToolTipText("add");
        CreateNewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewBtnActionPerformed(evt);
            }
        });
        MainPanel.add(CreateNewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 40, 30));

        DeptNameLabel.setText("Department Name:");
        MainPanel.add(DeptNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 30));

        DeptNameTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        DeptNameTF.setEnabled(false);
        MainPanel.add(DeptNameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 187, 30));

        DeptCodeTF.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        DeptCodeTF.setEnabled(false);
        MainPanel.add(DeptCodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 187, 30));

        DeptCodeLabel.setText("Dept. Code:");
        MainPanel.add(DeptCodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, 30));

        FormTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        FormTitle.setText("Department Information");
        FormTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MainPanel.add(FormTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 20));

        TotalRecordInDbLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TotalRecordInDbLabel.setText("Total Record(s) in database are : ");
        MainPanel.add(TotalRecordInDbLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 30));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 400));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        // TODO add your handling code here:
         try {
            String deptCode = DeptCodeTF.getText();
            String deptName = DeptNameTF.getText();   
                if (deptCode.isEmpty() || deptName.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Required fields are empty", "Error", JOptionPane.ERROR_MESSAGE);
                } else {               
                    String query = "INSERT INTO departmentdb (deptCode, deptName) VALUES (?, ?)";
                    PreparedStatement statement = conn.prepareStatement(query);
                    statement.setString(1, deptCode);
                    statement.setString(2, deptName);
                    statement.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Data saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    updateTableData();
                    clearFields();
                }
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_SaveBtnActionPerformed

    private void CreateNewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewBtnActionPerformed
        // TODO add your handling code here:
        this.DeptNameTF.setEnabled(true);
        this.DeptCodeTF.setEnabled(true);
    }//GEN-LAST:event_CreateNewBtnActionPerformed

    private void CloseFormBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseFormBtnActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(this, "Do you want to close the form?", "Close Form", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_CloseFormBtnActionPerformed

    private void UpdateTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateTableBtnActionPerformed
        // TODO add your handling code here:
        updateTableData();
    }//GEN-LAST:event_UpdateTableBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = DeptInfoTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String deptID = tableModel.getValueAt(selectedRow, 0).toString();
                String query = "DELETE FROM departmentdb WHERE deptID = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, deptID);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Row deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                updateTableData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error deleting row: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(DepartmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepartmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepartmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepartmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepartmentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseFormBtn;
    private javax.swing.JButton CreateNewBtn;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JLabel DeptCodeLabel;
    private javax.swing.JTextField DeptCodeTF;
    private javax.swing.JTable DeptInfoTable;
    private javax.swing.JLabel DeptNameLabel;
    private javax.swing.JTextField DeptNameTF;
    private javax.swing.JLabel FormTitle;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JLabel TotalRecordInDbLabel;
    private javax.swing.JButton UpdateTableBtn;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
