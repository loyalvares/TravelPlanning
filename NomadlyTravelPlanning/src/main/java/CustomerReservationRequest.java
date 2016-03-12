package main.java;

import main.java.places.*;

public class CustomerReservationRequest {
	
	private String customerName;
	private int phoneNumber;
	private String email;
	private Place place;
	
	
	public CustomerReservationRequest(String customerName, int phoneNumber, String email, Place place) {
		super();
		this.customerName = customerName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.place = place;
	}

	public String getCustomerName() {
		return customerName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public Place getPlace() {
		return place;
	}
	

	
}
