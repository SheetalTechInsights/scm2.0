# 📇 Smart Contact Management System (SCM)

A **full-stack web application** built using **Java & Spring Boot** that enables users to securely manage their personal and professional contacts with modern authentication, cloud storage, and email services.

---

## 🚀 Project Overview

The **Smart Contact Management System (SCM)** helps users store, organize, and manage contacts efficiently in a **secure, user-specific workspace**.

Each user can:
- Add, update, delete contacts
- Upload profile images
- Search and paginate contact lists
- Login securely using OAuth (Google & GitHub)

This project follows **industry-standard backend practices** and demonstrates real-world usage of **Spring Boot, Spring Security, OAuth2, and cloud integrations**.

---

## 🛠 Tech Stack

### 🔹 Backend
- Java
- Spring Boot
- Spring MVC
- Spring Security
- OAuth2 (Google & GitHub)
- Spring Data JPA (Hibernate)

### 🔹 Frontend
- HTML5  
- CSS3  
- JavaScript  
- Thymeleaf  
- Tailwind CSS  

### 🔹 Database
- MySQL

### 🔹 Cloud & Services
- Cloudinary (Image Upload)
- Gmail SMTP (Email Service)

### 🔹 Tools & Utilities
- Maven
- Git & GitHub
- REST APIs
- Pagination & Sorting

---

## ✨ Key Features

### 🔐 Authentication & Security
- User registration and login
- OAuth2 authentication using **Google** and **GitHub**
- Secure session-based authentication
- User-specific data isolation

### 📇 Contact Management
- Add new contacts
- Update existing contacts
- Delete contacts
- Mark contacts as **favorites**
- Upload contact profile images

### 🔍 Search & Pagination
- Search contacts by:
  - Name
  - Email
  - Phone number
- Pagination and sorting for large datasets

### ☁ Cloud Image Upload
- Secure image storage using **Cloudinary**
- Automatic image handling and retrieval

### 📧 Email Service
- Email integration using **JavaMailSender**
- Gmail SMTP configuration
- Ready for email verification & notifications

### 📤 Export Feature
- Export contact list to **Excel (.xlsx)** format

---

## 🧩 Project Structure

```text
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
