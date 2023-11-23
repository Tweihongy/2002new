//studentController need to pass in the enquiry object


import java.util.* ;

public class StudentEnquiries extends Enquiry {

    // Constructor
    public StudentEnquiries() {
        super();
    }

    //studentController need to pass in the enquiry object
    // Method to submit new enquiries
    public void submitEnquiries(StudentEnquiries enquiry) {
        //Enquiry enquiry = new Enquiry(Login.getUserID(), newEnquiry);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the camp you want to enquire for: ");
        String campName = scanner.next();

        if (CampDB.camps.containsKey(campName)) {
        
            // Get the camp details associated with the campName
            CampInfo campInfo = CampDB.camps.get(campName);

            System.out.println("Enter your enquiry: ");
            // get user's enquiry
            String content = scanner.next(); // scanner
            enquiry.setContent(content);
            enqID = GenerateEnquiryID.generateEnquiryID();
            enquiry.setEnqID(enqID);
            campInfo.addEnquiry(enquiry);
            enquiry.setStudentID(Login.getUserID()); //pass in studentID
        System.out.println("Enquiry submitted successfully.");
        System.out.println("Your added enquiry is: " + content);

        }
        else{
            System.out.println("Camp not found. Enquiry not submitted.");
        }
    }


    // Method to view enquiries
    @Override
    public void viewEnquiries() {
        // Iterate over all the Camp entries
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
        {
            System.out.println("The following are the enquiries for: "+ entry.getValue().getCampName());
            CampInfo campInfo = entry.getValue(); //getting campinfo obj 
            for (Enquiry enquiry : campInfo.getEnquiry()) 
            {
            // Assuming Suggestion has a method like getUserID() to get the user ID associated with the suggestion
                if (enquiry.getStudentID().equals(Login.getUserID())) {
                // Process or print the suggestion information as needed
                System.out.println("The Enquiry ID is " + enquiry.getEnqID()+ "Your enquiry for "+campInfo.getCampName()+ "is : " + enquiry.getContent());
                }
        }
        }
        
    }

    // Method to edit enquiries
    public void editEnquiries(int enqID) {
        // Iterate over all the Camp entries
        Boolean enquiryFound = false;
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
        {
            CampInfo campInfo = entry.getValue(); //getting campinfo obj 
            for (Enquiry enquiry : campInfo.getEnquiry()) 
            {
                if(enquiry.getEnqID()==enqID)
                {
                    enquiryFound = true;
                    if (enquiry.getStudentID().equals(Login.getUserID()))
                    {
                        if(enquiry.getProcessed() == EnqProcessedState.NOT_PROCESSED)
                        {
                            System.out.println("Please enter new enquiry" );
                            Scanner scanner = new Scanner(System.in);
                            String newEnquiry = scanner.next();
                            
                            //update enquiry content
                            enquiry.setContent(newEnquiry);
                            System.out.println("------------------ Enquiry updated successfully ------------------");
                            System.out.println(" Your updated enquiry is: " + newEnquiry);
                            
                        }
                        else
                        {
                            System.out.println("The enquiry has been "+enquiry.getProcessed());
                        }
                    }
                    else
                    {
                        System.out.println("You do not have access to edit this enquiry.");
                    }
                    break; //break out of innerloop once enquiry found
                }
            }

        }
        if (!enquiryFound) {
                System.out.println("Invalid enquiry ID.");
            }
    }

    // Method to delete an enquiry
    public void deleteEnquiry(int enqID) {
        // Iterate over all the Camp entries
        Boolean enquiryFound = false;
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
        {
            CampInfo campInfo = entry.getValue(); //getting campinfo obj 
            for (Enquiry enquiry : campInfo.getEnquiry()) 
            {
                if(enquiry.getEnqID()==enqID)
                {
                    enquiryFound = true;
                    if (enquiry.getStudentID().equals(Login.getUserID()) && enquiry.getProcessed() == EnqProcessedState.NOT_PROCESSED)
                    {
                        if(enquiry.getProcessed() == EnqProcessedState.NOT_PROCESSED)
                        {
                            //delete the enquiry from enquirylist
                            campInfo.getEnquiry().remove(enquiry);
                            System.out.println("------------------ Enquiry has been deleted successfully ------------------");                            
                        }
                        else
                        {
                            System.out.println("The enquiry has been "+enquiry.getProcessed());
                        }
                    }
                    else
                    {
                        System.out.println("You do not have access to delete this enquiry.");
                    }
                    break; //break out of innerloop once enquiry found
                }
            }

        }
        if (!enquiryFound) {
                System.out.println("Invalid enquiry ID.");
        }

        
    }

    // Method to view replies
    public void viewReply() {
        // Iterate over all the Camp entries
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
        {
            CampInfo campInfo = entry.getValue(); //getting campinfo obj 
            for (Enquiry enquiry : campInfo.getEnquiry()) 
            {
            // Assuming Suggestion has a method like getUserID() to get the user ID associated with the suggestion
                if (enquiry.getStudentID().equals(Login.getUserID())) {
                // Process or print the suggestion information as needed
                System.out.println("The Enquiry ID is " + enquiry.getEnqID()+ "the reply for "+campInfo.getCampName()+ "is : " + enquiry.getReply());
                }
        }
        }
    }

}
