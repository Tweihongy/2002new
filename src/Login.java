
import java.util.Scanner;
public class Login {
    private static String userID;
    private static UserData userObj;
    static Scanner sc = new Scanner(System.in);

    public static String getUserID(){
        return userID;
    }

    public static UserData login(){
        //Enter user id
        System.out.println("-------- LOGIN --------");
        System.out.println("Enter your User ID: ");
        String person = sc.next();

        //Check if user exist, if do, get respective object
        if (StudentDB.students.containsKey(person)) userObj = StudentDB.students.get(person);
        else if (StaffDB.staffs.containsKey(person)) userObj = StaffDB.staffs.get(person);
        else System.out.println("User does not exist.");

        //If password = "password", must change password
        if (userObj.getPassword().equals("password")){
            changePassword(userObj);
        }


        //Enter password (MAX 5 TRIES)
        for (int i=1;i<=5;i++){
            System.out.println("Enter your password: ");
            String pw = sc.next();
            if (pw.equals(userObj.getPassword())) break;

            else{
                if (i==5){
                    System.out.println("Incorrect Password! You have exceeded maximum number of tries.");
                    return null;
                }

                System.out.printf("Incorrect Password! Your have %d tries left!\n", 5-i);
            }
        }

        //Login successful
        userID = person;
        System.out.println("You have logged in successfully!");
        return userObj;
    }



    public static void changePassword(UserData user) {
        System.out.println("-------- CHANGE PASSWORD --------");
        //enter old password (MAX 5 TRIES)
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enter your old password: ");
            String old_password = sc.next();
            if (old_password.equals(user.getPassword())) break;

            if (i == 5) {
                System.out.println("Incorrect Password! You have exceeded maximum number of tries.");
                return;
            }
            System.out.printf("Incorrect Password! Your have %d tries left!\n", 5 - i);
        }
        System.out.println("Enter new password: ");

        //if password = "password" (usually first time login) reject and ask for another password
        String new_pw = sc.next();
        while (new_pw.equals("password")){
            System.out.println("Password not allowed. Please set a different");
            System.out.println("Enter new password: ");
        }

        user.setPassword(new_pw);
        System.out.println("New password set successfully!");
        return;
    }
    static void logout(){
        
    }

    public static UserData getuserObj(){
        return userObj;
    }


}
