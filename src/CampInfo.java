//CampInfo2 is an object that is stored as a value in the hashmap called camps
//Each object has the following attributes

import java.util.ArrayList;
import java.util.Map;

public class CampInfo {

    private String campName;
    private int campDate;
    private int regisCloseDate;
    private String location; // faculty or NTU
    private int totalSlots;
    private int remainingSlots;
    private int campComSlots = 10;
    private String campDescription;
    private UserData staffInCharge;
    private String faculty;
    private boolean visibility;
    private ArrayList<StudentData> campAttendees = new ArrayList<>();
    private ArrayList<String> campAttendeesName = new ArrayList<>();
    private ArrayList<StudentData> campCommitteeMembers = new ArrayList<>();
    private ArrayList<String> campCommitteeNames = new ArrayList<>();
    private ArrayList<Suggestion> campSuggestions = new ArrayList<>();
    private ArrayList<Enquiry> enquiries = new ArrayList<>();
    private ArrayList<String> withdrawnUsers = new ArrayList<>();


    // Constructor
    public CampInfo(String campName, int campDate, int regisCloseDate, String location, int totalSlots,
                    int campComSlots, String campDescription, UserData staffInCharge, boolean visibility,
                    String faculty) {
        this.campName = campName;
        this.campDate = campDate;
        this.regisCloseDate = regisCloseDate;
        this.location = location;
        this.totalSlots = totalSlots;
        this.remainingSlots = totalSlots; // Assuming initially all slots are available
        this.campComSlots = campComSlots;
        this.campDescription = campDescription;
        this.staffInCharge = staffInCharge;
        this.faculty = faculty;
        this.visibility = visibility;
    }

    // Getter and Setter methods
    
    public String getCampName() {
        return campName;
    }

    public void setCampName(String campName) {
        this.campName = campName;
    }

    public int getCampDate() {
        return campDate;
    }

    public void setCampDate(int campDate) {
        this.campDate = campDate;
    }

    public int getRegisCloseDate() {
        return regisCloseDate;
    }

    public void setRegisCloseDate(int regisCloseDate) {
        this.regisCloseDate = regisCloseDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalSlots() {
        return totalSlots;
    }

    public void setTotalSlots(int totalSlots) {
        this.totalSlots = totalSlots;
    }

    public int getRemainingSlots() {
        return remainingSlots;
    }

    public void setRemainingSlots(int remainingSlots) {
        this.remainingSlots = remainingSlots;
    }

    public int getCampComSlots() {
        return campComSlots;
    }

    public void setCampComSlots(int campComSlots) {
        this.campComSlots = campComSlots;
    }

    public String getCampDescription() {
        return campDescription;
    }

    public void setCampDescription(String campDescription) {
        this.campDescription = campDescription;
    }

    public UserData getStaffInCharge() {
        return staffInCharge;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public ArrayList<StudentData> getCampCommitteMembers() {
        return campCommitteeMembers;
    }

    //methods
    public void viewCamps(String student_faculty){
        for (Map.Entry<String, CampInfo> camp : CampDB.camps.entrySet()){
            if (camp.getValue().faculty.equals(student_faculty) || camp.getValue().faculty.equals("NTU")){
                System.out.println(camp.getValue().campName);
            }
        }
    }

    public void printCampInfo() {
        System.out.println("  ");
        System.out.println("Camp Name: " + campName);
        System.out.println("Camp Date: " + campDate);
        System.out.println("Registration Close Date: " + regisCloseDate);
        System.out.println("Location: " + location);
        System.out.println("Total Slots: " + totalSlots);
        System.out.println("Remaining Slots: " + remainingSlots);
        System.out.println("Camp Committed Slots: " + campComSlots);
        System.out.println("Camp Description: " + campDescription);
        System.out.println("Staff in Charge: " + staffInCharge.getName());
        System.out.println("Faculty: " + faculty);
        System.out.println("Visibility: " + visibility);
        System.out.println("Camp attendees: " + campAttendeesName);
        System.out.println("Camp coms: " + campCommitteeNames);

        System.out.println("  ");
    }

    public void increaseRemainingSlots(){
        this.remainingSlots++;
    }

    public void decreaseRemainingSlots(){
        this.remainingSlots--;
    }


    public void decreaseCampComSlots(){ this.campComSlots--; }
    public void addCampAttendees(StudentData user){
        campAttendees.add(user);
        campAttendeesName.add(user.getName());
    }
    public void removeCampAttendees(StudentData user){
        campAttendees.remove(user);
        campAttendeesName.remove(user.getName());
    }

    public void addCampCommittee(StudentData user){
        campCommitteeMembers.add(user);
        campAttendeesName.add(user.getName());
    }
    public void removeCampCommittee(StudentData user){
        campCommitteeMembers.remove(user);
        campAttendeesName.remove(user.getName());
    }



// UserData, StaffData, Enquiry classes and other details are assumed to be defined in your code

    // methods for suggestion
    public ArrayList<Suggestion> getSuggestion() {
        return campSuggestions;
    }

    public void addSuggestion(CampComSuggestion suggestion) {
        campSuggestions.add(suggestion);
    }

    // methods for enquiry

    public void addEnquiry(StudentEnquiries enquiry) {
        enquiries.add(enquiry);
    }

    public ArrayList<Enquiry> getEnquiry() {
        return enquiries;
    }

    // methods for withdrawn users
    public boolean hasJoinedBefore(String userID) {
        return withdrawnUsers.contains(userID);
    }

    public void addWithdrawnUsers(String userID) {
        withdrawnUsers.add(userID);
    }
}

