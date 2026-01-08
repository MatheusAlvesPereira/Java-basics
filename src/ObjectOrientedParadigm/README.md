# Payment Platform Example (Object-Oriented Paradigm)

This directory contains a practical example of **Object-Oriented Programming (OOP)** applied to a real-world scenario: a **Payment Platform**.

The goal is to demonstrate the four pillars of OOP (Abstraction, Inheritance, Encapsulation, and Polymorphism) using the Java language.

## 📂 Code Structure

The example is contained in the `PaymentPlatform.java` file and consists of the following classes:

1.  **`PaymentMethod` (Abstract Class)**:
    *   Represents the generic concept of a payment.
    *   Defines what every payment must have (transaction ID, amount) and what it must do (`processPayment`, `printReceipt`).
    *   Uses **Abstraction** to hide complexity and force subclasses to implement specific processing logic.

2.  **`CreditCardPayment` (Concrete Class)**:
    *   Inherits from `PaymentMethod`.
    *   Adds specific credit card data (card number, cardholder).
    *   Uses **Encapsulation** (`private`) to protect sensitive data.
    *   Implements its own version of `processPayment`.

3.  **`PayPalPayment` (Concrete Class)**:
    *   Inherits from `PaymentMethod`.
    *   Adds specific PayPal data (email).
    *   Implements its own version of `processPayment`.

4.  **`PaymentPlatform` (Main Class)**:
    *   Contains the `main` method.
    *   Simulates transaction processing.
    *   Demonstrates **Polymorphism** by treating `CreditCardPayment` and `PayPalPayment` objects as the generic type `PaymentMethod`.

## 🚀 How to Run

You can run this example directly through your IDE or via the terminal.

### Via IntelliJ IDEA (or other IDE)

1.  Open the `PaymentPlatform.java` file.
2.  Locate the `PaymentPlatform` class (which contains the `main` method).
3.  Click the **Play** (Run) icon next to the line `public class PaymentPlatform` or the `main` method.

### Via Terminal

Navigate to the project root (`C:/Users/mathe/IdeaProjects/Java-basics`) and execute the commands below:

1.  **Compile**:
    ```bash
    javac -d out src/ObjectOrientedParadigm/PaymentPlatform.java
    ```

2.  **Run**:
    ```bash
    java -cp out ObjectOrientedParadigm.PaymentPlatform
    ```

## 🧠 Applied OOP Concepts

*   **Abstraction**: We defined a model (`PaymentMethod`) without worrying about the detailed implementation of each payment type initially.
*   **Inheritance**: `CreditCardPayment` and `PayPalPayment` reuse code (like `transactionId` and `printReceipt`) from the parent class.
*   **Encapsulation**: The `cardNumber` and `email` fields are private and cannot be accessed directly from outside the class, ensuring security.
*   **Polymorphism**: The `processTransaction(PaymentMethod paymentMethod)` method accepts any type of payment. Java decides at runtime which `processPayment()` method to call (the credit card one or the PayPal one).
