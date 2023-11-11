/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Forms;

/**
 *
 * @author Adrian
 */
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeForm extends javax.swing.JFrame {

    /**
     * Creates new form EmployeeForm
     */
    private Connection conn;
    private PreparedStatement insertData;
    private PreparedStatement deleteData;
    private PreparedStatement getData;
    
    public EmployeeForm() {
        initComponents();
        db();
        disableFields();
        populateDepartmentComboBox();
        populatePositionComboBox();
        refreshTable();
    }
    
    public void db() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/sql_workbench?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "root", "adrian024");
            
            String insertQuery = "INSERT INTO employeedb (employeeID, lastName, firstName, bday, dept, position, contact) VALUES (?, ?, ?, ?, ?, ?, ?)";
            insertData = conn.prepareStatement(insertQuery);
            
            String deleteQuery = "DELETE FROM employeedb WHERE id = ?";
            deleteData = conn.prepareStatement(deleteQuery);
            
            String getQuery = "SELECT * FROM employeedb";
            getData = conn.prepareStatement(getQuery);
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
    }
    
     private void disableFields() {
        EmployeeIDTF.setEnabled(false);
        LastnameTF.setEnabled(false);
        FirstnameTF.setEnabled(false);
        DepartmentComboBox.setEnabled(false);
        PositionComboBox.setEnabled(false);
        ContactNumberTF.setEnabled(false);
        jDateChooser1.setEnabled(false);
    }
     
     private void enableFields() {
        EmployeeIDTF.setEnabled(true);
        LastnameTF.setEnabled(true);
        FirstnameTF.setEnabled(true);
        DepartmentComboBox.setEnabled(true);
        PositionComboBox.setEnabled(true);
        ContactNumberTF.setEnabled(true);
        jDateChooser1.setEnabled(true);
    }

     private void populateDepartmentComboBox() {
        try {
            String query = "SELECT * FROM departmentdb";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (resultSet.next()) {
                model.addElement(resultSet.getString("deptName"));
            }
            DepartmentComboBox.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
    }
     
     private void populatePositionComboBox() {
        try {
            String query = "SELECT * FROM positiondb";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            while (resultSet.next()) {
                model.addElement(resultSet.getString("positionName"));
            }
            PositionComboBox.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
    }
    
    private void refreshTable() {
        DefaultTableModel dtm = (DefaultTableModel) EmployeeInfoTable.getModel();
        int rowCount = dtm.getRowCount();
        while (rowCount-- > 0) {
            dtm.removeRow(rowCount);
        }

        try {
            ResultSet rs = getData.executeQuery();
            while (rs.next()) {
                Object[] rowData = {
                    rs.getInt("id"),
                    rs.getString("employeeID"),
                    rs.getString("lastName"),
                    rs.getString("firstName"),
                    rs.getString("bday"),
                    rs.getString("dept"),
                    rs.getString("position"),
                    rs.getString("contact")
                };
                dtm.addRow(rowData);
            }
            
            int totalRecords = dtm.getRowCount();
            TotalRecordLabel.setText("Total Record(s) in database are: " + totalRecords);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
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
        EmployeeInfoTable = new javax.swing.JTable();
        FormTitle = new javax.swing.JLabel();
        CloseBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        RefreshBtn = new javax.swing.JButton();
        SaveBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        TotalRecordLabel = new javax.swing.JLabel();
        ContactNumberLabel = new javax.swing.JLabel();
        PositionComboBox = new javax.swing.JComboBox<>();
        PositionLabel = new javax.swing.JLabel();
        DepartmentComboBox = new javax.swing.JComboBox<>();
        DepartmentLabel = new javax.swing.JLabel();
        BrithdayLabel = new javax.swing.JLabel();
        ContactNumberTF = new javax.swing.JTextField();
        FirstnameLabel = new javax.swing.JLabel();
        LastnameTF = new javax.swing.JTextField();
        LastnameLabel = new javax.swing.JLabel();
        EmployeeIDTF = new javax.swing.JTextField();
        EmployeeIDLabel = new javax.swing.JLabel();
        FirstnameTF = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        EmployeeInfoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Employee ID", "Lastname", "Firstname", "Birthday", "Department", "Position", "Contact Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeInfoTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        EmployeeInfoTable.setShowGrid(true);
        jScrollPane1.setViewportView(EmployeeInfoTable);
        if (EmployeeInfoTable.getColumnModel().getColumnCount() > 0) {
            EmployeeInfoTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            EmployeeInfoTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            EmployeeInfoTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            EmployeeInfoTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            EmployeeInfoTable.getColumnModel().getColumn(4).setPreferredWidth(80);
            EmployeeInfoTable.getColumnModel().getColumn(5).setPreferredWidth(80);
            EmployeeInfoTable.getColumnModel().getColumn(6).setPreferredWidth(80);
            EmployeeInfoTable.getColumnModel().getColumn(7).setPreferredWidth(80);
        }

        MainPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 450, 360));

        FormTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        FormTitle.setText("Employee Information");
        FormTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MainPanel.add(FormTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 20));

        CloseBtn.setBackground(new java.awt.Color(255, 102, 102));
        CloseBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        CloseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/power_switch_off_on_icon.png"))); // NOI18N
        CloseBtn.setToolTipText("close");
        CloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBtnActionPerformed(evt);
            }
        });
        MainPanel.add(CloseBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 40, 30));

        DeleteBtn.setBackground(new java.awt.Color(102, 255, 102));
        DeleteBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/8664938_trash_can_delete_remove_icon.png"))); // NOI18N
        DeleteBtn.setToolTipText("delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        MainPanel.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 40, 30));

        RefreshBtn.setBackground(new java.awt.Color(255, 204, 102));
        RefreshBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        RefreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/9104167_save_download_server_cloud_storage_icon.png"))); // NOI18N
        RefreshBtn.setToolTipText("refresh table");
        RefreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshBtnActionPerformed(evt);
            }
        });
        MainPanel.add(RefreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 40, 30));

        SaveBtn.setBackground(new java.awt.Color(255, 153, 255));
        SaveBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        SaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/134229_cloud_guardar_save_store_up_icon.png"))); // NOI18N
        SaveBtn.setToolTipText("save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });
        MainPanel.add(SaveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 40, 30));

        AddBtn.setBackground(new java.awt.Color(102, 204, 255));
        AddBtn.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        AddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resourses/4781840_+_add_circle_create_expand_icon.png"))); // NOI18N
        AddBtn.setToolTipText("add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        MainPanel.add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 40, 30));

        TotalRecordLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TotalRecordLabel.setText("Total Record(s) in database are : ");
        MainPanel.add(TotalRecordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, 20));

        ContactNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ContactNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ContactNumberLabel.setText("Contact No:");
        ContactNumberLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MainPanel.add(ContactNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 30));

        PositionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        MainPanel.add(PositionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 140, 30));

        PositionLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        PositionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PositionLabel.setText("Postision:");
        PositionLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MainPanel.add(PositionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 80, 30));

        DepartmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        MainPanel.add(DepartmentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 140, 30));

        DepartmentLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DepartmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        DepartmentLabel.setText("Department:");
        DepartmentLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MainPanel.add(DepartmentLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 80, 30));

        BrithdayLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BrithdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        BrithdayLabel.setText("Birthday:");
        BrithdayLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MainPanel.add(BrithdayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, 30));
        MainPanel.add(ContactNumberTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 187, 30));

        FirstnameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        FirstnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        FirstnameLabel.setText("Firstname:");
        FirstnameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MainPanel.add(FirstnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 80, 30));
        MainPanel.add(LastnameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 187, 30));

        LastnameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LastnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LastnameLabel.setText("Lastname:");
        LastnameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MainPanel.add(LastnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 80, 30));
        MainPanel.add(EmployeeIDTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 187, 30));

        EmployeeIDLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EmployeeIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        EmployeeIDLabel.setText("Employee ID:");
        EmployeeIDLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MainPanel.add(EmployeeIDLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 30));
        MainPanel.add(FirstnameTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 187, 30));
        MainPanel.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 190, 30));

        getContentPane().add(MainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
        enableFields();
        EmployeeIDTF.setText("");
        LastnameTF.setText("");
        FirstnameTF.setText("");      
        DepartmentComboBox.setSelectedIndex(0);
        PositionComboBox.setSelectedIndex(0);
        ContactNumberTF.setText("");
        jDateChooser1.setDate(null);
    }//GEN-LAST:event_AddBtnActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        // TODO add your handling code here:
        try {
            String employeeID = EmployeeIDTF.getText().trim();
            String lastName = LastnameTF.getText().trim();
            String firstName = FirstnameTF.getText().trim();
            String department = DepartmentComboBox.getSelectedItem().toString();
            String position = PositionComboBox.getSelectedItem().toString();
            String contact = ContactNumberTF.getText().trim();
            Date selectedDate = jDateChooser1.getDate();
    
            if (employeeID.isEmpty() || lastName.isEmpty() || firstName.isEmpty() || selectedDate == null || contact.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill out all fields", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
              SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
              String dateString = dateFormat.format(selectedDate);
        
                insertData.setString(1, employeeID);
                insertData.setString(2, lastName);
                insertData.setString(3, firstName);
                insertData.setString(4, dateString);
                insertData.setString(5, department);
                insertData.setString(6, position);
                insertData.setString(7, contact);
                insertData.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data saved successfully.");  
                refreshTable();
                disableFields();
             }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
        }
                                           

    }//GEN-LAST:event_SaveBtnActionPerformed

    private void RefreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshBtnActionPerformed
        // TODO add your handling code here:
        refreshTable();
    }//GEN-LAST:event_RefreshBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = EmployeeInfoTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int id = (int) EmployeeInfoTable.getValueAt(selectedRow, 0);
                try {
                    deleteData.setInt(1, id);
                    deleteData.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record deleted successfully.");
                    refreshTable();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void CloseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseBtnActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to close the form?", "Confirm Close", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_CloseBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JLabel BrithdayLabel;
    private javax.swing.JButton CloseBtn;
    private javax.swing.JLabel ContactNumberLabel;
    private javax.swing.JTextField ContactNumberTF;
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JComboBox<String> DepartmentComboBox;
    private javax.swing.JLabel DepartmentLabel;
    private javax.swing.JLabel EmployeeIDLabel;
    private javax.swing.JTextField EmployeeIDTF;
    private javax.swing.JTable EmployeeInfoTable;
    private javax.swing.JLabel FirstnameLabel;
    private javax.swing.JTextField FirstnameTF;
    private javax.swing.JLabel FormTitle;
    private javax.swing.JLabel LastnameLabel;
    private javax.swing.JTextField LastnameTF;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JComboBox<String> PositionComboBox;
    private javax.swing.JLabel PositionLabel;
    private javax.swing.JButton RefreshBtn;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JLabel TotalRecordLabel;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
