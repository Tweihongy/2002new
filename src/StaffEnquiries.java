import java.util.* ;

public class StaffEnquiries extends Enquiry {

    // Constructor
    public StaffEnquiries() {
        super();
    }

    public void viewEnquiries() {
        // Iterate over all the Camp entries
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
        {
            if(entry.getValue().getStaffInCharge().equals(Login.getuserObj()))
            {
                System.out.println("The following are the enquiries for: "+ entry.getValue().getCampName());
                CampInfo campInfo = entry.getValue(); //getting campinfo obj 
                for (Enquiry enquiry : campInfo.getEnquiry()) 
                {
                    // print all the enquiry for the camp
                    System.out.println("The Enquiry ID is " + enquiry.getEnqID()+ ", the enquiry for "+campInfo.getCampName()+ " is : " + enquiry.getContent());  
                }
            }
            
        }
        
    }

    public void replyEnquiry(int enqID)
    {
        Boolean enquiryFound = false;
        for (Map.Entry<String, CampInfo> entry : CampDB.camps.entrySet()) 
        {
            CampInfo campInfo = entry.getValue(); //getting campinfo obj 
            for (Enquiry enquiry : campInfo.getEnquiry()) 
            {
                if(enquiry.getEnqID()==enqID)
                {
                    enquiryFound = true;
                    if(campInfo.getStaffInCharge().equals(Login.getuserObj())) //check if is the camp they in charge of
                    {
                        if (enquiry.getProcessed() == EnqProcessedState.NOT_PROCESSED)
                        {
                        //ask for the reply
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Enter the reply for enquiry: ");
                        String reply = scanner.next();

                        //update the reply
                        enquiry.setReply(reply);
                        enquiry.setProcessed(EnqProcessedState.REPLIED);
                        }
                        else
                        {
                        System.out.println("The enquiry has been "+enquiry.getProcessed());
                        }
                    }
                    else
                    {
                        System.out.println("You do not have permission to reply to the enquiry ");
                    }
                    
                    break; //break out of innerloop once enquiry found
                }
            }

        }
        if (!enquiryFound) {
                System.out.println("Invalid enquiry ID.");
        }
    }

}
