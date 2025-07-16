package com.aurionpro.payment;

public class CashPayment implements IPaymentProcessor {
    public void processPayment(double amount) {
        System.out.println("Paid Rs." + amount + " in Cash.");
    }

    public String getPaymentMode() {
        return "Cash";
    }
}

