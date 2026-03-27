package in.bhushan;

public class MessageResponse
{

    private String reply;   // the bot's reply text
    private String status;  // "success" or "error"

    // Constructor — a quick way to create this object with values
    public MessageResponse(String reply, String status) {
        this.reply = reply;
        this.status = status;
    }

    // Getters — Spring needs these to CONVERT this object back to JSON
    public String getReply() {
        return reply;
    }

    public String getStatus() {
        return status;
    }
}