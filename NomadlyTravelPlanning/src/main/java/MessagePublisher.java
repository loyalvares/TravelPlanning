package main.java;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


import main.java.travelagencies.TravelAgency;

// publisher Message Bus

public class MessagePublisher {
	
	private class SubscriberInfo {
		public WeakReference<Object> subscriber;
		public Method method;
	}
	private Map<Class<?>, Set<SubscriberInfo>> subscribers = new HashMap<Class<?>, Set<SubscriberInfo>>();
	 
	public void addTravelAgencySubscriber(final Object subscriber) {
		System.out.println();
		for (Method method : subscriber.getClass().getMethods()) {
            if (method.getAnnotation(EventHandler.class)!=null) {
            	Class<?>[] paramTypes = method.getParameterTypes();
                if (paramTypes.length == 1){
                    addTypeSpecificSubscriber(subscriber, paramTypes[0],method);
                }
            }
        }
	}

	private void addTypeSpecificSubscriber(final Object subscriber, final Class<?> type, Method method) {
        Set<SubscriberInfo> typeSubscribers = subscribers.get(type);
        
        if (typeSubscribers == null) {
        	typeSubscribers = new HashSet<SubscriberInfo>();
            subscribers.put(type, typeSubscribers);
        }
        SubscriberInfo info = new SubscriberInfo();
        info.subscriber = new WeakReference<Object>(subscriber);
        info.method = method;
        // Add the subscriber
    	typeSubscribers.add(info);
        System.out.println(subscriber.getClass().getSimpleName() + " has been subscribed to "
        		+ "receive requests for " + type.getSimpleName());
	}

	public void publish(Object place, CustomerReservationRequest c) {
		Set<SubscriberInfo> typeSubscribers = subscribers.get(place.getClass());
		if (typeSubscribers == null) return;
		
		Collection<SubscriberInfo> invalidSubscribers = new LinkedList<SubscriberInfo>();
		
		for(SubscriberInfo info : typeSubscribers) {
			boolean handled = false;
			Object handler = info.subscriber.get();

			if (handler!=null) {
				try {
					info.method.invoke(handler, place);
					handled = true;
					TravelAgency a = (TravelAgency) handler;
					a.getCustomerDetails(c);
				} catch (IllegalArgumentException e) {					
					e.printStackTrace();
				} catch (IllegalAccessException e) {						
					e.printStackTrace();
				} catch (InvocationTargetException e) {				
					e.printStackTrace();
				}
				

			}
			if (!handled) invalidSubscribers.add(info);
		}
		for(SubscriberInfo info : invalidSubscribers) {
			typeSubscribers.remove(info);
		}
		if (typeSubscribers.size()==0) 
			subscribers.remove(place.getClass());		
	}
	
	public void unsubscribeTravelAgency(final Object place, final Object subscriber) {
		
		Set<SubscriberInfo> typeSubscribers = subscribers.get(place.getClass());
		if (typeSubscribers == null) return;
		
		Iterator<SubscriberInfo> itr = typeSubscribers.iterator();
		while(itr.hasNext()) {
			if(itr.next().subscriber.get().getClass().getSimpleName().toString()
					.equals(subscriber.getClass().getSimpleName().toString())) {
				itr.remove();
				System.out.println(subscriber.getClass().getSimpleName().toString()
						+ " has been Unsubscribed!!!");
			}
		}
	}
}

