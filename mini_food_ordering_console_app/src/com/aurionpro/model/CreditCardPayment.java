package com.aurionpro.model;

import com.aurionpro.exceptions.InvalidCardException;
import java.util.Scanner;

public class CreditCardPayment implements IPaymentProcessor {
    private String paymentMode = "Credit Card";

    @Override
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter 16-digit Credit Card Number: ");
            String cardNumber = scanner.nextLine();
            if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
                throw new InvalidCardException("Invalid Credit Card number.");
            }

            System.out.print("Enter 3-digit CVV: ");
            String cvv = scanner.nextLine();
            if (cvv.length() != 3 || !cvv.matches("\\d+")) {
                throw new InvalidCardException("Invalid CVV.");
            }

            System.out.print("Enter OTP: ");
            String otp = scanner.nextLine();
            if (otp.length() != 4 || !otp.matches("\\d+")) {
                throw new InvalidCardException("Invalid OTP.");
            }

            System.out.println("Paid Rs." + amount + " via Credit Card.");
        } catch (InvalidCardException e) {
            System.out.println(e.getMessage());
            processPayment(amount); // Retry
        }
    }

    @Override
    public String getPaymentMode() {
        return paymentMode;
    }
}

