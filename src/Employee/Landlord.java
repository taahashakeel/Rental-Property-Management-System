package Employee;

import java.util.ArrayList;

public class Landlord {

 private String username; 
 private String password; 
 //private Property [] properties;
 private ArrayList<Property> newProperty;
 private DatabaseController dbControl;
 private EmailSystem email;
 private String LLID;

 
 ConcreteSubscriptionServiceSubject subscribed;


 public Landlord() 
 {
	 

 }

 public Landlord(String username, String password)
 {
	 	this.username = username;
		this.password = password;
		this.subscribed = ConcreteSubscriptionServiceSubject.getOnlyInstance();
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
	 this.password=password;
 } 
//<---->//
 public void changeState(int propertyID)
 {
	 
 } 
//<---->//
public int payFee(int propertyID)
{
	
} 
////
public void createProperty()
{
	newProperty = new ArrayList<Property>();
}
 
	
}
