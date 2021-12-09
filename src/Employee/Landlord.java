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
import BackEnd.EmailSystem;
import Services.ConcreteSubscriptionServiceSubject;
public class Landlord {

	private String username;
	private String password;
	private ArrayList<Property> newProperty;
	private DatabaseController dbControl;
	private EmailSystem email;
	private String landlordEmail;
	private String LLID;
	private ConcreteSubscriptionServiceSubject subscribed;

	public Landlord(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.landlordEmail = email;
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
	/**
	 * Generates grid bag constraints with provided values.
	 *
	 * @param propertyID Property id representing the property being changed
	 * @param state The new state of the property
	 * 
	 * @return If state change was successful
	 */
	public boolean changeState(String propertyID, String state) {
		return dbControl.changePropertyState(propertyID, state);

	}

//<---->//
	// Could we make them pay a fee first before creating a property???
	public int payFee(int propertyID) {

	}


	/**
	 * Landlord creates a a new property. The landlord is prompted to pay 
	 * a free, if the fee is payed, the property is listed for renters to view.
	 * For those that are subscribed, they will be notified if the property 
	 * matches their search criteria
	 */
	public void createProperty(Property newProperty)
	{
		dbControl.saveNewProperty(newProperty);
		subscribed.add(newProperty); // notifies subscribed renters
	}

}
