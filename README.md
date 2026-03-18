# Credit-Card-Management-System-Spring-Hibernate
A console-based Credit Card Management System built using Spring and Hibernate. It allows users to register customers, issue credit cards, perform transactions within limits, generate monthly bills, and process payments, demonstrating real-world business logic and layered architecture.

## 🚀 Project Objective

- The main objective of this project is to:

- Manage credit card lifecycle

- Perform secure transactions within credit limits

- Generate monthly billing statements

- Process bill payments

- Demonstrate layered architecture using Spring & Hibernate
## 🛠️ Tech Stack

Language: Java

Framework: Spring Framework

ORM: Hibernate

Database: MySQL

Tools: Spring Tool Suite / IntelliJ / Eclipse

## 📂 Features

✔️ Register Customer
✔️ Apply for Credit Card
✔️ Assign Credit Limit
✔️ Perform Transactions
✔️ View Transaction History
✔️ Generate Monthly Bill
✔️ Pay Bill & Restore Credit Limit

## 🧱 Project Architecture

- The application follows a layered architecture:

- Controller Layer – Handles user input (console)

- Service Layer – Business logic

- DAO Layer – Database operations

- Entity Layer – Hibernate entities

## 🖥️ Console Menu
===== CREDIT CARD MANAGEMENT SYSTEM =====
1. Register Customer
2. Apply for Credit Card
3. View Credit Card Details
4. Make Transaction
5. View Transactions
6. Generate Bill
7. Pay Bill
8. Exit

## 🔄 Application Flow
1. Register Customer

   - Enter basic details

   - Customer ID generated

2. Apply for Credit Card

   - Link with customer

   - Assign credit limit

   - Generate card number

3. Perform Transaction

   - Deduct from available limit

   - Store transaction history

4. Generate Bill

   - Calculate total monthly spending

   - Generate bill with due date

5. Pay Bill

   - Accept payment

   - Restore available credit limit
