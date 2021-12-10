/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.1 Added documentation
 *  @since 1.0
 *  
 * Services impliments the Observer Design Pattern and represents the Subject 
 * interface that is implimented by the ConcreteSubscriptionServer Subject
 * This element briefly summarizes information on the property, including:
 * - city quadrant
 * - housing type
 * - furnish state
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
