//not sure about constructor

import java.util.Map;

public class StaffSuggestion extends Suggestion {
    
    // Constructor
    public StaffSuggestion() {
        super();
    }

    
    public void viewSuggestions()
    {
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet())
        {
            if(entry.getValue().getStaffInCharge().equals(Login.getuserObj()))
            {
                int i =1;
                System.out.println("The suggestion for "+ entry.getValue().getCampName() + " are: ");

                for (Suggestion suggestion : entry.getValue().getSuggestion()) {
                    // Assuming Suggestion has a method like getUserID() to get the user ID associated with the suggestion
                    
                    System.out.println(i+". Suggestion ID is " + suggestion.getSuggestionID()+ "Your suggestion for "+ entry.getValue().getCampName()+ "is : " + suggestion.getContent() + " Status: " +suggestion.getProcessed());
                     i++;   
                }
            }
            else 
                return;
        }
    }

    public void approveSuggestion(String campName, String suggestionID)
    {
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet())
        {
            if(entry.getValue().getCampName().equals(campName))
            {
                for (Suggestion suggestion : entry.getValue().getSuggestion())
                {
                    if(entry.getValue().getStaffInCharge().equals(Login.getuserObj()))
                    {
                        if(suggestion.getProcessed() == SugProcessedState.NOT_PROCESSED)
                        {
                            suggestion.processed = SugProcessedState.ACCEPTED;
                        }
                        else 
                        {
                            System.out.println("It has been "+ suggestion.getProcessed());
                        }
                    }

                    else
                    {
                        System.out.println("You do not have permission to approve this suggestion. ");
                    }
                }
                
                
            }
            else 
                return;
        }
    }

    public void rejectSuggestion(String campName, String suggestionID)
    {
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet())
        {
            if(entry.getValue().getCampName().equals(campName))
            {
                for (Suggestion suggestion : entry.getValue().getSuggestion())
                {
                    if(entry.getValue().getStaffInCharge().equals(Login.getuserObj()))
                    {
                        if(suggestion.getProcessed() == SugProcessedState.NOT_PROCESSED)
                        {
                            suggestion.processed = SugProcessedState.REJECTED;
                            System.out.println("The status for Suggestion ID: "+ suggestion.getSuggestionID() + " is "+ suggestion.getProcessed());
                        }
                        else 
                        {
                            System.out.println("It has been "+ suggestion.getProcessed());
                        }
                    }

                    else
                    {
                        System.out.println("You do not have permission to approve this suggestion. ");
                    }
                }
                
                
            }
            else 
                return;
        }
    }
}
