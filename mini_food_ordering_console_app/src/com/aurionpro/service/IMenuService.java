package com.aurionpro.service;

import java.util.*;

import com.aurionpro.model.CuisineType;
import com.aurionpro.model.MenuItem;

public interface IMenuService {
    void displayMenu();
    void displayMenuByCuisine(CuisineType cuisine);
    void addMenuItem(MenuItem item);
    List<MenuItem> getAllMenuItems();
    MenuItem getItemById(int id);
	void removeMenuItem(int index);
	void updateItemPrice(int itemId, double newPrice);

}

