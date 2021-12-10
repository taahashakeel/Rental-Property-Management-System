/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.1 Added documentation
 *  @since 1.0
 *  
 * Services impliments the Observer Design Pattern and represents the Subject 
 * interface that is implimented by the ConcreteSubscriptionServerSubject.
 * 
 * The class contains abstract methods that the ConcreteSubscriptionServerSubject
 * must define and contain. Functions include the ability to register an observer, 
 * remove an observer, and notify all the observers of a change to the data.
 */
 */

package Services;

import java.io.*;
import java.util.*;

public interface SubscriptionServiceSubject {
	public void registerSubscribedObserver(SubscribedObserver subscriber);

	public void removeSubscribedObserver(SubscribedObserver subscriber);

	public void notifyAllSubscribedObservers();

}
