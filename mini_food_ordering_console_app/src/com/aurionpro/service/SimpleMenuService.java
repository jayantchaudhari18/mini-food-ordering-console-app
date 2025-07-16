package com.aurionpro.service;

import java.util.ArrayList;
import java.util.List;

import com.aurionpro.model.CuisineType;
import com.aurionpro.model.MenuItem;

public class SimpleMenuService implements IMenuService {
	private List<MenuItem> menuItems = new ArrayList<>();
	private int currentId = 1;



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
			System.out.println();
		}
	}



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

	public void removeMenuItem(int id) {

		for (MenuItem item : menuItems) {
			if (item.getId() == id) {
				menuItems.remove(id - 1);
				return;

			}
		}

	}
	
	public void updateItemPrice(int itemId, double newPrice) {
	    MenuItem item = getItemById(itemId);
	    if (item != null) {
	        item.setPrice(newPrice);
	        System.out.println("Price updated successfully.");
	    } else {
	        System.out.println("Item not found.");
	    }
	}


	public List<MenuItem> getAllMenuItems() {
		return menuItems;
	}

	// used when cutomer enters id to order
	public MenuItem getItemById(int id) {
		for (MenuItem item : menuItems) {
			if (item.getId() == id)
				return item;
		}
		return null;
	}
}
