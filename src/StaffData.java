import java.util.ArrayList;

public class StaffData extends UserData{
    private ArrayList<CampInfo> createdCamps;
    
    public StaffData(String name, String email, String faculty){
        super(name,email,faculty);
        this.createdCamps = new ArrayList<CampInfo>();

        int index = email.indexOf("@");
        String userID = email.substring(0, index);
        StaffDB.staffs.put(userID,this);
        System.out.printf("%s [%s] created.\n","Staff",userID);
    }

    public static boolean checkIfStaff(String userID){
        if (StaffDB.staffs.containsKey(userID)){
            return true;
        }
        else{
            System.out.println("User does not exist!");
            return false;
        }  
    }
    
    public static StaffData getStaffObj(String userID){
        return StaffDB.staffs.get(userID);
    }


    public ArrayList<CampInfo> getCreatedCamps(){
        return this.createdCamps;
    }

}
