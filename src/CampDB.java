//CampDB is a class that has a hashmap called camps whose key is CampName and the value is an object called CampInfo2
//Look at CampInfo2 class for the object implementation

import java.util.*;

public class CampDB {

    public static Map<String, CampInfo> camps = new HashMap<>();

    // Other methods and attributes for CampDB...

    // Method to add a camp to the database
    public static void addCamp(String campName, CampInfo campInfo) {
        camps.put(campName, campInfo);
    }

    // UserData, StaffData, Enquiry classes and other details are assumed to be defined in your code
}
