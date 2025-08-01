
# 🛠️ Support Ticket Management System

A Java-based backend solution for managing customer support tickets, integrating both a **console-driven application using JDBC** and a **Spring Boot REST API using JPA**. This system allows users and support agents to interact with a common PostgreSQL database for creating, assigning, updating, and tracking tickets efficiently.

---

## ✅ Purpose

The purpose of this system is to demonstrate a full-stack backend implementation of a support ticketing workflow, with:

- A console-based CLI for support agents or internal users.
- A Spring Boot REST API for scalable and modern client integrations.
- A shared PostgreSQL database to maintain data consistency across both platforms.

---

## 📁 Project Folder Structure

```
support-ticket-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── supportjavaspring/
│   │   │               ├── controller/
│   │   │               ├── entity/
│   │   │               ├── repository/
│   │   │               └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── java/
├── pom.xml
└── README.md

---

## 🧩 Components

### 1. **Console-Based Application (JDBC)**
- CLI for creating and managing tickets and users.
- Built using core Java, JDBC, and PostgreSQL.

### 2. **Spring Boot REST API (JPA)**
- RESTful API for managing tickets and users via HTTP requests.
- Follows a layered architecture (Controller → Service → Repository → Entity).

---

## 🎯 Features

- 🎫 **Support Ticket Creation:** Log new tickets with issue details.
- 🧑‍💼 **Agent Assignment:** Assign tickets to available support staff.
- 🔍 **Search & View:** View all tickets or filter by status.
- 🗂️ **Status Update:** Change ticket status (open, in-progress, closed).
- 🔄 **Shared Database:** JDBC and JPA apps operate on the same dataset.
- 🛑 **Exception Handling:** Handles invalid inputs and missing data gracefully.

---

## 🎨 Design Highlights

- **Decoupled Architecture:** Console UI and REST API run independently.
- **Modular Package Structure:** Separates concerns for clean code maintenance.
- **Spring Boot Best Practices:** Uses annotations and layered service structure.
- **Scalable Backend:** REST API is ready for frontend/mobile integration.
- **Code Reusability:** Services and models can be reused across layers or extended.

---

## 🔧 Technologies Used

| Layer            | Technology                            |
|------------------|----------------------------------------|
| Language         | Java                                   |
| Console App      | Core Java, JDBC                        |
| API Layer        | Spring Boot, Spring Data JPA           |
| ORM              | Hibernate                              |
| Database         | PostgreSQL                             |
| Build Tool       | Maven                                  |
| API Testing Tool | Postman or cURL                        |

---

## ▶️ Setup Instructions

### Console-Based Application (JDBC)

1. Open the `supportjavaconsole` project in your IDE.
2. Ensure your PostgreSQL database is running.
3. Go to `com.supportjavaconsole.main.Main`.
4. Run the `Main.java` class.
5. Use the console UI to:
   - Create users
   - Add tickets
   - Assign tickets
   - List/update ticket status

### Spring Boot REST API (JPA)

1. Open the `supportjavaspring` project in your IDE or terminal.
2. Verify the database connection settings in `application.properties`.
3. Run the application with:

   ```bash
   mvn spring-boot:run
   ```

4. Access the API at:

   ```
   http://localhost:8080
   ```

5. Use tools like Postman or cURL to perform:
   - `POST /users` – create user
   - `GET /tickets` – fetch all tickets
   - `PUT /tickets/{id}` – update ticket status
   - And other CRUD operations

---

## 👤 Developer

**Lokeshwaran M**

---

## 📄 License

This project is created for educational and demonstration purposes only.


```
