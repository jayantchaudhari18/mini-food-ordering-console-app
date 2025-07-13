package com.aurionpro.model;

import java.util.Scanner;

public class UPIPayment implements IPaymentProcessor {
	
    public void processPayment(double amount) {
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.println("Enter UPI ID:");
    	String upi_id=scanner.next();
    	
    	if(isValidUPI(upi_id)) {
    		System.out.println("Upi ID verified");
    		System.out.println("Paid Rs." + amount + " via UPI.");
    		return;
    		
    	}
    	System.out.println("Invalid Upi ID");
    	
        
    }

    public String getPaymentMode() {
        return "UPI";
    }
    
    public  boolean isValidUPI(String upiId) {
 
        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z]+$";
        if(upiId != null && upiId.matches(regex)) {
        	return true;
        }
        return false;
    }
}

