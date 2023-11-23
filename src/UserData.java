import java.io.IOException;
import java.util.*;
import org.w3c.dom.Text;

public class UserData {
    public static Map<String, UserData> users = new HashMap<>();

    private String userID;
    private String name;
    private String password = "password";
    private String faculty;
    private String email;

    static Scanner sc = new Scanner(System.in);

    //-------- METHODS --------

    //Constructor
    public UserData(String name, String email, String faculty){
        //get User ID before "@" in email
        int index = email.indexOf("@");
        String userID = email.substring(0, index);

        this.userID = userID;
        this.name = name;
        this.email = email;
        this.faculty = faculty;

        //add in all users hashmap
        users.put(userID, this);
    }

    public static boolean checkIfUserType(String userID){
        if (users.containsKey(userID)){
            return true;
        }
        else{
            System.out.println("User does not exist!");
            return false;
        }
    }

    public static Map<String, UserData> getUserRecords(){
        return users;
    }

    public String getUserID(){
        return this.userID;
    }

    public String getName(){
        return this.name;
    }

    public String getFaculty(){
        return this.faculty;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String new_password){
        this.password = new_password;
    }
}