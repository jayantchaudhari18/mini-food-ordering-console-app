package com.aurionpro.service;

public interface IDeliveryService {
    // Assigns a delivery partner at random
    String assignDeliveryPartner();

    // Adds a new delivery partner to the system
    void addPartner(String partnerName);

    // Displays all delivery partners
    void showPartners();

	void removePartner(String partner);
}
