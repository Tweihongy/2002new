public class GenerateEnquiryID {
    private static int enquiryIDCounter = 1;
    
    // Static method to generate suggestion ID
    public static int  generateEnquiryID() {
        return enquiryIDCounter++;
    }
}
