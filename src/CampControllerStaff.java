// discuss StaffController attributes
// datatype for staffInCharge
// discuss Constructor for StaffController
// Clarify implementation
// Date Format is currently DDMMYY
// Hashmap for camps
// name of hashmap is camp, need to standardise

import java.util.*;

public class CampControllerStaff {
	
    
    //methods
    public void createCamp(String campName,int campDate, int regisCloseDate, String location, int totalSlots, int campComSlots, String campDescription, StaffData staffInCharge, boolean visibility, String faculty) {


        // Assuming CampDB.CampInfo is your class for camp information
        CampInfo campInfo = new CampInfo(campName, campDate, regisCloseDate, location, totalSlots, 10, campDescription, staffInCharge, visibility,faculty);

        // Add the camp to the CampDB
        CampDB.addCamp(campName, campInfo);

        // Get the staff information that is created the camp
        UserData userObj = Login.getuserObj();
        StaffData staffObj = (StaffData) userObj;

        // Add camp to staffdata arraylist
        staffObj.getCreatedCamps().add(campInfo);
        System.out.println("Camp created ");
        campInfo.printCampInfo();
    }

    public void viewMyCamps(UserData user) {

        // Iterate over the Camp entries
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) {

            // Assuming you want to print information about the camp
            if(entry.getValue().getStaffInCharge() == user)
                entry.getValue().printCampInfo();
            
        }
    }



    public void viewCamps() {

        // Iterate over the Camp entries
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) {

            // Assuming you want to print information about the camp
            entry.getValue().printCampInfo();
            
        }
    }

    public void deleteCamp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter camp name:");
        String campName = scanner.nextLine();
    // Check if the campName exists in the map
    if (CampDB.camps.containsKey(campName)) {
        
        // Get the camp details associated with the campName
        CampInfo campInfo = CampDB.camps.get(campName);

        // Extract the staff in charge from the campInfo
        UserData staffInCharge = campInfo.getStaffInCharge();

        // Check if the current staff is the same as the staff in charge of the camp
        if (Login.getuserObj().equals(staffInCharge)) {
            // Remove the camp entry based on the campName
            CampDB.camps.remove(campName);
            System.out.println("Camp '" + campName + "' has been deleted.");
        } else {
            System.out.println("You can only delete camps that you created.");
        }
    } else {
        System.out.println("Camp '" + campName + "' not found.");
    }
}


 public void editCamp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter camp name:");
        String campName = scanner.nextLine();


    // Check if the campName exists in the map
    if (CampDB.camps.containsKey(campName)) {
        

        // Get the camp details associated with the campName
        CampInfo campInfo = CampDB.camps.get(campName);

        // Extract the staff in charge from the campInfo
        UserData staffInCharge = campInfo.getStaffInCharge();

        // Check if the current staff is the same as the staff in charge of the camp
        if (Login.getuserObj().equals(staffInCharge)) {

            // Display menu for editing
            displayEditMenu();

            // Get user input for the choice of detail to edit
           
            int choice = scanner.nextInt();

            // Switch statement to handle the chosen detail to edit
            switch (choice) {
                case 1:
                    System.out.println("Enter new camp date:");
                    int newCampDate = scanner.nextInt();
                    campInfo.setCampDate(newCampDate);
                    System.out.println("Camp date updated successfully.");
                    break;
                case 2:
                    System.out.println("Enter new registration closing date:");
                    int newRegisCloseDate = scanner.nextInt();
                    campInfo.setRegisCloseDate(newRegisCloseDate);
                    System.out.println("Registration closing date updated successfully.");
                    break;
                case 3:
                    System.out.println("Enter new location:");
                    String newLocation = scanner.next();
                    campInfo.setLocation(newLocation);
                    System.out.println("Location updated successfully.");
                    break;
                case 4:
                    System.out.println("Enter new total slots:");
                    int newTotalSlots = scanner.nextInt();
                    campInfo.setTotalSlots(newTotalSlots);
                    System.out.println("Total slots updated successfully.");
                    break;
                case 5:
                    System.out.println("Enter new camp committee slots:");
                    int newCampComSlots = scanner.nextInt();
                    campInfo.setCampComSlots(newCampComSlots);
                    System.out.println("Camp committee slots updated successfully.");
                    break;
                case 6:
                    System.out.println("Enter new camp description:");
                    String newCampDescription = scanner.next();
                    campInfo.setCampDescription(newCampDescription);
                    System.out.println("Camp description updated successfully.");
                    break;
                case 7:
                    System.out.println("Enter new visibility (true/false):");
                    boolean newVisibility = scanner.nextBoolean();
                    campInfo.setVisibility(newVisibility);
                    System.out.println("Visibility updated successfully.");
                    break;
                case 8:
                    System.out.println("Enter new faculty:");
                    String newFaculty = scanner.next();
                    campInfo.setFaculty(newFaculty);
                    System.out.println("Faculty updated successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. No changes made.");
                    break;
            }
        } else {
            System.out.println("You can only edit camps that you created.");
        }
    } else {
        System.out.println("Camp '" + campName + "' not found.");
    }
}


    private void displayEditMenu() {
        System.out.println("Choose the detail to edit:");
        System.out.println("1. Camp Date");
        System.out.println("2. Registration Close Date");
        System.out.println("3. Location");
        System.out.println("4. Total Slots");
        System.out.println("5. Camp Committed Slots");
        System.out.println("6. Camp Description");
        System.out.println("7. Visibility");
        System.out.println("8. Faculty");
    }

    public void createCampUI(StaffData staffdata, Scanner input2){
                
                System.out.println("Input camp name");
                String campName = input2.next(); // scanner
                System.out.println("Input location");
                String campLocation = input2.next(); // scanner
                System.out.println("Input camp description");
                String campDescription = input2.next(); // scanner
                System.out.println("Input visibility");
                while (!input2.hasNextBoolean()) {
                    System.out.println("Invalid input. Please enter a valid boolean.");
                    input2.next(); // Consume the invalid input to avoid an infinite loop
                   
                }
                boolean campVisibility = input2.nextBoolean(); // scanner
                System.out.println("Input faculty");
                String campFaculty = input2.next(); // scanner
                System.out.println("Input Camp start date");
                while (!input2.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input2.next(); // Consume the invalid input to avoid an infinite loop
                   
                }
                int campDate = input2.nextInt(); // scanner
                System.out.println("Input registration end date");
                while (!input2.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input2.next(); // Consume the invalid input to avoid an infinite loop
                   
                }
                int campRegisclose = input2.nextInt(); // scanner
                System.out.println("Input slots");
                while (!input2.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    input2.next(); // Consume the invalid input to avoid an infinite loop
                   
                }
                int campSlots = input2.nextInt(); // scanner
                
                this.createCamp(campName, campDate, campRegisclose, campLocation, campSlots, 10, campDescription, staffdata, campVisibility, campFaculty);

    }

}
