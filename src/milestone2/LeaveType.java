package milestone2;

public class LeaveType extends LeaveRequests {

    private int LID;
    private String LName;
    private int totalDays;

    public int getLID() {
        return LID;
    }

    public void setLID(int LID) {
        this.LID = LID;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public LeaveType(int LID, String LName, int totalDays) {
        this.LID = LID;
        this.LName = LName;
        this.totalDays = totalDays;
    }

    public LeaveType(String LName, int totalDays) {
        this.LName = LName;
        this.totalDays = totalDays;
    }

    public LeaveType(String name, String surname, int age, String email, String phone, int DepartmentID, int LID, String LName, int totalDays, String startDate, String endDate, String status) {
        super(name, surname, age, email, phone, DepartmentID, startDate, endDate, status);
        this.LID = LID;
        this.LName = LName;
        this.totalDays = totalDays;
    }

    public LeaveType() {
    }

    @Override
    public String toString() {
        return LID + ", " + LName + ", " + totalDays ;
    }
}
