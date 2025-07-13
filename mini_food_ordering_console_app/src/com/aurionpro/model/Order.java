package com.aurionpro.model;

import java.util.*;

public class Order {
    private List<OrderItem> items = new ArrayList<>();
    private double totalAmount;
    private double discountedAmount;
    private String paymentMode;
    private String deliveryPartner;

//    public void addItem(OrderItem item) {
//        items.add(item);
//    }

    
    public void addItem(OrderItem newItem) {
        for (OrderItem existingItem : items) {
            if (existingItem.getItem().getId() == newItem.getItem().getId()) {
                // Item already exists → update quantity
                int newQty = existingItem.getQuantity() + newItem.getQuantity();
                existingItem.setQuantity(newQty);
                return;
            }
        }

        items.add(newItem);
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public double calculateTotal() {
        totalAmount = 0;
        for (OrderItem item : items) {
            totalAmount += item.getTotalPrice();
        }
        return totalAmount;
    }

    public void setDiscountedAmount(double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public double getDiscountedAmount() {
        return discountedAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setDeliveryPartner(String deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }

    public String getDeliveryPartner() {
        return deliveryPartner;
    }
}

