package com.aurionpro.test;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import com.aurionpro.discount.FlatDiscountStrategy;
import com.aurionpro.discount.IDiscountStrategy;
import com.aurionpro.exceptions.InvalidItemIdException;
import com.aurionpro.exceptions.InvalidQuantityException;
import com.aurionpro.model.CuisineType;
import com.aurionpro.model.MenuItem;
import com.aurionpro.model.Order;
import com.aurionpro.model.OrderItem;
import com.aurionpro.payment.CashPayment;
import com.aurionpro.payment.CreditCardPayment;
import com.aurionpro.payment.DebitCardPayment;
import com.aurionpro.payment.IPaymentProcessor;
import com.aurionpro.payment.UPIPayment;
import com.aurionpro.service.IDeliveryService;
import com.aurionpro.service.IMenuService;
import com.aurionpro.service.OrderHistoryService;
import com.aurionpro.service.SimpleDeliveryService;
import com.aurionpro.service.SimpleMenuService;

public class FoodOrderingApp {
    private static Scanner scanner = new Scanner(System.in);
    private static IMenuService menuService = new SimpleMenuService();
    private static IDeliveryService deliveryService = new SimpleDeliveryService();
    private static IDiscountStrategy discountStrategy = new FlatDiscountStrategy();
    private static IPaymentProcessor cashPayment = new CashPayment();
    private static IPaymentProcessor upiPayment = new UPIPayment();
    private static OrderHistoryService orderHistoryService = new OrderHistoryService();
    


