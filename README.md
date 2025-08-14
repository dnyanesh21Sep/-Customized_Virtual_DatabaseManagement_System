# 📊 JSPM RSCOE Database Management System (DBMS)

> A **menu-driven, in-memory database management system** implemented in Java to store and manage employee records.  
> It mimics SQL-like operations using Java’s data structures without relying on an actual DBMS.

---

## 📌 Overview

This project implements a **Custom Virtual Database Management System (DBMS)** for managing employee records using Java’s `LinkedList`.  
It supports **insertion, deletion, selection, aggregation, and update** operations — similar to SQL queries — entirely in **primary memory (RAM)**.

---

## 🏗️ System Architecture

- **Data Structure Used:** `LinkedList<Employee>`  
- **Record Structure (`Employee`):**
  - `EID` – Auto-increment employee ID
  - `Ename` – Employee name
  - `EAddress` – Employee address
  - `ESalary` – Employee salary

---

## 📊 Architecture Diagram

```text
┌────────────────────────────┐
│ LinkedList<Employee> lobj  │
└──────────────┬─────────────┘
               │
               ▼
      ┌──────────────────────┐
      │ Employee Object       │
      │──────────────────────│
      │ EID        → int      │
      │ Ename      → String   │
      │ EAddress   → String   │
      │ ESalary    → int      │
      └──────────────────────┘
               │
               ▼
      (Multiple Employee Objects in LinkedList)
🔹 Features
1️⃣ Insert Record
INSERT INTO Employee VALUES (name, address, salary);
-Auto-assigns EID.
-Stores data in LinkedList.
2️⃣ Display All Records
-SELECT * FROM Employee;
-Prints all employee data in tabular format.
3️⃣ Display Record by EID
-SELECT * FROM Employee WHERE EID = <id>;
-Shows details of a specific employee.
4️⃣ Display Record by Name
-SELECT * FROM Employee WHERE Ename = "<name>";
-Shows all employees matching the given name.
5️⃣ Delete Record by EID
-DELETE FROM Employee WHERE EID = <id>;
-Removes the employee with the given ID.
6️⃣ Delete Record by Name
-DELETE FROM Employee WHERE Ename = "<name>";
-Removes the first matching record by name.
7️⃣ Aggregate Functions
➕ Sum of Salaries
-SELECT SUM(ESalary) FROM Employee;
📈 Maximum Salary
-SELECT MAX(ESalary) FROM Employee;
📉 Minimum Salary
-SELECT MIN(ESalary) FROM Employee;
📊 Average Salary
-SELECT AVG(ESalary) FROM Employee;
🔢 Count of Employees
-SELECT COUNT(*) FROM Employee;
8️⃣ Update Employee Record
-UPDATE Employee SET Ename = ..., EAddress = ..., ESalary = ... WHERE EID = <id>;
-Allows interactive update of name, address, or salary.
9️⃣ Help Menu
-Lists all available commands with descriptions.
🔟 About
-Displays developer and project information.
💻 Example Session
-------- JSPM RSCOE Database Management System --------
1 : Insert new record
2 : Display all records
3 : Display record by EID
4 : Display record by Name
5 : Delete record by EID
6 : Delete record by Name
7 : Display Sum of salaries
8 : Display Average salary
9 : Display Minimum salary
10 : Display Maximum salary
11 : Display record count
12 : Update Employee record
13 : Help
14 : About
15 : Exit DBMS
----------------------------------------------------------
🛠️ How to Run
javac program17.java
java program17
📌 Key Points
-No external DBMS required — uses primary storage (LinkedList).
-Demonstrates SQL-like commands in Java.
-Fully menu-driven and user-interactive.
-Excellent for learning DBMS concepts and Java collections.
📜 License
-Developed by Dnyanesh More at JSPM RSCOE.
-All rights reserved.

---
