package main.java.travelagencies;

import main.java.CustomerReservationRequest;

public class TravelAgency {
	
	public TravelAgency() {
	}
	
	public void getCustomerDetails(CustomerReservationRequest c) {
		
		System.out.println("Customer Details:");
		System.out.println("Customer Name : " + c.getCustomerName());
		System.out.println("Phone Number : " + c.getPhoneNumber());
		System.out.println("Email : " + c.getEmail());
	}
}
