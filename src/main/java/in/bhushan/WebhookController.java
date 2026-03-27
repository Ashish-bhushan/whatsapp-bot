package in.bhushan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @RestController = This class handles HTTP requests and returns JSON
// @RequestMapping = All routes in this class start with /api
@RestController
@RequestMapping("/api")
public class WebhookController {

    // Logger — prints messages to the console (for tracking incoming messages)
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    // @Autowired = Spring automatically gives us an instance of ChatbotService
    // We don't need to write: ChatbotService service = new ChatbotService();
    @Autowired
    private ChatbotService chatbotService;

    // @PostMapping("/webhook") = This method handles POST requests to /api/webhook
    // @RequestBody = Spring reads the JSON body and converts it to MessageRequest object
    @PostMapping("/webhook")
    public ResponseEntity<MessageResponse> receiveMessage(@RequestBody MessageRequest request) {

        // ── Step 1: Log the incoming message to console ──────────────────
        logger.info("📩 Incoming message from [{}]: {}", request.getSender(), request.getMessage());

        // ── Step 2: Validate — make sure message isn't empty ─────────────
        if (request.getMessage() == null || request.getMessage().isBlank()) {
            logger.warn("⚠️ Empty message received from [{}]", request.getSender());
            // Return 400 Bad Request with an error response
            return ResponseEntity.badRequest()
                    .body(new MessageResponse("Message cannot be empty", "error"));
        }

        // ── Step 3: Get reply from the ChatbotService ─────────────────────
        String reply = chatbotService.getReply(request.getMessage());

        // ── Step 4: Log what we're replying ───────────────────────────────
        logger.info("✅ Reply sent to [{}]: {}", request.getSender(), reply);

        // ── Step 5: Send back the reply as JSON with 200 OK status ────────
        return ResponseEntity.ok(new MessageResponse(reply, "success"));
    }

    // A simple GET endpoint to check if the server is running
    // Visit http://localhost:8080/api/health in browser to test
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("✅ WhatsApp Bot Server is running!");
    }
}