    public static void main(String[] args) {
    	    menuService.addMenuItem(new MenuItem(0, "Paneer Butter Masala", 250.0, CuisineType.INDIAN));
    	    menuService.addMenuItem(new MenuItem(0, "Dal Tadka", 180.0, CuisineType.INDIAN));
    	    menuService.addMenuItem(new MenuItem(0, "Butter Naan", 40.0, CuisineType.INDIAN));

    	    menuService.addMenuItem(new MenuItem(0, "Margherita Pizza", 300.0, CuisineType.ITALIAN));
    	    menuService.addMenuItem(new MenuItem(0, "Pasta Alfredo", 350.0, CuisineType.ITALIAN));
    	    menuService.addMenuItem(new MenuItem(0, "Bruschetta", 150.0, CuisineType.ITALIAN));

    	    menuService.addMenuItem(new MenuItem(0, "Veg Hakka Noodles", 200.0, CuisineType.CHINESE));
    	    menuService.addMenuItem(new MenuItem(0, "Spring Rolls", 180.0, CuisineType.CHINESE));
    	    menuService.addMenuItem(new MenuItem(0, "Manchurian Gravy", 220.0, CuisineType.CHINESE));

    	    menuService.addMenuItem(new MenuItem(0, "Tacos", 120.0, CuisineType.MEXICAN));
    	    menuService.addMenuItem(new MenuItem(0, "Burrito", 280.0, CuisineType.MEXICAN));
    	    menuService.addMenuItem(new MenuItem(0, "Nachos", 140.0, CuisineType.MEXICAN));
    	    
    	    deliveryService.addPartner("Rahul");
    	    deliveryService.addPartner("Priya");
    	    
    	    


    	
    	
    	
    	
    	
    	
    	
        while (true) {
            System.out.println("\n--- Welcome to Food Ordering System ---");
            System.out.println("1. Admin Panel");
            System.out.println("2. Customer Panel");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            
            

            switch (choice) {
                case 1:
                    adminPanel();
                    break;
                case 2:
                    customerPanel();
                    break;
                case 3:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void adminPanel() {
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();

        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        if (authenticateAdmin(username, password)) {
        	   while (true) {
                   System.out.println("\n--- Admin Panel ---");
                   System.out.println("1. Add Menu Item");
                   System.out.println("2. Add Delivery Partner");
                   System.out.println("3. Show Menu");
                   System.out.println("4. Show Delivery Partners");
                   System.out.println("5. Remove Delivery Partners");
                   System.out.println("6. View All Orders");
                   System.out.println("7. Remove Menu Item");
                   System.out.println("8. Update Menu Item Price");
                   System.out.println("9. Back");
                   System.out.print("Enter your choice: ");
                   int adminChoice = scanner.nextInt();
                   scanner.nextLine();

                   switch (adminChoice) {
                       case 1:
                           addMenuItem();
                           break;
                       case 2:
                           addDeliveryPartner();
                           break;
                       case 3:
                           menuService.displayMenu();
                           break;
                       case 4:
                           deliveryService.showPartners();
                           break;
                       case 5:
                           removeDeliveryPartner();
                       case 6:
                           orderHistoryService.displayAllOrders();
                           break;
           
                       case 7:
                           removeMenuItem();
                           break;
                       case 8:
                           updateMenuItem();
                           break;
                       case 9:
                           return;    
                       default:
                           System.out.println("Invalid choice.");
                   }
               }
        	
        }else {
            System.out.println("Invalid credentials. Access denied.");
        }
        
     
    }
    
    
    private static boolean authenticateAdmin(String username, String password) {
        final String ADMIN_USERNAME = "admin";
        final String ADMIN_PASSWORD = "1234";

        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    private static void addMenuItem() {
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Choose Cuisine:");
        CuisineType.showAllCuisines();
        int cuisineIndex = scanner.nextInt();
        scanner.nextLine();
        if (cuisineIndex < 1 || cuisineIndex > CuisineType.values().length) {
            System.out.println("Invalid cuisine type.");
            return;
        }
        CuisineType cuisine = CuisineType.fromIndex(cuisineIndex - 1);

        MenuItem newItem = new MenuItem(0, name, price, cuisine);
        menuService.addMenuItem(newItem);
        System.out.println("Item added successfully.");
    }
    
    private static void updateMenuItem() {
        menuService.displayMenu();
        System.out.print("Enter Item ID to update: ");
        int itemId = scanner.nextInt();
        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        menuService.updateItemPrice(itemId, newPrice);
        
    }
    
    private static void removeMenuItem() {

    	menuService.displayMenu();
        System.out.println("Enter Item ID: ");
 
        int index = scanner.nextInt();
        scanner.nextLine();

 

 
        menuService.removeMenuItem(index);
        System.out.println("Item removed successfully.");
    }

    private static void addDeliveryPartner() {
        System.out.print("Enter Partner Name: ");
        String partner = scanner.nextLine();
        deliveryService.addPartner(partner);
        System.out.println("Partner added.");
    }
    
    private static void removeDeliveryPartner() {
        System.out.print("Enter Partner Name: ");
        String partner = scanner.nextLine();
        deliveryService.removePartner(partner);
        System.out.println("Partner removed.");
    }
    
    private static boolean authenticateCustomer(String email, String password) {
        final String CUSTOMER_EMAIL = "jayant@gmail.com";
        final String CUSTOMER_PASSWORD = "1234";

        return email.equalsIgnoreCase(CUSTOMER_EMAIL) && password.equals(CUSTOMER_PASSWORD);
    }


    //Customer panel code
    private static void customerPanel() {
        Order order = new Order();


        boolean finishedOrdering = false;
        System.out.print("Enter Customer Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        if (authenticateCustomer(email, password)) {
        	
        

        while (!finishedOrdering) {
            System.out.println("\n--- Choose Cuisine to Browse Menu ---");
            CuisineType.showAllCuisines();
            int cuisineChoice = scanner.nextInt();
            scanner.nextLine();

            if (cuisineChoice < 1 || cuisineChoice > CuisineType.values().length) {
                System.out.println("Invalid cuisine selected.");
                continue;
            }

            CuisineType selectedCuisine = CuisineType.fromIndex(cuisineChoice - 1);
            menuService.displayMenuByCuisine(selectedCuisine);

            while (true) {
            	try {
            		System.out.print("Enter Item ID to order (0 to go back to cuisine menu / -1 to finish ordering): ");
                    int itemId = scanner.nextInt();
                    scanner.nextLine();

                    if (itemId == -1) {
                        finishedOrdering = true;
                        break;
                    }

                    if (itemId == 0) {
                    	break;
                    }

                    MenuItem selectedItem = menuService.getItemById(itemId);
                    if (selectedItem == null) {
                        System.out.println("Invalid item ID.");
                        throw new InvalidItemIdException("Invalid item ID.");
                        
                    }

                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine();
                    if (qty <= 0) {
                        throw new InvalidQuantityException("Quantity must be greater than zero.");
                    }

                    OrderItem orderItem = new OrderItem(selectedItem, qty);
                    order.addItem(orderItem);
                    orderHistoryService.saveOrder(order);

                    System.out.println("Added to order.");
            		
            	}
            	catch (InvalidItemIdException | InvalidQuantityException e) {
            	    System.out.println(e.getMessage());
            	}
                
            }
        }



        if (order.getItems().isEmpty()) {
            System.out.println("You did not order anything. Returning to main menu.");
            return;
        }

        double total = order.calculateTotal();
        double discounted = discountStrategy.applyDiscount(total);
        order.setDiscountedAmount(discounted);

        System.out.println("Total: Rs." + total);
        System.out.println("After Discount: Rs." + discounted);


        
        System.out.println("Choose Payment Mode:");
        System.out.println("1. Cash\n2. UPI\n3. Credit Card\n4. Debit Card");
        int payChoice = scanner.nextInt();
        scanner.nextLine();

        switch (payChoice) {
            case 1:
                cashPayment.processPayment(discounted);
                order.setPaymentMode(cashPayment.getPaymentMode());
                break;
            case 2:
                upiPayment.processPayment(discounted);
                order.setPaymentMode(upiPayment.getPaymentMode());
                break;
            case 3:
                IPaymentProcessor credit = new CreditCardPayment();
                credit.processPayment(discounted);
                order.setPaymentMode(credit.getPaymentMode());
                break;
            case 4:
                IPaymentProcessor debit = new DebitCardPayment();
                debit.processPayment(discounted);
                order.setPaymentMode(debit.getPaymentMode());
                break;
            default:
                System.out.println("Invalid payment mode.");
        }


        String partner = deliveryService.assignDeliveryPartner();
        order.setDeliveryPartner(partner);


        
        System.out.println("\n=== Invoice ===");
        System.out.printf("%-30s %-10s %-10s\n", "Item", "Qty", "Price");
        System.out.println("----------------------------------------------------");

        for (OrderItem item : order.getItems()) {
            System.out.printf("%-30s %-10d Rs.%-10.2f\n",
                    item.getItem().getName(), item.getQuantity(), item.getTotalPrice());
        }
        System.out.println("----------------------------------------------------");
        System.out.printf("%-30s Rs.%-10.2f\n", "Total:", total);
        System.out.printf("%-30s Rs.%-10.2f\n", "Discounted:", discounted);
        System.out.printf("%-30s %s\n", "Payment Mode:", order.getPaymentMode());
        System.out.printf("%-30s %s\n", "Delivery Partner:", order.getDeliveryPartner());
        
        System.out.print("Do you want to print the bill to a file? (yes/no): ");
        String printChoice = scanner.nextLine();

        if (printChoice.equalsIgnoreCase("yes")) {
            try {
            	String folderPath = "invoices";
            	File directory = new File(folderPath);
            	if (!directory.exists()) {
            	    directory.mkdirs(); // folder create -if it does not exist
            	}

            	String fileName = folderPath + "/Invoice_" + System.currentTimeMillis() + ".txt";
            	PrintWriter writer = new PrintWriter(fileName);

                writer.println("=== Invoice ===");
                writer.printf("%-30s %-10s %-10s\n", "Item", "Qty", "Price");
                writer.println("----------------------------------------------------");

                for (OrderItem item : order.getItems()) {
                    writer.printf("%-30s %-10d Rs.%-10.2f\n",
                            item.getItem().getName(), item.getQuantity(), item.getTotalPrice());
                }

                writer.println("----------------------------------------------------");
                writer.printf("%-30s Rs.%-10.2f\n", "Total:", total);
                writer.printf("%-30s Rs.%-10.2f\n", "Discounted:", discounted);
                writer.printf("%-30s %s\n", "Payment Mode:", order.getPaymentMode());
                writer.printf("%-30s %s\n", "Delivery Partner:", order.getDeliveryPartner());

                writer.close();
                System.out.println("Invoice saved at: " + new File(fileName).getAbsolutePath());

                System.out.println("Invoice printed to file: " + fileName);
            } catch (Exception e) {
                System.out.println("Error printing invoice: " + e.getMessage());
            }
        }


    }else {
        System.out.println("Invalid credentials. Access denied.");
    }
    
}
}
