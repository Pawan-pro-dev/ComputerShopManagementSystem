# Computer Shop Management System

Enterprise Application Development 1 - Repeat Coursework
Specified area: **Sales**

## Student Details
- Name: T.M.P.Adithya
- Student ID: KUDSE233F-015

## About
A Java Swing desktop application for managing a computer shop: products,
customers, suppliers, purchases and sales, with a dashboard and sales reports.

## Features
- Login
- Dashboard
- Sales (transaction UI): shopping cart, stock validation, stock update on save
- Purchases from suppliers
- Input forms: Category, Product, Customer, Supplier
- Jasper report: Daily Sales Report, Monthly Sales Report, Stock Report, Product Sales Report
- Validations and exception handling

## Tools
- Java, Swing (NetBeans)
- MySQL
- JasperReports
- Maven

## How to run
1. Install MySQL and run `database/setup.sql` (MySQL Workbench: File > Open SQL Script > Run).
   This creates the `computer_shop` database with tables and sample data.
2. Open the project in NetBeans.
3. Set your MySQL username and password in the database connection class.
4. Run the project (start from `LoginForm`).

## Login
- Username: admin
- Password: 1234

## Project structure
- `src/` : source code (ui, dao, model)
- `database/computer_shop.sql` : database setup script
- `dist/` : runnable JAR (if included)
