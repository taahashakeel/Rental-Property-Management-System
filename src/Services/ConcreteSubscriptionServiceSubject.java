/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.0
 *  @since 1.0
 */

package Services;

import java.io.*;
import java.util.*;
import Employee.Property;
import BackEnd.DatabaseController;

public class ConcreteSubscriptionServiceSubject {
	private DatabaseController dbControl;
	private ArrayList<SubscribedObserver> subscribers;
	private Property newProperty;

	public ConcreteSubscriptionServiceSubject() {
		dbControl = new DatabaseController();
		subscribers = new ArrayList<SubscribedObserver>();
	}

	public void registerSubscribedObserver(SubscribedObserver subscriber) {
		subscribers.add(subscriber);
		subscriber.update(newProperty);  //update is not a function of an array list, im not sure what this does
	}

	public void removeSubscribedObserver(SubscribedObserver subscriber) {
		subscribers.remove(subscriber);
	}

	public void notifyAllSubscribedObservers() {
		for (int i = 0; i < subscribers.size(); i++) {
			SubscribedObserver subscriber = subscribers.get(i);
			subscriber.update(newProperty);
		}
	}

	public void addProperty(Property p) {
		this.newProperty = p;
		notifyAllSubscribedObservers();
	}

	public static ConcreteSubscriptionServiceSubject getOnlyInstance() {
		// TODO Auto-generated method stub
		return null;
	}
}
