package main.java;

import main.java.places.Bangalore;
import main.java.places.Mangalore;
import main.java.travelagencies.BarTravelAgency;
import main.java.travelagencies.BazTravelAgency;
import main.java.travelagencies.FooTravelAgency;
import main.java.travelagencies.TravelAgency;

// Main Class
public class PubSubMain {

	public static void main(String[] args) {
		
		MessagePublisher disp = new MessagePublisher();
		
		TravelAgency sub1 = new FooTravelAgency();
		TravelAgency sub2 = new BarTravelAgency();
		TravelAgency sub3 = new BazTravelAgency();
		
		// Add Subscribers
		disp.addTravelAgencySubscriber(sub1);
		disp.addTravelAgencySubscriber(sub2);
		disp.addTravelAgencySubscriber(sub3);
		
		// Create a Customer Request Object
		CustomerReservationRequest c1 = new CustomerReservationRequest("Loy", 777, "loy@loy.com", new Mangalore());
		
		System.out.println("\nCustomer publishes a Travel Planning request:");
		disp.publish(c1.getPlace(), c1);
		
		System.out.println("\nFooTravelAgency will now be Unsubscribed. . .");
		disp.unsubscribeTravelAgency(c1.getPlace(), sub1); 
		
		System.out.println("\nAfter Unsubscribing FooTravelAgency:");
		disp.publish(c1.getPlace(), c1);
		
	}

}
