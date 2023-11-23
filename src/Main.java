import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws CsvValidationException, IOException {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        StudentDB Studentdatabase = new StudentDB();
        StaffDB Staffdatabase = new StaffDB();


        Studentdatabase.initializeUserCSV();
        Staffdatabase.initializeUserCSV();

        while(true) {


            UserData currentuser = Login.login();

            if(currentuser.getClass().equals(StudentData.class)) {

                StudentData currentstudent = (StudentData) currentuser;

                System.out.println("welcome student " + currentuser.getName());
                StudentController userControl = new StudentController();

                
                UI.studentUI(userControl,currentstudent);
                
                

            }
            if(currentuser.getClass().equals(StaffData.class)) {

                System.out.println("welcome staff " + currentuser.getName());
                CampControllerStaff userControl = new CampControllerStaff();
                Scanner input2 = new Scanner (System.in);
                UI.staffUI(userControl, currentuser, input2);
                
                

            }







                


        }

        //System.out.println(StudentData.students.get("SL22").getName());

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

    }
}