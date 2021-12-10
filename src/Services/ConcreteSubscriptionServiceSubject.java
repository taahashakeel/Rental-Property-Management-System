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
	private ArrayList<Property> newProperty;

	public ConcreteSubscriptionServiceSubject() {
		dbControl = new DatabaseController();
		subscribers = new ArrayList<SearchObserver>();
		newProperty = new ArrayList<Property>();
	}

	public void registerSubscribedObserver(SearchObserver subscriber) {
		subscribers.add(subscriber);
		subscribers.update(newProperty);
	}

	public void removeSubscribedObserver(SearchObserver subscriber) {
		subscribers.remove(subscriber);
	}

	public void notifyAllSubscribedObservers() {
		for (int i = 0; i < subscribers.size(); i++) {
			SearchObserver subscribers = subscribers.get(i);
			subscribers.update(newProperty);
		}
	}

	public void addProperty(Property p) {
		newProperty.add(p);
		notifyAllSubscribedObservers();
	}
}
