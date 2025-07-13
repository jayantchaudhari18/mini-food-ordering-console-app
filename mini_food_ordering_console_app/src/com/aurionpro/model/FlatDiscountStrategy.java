package com.aurionpro.model;

public class FlatDiscountStrategy implements IDiscountStrategy {
    public double applyDiscount(double amount) {
        if (amount > 500) {
        	
            return amount * 0.9; 
        }
        return amount;
    }
}

