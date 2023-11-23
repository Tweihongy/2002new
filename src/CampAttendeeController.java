/**
 * Represents a student that has registered as a camp attendee.
 * A student can be a camp attendee for many camps.
 */

public class CampAttendeeController extends StudentController {
    public void withdrawCamp(CampInfo camp){
        UserData u = Login.getuserObj();
        if(!(u instanceof StudentData)) return;
        StudentData user = (StudentData) u;
        camp.removeCampAttendees(user);
        camp.increaseRemainingSlots();
        camp.addWithdrawnUsers(user.getUserID());
    }
}