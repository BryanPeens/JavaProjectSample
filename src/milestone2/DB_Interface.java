package milestone2;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Bryan
 */
public interface DB_Interface {

    //public void ConnectToServ() throws RemoteException;
    public boolean loginsearch(String Uname, String pword) throws SQLException, RemoteException;

    //public List<LeaveType> typeList() throws SQLException;

    public boolean InsertUser(String name, String surname, int age, String email, String phone, int depID, String password) throws SQLException, RemoteException;
    
    public boolean InsertEmployeeLeaveRequest(String name, String surname, int age, String email, String phone, int DepartmentID, int LID, String LName, int totalDays, String startDate, String endDate, String status) throws SQLException, RemoteException;
    
    public boolean UpdateEmployeeLeaveRequest(String name, String surname, int age, String email, String phone, int DepartmentID, int LID, String LName, int totalDays, String startDate, String endDate, String status,String newStatus, String ename) throws SQLException, RemoteException;

    public boolean DeleteUser(int userID) throws SQLException, RemoteException;

    public Person GetUserInfo(String Uname) throws SQLException, RemoteException;
    

    public boolean UpdateUser(String name, String surname, int age, String email, String phone, int depID, String password,int id) throws SQLException, RemoteException;

    public List<Person> personList() throws SQLException, RemoteException;
    
    public List<LeaveType> populatePendingtbl(String status) throws SQLException, RemoteException;
    
    public List<LeaveType> populatePendingtblSingleUser(String status,String name) throws SQLException, RemoteException;
    
//    public List<LeaveType >populateApprovedbl(String status) throws SQLException, RemoteException;
//    
//    public List<rejectedRequests> populateRejectedbl() throws SQLException, RemoteException;
    
    public List<LeaveType> populateLeaveTable() throws SQLException, RemoteException;
    
    //public List<RequestLeave> leaveList() throws SQLException, RemoteException;
    //public boolean InsertUser(String uName, String uSurname, String uDepartment, String uLocation, int uContact, int isAdmin, int uPassword, String dateOfBirth, String username) throws SQLException, RemoteException;
    //public User finedByUsername(String usersName) throws SQLException, RemoteException;
}
