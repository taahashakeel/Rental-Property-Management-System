package Employee;

import java.util.ArrayList;
//FeeController?
import BackEnd.DatabaseController;

/**
 * A class the represents a manager
 * @author Alexander
 *
 */
public class Manager {

	private String username;
	private String password;
	private DatabaseController dbControl;
	private ArrayList <Property> arrayProperty = new ArrayList<Property>();
	/**
	 * Default constructor
	 */
	public Manager() 
	{
		
	}
	/**
	 * Constructor
	 * @param username
	 * @param password
	 */
	public Manager (String username, String password)
	{
		this.username=username;
		this.password=password;
	} 
	/**
	 * getter for username
	 * @return username
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * getter for password
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
		this.password = password;
	} 
	/**
	 * Returns a summary
	 * @return an array list of all properties
	 */
	public ArrayList<Property> getSummary()
	{
		return dbControl.fetchAllProperty();
	}
	/**
	 * Setter for property array
	 * @param list
	 */
	public void setArrayProperty(ArrayList<Property> list) {
		this.arrayProperty = list;
	}
	/**
	 * Changes the state of a property
	 * @param propertyID
	 */
	public void changeState(String propertyID, String state) 
	{
		dbControl.changePropertyState(propertyID, state);
	}
	
}
