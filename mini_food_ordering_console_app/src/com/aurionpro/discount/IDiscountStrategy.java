package com.aurionpro.discount;

public interface IDiscountStrategy {
    // Applies discount and returns the final amount
    double applyDiscount(double amount);
}

