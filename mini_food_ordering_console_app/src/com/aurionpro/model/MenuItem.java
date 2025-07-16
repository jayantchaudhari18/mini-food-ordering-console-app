package com.aurionpro.model;

public class MenuItem {
    private int id;
    private String name;
    private double price;
    private CuisineType cuisine;

    public MenuItem(int id, String name, double price, CuisineType cuisine) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cuisine = cuisine;
    }

    public int getId()
    { 
    	return id;
    	}
    
    public void setId(int id) {
    	this.id = id;
    	}
    
    public void setPrice(double price) {
		this.price = price;
	}

	public String getName() { 
    	return name;
    	}
    
    public double getPrice() {
    	return price; 
    	}
    
    public CuisineType getCuisine() { 
    	return cuisine; 
    	}
}

