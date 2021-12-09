/**
 * @author Taaha
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.2 added some documentation and added to create property
 *  @since 1.0
 *  
 *  
 */
package Employee;

import java.util.ArrayList;

public class Landlord {

	private String username;
	private String password;
	private ArrayList<Property> newProperty;
	private DatabaseController dbControl;
	private EmailSystem email;
	private String LLID;
	private ConcreteSubscriptionServiceSubject subscribed;

	public Landlord(String username, String password) {
		this.username = username;
		this.password = password;
		this.subscribed = ConcreteSubscriptionServiceSubject.getOnlyInstance();
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//<---->//
	public void changeState(int propertyID) {

	}

//<---->//
	// Could we make them pay a fee first before creating a property???
	public int payFee(int propertyID) {

	}

	////
	/**
	 * Landlord creates a a new property. The landlord is prompted to pay 
	 * a free, if the fee is payed, the property is listed for renters to view.
	 * For those that are subscribed, they will be notified if the property 
	 * matches their search criteria
	 */
	public void createProperty()
	{
		Property newProperty = new Property()
		newProperty = new ArrayList<Property>();
		dbControl.saveNewProperty(newProperty);
		subscribed.add(newProperty); // notifies subscribed renters
	}

}
