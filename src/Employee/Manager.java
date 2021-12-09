package Employee;

import java.util.ArrayList;
//FeeController?
import BackEnd.DatabaseController;
public class Manager {

	private String username;
	private String password;
	private FeeController feeControl;
	private DatabaseController dbControl;
	private ArrayList <Property> arrayProperty = new ArrayList<Property>();
	public Manager() 
	{
		
	}
	public Manager (String username, String password)
	{
		this.username=username;
		this.password=password;
	} 
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setUsername(String username) 
	{
		this.username=username;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	} 

	public ArrayList<Property> getSummary()
	{
		
		return arrayProperty;
		
	}
	//<---->//
	public boolean changeState(int StringID, String state)
 
	{
		return dbControl.changePropertyState(propertyID, state);
	
	}
	
}
