package com.aurionpro.model;

import java.util.*;

public class SimpleMenuService implements IMenuService {
    private List<MenuItem> menuItems = new ArrayList<>();
    private int currentId = 1;

    //used at admin panel for showing menu
//    public void displayMenu() {
//        for (CuisineType type : CuisineType.values()) {
//            System.out.println("---- " + type.getDisplayName() + " ----");
//            for (MenuItem item : menuItems) {
//                if (item.getCuisine() == type) {
//                    System.out.println(item.getId() + ". " + item.getName() + " - Rs." + item.getPrice());
//                }
//            }
//        }
//    }
    
    public void displayMenu() {
        for (CuisineType type : CuisineType.values()) {
            System.out.println("---- " + type.getDisplayName() + " ----");
            System.out.printf("%-5s %-30s %-10s\n", "ID", "Item Name", "Price (Rs.)");
            System.out.println("--------------------------------------------------------");
            for (MenuItem item : menuItems) {
                if (item.getCuisine() == type) {
                    System.out.printf("%-5d %-30s %-10.2f\n", item.getId(), item.getName(), item.getPrice());
                }
            }
            System.out.println(); // Empty line after each cuisine
        }
    }


    //used at customer panel when user selects cuisine
//    public void displayMenuByCuisine(CuisineType cuisine) {
//        System.out.println("---- " + cuisine.getDisplayName() + " ----");
//        boolean found = false;
//        for (MenuItem item : menuItems) {
//            if (item.getCuisine() == cuisine) {
//                System.out.println(item.getId() + ". " + item.getName() + " - Rs." + item.getPrice());
//                found = true;
//            }
//        }
//        if (!found) {
//            System.out.println("No items available for this cuisine.");
//        }
//    }
    
    public void displayMenuByCuisine(CuisineType cuisine) {
        System.out.println("---- " + cuisine.getDisplayName() + " ----");
        boolean found = false;

        System.out.printf("%-5s %-30s %-10s\n", "ID", "Item Name", "Price (Rs.)");
        System.out.println("--------------------------------------------------------");

        for (MenuItem item : menuItems) {
            if (item.getCuisine() == cuisine) {
                System.out.printf("%-5d %-30s %-10.2f\n", item.getId(), item.getName(), item.getPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No items available for this cuisine.");
        }
    }


    public void addMenuItem(MenuItem item) {
        item.setId(currentId++);
        menuItems.add(item);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItems;
    }
    
    //used when cutomer enters id to order
    public MenuItem getItemById(int id) {
        for (MenuItem item : menuItems) {
            if (item.getId() == id) return item;
        }
        return null;
    }
}

