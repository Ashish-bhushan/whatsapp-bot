# 🤖 WhatsApp Chatbot Backend

<div align="center">

![Java](https://img.shields.io/badge/Java-17+-orange?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.x-brightgreen?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-red?style=for-the-badge&logo=apachemaven&logoColor=white)
![REST API](https://img.shields.io/badge/REST-API-blue?style=for-the-badge&logo=postman&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

**A simple WhatsApp chatbot backend simulation built with Java & Spring Boot.**  
Accepts WhatsApp-style JSON messages via a REST API and responds with intelligent predefined replies.

[🚀 Live Demo](#-live-demo) • [📦 Installation](#-installation--setup) • [🧪 API Testing](#-api-testing-with-postman) • [📁 Project Structure](#-project-structure) • [🤝 Contributing](#-contributing)

</div>

---

## 📖 Table of Contents

- [📌 About the Project](#-about-the-project)
- [✨ Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [📁 Project Structure](#-project-structure)
- [⚙️ Prerequisites](#️-prerequisites)
- [📦 Installation & Setup](#-installation--setup)
- [▶️ Running the Application](#️-running-the-application)
- [🧪 API Testing with Postman](#-api-testing-with-postman)
- [💬 Supported Commands](#-supported-commands)
- [📸 Screenshots](#-screenshots)
- [🚀 Live Demo](#-live-demo)
- [☁️ Deployment on Render](#️-deployment-on-render)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)
- [👨‍💻 Author](#-author)

---

## 📌 About the Project

This project is a **WhatsApp Chatbot Backend Simulation** built as part of a backend development assignment.  
It mimics how a real WhatsApp webhook works — receiving incoming message events and responding with automated replies.

> 💡 **Real-world use case:** In production, Meta (WhatsApp Business API) sends POST requests to your webhook URL every time a user messages your business. This project simulates exactly that flow.

The backend:
- 📥 **Receives** POST requests at `/api/webhook`
- 🧠 **Processes** the message using a service layer
- 📤 **Returns** a smart reply in JSON format
- 🪵 **Logs** every message to the console for monitoring

---

## ✨ Features

- ✅ REST API endpoint (`POST /api/webhook`) to receive messages
- ✅ Accepts WhatsApp-style JSON payload `{ "sender": "...", "message": "..." }`
- ✅ Predefined smart replies (Hi → Hello, Bye → Goodbye, and more)
- ✅ Input validation — rejects empty/null messages with `400 Bad Request`
- ✅ Structured JSON response with reply and status fields
- ✅ Console logging of all incoming and outgoing messages using SLF4J
- ✅ Health check endpoint (`GET /api/health`) to verify server status
- ✅ Clean layered architecture (Controller → Service → Model)
- ✅ Deployed on Render (free hosting) with a public URL

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| ☕ **Java 17** | Programming language |
| 🌱 **Spring Boot 3.2.x** | Backend framework |
| 🔗 **Spring Web (MVC)** | Building REST APIs |
| 📦 **Maven** | Dependency management & build tool |
| 🪵 **SLF4J + Logback** | Logging framework |
| 📮 **Postman** | API testing |
| 🐙 **Git + GitHub** | Version control |
| ☁️ **Render** | Free cloud deployment |

---

## 📁 Project Structure

```
whatsapp-bot/
│
├── 📂 src/
│   └── 📂 main/
│       ├── 📂 java/in/bhushan
│       │   ├── 🟢 ChatBotApplication.java   ← Main entry point, starts the server
│       │   ├── 📨 MessageRequest.java            ← Input model (JSON → Java Object)
│       │   ├── 📤 MessageResponse.java           ← Output model (Java Object → JSON)
│       │   ├── 🧠 ChatbotService.java            ← Business logic & reply generation
│       │   └── 🌐 WebhookController.java         ← REST endpoints (/webhook, /health)
│       │
│       └── 📂 resources/
│           └── ⚙️ application.properties         ← Server config (port, logging, etc.)
│
├── 📂 src/test/                                  ← Unit test folder
├── 📄 pom.xml                                    ← Maven dependencies
└── 📄 README.md                                  ← You are here!
```

---

## ⚙️ Prerequisites

Make sure you have the following installed before running the project:

| Tool | Version | Check Command |
|---|---|---|
| ☕ Java JDK | 21 | `java -version` |
| 📦 Apache Maven | 3.6+ | `mvn -version` |
| 🐙 Git | Any | `git --version` |
| 📮 Postman | Any | — |

> 🔗 **Download Links:**
> - Java: [adoptium.net](https://adoptium.net)
> - Maven: [maven.apache.org](https://maven.apache.org)
> - Postman: [postman.com](https://postman.com)

---

## 📦 Installation & Setup

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/Ashish-bhushan/whatsapp-bot.git
cd whatsapp-bot
```

### 2️⃣ Install Dependencies

```bash
mvn clean install
```

> ⏳ Maven will automatically download all required dependencies on first run.

---

## ▶️ Running the Application

### 🖥️ Option 1 — Using Maven (Terminal)

```bash
mvn spring-boot:run
```

### 💡 Option 2 — Using IntelliJ IDEA

```
1. Open the project in IntelliJ IDEA
2. Navigate to ChatBotApplication.java
3. Click the ▶ green Run button
```

### ✅ Success Output

If everything works, you'll see this in the console:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v3.2.x)

✅ Started ChatBotApplication in 2.3 seconds
```

🌐 Server is now running at: **`http://localhost:8080`**

---

## 🧪 API Testing with Postman

### 🔵 Endpoint 1 — Health Check

| Field | Value |
|---|---|
| **Method** | `GET` |
| **URL** | `http://localhost:8080/api/health` |

**Response:**
```
✅ WhatsApp Bot Server is running!
```

---

### 🟢 Endpoint 2 — Send a Message (Webhook)

| Field | Value |
|---|---|
| **Method** | `POST` |
| **URL** | `http://localhost:8080/api/webhook` |
| **Header** | `Content-Type: application/json` |

**📥 Request Body:**
```json
{
  "sender": "John",
  "message": "Hi"
}
```

**📤 Success Response (`200 OK`):**
```json
{
  "reply": "Hello! How can I help you today? 😊",
  "status": "success"
}
```

**📤 Error Response (`400 Bad Request`) — when message is empty:**
```json
{
  "reply": "Message cannot be empty",
  "status": "error"
}
```

---

## 💬 Supported Commands

| 💬 User Message | 🤖 Bot Reply |
|---|---|
| `Hi` / `Hello` | Hello! How can I help you today? 😊 |
| `Bye` / `Goodbye` | Goodbye! Have a great day! 👋 |
| `How are you` | I'm just a bot, but I'm doing great! 🤖 |
| `Help` | Available commands: Hi, Bye, How are you, Help |
| *Anything else* | Sorry, I didn't understand that. Type 'help' for options. |

> 🔡 **Note:** The bot is **case-insensitive** — `HI`, `hi`, `Hi` all give the same reply.

---

## 📸 Screenshots

### ✅ Server Running in Console
![Console Screenshot](https://github.com/Ashish-bhushan/whatsapp-bot/blob/d3b0f3ad70728456906e716a3f8c562937aac6c3/Screenshot%202026-03-27%2001.png)
```
📸 [Console screenshot showing Spring Boot startup logs]
```
### 📮 Postman — Sending "hi"
![Console Screenshot](https://github.com/Ashish-bhushan/whatsapp-bot/blob/c9167174eff0f970dd7acc1e1bcb779871575507/Screenshot%202026-03-27%2004.png)
```
📸 [Postman POST request with {"sender": "Alice", "message": "hi"}]
```

### 📮 Postman — Sending "bye"
> ![Console Screenshot](https://github.com/Ashish-bhushan/whatsapp-bot/blob/01a2dff8f85e2bcb4c7c93af4b25de8d5732d3d1/Screenshot%202026-03-27%2002.png)
```
📸 [Postman POST request with {"sender": "John", "message": "bye"}]
```

### 🪵 Console Logs (Message Tracking)
![Console Screenshot](https://github.com/Ashish-bhushan/whatsapp-bot/blob/773da0346a9f06e77ca4f99f3c686f7d92e63f62/Screenshot%202026-03-27%2003.png)
```
📸 [Console showing logged incoming and outgoing messages]
```

---

## 🚀 Live Demo

> 🌐 **Deployed URL:** `https://whatsapp-bot-xyz.onrender.com`

Test the live API:
```bash
curl -X POST https://whatsapp-bot-xyz.onrender.com/api/webhook \
  -H "Content-Type: application/json" \
  -d '{"sender": "TestUser", "message": "Hi"}'
```

---

## ☁️ Deployment on Render

Follow these steps to deploy for **free** on [Render](https://render.com):

### Step 1 — Push code to GitHub
```bash
git add .
git commit -m "Ready for deployment"
git push origin main
```

### Step 2 — Create a Web Service on Render
```
1. Go to render.com → Sign up (free)
2. Click "New" → "Web Service"
3. Connect your GitHub repository
4. Fill in the settings:
```

| Setting | Value |
|---|---|
| **Runtime** | `Java` |
| **Build Command** | `mvn clean package -DskipTests` |
| **Start Command** | `java -jar target/whatsapp-bot-0.0.1-SNAPSHOT.jar` |
| **Instance Type** | `Free` |

### Step 3 — Deploy 🚀
```
Click "Create Web Service" → Wait 3-5 minutes → Your app is live! 🎉
```

> ⚠️ **Free tier note:** The app sleeps after 15 mins of inactivity. First request may take ~30 seconds to wake up.

---

## 🤝 Contributing

Contributions are welcome! Here's how:

```bash
# 1. Fork the repository
# 2. Create a feature branch
git checkout -b feature/add-new-reply

# 3. Commit your changes
git commit -m "Add new reply for 'Thanks' message"

# 4. Push to branch
git push origin feature/add-new-reply

# 5. Open a Pull Request on GitHub
```

---

## 👨‍💻 Author

<div align="center">

**ASHISH BHUSHAN SINGH**

[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](github.com/Ashish-bhushan)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](linkedin.com/in/ashish-bhushan-singh-0b626735b 
)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:hariomsinghswn555@outlook.com)

</div>

---

<div align="center">

Made with ❤️ using Java & Spring Boot

</div>
