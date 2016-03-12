package main.java.travelagencies;

import main.java.CustomerReservationRequest;
import main.java.EventHandler;
import main.java.places.Bangalore;
import main.java.places.Goa;
import main.java.places.Mumbai;

public class BazTravelAgency extends TravelAgency {
	
	public BazTravelAgency() {
		System.out.println("Baz Travel Agency has subscribed.");
	}
	
	@EventHandler
    public void handleCustom(Bangalore bangalore) {
		System.out.println("\nBazTravelAgency received a request for " + bangalore.getName());
	}
	
	@EventHandler
    public void handleString(Mumbai mumbai) {
		System.out.println("\nBazTravelAgency received a request for " + mumbai.getName());
	}
	
	@EventHandler
    public void handleString(Goa goa) {
		System.out.println("\nBazTravelAgency received a request for " + goa.getName());
	}

}
