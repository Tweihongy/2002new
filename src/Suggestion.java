// Enum for processed states
enum SugProcessedState {
    NOT_PROCESSED,
    DELETED,
    ACCEPTED,
    REJECTED
}

public abstract class Suggestion {
    protected String content;
    protected SugProcessedState processed; // Enum type
    protected String studentID; //camcomID
    private int suggestionID; // Instance-specific suggestion ID

    public Suggestion() {
        this.studentID = null;
        this.content = null;
        this.processed = SugProcessedState.NOT_PROCESSED; // Suggestion is not processed initially
        this.suggestionID = -1;
    }

    // Getter and setter for content
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and setter for processed
    public SugProcessedState getProcessed() {
        return processed;
    }

    public void setProcessed(SugProcessedState processed) {
        this.processed = processed;
    }

    // Getter and setter for studentID
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getSuggestionID(){
        return this.suggestionID;
    }

    public void setSuggestionID(int suggestionID) {
        this.suggestionID = suggestionID;
    }
    

    // Abstract method for viewing suggestions
    public abstract void viewSuggestions();
}
