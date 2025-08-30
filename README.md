# Bank Management System (Console-Based)

## Project Overview

The **Bank Management System** is a **console-based Java application** that simulates real-world banking operations while applying **OOP concepts**.

Users can **create accounts, deposit, withdraw, transfer funds, check balance**, deactivate accounts, and verify accounts using a **PIN**, demonstrating practical usage of **abstraction, encapsulation, inheritance, and polymorphism**.

---

## Features

1. **Account Management**

    * Create **Savings Account** or **Current Account**
    * **PIN-based verification** for all account operations
    * Deactivate accounts
    * Manage multiple accounts in the bank

2. **Banking Operations**

    * Deposit money
    * Withdraw money with account-type-specific rules

        * SavingsAccount → maintain minimum balance of Rs 500
        * CurrentAccount → overdraft allowed up to Rs -10,000
    * Transfer funds between accounts with PIN verification
    * Check account balance with PIN verification

3. **Security**

    * All sensitive operations require correct **PIN entry**

---

## Key OOP Concepts Demonstrated

### **Abstraction**

```java
public abstract class Account {
    protected int accountNumber;
    protected String holderName;
    private double balance;
    private final int pin;

    abstract String withdraw(double amount, int pin);
}
```

* Defines a common structure for all account types
* Forces subclasses to implement `withdraw()` logic specific to account type

### **Inheritance & Polymorphism**

```java
public class SavingsAccount extends Account {
    @Override
    String withdraw(double amount, int pin) {
        // Minimum balance check
    }
}

public class CurrentAccount extends Account {
    @Override
    String withdraw(double amount, int pin) {
        // Overdraft limit logic
    }
}
```

* Different withdrawal behavior depending on account type

### **Encapsulation**

```java
private double balance;
private final int pin;

public double getBalance() { return balance; }
public int getPin() { return pin; }
public String deposit(double amount) { balance += amount; return "Deposited " + amount; }
```

* Sensitive fields are private and accessed via getters and controlled methods

---

## Sample Flow

```text
Welcome to the Banking System

1. Create Savings Account
2. Create Current Account
3. Deactivate Account
4. Deposit Money
5. Withdraw Money
6. Transfer Money
7. Check Balance
8. Exit

Create Savings Account:
Set your 8 digit Account Number: 101
Enter your Name: Jaseem
Set your PIN: 1234
Enter your Balance: 1000
Account added successfully!

Withdraw Money:
Enter your account number: 101
Enter your pin: 1234
Enter the Amount: 200
Withdrawn 200 successfully
```

---

## Tools & Technologies

* **Language:** Java
* **IDE:** IntelliJ IDEA / Eclipse / VS Code
* **Concepts Used:** OOP (Abstraction, Encapsulation, Inheritance, Polymorphism)

---

## Resume-Highlight

* Demonstrates **core OOP principles** in a real-world scenario
* **Menu-driven console application** simulating a functional banking system
* **PIN verification feature** enhances security and realism
* Supports **account deactivation and fund transfers**
* Easily extendable with **file storage, transaction history, or GUI integration**
