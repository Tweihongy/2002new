import java.util.Map;

abstract class CampController {
    
//methods
    public void getRemainingSlots(String student_faculty) {
        for (Map.Entry<String, CampInfo> camp : CampDB.camps.entrySet()){
            //check if the camp is from the same faculty as user or by NTU and ensure that the camp is visible
            if ((camp.getValue().getFaculty().equals(student_faculty) || camp.getValue().getFaculty().equals("NTU" )) && camp.getValue().isVisibility()){
                System.out.println(camp.getValue().getCampName() + ":" + camp.getValue().getRemainingSlots());
            }
        }
    }

public abstract void viewCamps();

}
