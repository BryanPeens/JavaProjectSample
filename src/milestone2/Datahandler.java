package milestone2;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import milestone2.DB_Interface;
import milestone2.LeaveType;
import milestone2.Person;

/**
 *
 * @author Bryan
 */
public class Datahandler implements DB_Interface {

    public final String connectString = "jdbc:mysql://localhost:3306/java_2018_leave_system?";
    public Connection conn = null;
    public Statement st;
    public ResultSet rs = null;
    public String Qry;

    public void connectToDB() {
        try {
            conn = DriverManager.getConnection(connectString, "root", "");
        } catch (SQLException ex) {
            System.out.println("Connection Error!" + ex.getMessage());
        }
    }

    public Datahandler() {
        connectToDB();
    }

    @Override
    public boolean loginsearch(String uname, String pword) throws SQLException, RemoteException {
        Qry = "SELECT * FROM `user_tbl` WHERE `name`= ? AND `password`= ? ";
//            st = conn.createStatement(Qry);
//            rs = st.executeQuery(Qry);

        PreparedStatement loginStatement = conn.prepareStatement(Qry);
        loginStatement.setString(1, uname);
        loginStatement.setString(2, pword);

        rs = loginStatement.executeQuery();

        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Username and Password correct.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Username and Password incorrect!");
            return false;
        }
    }

