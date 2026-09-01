# 🚲 Peer-to-Peer Bike Rental System

A Spring Boot backend application that enables users to rent bikes from other users through a peer-to-peer rental platform.

---

## 📌 Project Overview

The Peer-to-Peer Bike Rental System allows users to:

- Register and login
- List bikes for rent
- Browse available bikes
- Book bikes for specific dates
- Make payments for bookings
- Submit reviews and ratings
- Store all data in PostgreSQL

The application follows a layered architecture using Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL.

---

## 🛠️ Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Hibernate

### Database
- PostgreSQL

### Build Tool
- Gradle

### Tools Used
- Postman
- pgAdmin
- Git
- GitHub
- VS Code

---

## 📂 Project Structure

```text
src/main/java/com/bikerental

├── controller
├── service
├── repository
├── entity
├── dto
│   └── request
├── config
└── BikerentalApplication
```

---

## ✅ Features Implemented

### User Management
- User Registration
- User Login
- Get All Users
- Get User By ID
- Update User
- Delete User

### Bike Management
- Add Bike
- Get All Bikes
- Get Bike By ID
- Update Bike
- Delete Bike

### Booking Management
- Create Booking
- Get All Bookings
- Get Booking By ID
- Update Booking
- Delete Booking

### Payment Management
- Create Payment
- Get All Payments
- Get Payment By ID
- Update Payment
- Delete Payment

### Review & Rating Management
- Create Review
- Get All Reviews
- Get Review By ID
- Get Reviews By Bike
- Update Review
- Delete Review

---

## 🗄️ Database Tables

```text
users
bikes
booking
payments
reviews
```

---

## 🔗 Entity Relationships

```text
User (1)
   |
   |
Booking (1)
   |
   |
Bike (1)
```

A booking is associated with:

- One User
- One Bike

---

## 🚀 API Endpoints
### Authentication

```http
POST   /auth/register
POST   /auth/login
GET    /auth/users
GET    /auth/users/{id}
PUT    /auth/users/{id}
DELETE /auth/users/{id}
```

### Bikes

```http
POST   /bikes
GET    /bikes
GET    /bikes/{id}
PUT    /bikis/{id}
DELETE /bikes/{id}
```

### Bookings

```http
POST   /bookings
GET    /bookings
GET    /bookings/{id}
PUT    /bookings/{id}
DELETE /bookings/{id}
```

### Payments

```http
POST   /payments
GET    /payments
GET    /payments/{id}
PUT    /payments/{id}
DELETE /payments/{id}
```

### Reviews

```http
POST   /reviews
GET    /reviews
GET    /reviews/{id}
GET    /reviews/bike/{bikeId}
PUT    /reviews/{id}
DELETE /reviews/{id}
```

---

## ⚙️ Database Configuration

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bikerentaldb
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## ▶️ Running the Application

### Clone Repository

```bash
git clone <repository-url>
```

### Navigate to Backend Folder

```bash
cd Backend
```

### Start PostgreSQL

Make sure PostgreSQL is running and the database `bikerentaldb` exists.

### Run Application

```bash
./gradlew bootRun
```

Application starts at:

```text
http://localhost:8080
```

---

## ✅ End-to-End Workflow

```text
User Registration
        ↓
User Login
        ↓
Add Bike
        ↓
Book Bike
        ↓
Make Payment
        ↓
Submit Review
        ↓
Store Data in PostgreSQL
```

---

## 📈 Project Status

### Completed Modules

✅ User Module  
✅ Login Module  
✅ Bike Module  
✅ Booking Module  
✅ Payment Module  
✅ Review & Rating Module  
✅ PostgreSQL Integration  
✅ CRUD Operations  
✅ Entity Relationships  

### Future Enhancements

- JWT Authentication
- Role-Based Access Control
- Swagger API Documentation
- Global Exception Handling
- Request Validation
- Docker Deployment

---

## 👨‍💻 Author

**Tejas Girish Choudhari**

Java | Spring Boot | PostgreSQL | REST APIs

---
⭐ If you found this project useful, consider giving it a star.
