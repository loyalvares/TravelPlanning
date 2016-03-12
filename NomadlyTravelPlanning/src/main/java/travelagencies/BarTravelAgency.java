package main.java.travelagencies;

import main.java.CustomerReservationRequest;
import main.java.EventHandler;
import main.java.places.Bangalore;
import main.java.places.Mangalore;
import main.java.places.Mysore;

public class BarTravelAgency extends TravelAgency {
	
	public BarTravelAgency() {
		System.out.println("Bar Travel Agency has subscribed.");
	}
	
	@EventHandler
    public void handleCustom(Bangalore bangalore) {
		System.out.println("\nBarTravelAgency received a request for " + bangalore.getName());
	}
	
	@EventHandler
    public void handleString(Mysore mysore) {
		System.out.println("\nBarTravelAgency received a request for " + mysore.getName());
	}
	
	@EventHandler
    public void handleString(Mangalore mangalore) {
		System.out.println("\nBarTravelAgency received a request for " + mangalore.getName());
	}

}