//    @Override
//    public List<LeaveType> typeList() throws SQLException {
//        List<LeaveType> l = new ArrayList<LeaveType>();
//        Qry = "SELECT * FROM `leave_tbl`";
//        st = conn.createStatement();
//        rs = st.executeQuery(Qry);
//
//        while (rs.next()) {
//            l.add(new LeaveType(
//                    rs.getInt("lid"),
//                    rs.getString("name"),
//                    rs.getInt("days")));
//        }
//        return l;
//    }
    @Override
    public boolean InsertUser(String name, String surname, int age, String email, String phone, int depID, String password) throws SQLException, RemoteException {
        try {

            Qry = "INSERT INTO `user_tbl`(`uid`, `name`, `surname`, `age`, `email`, `phone`, `departmentID`, `password`) VALUES (NULL,?,?,?,?,?,?,?)";

            PreparedStatement insertUserStatement = conn.prepareStatement(Qry);

            insertUserStatement.setString(1, name);
            insertUserStatement.setString(2, surname);
            insertUserStatement.setInt(3, age);
            insertUserStatement.setString(4, email);
            insertUserStatement.setString(5, phone);
            insertUserStatement.setInt(6, depID);
            insertUserStatement.setString(7, password);

            insertUserStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean DeleteUser(int userID) throws SQLException, RemoteException {
        try {
            Qry = "DELETE FROM `user_tbl` WHERE `uid` = '" + userID + "'";
            PreparedStatement deleteStatement = conn.prepareStatement(Qry);
            deleteStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Person GetUserInfo(String Uname) throws SQLException, RemoteException {
        Person p = new Person();
        Qry = "SELECT * FROM `user_tbl` WHERE `name`= ? ";
        PreparedStatement getUserStatement = conn.prepareStatement(Qry);
        getUserStatement.setString(1, Uname);

        rs = getUserStatement.executeQuery();

        while (rs.next()) {
            p = new Person(
                    rs.getInt("uid"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("departmentID"),
                    rs.getString("password"));
        }
        return p;
    }

    @Override
    public boolean UpdateUser(String name, String surname, int age, String email, String phone, int depID, String password, int id) throws SQLException, RemoteException {
        try {
            Qry = "UPDATE `user_tbl` SET `name`= ?,`surname`= ?,`age`= ?,`email`= ?,`phone`= ?,`departmentID`= ?,`password`= ? WHERE `uid` = ?";

            PreparedStatement updateUsersStatement = conn.prepareStatement(Qry);
            updateUsersStatement.setString(1, name);
            updateUsersStatement.setString(2, surname);
            updateUsersStatement.setInt(3, age);
            updateUsersStatement.setString(4, email);
            updateUsersStatement.setString(5, phone);
            updateUsersStatement.setInt(6, depID);
            updateUsersStatement.setString(7, password);
            updateUsersStatement.setInt(8, id);

            updateUsersStatement.executeUpdate();

            System.out.println(" Updated Totally Just Worked! " + updateUsersStatement);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Person> personList() throws SQLException, RemoteException {
        List<Person> pers = new ArrayList<Person>();
        Qry = "SELECT * FROM `user_tbl`";
        st = conn.createStatement();
        rs = st.executeQuery(Qry);

        while (rs.next()) {
            pers.add(new Person(
                    rs.getInt("uid"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getInt("age"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("departmentID"),
                    rs.getString("password")));
        }
        return pers;
    }

    @Override
    public List<LeaveType> populatePendingtbl(String status) throws SQLException, RemoteException {
        List<LeaveType> pending = new ArrayList<LeaveType>();
        Qry = Qry = "SELECT * FROM `request_tbl` WHERE `status`= ?";

        PreparedStatement getSingleUserStatus = conn.prepareStatement(Qry);
        getSingleUserStatus.setString(1, status);

        rs = getSingleUserStatus.executeQuery();

        while (rs.next()) {
            pending.add(new LeaveType(
                    rs.getString("empName"),
                    rs.getString("empSurname"),
                    rs.getInt("empAge"),
                    rs.getString("empEmail"),
                    rs.getString("empPhone"),
                    rs.getInt("departmentid"),
                    rs.getInt("leaveid"),
                    rs.getString("leaveName"),
                    rs.getInt("days"),
                    rs.getString("startDate"),
                    rs.getString("endDate"),
                    rs.getString("status")));

        }
        return pending;
    }

    @Override
    public List<LeaveType> populatePendingtblSingleUser(String status, String name) throws SQLException, RemoteException {
        List<LeaveType> pending = new ArrayList<LeaveType>();
        Qry = Qry = "SELECT * FROM `request_tbl` WHERE `status`= ? AND `empName`= ? ";

        PreparedStatement getSingleUserStatus = conn.prepareStatement(Qry);
        getSingleUserStatus.setString(1, status);
        getSingleUserStatus.setString(2, name);

        rs = getSingleUserStatus.executeQuery();

        while (rs.next()) {
            pending.add(new LeaveType(
                    rs.getString("empName"),
                    rs.getString("empSurname"),
                    rs.getInt("empAge"),
                    rs.getString("empEmail"),
                    rs.getString("empPhone"),
                    rs.getInt("departmentid"),
                    rs.getInt("leaveid"),
                    rs.getString("leaveName"),
                    rs.getInt("days"),
                    rs.getString("startDate"),
                    rs.getString("endDate"),
                    rs.getString("status")));
        }
        return pending;
    }

    @Override
    public List<LeaveType> populateLeaveTable() throws SQLException, RemoteException {
        List<LeaveType> types = new ArrayList<LeaveType>();
        Qry = Qry = "SELECT * FROM `leave_tbl`";
        st = conn.createStatement();
        rs = st.executeQuery(Qry);

        while (rs.next()) {
            types.add(new LeaveType(
                    rs.getInt("lid"),
                    rs.getString("name"),
                    rs.getInt("days")));

        }
        return types;
    }

    public boolean ReturnPendingDetails(int id) {

        Person p = new Person();
        LeaveType l = new LeaveType();
        pendingRequest pr = new pendingRequest();

        try {
            Qry = "SELECT `p`.`pid`,`u`.`uid` AS userid,`u`.`name` AS userName,`u`.`surname` AS userSurname,`l`.`name` AS leaveType,`p`.`daysRequested`"
                    + "FROM `pending_tbl` AS p"
                    + "INNER JOIN `user_tbl` AS u ON u.uid = p.empid"
                    + "INNER JOIN `leave_tbl` AS l ON p.leaveid"
                    + "WHERE p.empid = ?";
            st = conn.createStatement();
            rs = st.executeQuery(Qry);

            while (rs.next()) {
                int pid = rs.getInt("pid");
                int uid = rs.getInt("uid");
                String uName = rs.getString("name");
                String uSurname = rs.getString("surname");
                String leaveType = rs.getString("name");
                String days = rs.getString("daysRequested");
            }
            return true;

        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean InsertEmployeeLeaveRequest(String name, String surname, int age, String email, String phone, int DepartmentID, int LID, String LName, int totalDays, String startDate, String endDate, String status) throws SQLException, RemoteException {
        try {

            Qry = "INSERT INTO `request_tbl`(`requestid`, `empName`, `empSurname`, `empAge`, `empEmail`, `empPhone`, `departmentid`, `leaveid`, `leaveName`, `days`, `startDate`, `endDate`, `status`) VALUES (NULL,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement insertRequestStatement = conn.prepareStatement(Qry);

            insertRequestStatement.setString(1, name);
            insertRequestStatement.setString(2, surname);
            insertRequestStatement.setInt(3, age);
            insertRequestStatement.setString(4, email);
            insertRequestStatement.setString(5, phone);
            insertRequestStatement.setInt(6, DepartmentID);
            insertRequestStatement.setInt(7, LID);
            insertRequestStatement.setString(8, LName);
            insertRequestStatement.setInt(9, totalDays);
            insertRequestStatement.setString(10, String.valueOf(startDate));
            insertRequestStatement.setString(11, String.valueOf(endDate));
            insertRequestStatement.setString(12, status);

            insertRequestStatement.executeUpdate();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean UpdateEmployeeLeaveRequest(String name, String surname, int age, String email, String phone, int DepartmentID, int LID, String LName, int totalDays, String startDate, String endDate, String status, String newStatus, String eName) throws SQLException, RemoteException {
        try {
            Qry = "UPDATE `request_tbl` SET `empName`= ?,`empSurname`= ?,`empAge`= ?,`empEmail`= ?,`empPhone`= ?,`departmentid`= ?,`leaveid`= ?,`leaveName`= ?,`days`= ?,`startDate`= ?,`endDate`= ?,`status`= ? WHERE `status`= ? AND `empName`= ?";

            PreparedStatement updateRequestStatus = conn.prepareStatement(Qry);

            updateRequestStatus.setString(1, name);
            updateRequestStatus.setString(2, surname);
            updateRequestStatus.setInt(3, age);
            updateRequestStatus.setString(4, email);
            updateRequestStatus.setString(5, phone);
            updateRequestStatus.setInt(6, DepartmentID);
            updateRequestStatus.setInt(7, LID);
            updateRequestStatus.setString(8, LName);
            updateRequestStatus.setInt(9, totalDays);
            updateRequestStatus.setString(10, String.valueOf(startDate));
            updateRequestStatus.setString(11, String.valueOf(endDate));
            updateRequestStatus.setString(12, status);

            updateRequestStatus.setString(13, newStatus);
            updateRequestStatus.setString(14, name);

            updateRequestStatus.executeUpdate();

            System.out.println(" Leave Request Was Approved! " + updateRequestStatus);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
