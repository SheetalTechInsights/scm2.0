🚀 Project Overview

The Smart Contact Management System (SCM) is designed to help users store, organize, and manage contacts efficiently.
Each user gets a secure personal workspace where they can add, update, search, and manage contacts without data overlap.

This project follows industry-standard backend practices and demonstrates real-world usage of Spring Boot, Spring Security, OAuth2, and cloud services.



Tech Stack
🔹 Backend

Java

Spring Boot

Spring MVC

Spring Security

OAuth2 (Google & GitHub)

Spring Data JPA (Hibernate)

🔹 Frontend

HTML5

CSS3

JavaScript

Thymeleaf

Tailwind CSS

🔹 Database

MySQL

🔹 Cloud & Services

Cloudinary (Image Upload)

Gmail SMTP (Email Service)

🔹 Tools & Utilities

Maven

Git & GitHub

REST APIs

Pagination & Sorting

Key Features
🔐 Authentication & Security

User registration and login

OAuth2 login using Google and GitHub

Secure session-based authentication

User-specific data isolation

📇 Contact Management

Add new contacts

Update existing contacts

Delete contacts

Mark contacts as favorites

Upload profile images (Cloudinary)

🔍 Search & Pagination

Search contacts by:

Name

Email

Phone number

Pagination and sorting for large contact lists

☁ Cloud Image Upload

Contact profile images stored securely using Cloudinary

Automatic image handling and retrieval

📧 Email Service

Email integration using JavaMailSender

Gmail SMTP configuration

Ready for email verification & notifications

📤 Export Feature

Export contact list to Excel (.xlsx)

Project Structure

scm2.0
│
├── controllers
│   └── ContactController.java
│
├── entities
│   ├── User.java
│   └── Contact.java
│
├── repositories
│   ├── UserRepository.java
│   └── ContactRepository.java
│
├── services
│   ├── ContactService.java
│   ├── ImageService.java
│   └── EmailService.java
│
├── forms
│   ├── ContactForm.java
│   └── ContactSearchForm.java
│
├── security
│   └── SecurityConfig.java
│
├── templates
│   └── user
│       ├── contacts.html
│       ├── add_contact.html
│       └── update_contact_view.html
│
├── static
│   ├── css
│   └── js
│
└── application.properties


Configuration
🔹 Database (MySQL)

   spring.datasource.url=jdbc:mysql://localhost:3306/scm20
   spring.datasource.username=root
   spring.datasource.password=YOUR_DB_PASSWORD

🔹 JPA

     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true

     
 OAuth2 (Google & GitHub)

 spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET

spring.security.oauth2.client.registration.github.client-id=YOUR_GITHUB_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_GITHUB_CLIENT_SECRET


🔹 Email (Gmail SMTP)

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=YOUR_GMAIL_APP_D
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

🔹 Cloudinary

cloudinary.cloud-name=YOUR_CLOUD_NAME
cloudinary.api.key=YOUR_API_KEY
cloudinary.api.secret=YOUR_API_SECRET


▶ How to Run the Project

1️⃣ Clone the repository

git clone https://github.com/SheetalTechInsights/scm2.0.git


2️⃣ Configure application.properties

3️⃣ Build and run

mvn clean install
mvn spring-boot:run


4️⃣ Open browser

http://localhost:8081

🔒 Security Best Practices Used

OAuth2 authentication

Password encryption

User-specific authorization

Cloud-based secure image storage

Input validation using JSR-303

📈 Future Enhancements

Email verification after signup

Forgot password flow

Role-based access control

REST API version

Docker & cloud deployment

Admin dashboard

👨‍💻 Author

Sheetal Patidar
Bachelor of Engineering – CSE (AI & ML)
Acropolis Institute of Technology & Research, Indore

🔗 GitHub: https://github.com/SheetalTechInsights

 Why This Project Matters

This project demonstrates:

Real-world Spring Boot backend development

Secure authentication with OAuth

Cloud integration

Clean MVC architecture

Production-ready coding practices


 

