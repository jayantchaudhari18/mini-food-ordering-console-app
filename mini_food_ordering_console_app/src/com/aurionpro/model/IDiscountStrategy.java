package com.aurionpro.model;

public interface IDiscountStrategy {
    // Applies discount and returns the final amount
    double applyDiscount(double amount);
}

