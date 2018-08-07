package milestone2;

import java.util.Date;

/**
 *
 * @author Bryan
 */
public abstract class LeaveRequests extends Person {

    private int requestid;
    private String startDate;
    private String endDate;
    private String status;

    public int getRequestid() {
        return requestid;
    }

    public void setRequestid(int requestid) {
        this.requestid = requestid;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LeaveRequests(int requestid, String name, String surname, int age, String email, String phone, int DepartmentID, String startDate, String endDate, String status) {
        super(name, surname, age, email, phone, DepartmentID);
        this.requestid = requestid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public LeaveRequests(String name, String surname, int age, String email, String phone, int DepartmentID, String startDate, String endDate, String status) {
        super(name, surname, age, email, phone, DepartmentID);
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public LeaveRequests() {
    }

    @Override
    public String toString() {
        return requestid + ", " + startDate + ", " + endDate + ", " + status;
    }
}
