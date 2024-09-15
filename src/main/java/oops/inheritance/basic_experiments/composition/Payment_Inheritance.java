package oops.inheritance.basic_experiments.composition;

 abstract class Payment {
    public abstract void pay(double amount);
}

 class CreditCardPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card.");
    }
}

 class PaypalPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal.");
    }
}

public class Payment_Inheritance {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment();
        payment.pay(100.0);

        payment = new PaypalPayment();
        payment.pay(200.0);

        /*
        *
            Problems with inheritance
            1.  This leads to tight coupling, meaning that if you want to add more payment methods (e.g., BitcoinPayment), you would need to modify the Main class to create new instances for each new payment method.
                Problem: It violates the Open/Closed Principle from SOLID design principles. Your code is not closed for modification but should only be open for extension.
                *
            2. Problem: If the payment method needs to be selected based on user input, a conditional block would be required (like an if-else or switch statement), which reduces maintainability.
        *
        * */
    }
}
