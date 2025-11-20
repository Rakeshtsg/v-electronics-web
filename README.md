    V Electronics - Ultimate (feature-rich scaffold)


    Contents:
 - backend/: Spring Boot backend with JWT, Redis hooks, Swagger, Dockerfile, unit tests
 - frontend/: React app (create-react-app expected)
 - docker-compose.yml: brings up Redis for local testing
 - .github/workflows/ci.yml: CI pipeline example

Quick start (dev):
1. Start Redis (docker-compose up -d)
2. Build and run backend: mvn -f backend spring-boot:run
3. Seed products: POST http://localhost:8080/api/public/products/seed
4. Start frontend (in its folder): npm install && npm start

Notes: Razorpay integration is mocked in PaymentService. Replace with real SDK and credentials when ready.
