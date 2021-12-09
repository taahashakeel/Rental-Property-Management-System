/**
 * @author Taaha
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.2 added some documentation and finished subscribeToSearch
 *  @since 1.0
 *  
 *  
 */

package Renter;

import Services.ConcreteSubscriptionServiceSubject;
import Services.SubscribedObserver;

public class RegisteredRenter
impliments SubscribedObserver{
	// Observer pattern implimentation
	private ConcreteSubscriptionServiceSubject renterSubject;
	private String username;
	private String password;
	private boolean isSubscribed;
	private String renterEmail;
	private SearchCriteria search;
	private EmailSystem email;
	private DatabaseController dbControl;
	private String RRID;

	public RegisteredRenter(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.dbControl = new DataDatabaseController();
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

	public void createSearchCriteria() {
		SearchCriteria search = new SearchCriteria();
	}

	/**
   * Subscribes a registered renter to a specific search criteria.
   *
   * @param RRID Renter ID needed to be passed to the dbControl function
   * @param search search criteria object to be saved to the database
   *
   */
	public void subscribeToSearch(String RRID, SearchCriteria search)
	{
		dbControl.saveSearchCriteria(RRID: String, search: SearchCriteria): bool
		renterSubject.registerSubscribedObserver(this);
	}

	/**
	   * Checks if the newProperty added to the database matches the registered
	   * renters search criteria. If there is a match, the update will continute
	   * and send an email to the registered renter. 
	   *
	   * @param 	newProperty the new property that was added to the database by a 
	   * 			landlord.
	   *
	   * @return 	a boolean representing if an update email should be sent to the
	   * 			registered renter.
	   */
	public boolean isMatch(Property newProperty)
		{
			if(newProperty.getHouseType() != search.getHouseType())
				return false;
		
			if(newProperty.getNumBedrooms() != search.getNumBedrooms())
				return false;
			
			if(newProperty.getNumBathrooms() != search.getNumBathrooms())
				return false;
			
			if(newProperty.getIfFurnished()  != search.getIfFurnished()
				return false;
		
			if(newProperty.getQuadrant() != search.getQuadrant())
				return false;

			if(newProperty.getbudget() != search.getbudget())
				return false;
			
			return true;
		}

	public void update(Property newProperty) {
		if (this.isSubscribed == true && isMatch(newProperty) == true)
			email.sendEmail(email, newProperty.getLandlordEmail(), newProperty);
	}

}
