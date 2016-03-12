package main.java.travelagencies;

import main.java.CustomerReservationRequest;
import main.java.EventHandler;
import main.java.places.Bangalore;
import main.java.places.Goa;
import main.java.places.Mangalore;

public class FooTravelAgency extends TravelAgency{
	
	public FooTravelAgency() {
		System.out.println("Foo Travel Agency has subscribed.");
	}
	
	@EventHandler
    public void handleCustom(Bangalore bangalore) {
		System.out.println("\nFooTravelAgency received a request for " + bangalore.getName());
	}
	
	@EventHandler
    public void handleString(Mangalore mangalore) {
		System.out.println("\nFooTravelAgency received a request for " + mangalore.getName());
	}
	
	@EventHandler
    public void handleString(Goa goa) {
		System.out.println("\nFooTravelAgency received a request for " + goa.getName());
	}

}
