import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.opencsv.CSVReader;

import java.io.IOException;
import com.opencsv.exceptions.CsvValidationException;
public class StudentData extends UserData implements AddUserCSV{

    private boolean isCampCom = false;
    private String campComOf = null;
    private CampInfo campRegistered[][] = null;
    private int totalPoints = 0;

    public StudentData(String name, String email, String faculty, StudentDB students){
        super(name,email,faculty);
        int index = email.indexOf("@");
        String userID = email.substring(0, index);
        students.students.put(userID,this);
        System.out.printf("%s [%s] created.\n","Student",userID);
    }


    public static boolean checkIfUserType(String userID , StudentDB Studentdb){
        if (Studentdb.students.containsKey(userID)){
            return true;
        }
        else{
            System.out.println("User does not exist!");
            return false;
        }
    }
    public void registerCampCom(CampInfo campname){
        isCampCom = true;
        campComOf = campname.getCampName();
    }




}