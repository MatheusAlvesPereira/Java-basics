package ObjectOrientedParadigm;

import java.util.UUID;

// Abstraction: Defining a blueprint for all payment methods
abstract class PaymentMethod {
    protected String transactionId;
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
        this.transactionId = UUID.randomUUID().toString();
    }

    // Abstract method forcing subclasses to implement their own logic
    public abstract void processPayment();

    // Concrete method shared by all subclasses
    public void printReceipt() {
        System.out.println("Receipt for Transaction: " + transactionId);
        System.out.println("Amount: $" + amount);
        System.out.println("Status: Processed");
    }
}

// Inheritance: CreditCardPayment inherits from PaymentMethod
class CreditCardPayment extends PaymentMethod {
    // Encapsulation: Private fields to protect sensitive data
    private final String cardNumber;
    private final String cardHolder;

    public CreditCardPayment(double amount, String cardNumber, String cardHolder) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void processPayment() {
        // Polymorphism: Specific implementation for Credit Card
        System.out.println("Processing Credit Card payment for " + cardHolder);
        // Simulating security check (masking card number)
        String maskedCard = "XXXX-XXXX-XXXX-" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("Charging card: " + maskedCard);
        System.out.println("Contacting Bank API...");
        System.out.println("Payment Authorized.");
    }
}

// Inheritance: PayPalPayment inherits from PaymentMethod
class PayPalPayment extends PaymentMethod {
    private final String email;

    public PayPalPayment(double amount, String email) {
        super(amount);
        this.email = email;
    }

    @Override
    public void processPayment() {
        // Polymorphism: Specific implementation for PayPal
        System.out.println("Connecting to PayPal Gateway...");
        System.out.println("Verifying account: " + email);
        System.out.println("Transferring funds...");
        System.out.println("Payment Successful.");
    }
}

// Main class to demonstrate the Payment Platform
public class PaymentPlatform {
    public static void main(String[] args) {
        System.out.println("=== Welcome to the Payment Platform ===\n");

        // Polymorphism: Treating different objects (CreditCard, PayPal) as the common type (PaymentMethod)
        PaymentMethod payment1 = new CreditCardPayment(250.50, "1234567812345678", "Matheus Developer");
        PaymentMethod payment2 = new PayPalPayment(89.99, "matheus@example.com");

        // Processing payments without needing to know the specific type at compile time
        processTransaction(payment1);
        
        System.out.println("\n--------------------------------------\n");
        
        processTransaction(payment2);
    }

    static void processTransaction(PaymentMethod paymentMethod) {
        System.out.println("Initiating Transaction...");
        paymentMethod.processPayment(); // Dynamic binding calls the correct method
        paymentMethod.printReceipt();
    }
}
