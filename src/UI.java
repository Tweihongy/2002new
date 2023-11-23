import java.util.Scanner;

public abstract class UI {
    
    public static void studentUI(StudentController student, StudentData studentdata){
        loop:
        while(true){
        System.out.println("1. View camps");
        System.out.println("2. Register camps");
        System.out.println("3. Register as camp committee");
        System.out.println("4. Withdraw from camp");
        System.out.println("5. Submit Enquires");
        System.out.println("6. View your enquires");
        System.out.println("7. Edit your enquires");
        System.out.println("8. View your registered camp");
        System.out.println("9. Logout");

        Scanner input = new Scanner (System.in);
        int choice = Integer.parseInt(input.next());

        switch(choice){
            case 1:
                student.viewCamps();
                System.out.println("1.View camps");


                break;
            case 2:
                student.registerCamp(studentdata);
                System.out.println("2.Register camps");
                break;
            case 3:
                System.out.println("3.Register as camp committee");
                break;
            case 4:
                System.out.println("4.Withdraw from camp");
                
                break;
            case 5:
                System.out.println("5.Submit Enquires");
                student.sendEnquire(studentdata);
                break;
            case 6:
                System.out.println("6.View your enquires");
                student.viewEnquiries(studentdata);
                break;
            case 7:
                System.out.println("7.Edit your enquires");
                break;
            case 8:
                System.out.println("8. View your registered camp");
                break;
            case 9:
                System.out.println("9. Logout");
                break loop;
            
        }
    }


    }
    public static void CampComUI(){
        loop:
        while (true) {
            
        
        System.out.println("1. View camps");
        System.out.println("2. Register camps");
        System.out.println("3. Register as camp committee");
        System.out.println("4. Withdraw from camp");
        System.out.println("5. Submit Enquires");
        System.out.println("6. View your enquires");
        System.out.println("7. Edit your enquires");
        System.out.println("8. View your registered camp");
        System.out.println("--CampCommittee permissions--");
        System.out.println("9. View enquires of your camp");
        System.out.println("10. Reply enquires of your camp");
        System.out.println("11. Submit suggestions");
        System.out.println("12. View suggestions");
        System.out.println("13. Edit suggestions");
        System.out.println("14. Delete suggestions");

        Scanner input = new Scanner (System.in);
        int choice = Integer.parseInt(input.next());

        switch(choice){
            case 1:
                System.out.println("1.view camps");
                break;
            case 2:
                System.out.println("2.register camps");
                break;
            case 3:
                System.out.println("3.register as camp committee");
                break;
            case 4:
                System.out.println("4.withdraw from camp");
                break;
            case 5:
                System.out.println("5.Submit Enquires");
                break;
            case 6:
                System.out.println("6.View your enquires");
                break;
            case 7:
                System.out.println("7.Edit your enquires");
                break;
            case 8:
                System.out.println("8. View your registered camp");
                break;
            case 9:
                System.out.println("9. View enquires of your camp");
                break;
            case 10:
                System.out.println("10. Reply enquires of your camp");
                break;
            case 11:
                System.out.println("11. Submit suggestions");
                break;
            case 12:
                System.out.println("12. View suggestions");
                break;
            case 13:
                System.out.println("13. Edit suggestions");
                break;
            case 14:
                System.out.println("14. Delete suggestions");
                break;
            case 15:
                System.out.println("15. Logout");
                
                break loop;

        }
    }
    }


    public static void staffUI(CampControllerStaff control, StaffData staffdata, Scanner input2){

        
        loop:
        while(true){
        System.out.println("1. Create camp");
        System.out.println("2. Edit camps I created");
        System.out.println("3. Delete camp");
        System.out.println("4. Change camp visibility");
        System.out.println("5. View all camps");
        System.out.println("6. View Camps I created");
        System.out.println("7. View enquires from camp I created");
        System.out.println("8. Reply to enquires from camp I created");
        System.out.println("9. View Suggestions from camp I created");
        System.out.println("10. Approve to Suggestions from camp I created");
        System.out.println("11. Generate report of camp");
        System.out.println("12. Generate performance report of camp committee");
        System.out.println("13. Logout");




        
        
        while (!input2.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number.");
            input2.next(); // Consume the invalid input to avoid an infinite loop
            
        }
        
        int choice = input2.nextInt();
        

        switch(choice){
            case 1:
                control.createCampUI(staffdata,input2);
                break;
            case 2:
                control.editCamp();
                break;
            case 3:
                control.deleteCamp();
                break;
            case 4:

                break;
            case 5:
                control.viewCamps();
                break;
            case 6:
                control.viewMyCamps(staffdata);

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:

                break;
            case 10:

                break;
            case 11:

                break;
            case 12:

                break;
            case 13:

                break loop;
            case 14:

                break;
        }
        
        
    }
        
    }



}
