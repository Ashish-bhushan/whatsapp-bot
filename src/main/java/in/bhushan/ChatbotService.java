package in.bhushan;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {

    
    public String getReply(String message) {

       
        String lowerMessage = message.toLowerCase().trim();

       
        if (lowerMessage.equals("hi") || lowerMessage.equals("hello")) {
            return "Hello! How can I help you today? 😊";

        } else if (lowerMessage.equals("bye") || lowerMessage.equals("goodbye")) {
            return "Goodbye! Have a great day! 👋";

        } else if (lowerMessage.equals("how are you")) {
            return "I'm just a bot, but I'm doing great! 🤖";

        } else if (lowerMessage.equals("help")) {
            return "Available commands: Hi, Bye, How are you, Help";

        } else {
           
            return "Sorry, I didn't understand that. Type 'help' for options.";
        }
    }
}