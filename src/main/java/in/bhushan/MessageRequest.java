package in.bhushan;

public class MessageRequest 
{

    private String sender;   
    private String message;  

   
    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

   
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}