//package milestone2;
//
//import milestone2.LeaveRequests;
//
///**
// *
// * @author Bryan
// */
//public class approvedRequests extends LeaveRequests {
//
//    private int statusid;
//
//    private int days;
//
//    public int getStatusid() {
//        return statusid;
//    }
//
//    public void setStatusid(int statusid) {
//        this.statusid = statusid;
//    }
//
//    public int getDays() {
//        return days;
//    }
//
//    public void setDays(int days) {
//        this.days = days;
//    }
//
//    public approvedRequests(int requestid, int empid, int leaveid, int statusid, int days) {
//        super(requestid, empid, leaveid);
//        this.statusid = statusid;
//        this.days = days;
//    }
//
//    public approvedRequests() {
//    }
//
//    @Override
//    public String toString() {
//        return statusid + ", " + days;
//    }
//}
