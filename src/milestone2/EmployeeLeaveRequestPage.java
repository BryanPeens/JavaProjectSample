package milestone2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Bryan
 */
public final class EmployeeLeaveRequestPage extends javax.swing.JFrame {

    public DB_Interface b;

    public EmployeeLeaveRequestPage() {
        initComponents();
        date1();
        date2();
        populateLeaveTable();
    }

    public Person userman;

    public EmployeeLeaveRequestPage(Person p) {
        initComponents();
        userman = p;

        jUsernameHere.setText(p.getName());

        date1();
        date2();
        populateLeaveTable();

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(userman.getName(), userman.getSurname(), userman.getAge(), userman.getEmail(), userman.getPhone(), userman.getDepartmentID()));

        String name = userman.getName();
        String surname = userman.getSurname();
        int age = userman.getAge();
        String email = userman.getEmail();
        String phone = userman.getPhone();
        int dep = userman.getDepartmentID();

//        txtDisplayArea.append(personList.toString() + "\n");
        txtDisplayArea.append("############################# Details Seen Below #############################" + "\n" + "\n");
        txtDisplayArea.append("     Employee Name : " + name + "\n");
        txtDisplayArea.append("     Employee Surname : " + surname + "\n");
        txtDisplayArea.append("     Employee Age : " + age + "\n");
        txtDisplayArea.append("     Employee Email : " + email + "\n");
        txtDisplayArea.append("     Employee Phone : " + phone + "\n");
        txtDisplayArea.append("     Employee Department : " + dep + "\n");

    }

    public void populateLeaveTable() {
        Datahandler dh = new Datahandler();
        List<LeaveType> leaves = null;
        try {
            leaves = dh.populateLeaveTable();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeLeaveRequestPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultTableModel tm = (DefaultTableModel) jLeaveTable.getModel();
        int rowCount = tm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            tm.removeRow(i);
        }

        for (LeaveType leave : leaves) {
            Object[] obj = new Object[3];
            obj[0] = leave.getLID();
            obj[1] = leave.getLName();
            obj[2] = leave.getTotalDays();

            tm.addRow(obj);
        }
        jLeaveTable.setModel(tm);
    }

    public void date1() {
        String txtDate1 = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH).format(new Date());
        txtStartDate.setText(txtDate1 + "\n");
    }

    public void date2() {
        String txtDate2 = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH).format(new Date());
        txtEndDate.setText(txtDate2 + "\n");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jUsernameHere = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLeaveHistory = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jLeaveTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtStartDate = new javax.swing.JTextField();
        txtEndDate = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDisplayArea = new javax.swing.JTextArea();
        btnGenerateReport = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRequest = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jUsernameHere.setText("Username Here");

        jLabel2.setText("errorInfo");

        btnLeaveHistory.setText("Leave Histopry");
        btnLeaveHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jUsernameHere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(100, 100, 100)
                .addComponent(btnLeaveHistory)
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUsernameHere)
                    .addComponent(jLabel2)
                    .addComponent(btnLeaveHistory))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 51, 153));

        jLeaveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leave ID", "Leave Description", "Days Available"
            }
        ));
        jLeaveTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLeaveTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jLeaveTable);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Start Date");

        txtStartDate.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N

        txtEndDate.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("End Date");

        txtDisplayArea.setColumns(20);
        txtDisplayArea.setRows(5);
        jScrollPane1.setViewportView(txtDisplayArea);

        btnGenerateReport.setText("Generate Leave Request Report");
        btnGenerateReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateReportActionPerformed(evt);
            }
        });

        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnRequest.setText("REQUEST");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Please Select A Start And End Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtEndDate))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGenerateReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRequest)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnGenerateReport)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRequest)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    public void ClearDisplayArea() {
        txtDisplayArea.setText("");
    }

    String choice = "";
    String startDate;
    String endDate;

    TableModel model;
    String value1;
    String value2;
    String value3;


    private void jLeaveTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLeaveTableMouseClicked

        //ClearDisplayArea();
        int index = jLeaveTable.getSelectedRow();
        model = jLeaveTable.getModel();
        value1 = model.getValueAt(index, 0).toString();
        value2 = model.getValueAt(index, 1).toString();
        value3 = model.getValueAt(index, 2).toString();

        choice = "      " + "CHOICE : " + value1 + " " + value2 + " " + value3;

        startDate = txtStartDate.getText();
        endDate = txtEndDate.getText();
        String dateError = "";

        JOptionPane.showMessageDialog(null, "      " + "CHOICE : " + value1 + " " + value2 + " " + value3 + "\n" + startDate + " " + endDate);

        txtDisplayArea.append("\n" + "\n" + choice.toString() + "\n" + startDate + "\n" + endDate + "\n");

    }//GEN-LAST:event_jLeaveTableMouseClicked


    private void btnGenerateReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateReportActionPerformed

        if ("".equals(txtDisplayArea.getText())) {
            System.out.println("empty string");
        } else {
            String contents = txtDisplayArea.getText();

            System.out.println("\n" + "The Folowing Employee Has Requested Leave : " + "\n" + "\n" + contents);
        }
    }//GEN-LAST:event_btnGenerateReportActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed

        Datahandler dh = new Datahandler();
        dh.connectToDB();

        String status = "Pending";

        try {
            if (!dh.InsertEmployeeLeaveRequest(userman.getName(),
                    userman.getSurname(),
                    userman.getAge(),
                    userman.getEmail(),
                    userman.getPhone(),
                    userman.getDepartmentID(),
                    Integer.parseInt(value1),
                    value2,
                    Integer.parseInt(value3),
                    startDate,
                    endDate,
                    status)) {

                Person p = new Person();
                p = dh.GetUserInfo(userman.getName());
                JOptionPane.showMessageDialog(this, "Your Request For Leave Could Not Be Made At This Time!");
            } else {

                JOptionPane.showMessageDialog(this, "Your Leave Request Has Successfully Been Submitted.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnRequestActionPerformed

    private void btnLeaveHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveHistoryActionPerformed
        Datahandler dh = new Datahandler();

        Person p = new Person();
        try {
            p = dh.GetUserInfo(userman.getName());
            ViewLeaveHistory vlh = new ViewLeaveHistory(p);
            vlh.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeLeaveRequestPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(EmployeeLeaveRequestPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLeaveHistoryActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeLeaveRequestPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeLeaveRequestPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeLeaveRequestPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeLeaveRequestPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeLeaveRequestPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGenerateReport;
    private javax.swing.JButton btnLeaveHistory;
    private javax.swing.JButton btnRequest;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTable jLeaveTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jUsernameHere;
    private javax.swing.JTextArea txtDisplayArea;
    private javax.swing.JTextField txtEndDate;
    private javax.swing.JTextField txtStartDate;
    // End of variables declaration//GEN-END:variables

}
