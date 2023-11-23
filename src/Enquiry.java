//enquiry object

// Enum for processed states
enum EnqProcessedState {
    NOT_PROCESSED,
    DELETED,
    REPLIED
}

public abstract class Enquiry {

    // Protected attributes
    protected String content;
    protected String reply;
    protected EnqProcessedState processed; // Enum type
    protected String studentID;
    protected int enqID;

    // Constructor
    public Enquiry() {

        this.studentID = null;
        this.content = null;
        this.reply = ""; // Initial reply is empty
        this.processed = EnqProcessedState.NOT_PROCESSED; // Enquiry is not processed initially
        this.enqID = -1; //defualt is 0
    }


    // Getter and Setter methods

    public int getEnqID() {
        return enqID;
    }

    public void setEnqID(int enqID) {
        this.enqID = enqID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public EnqProcessedState getProcessed() {
        return processed;
    }

    public void setProcessed(EnqProcessedState processed) {
        this.processed = processed;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String userID) {
        this.studentID = userID;
    }

    // Abstract method for viewing enquiries
    public abstract void viewEnquiries();
}
