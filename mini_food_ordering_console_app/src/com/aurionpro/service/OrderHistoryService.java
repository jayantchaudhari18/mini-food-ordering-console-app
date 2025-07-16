package com.aurionpro.service;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.Order;
import com.aurionpro.model.OrderItem;

public class OrderHistoryService {
    private List<Order> allOrders = new ArrayList<>();

    public void saveOrder(Order order) {
        allOrders.add(order);
    }

    public void displayAllOrders() {
        if (allOrders.isEmpty()) {
            System.out.println("No orders placed yet.");
            return;
        }

        int i = 1;
        for (Order order : allOrders) {
            System.out.println("\nOrder #" + i++);
            for (OrderItem item : order.getItems()) {
                System.out.println(item.getItem().getName() + " x " + item.getQuantity() + " = Rs." + item.getTotalPrice());
            }
            System.out.println("Total: Rs." + order.calculateTotal());
            System.out.println("Discounted: Rs." + order.getDiscountedAmount());
            System.out.println("Payment Mode: " + order.getPaymentMode());
            System.out.println("Delivery Partner: " + order.getDeliveryPartner());
        }
    }
}
