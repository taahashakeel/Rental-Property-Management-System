/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.0
 *  @since 1.0
 */
package Services;

import Employee.Property;

public interface SubscribedObserver {
	public void update(Property newProperty);
}
