import java.util.Scanner;

public class StudentController {
    public void viewCamps(){
        for (String key : CampDB.camps.keySet()) {
            System.out.println("Camp: " + key);
        }
    }
    public void registerCamp(StudentData user){
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter camp name:");
        String campName = scanner.nextLine(); 
        if (CampDB.camps.containsKey(campName)) {
            if(CampDB.camps.get(campName).getRemainingSlots() == 0){
                System.out.println("Camp Full");
            }

            else{
                CampDB.camps.get(campName).decreaseRemainingSlots();
                CampDB.camps.get(campName).addCampAttendees(user);
            
                System.out.println("Camp registered");
            }
        }
        else{
            System.out.println("Camp not found");
        }
        

    }
    public void withdrawCamp(StudentData user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter camp name:");
        String campName= scanner.nextLine(); 
        if (CampDB.camps.containsKey(campName)) {
            if(CampDB.camps.get(campName).getCampCommitteMembers().contains(user)){
                System.out.println("Cannot leave camp, you are camp committee");
            }
            else{
            CampDB.camps.get(campName).decreaseRemainingSlots();
            CampDB.camps.get(campName).removeCampAttendees(user);
            System.out.println("Camp left");
            }
        }
        else{
            System.out.println("Camp not found");
        }
        

    }

    public void registerAsCampCommitee(StudentData user){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter camp name:");
        String campName1= scanner.nextLine();
        if (CampDB.camps.containsKey(campName1)) {

            CampInfo campName = CampDB.camps.get(campName1);
            campName.decreaseCampComSlots();
            campName.addCampCommittee(user);
            user.registerCampCom(campName);

        }
        else{
            System.out.println("Camp not found");
            
        }
        
    }

    public void sendEnquire(UserData user){
        StudentEnquiries newenquire = new StudentEnquiries();
        newenquire.submitEnquiries(newenquire);

    }

    public void viewEnquiries(UserData user){
         StudentEnquiries newenquire = new StudentEnquiries();
         newenquire.viewEnquiries();
    }


}
