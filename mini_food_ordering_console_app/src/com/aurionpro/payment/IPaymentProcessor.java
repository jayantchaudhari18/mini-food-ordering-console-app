package com.aurionpro.payment;

public interface IPaymentProcessor {
    // Method to process the payment with a given amount
    void processPayment(double amount);

    // Method to get the type of payment mode (Cash, UPI, etc.)
    String getPaymentMode();
}

