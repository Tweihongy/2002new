//check how to get CampInfo for viewsuggestions method

import java.util.*;

public class CampComSuggestion extends Suggestion {
    //private static int suggestionIDCounter = 1; // Counter shared among all instances
    private int suggestionID; // Instance-specific suggestion ID

    // Constructor
    public CampComSuggestion() {
        super();
    }

    public void submitSuggestion(CampComSuggestion suggestion) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the camp you want to suggest for: ");
        String campName = scanner.next();

        if (CampDB.camps.containsKey(campName)) {
        
            // Get the camp details associated with the campName
            CampInfo campInfo = CampDB.camps.get(campName);

            System.out.println("Enter your suggestion: ");
            // get user's suggestion
            String content = scanner.next(); // scanner

            //update the suggestion obj
            suggestion.setContent(content); 
            suggestionID = GenerateSuggestionID.generateSuggestionID();
            suggestion.setSuggestionID(suggestionID);
            campInfo.addSuggestion(suggestion);
            suggestion.setStudentID(Login.getUserID()); //pass in studentID
            System.out.println("Suggestion submitted successfully.");
            System.out.println("Your suggestion is: " + content);
        }
        else{
            System.out.println("Camp not found. Suggestion not submitted.");
        }
    }
    

    // Method to view suggestions
    public void viewSuggestions() {
         // Iterate over all the Camp entries
         for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
         {
            if(entry.getValue().getCampCommitteMembers().contains(Login.getuserObj())) //find the camp user camp com of
            {
                System.out.println("The suggestion you have for "+ entry.getValue().getCampName() + " are: ");
                CampInfo campInfo = entry.getValue(); //getting campinfo obj 
                int i = 1; //for UI purpose, counter for number of suggestion they have

                //iterate over all the suggestion under suggestion array for the specific camp
                for (Suggestion suggestion : campInfo.getSuggestion()) 
                {
                // Assuming Suggestion has a method like getUserID() to get the user ID associated with the suggestion
                    if (suggestion.getStudentID().equals(Login.getUserID())) {
                    // Process or print the suggestion information as needed
                    System.out.println(i+". Suggestion ID is " + suggestion.getSuggestionID()+ "Your suggestion for "+campInfo.getCampName()+ "is : " + suggestion.getContent() + " Status: " +suggestion.getProcessed());
                    i++;
                    }
                }
                break; //stop when find the camp
            }
             
             
         }



    }


    public void editSuggestion(int suggestionID)
    {
        // Iterate over all the Camp entries
        Boolean suggestionFound = false;
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
        {
            CampInfo campInfo = entry.getValue(); //getting campinfo obj 
            for (Suggestion suggestion : campInfo.getSuggestion()) 
            {
                if(suggestion.getSuggestionID()==suggestionID)
                {
                    suggestionFound = true;
                    if (suggestion.getStudentID().equals(Login.getUserID())) //is the user
                    {
                        if(suggestion.getProcessed() == SugProcessedState.NOT_PROCESSED) //check if processed
                        {
                            System.out.println("Please enter new suggestion" );
                            Scanner scanner = new Scanner(System.in);
                            String newsuggestion = scanner.next();
                            
                            //update suggestion content
                            suggestion.setContent(newsuggestion);
                            System.out.println("------------------ suggestion updated successfully ------------------");
                            System.out.println(" Your updated suggestion is: " + newsuggestion);
                            
                        }
                        else
                        {
                            System.out.println("The suggestion has been "+suggestion.getProcessed());
                        }
                    }
                    else
                    {
                        System.out.println("You do not have access to edit this suggestion.");
                    }
                    break; //break out of innerloop once suggestion found
                }
            }

        }
        if (!suggestionFound) {
                System.out.println("Invalid Suggestion ID.");
            }
    }

    public void deleteSuggestion(int suggestionID)
    {
        // Iterate over all the Camp entries
        Boolean suggestionFound = false;
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
        {
            CampInfo campInfo = entry.getValue(); //getting campinfo obj 
            for (Suggestion suggestion : campInfo.getSuggestion()) 
            {
                if(suggestion.getSuggestionID()==suggestionID)
                {
                    suggestionFound = true;
                    if (suggestion.getStudentID().equals(Login.getUserID())) //is the user
                    {
                        if(suggestion.getProcessed() == SugProcessedState.NOT_PROCESSED) //check if processed
                        {
                            
                            //delete the suggestion from suggestionlist
                            campInfo.getSuggestion().remove(suggestion);
                            System.out.println("------------------ Suggestion has been deleted successfully ------------------");                            

                        }

                        else
                        {
                            System.out.println("The suggestion has been "+suggestion.getProcessed());
                        }
                    }

                    else
                    {
                        System.out.println("You do not have access to delete this suggestion.");
                    }
                    break; //break out of innerloop once suggestion found
                }
            }

        }
        if (!suggestionFound) {
                System.out.println("Invalid Suggestion ID.");
            }
    }



}
