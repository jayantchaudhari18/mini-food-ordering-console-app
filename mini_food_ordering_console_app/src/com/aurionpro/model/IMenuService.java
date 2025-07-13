package com.aurionpro.model;

import java.util.*;

public interface IMenuService {
    void displayMenu();
    void displayMenuByCuisine(CuisineType cuisine);
    void addMenuItem(MenuItem item);
    List<MenuItem> getAllMenuItems();
    MenuItem getItemById(int id);
}

