package Employee;

import java.util.ArrayList;

import BackEnd.DatabaseController;
import BackEnd.EmailSystem;
import Services.ConcreteSubscriptionServiceSubject;
/**
 * A class that represents a landlord
 * @author Alexander
 *
 */
public class Landlord {

	 private String username; 
	 private String password; 
	 private ArrayList<Property> properties;
	 private ArrayList<Property> newProperty;
	 private DatabaseController dbControl;
	 private EmailSystem email;
	 private String LLID;
	
	 
	 ConcreteSubscriptionServiceSubject subscribed;

	/**
	 * default constructor
	 */
	 public Landlord() 
	 {
		
	 }
	 
	 /**
	  * Constructor
	  * @param username
	  * @param password
	  */
	 public Landlord(String username, String password)
	 {
		 	this.username = username;
			this.password = password;
			this.subscribed = ConcreteSubscriptionServiceSubject.getOnlyInstance();
	 }
	/**
	 * Getter for username
	 * @return username
	 */
	 public String getUsername() 
	 {
		 return username;
	 }
	/**
	 * getter for pasword
	 * @return password
	 */
	 public String getPassword() 
	 {
		 return password;
	 } 
	 /**
	  * setter for username
	  * @param username
	  */
	 public void setUsername(String username) 
	 {
		 this.username=username;
	 } 
	/**
	 * setter for password
	 * @param password
	 */
	 public void setPassword(String password)
	 {
		 this.password=password;
	 } 
	//<---->//
	 /**
	  * Changes the state of a property
	  * @param propertyID
	  */
	 public void changeState(String propertyID)
	 {
		 dbControl.changePropertyState(LLID, propertyID);
	 } 
	/**
	 * Pays the fee
	 * @param propertyID
	 * @return true (1) or false (0)
	 */
	public int payFee(int propertyID)
	{
		return 0;	//not right 
	} 
	/**
	 * create a new property
	 */
	public void createProperty()
	{
		newProperty = new ArrayList<Property>();
	}
	/**
	 * setter for LLID
	 * @param string
	 */
	public void setLLID(String string) {
		this.LLID = string;
		// TODO Auto-generated method stub
	}
	/**
	 * getter for LLID
	 * @return LLID
	 */
	public String getLLID() {
		// TODO Auto-generated method stub
		return this.LLID;
	}
	/**
	 * setter for landlord properties
	 * @param fetchLandlordProperties
	 */
	public void setProperties(ArrayList<Property> fetchLandlordProperties) {
		this.properties = dbControl.fetchLandlordProperties(LLID);
	}
 
	
}
