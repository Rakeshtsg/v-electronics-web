Here is **a clean, developer-friendly README** written specifically for **offline VS Code development**, matching your full project structure.

---

# 📘 **V-Electronics – Developer Setup Guide (Offline VS Code Edition)**

This README is designed so you can run the **entire backend + frontend** offline on **VS Code** without needing any external tools except JDK, Maven, Node.js, and optionally Docker (for Redis).

---

# 🚀 **1. Prerequisites (Install These First)**

## ✅ **Backend Requirements**

| Tool                   | Version                      | Why?                        |
| ---------------------- | ---------------------------- | --------------------------- |
| **Java JDK**           | 17+                          | Required for Spring Boot    |
| **Apache Maven**       | 3.8+                         | To build the backend        |
| **VS Code Extensions** | Java Pack, Spring Boot Tools | For autocomplete, debugging |

## ✅ **Frontend Requirements**

| Tool        | Version            |
| ----------- | ------------------ |
| **Node.js** | 16+ or 18+         |
| **npm**     | included with Node |

## Optional (for advanced features)

| Tool                                   | Purpose                    |
| -------------------------------------- | -------------------------- |
| **Docker Desktop**                     | To run Redis               |
| **Postman / Thunder Client**           | To test backend APIs       |
| **VS Code Extension – Thunder Client** | API testing inside VS Code |

---

# 🗂️ **2. Project Structure Overview**

Your extracted folder:

```
v-electronics-ultimate/
│
├── backend/             <-- Spring Boot Backend (Java 17)
├── frontend/            <-- React Frontend (CRA)
├── docker-compose.yml   <-- Redis service
└── .github/             <-- CI Pipeline (GitHub Actions)
```

Backend uses:

* Spring Boot
* JWT Security
* H2
* Redis (optional caching)
* Swagger
* Unit Tests
* Razorpay mock

Frontend uses:

* React 18
* Axios Client
* Context API
* Components & Pages

---

# 🛠️ **3. Run Backend (VS Code Offline)**

## Step 1 — Open project in VS Code

Open folder:

```
v-electronics-ultimate/backend
```

## Step 2 — Install Java extensions

VS Code shows popup:
➡️ *“Required Java extensions missing. Install?”*
Click **Install All**.

## Step 3 — Run Backend

### **Option A: Run with Maven**

Open terminal inside VS Code:

```
cd backend
mvn spring-boot:run
```

### **Option B: Run in VS Code (Run Button)**

VS Code > Run > *Run Spring Boot App*

---

# 🌐 **4. Access Backend Services**

| Service             | URL                                                                                        |
| ------------------- | ------------------------------------------------------------------------------------------ |
| Swagger UI          | [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) |
| H2 Database Console | [http://localhost:8080/h2-console](http://localhost:8080/h2-console)                       |
| Public Products     | [http://localhost:8080/api/public/products](http://localhost:8080/api/public/products)     |

### Seed Dummy Products

```
POST http://localhost:8080/api/public/products/seed
```

---

# 🖥️ **5. Run Frontend (React App)**

## Step 1 — Open Frontend in VS Code

```
v-electronics-ultimate/frontend
```

## Step 2 — Install dependencies

```
npm install
```

## Step 3 — Start React

```
npm start
```

Frontend will open at:

👉 **[http://localhost:3000](http://localhost:3000)**

Backend auto-connects to **[http://localhost:8080](http://localhost:8080)**.

---

# 🛒 **6. Demo User Login**

Your backend seeds a demo user:

| Field        | Value |
| ------------ | ----- |
| **Username** | demo  |
| **Password** | demo  |

Login → receives JWT → stored in localStorage.

---

# 💳 **7. Payment (Mock Mode)**

Your backend returns fake Razorpay payment success:

```json
{
  "status": "success",
  "transactionId": "txn_173281716"
}
```

You can replace the mock later with the real Razorpay SDK.

---

# 🧩 **8. Optional: Run Redis (for caching)**

If you want Redis caching enabled:

### Start Redis using Docker:

```
docker-compose up -d
```

Redis runs at:

```
localhost:6379
```

---

# 🧪 **9. Running Unit Tests**

From backend folder:

```
mvn test
```

---

# 🐳 **10. Build Backend Docker Image**

```
cd backend
mvn clean package -DskipTests
docker build -t velectronics-backend .
```

Run:

```
docker run -p 8080:8080 velectronics-backend
```

---

# 🔧 **11. Full Developer Workflow (Offline)**

### 1️⃣ Start Redis (optional)

```
docker-compose up -d
```

### 2️⃣ Start backend

```
cd backend
mvn spring-boot:run
```

### 3️⃣ Seed products

Use Swagger or Postman.

### 4️⃣ Start frontend

```
cd frontend
npm start
```

### 5️⃣ Login

Use: `demo / demo`

### 6️⃣ Add items → Checkout → Mock Payment

---

# 🎉 **12. You're Ready to Develop**

Now you have:

* Full backend + frontend
* JWT Auth
* Cart + Orders + Payment
* Swagger docs
* Redis-ready architecture
* Docker deployments
* CI/CD pipeline scaffold

---


