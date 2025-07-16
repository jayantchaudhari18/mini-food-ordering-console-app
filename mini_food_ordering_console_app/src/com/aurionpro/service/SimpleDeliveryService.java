package com.aurionpro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleDeliveryService implements IDeliveryService {
    private List<String> partners = new ArrayList<>();
    private Random rand = new Random();

    public String assignDeliveryPartner() {
        if (partners.size() == 0) {
        	return "No Partner Assigned";
        	
        }
        	
        int index = rand.nextInt(partners.size());
        return partners.get(index);
    }

    public void addPartner(String partnerName) {
        partners.add(partnerName);
    }
    
    public void removePartner(String partnerName) {
        partners.remove(partnerName);
    }

    public void showPartners() {
        if (partners.isEmpty()) {
            System.out.println("No partners are added yet.");
            return;
        }
        System.out.println("---Delivery Partners:---");
        for (String partner : partners) {
            System.out.println("- " + partner);
        }
    }
}
