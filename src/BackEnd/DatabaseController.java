package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import Employee.Landlord;
import Employee.Manager;
import Employee.Property;
import Renter.RegisteredRenter;
import Services.SearchCriteria;
/**
 * This class is used to interact with the MySQL database
 * @author Alexander
 *
 */
public class DatabaseController {

	public String DBURL = "jdbc:mysql://localhost/rental"; //store the database url information
    public String USERNAME = "root"; //store the user's account username
    public String PASSWORD = "hellothere"; //store the user's account password
    
    private Connection dbConnect;
    
    public DatabaseController() {};
    
    /**
     * Constructor
     * @param DUBRL
     * @param USERNAME
     * @param PASSWORD
     */
    public DatabaseController(String DUBRL, String USERNAME, String PASSWORD){
    	this.DBURL = DUBRL;
    	this.USERNAME = USERNAME;
    	this.PASSWORD = PASSWORD;
    }
    
    /**
     * gets the database url
     * @return DBURL
     */
    public String getDUBRL() {
    	return this.DBURL;
    }
    
    /**
     * gets the username
     * @return USERNAME
     */
    public String getUSERNAME() {
    	return this.USERNAME;
    }
    
    /**
     * gets the password
     * @return PASSWORD
     */
    public String getPASSWORD() {
    	return this.PASSWORD;
    }
    
    /**
     * This method establishes a connect to the specified database. 
     */
    public void dbConnect() {
    	
    	try {
    		dbConnect = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
    		System.out.println("Connection Initialized");
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
    }
    
    /**
     * gets all active properties from the database
     * @return an array list of active properties
     */
    public ArrayList<Property> fetchActiveProperty(){
		
		ArrayList<Property> active = new ArrayList<Property>();		//the list of propertys to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "property"); //selects all data from the table chair
    		
    		while(result.next()) {	
    			if(result.getString("Status").equals("Active")) {	//selects only the type of property requested
    				
    				Property temp = new Property();
    				temp.setPropertyID(result.getString("PID"));
    				temp.setStatus(result.getString("Status"));
    				temp.setHouseType(result.getString("HouseType"));
    				temp.setAddress(result.getString("Address"));
    				temp.setNumBedrooms(result.getInt("BedroomNumber"));
    				temp.setNumBathrooms(result.getInt("BathroomNumber"));
    				temp.setIfFurnished(result.getInt("Furnished"));
    				temp.setQuadrant(result.getString("Quadrant"));
    				temp.setRentCost(result.getInt("RentCost"));
    				temp.setPropertyFee(result.getInt("Fee"));
    				temp.setFeePaid(result.getInt("FeePaid"));
    				temp.setLandlordID(result.getString("LLID"));
    				
    				active.add(temp);	//adds the active property to the list
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return active;
	}
    
    /**
     * Returns all properties in the db
     * @return an arraylist of property
     */
    public ArrayList<Property> fetchAllProperty(){
		
		ArrayList<Property> all = new ArrayList<Property>();		//the list of propertys to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "property"); //selects all data from the table property
    		
    		while(result.next()) {	
				
				Property temp = new Property();
				temp.setPropertyID(result.getString("PID"));
				temp.setStatus(result.getString("Status"));
				temp.setHouseType(result.getString("HouseType"));
				temp.setNumBedrooms(result.getInt("BedroomNumber"));
				temp.setNumBathrooms(result.getInt("BathroomNumber"));
				temp.setIfFurnished(result.getInt("Furnished"));
				temp.setQuadrant(result.getString("Quadrant"));
				temp.setRentCost(result.getInt("RentCost"));
				temp.setPropertyFee(result.getInt("Fee"));
				temp.setFeePaid(result.getInt("FeePaid"));
				temp.setLandlordID(result.getString("LLID"));
				temp.setAddress(result.getString("Address"));
				
				all.add(temp);	//adds the active property to the list
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return all;
	}
    
    /**
     * Returns all the properties beloning to a landlord with LLID
     * @param LLID the landlord id
     * @return an arrarylist of property
     */
    public ArrayList<Property> fetchLandlordProperties(String LLID){
		
		ArrayList<Property> properties = new ArrayList<Property>();		//the list of propertys to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "property"); //selects all data from the table chair
    		
    		while(result.next()) {	
    			if(result.getString("LLID").equals(LLID)) {	//selects only the type of property requested
    				
    				Property temp = new Property();
    				temp.setPropertyID(result.getString("PID"));
    				temp.setStatus(result.getString("Status"));
    				temp.setHouseType(result.getString("HouseType"));
    				temp.setNumBedrooms(result.getInt("BedroomNumber"));
    				temp.setNumBathrooms(result.getInt("BathroomNumber"));
    				temp.setIfFurnished(result.getInt("Furnished"));
    				temp.setQuadrant(result.getString("Quadrant"));
    				temp.setRentCost(result.getInt("RentCost"));
    				temp.setPropertyFee(result.getInt("Fee"));
    				temp.setFeePaid(result.getInt("FeePaid"));
    				temp.setLandlordID(result.getString("LLID"));
    				temp.setAddress(result.getString("Address"));
    				
    				properties.add(temp);	//adds the active property to the list
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return properties;
	}
    
    /**
     * returns an array list of rented properties
     * @return 
     */
    public ArrayList<Property> fetchHouseRentedData(){
		
		ArrayList<Property> properties = new ArrayList<Property>();		//the list of propertys to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "property"); //selects all data from the table chair
    		
    		while(result.next()) {	
    			if(result.getString("Status").equals("Rented")) {	//selects only the type of property requested
    				
    				Property temp = new Property();
    				temp.setPropertyID(result.getString("PID"));
    				temp.setStatus(result.getString("Status"));
    				temp.setHouseType(result.getString("HouseType"));
    				temp.setNumBedrooms(result.getInt("BedroomNumber"));
    				temp.setNumBathrooms(result.getInt("BathroomNumber"));
    				temp.setIfFurnished(result.getInt("Furnished"));
    				temp.setQuadrant(result.getString("Quadrant"));
    				temp.setRentCost(result.getInt("RentCost"));
    				temp.setPropertyFee(result.getInt("Fee"));
    				temp.setFeePaid(result.getInt("FeePaid"));
    				temp.setLandlordID(result.getString("LLID"));
    				temp.setAddress(result.getString("Address"));
    				
    				properties.add(temp);	//adds the active property to the list
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return properties;
	}
    /**
     * gets the number of rented houses
     * @return int house rented
     */
    public int fetchHouseRentedNum(){
    	return fetchHouseRentedData().size();
    }
    
    /**
     * Gets all active properties
     * @return ArrayList of property.
     */
    public ArrayList<Property> fetchHouseListingData(){
		
		ArrayList<Property> properties = new ArrayList<Property>();		//the list of propertys to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "property"); //selects all data from the table chair
    		
    		while(result.next()) {	
    			if(result.getString("Status").equals("Active")) {	//selects only the type of property requested
    				
    				Property temp = new Property();
    				temp.setPropertyID(result.getString("PID"));
    				temp.setStatus(result.getString("Status"));
    				temp.setHouseType(result.getString("HouseType"));
    				temp.setNumBedrooms(result.getInt("BedroomNumber"));
    				temp.setNumBathrooms(result.getInt("BathroomNumber"));
    				temp.setIfFurnished(result.getInt("Furnished"));
    				temp.setQuadrant(result.getString("Quadrant"));
    				temp.setRentCost(result.getInt("RentCost"));
    				temp.setPropertyFee(result.getInt("Fee"));
    				temp.setFeePaid(result.getInt("FeePaid"));
    				temp.setLandlordID(result.getString("LLID"));
    				temp.setAddress(result.getString("Address"));
    				
    				properties.add(temp);	//adds the active property to the list
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return properties;
	}
    
    /**
     * returns all landlords in db
     * @return an arraylist of landlords
     */
    public ArrayList<Landlord> fetchLandlords(){
		
		ArrayList<Landlord> all = new ArrayList<Landlord>();		//the list of propertys to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "landlord"); //selects all data from the table property
    		
    		while(result.next()) {	
				
				Landlord temp = new Landlord();
				temp.setUsername(result.getString("Username"));
				temp.setPassword(result.getString("Password"));
				temp.setLLID(result.getString("LLID"));
				all.add(temp);	//adds the active property to the list
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
		
		for(int i = 0; i<all.size(); i++) {
			Landlord edit = all.get(i);
			edit.setProperties(fetchLandlordProperties(edit.getLLID()));
			all.add(i,edit);
		}

		return all;
	}
    
    /**
     * returns all registeredrenters in the db
     * @return registered renter arraylist.
     */
    public ArrayList<RegisteredRenter> fetchRegisteredRenters(){ //incomplete
		
		ArrayList<RegisteredRenter> all = new ArrayList<RegisteredRenter>();		//the list of propertys to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "registeredrenters"); //selects all data from the table property
    		
    		while(result.next()) {	
				
				RegisteredRenter temp = new RegisteredRenter();
				temp.setUsername(result.getString("Username"));
				temp.setPassword(result.getString("Password"));
				temp.setRRID(result.getString("RRID"));
				temp.setEmail(result.getString("Email"));
				temp.setIsSubscribed(result.getInt("Subscribed"));
				
				all.add(temp);
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return all;
	}
    
    /**
     * Checks userlogin credentials
     * @param <T> the type of user that logs in, null if login fails
     * @param username
     * @param password
     * @param type, what type of account
     * @return an object of type T that corresponds to a login type
     */
    public <T> Object checkUserLogin(String username, String password, String type) {
    		
    	try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + type); //selects all data from the table chair
    		
    		while(result.next()) {	
    			if(result.getString("Username").equals(username) && result.getString("Password").equals(password)) {
    				if(type.equals("manager")) {
    		    		Manager temp = new Manager();
    		    		temp.setUsername(result.getString("Username"));
    		    		temp.setPassword(result.getString("Password"));
    		    		state.close();
    		    		temp.setArrayProperty(fetchAllProperty());
    		    		return temp;
    		    	}
    		    	else if(type.equals("landlord")) {
    		    		Landlord temp = new Landlord();
    		    		temp.setUsername(result.getString("Username"));
    		    		temp.setPassword(result.getString("Password"));
    		    		temp.setLLID(result.getString("LLID"));
    		    		state.close();
    		    		temp.setProperties(fetchLandlordProperties(result.getString("LLID")));
    		    		return temp;
    		    	}
    		    	else if(type.equals("registeredrenter")) {
    		    		RegisteredRenter temp = new RegisteredRenter();
    		    		temp.setUsername(result.getString("Username"));
    		    		temp.setPassword(result.getString("Password"));
    		    		temp.setRRID(result.getString("RRID"));
    		    		state.close();
    		    		return temp;
    		    	}
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return null;
    }	
    
    /**
     * adds a subscription to the database
     * @param RRID the renter that subs
     * @param sub the searchCriteria the renter wants
     */
    public void saveSearchCriteria(String RRID, SearchCriteria sub){
    	
		try {
			String query = "INSERT INTO subscription (HouseType,BedroomNumber,BathroomNumber,Furnished,Quadrant,Budget,SID,RRID) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement state = dbConnect.prepareStatement(query);
		
			state.setString(1, sub.getHouseType());
			state.setInt(2, sub.getNumBedrooms());
			state.setInt(3, sub.getNumBedrooms());
			state.setInt(4, sub.getIfFurnished());
			state.setString(5, sub.getQuadrant());
			state.setInt(6, sub.getBudget());
			state.setString(7, "S0003"); //this should change, to give a unique id each time if nessesary. If we are doing 1 sub per renter we dont need this
			state.setString(8, RRID);
		
			state.executeUpdate();
			state.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
    	
    }
    
    /**
     * add a new property to the db
     * @param property the property to be added
     * @return true or false
     */
    public boolean saveNewProperty(Property property){
    	
    	int length = fetchAllProperty().size() + 1;
    	
    	String number = String.valueOf(length);
    	
    	String id = "P000" + number;
    	
		try {
			String query = "INSERT INTO PROPERTY (Status,HouseType,Address,BedroomNumber,BathroomNumber,Furnished,Quadrant,RentCost,Fee,FeePaid,FeePeriod,PID,LLID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement state = dbConnect.prepareStatement(query);
		
			state.setString(1, property.getStatus());
			state.setString(2, property.getHouseType());
			state.setString(3, property.getAddress());
			state.setInt(4, property.getNumBedrooms());
			state.setInt(5, property.getNumBathrooms());
			state.setInt(6, property.getIfFurnished());
			state.setString(7, property.getQuadrant());
			state.setInt(8, property.getRentCost());
			state.setInt(9, property.getPropertyFee());
			state.setInt(10, property.getFeePaid());
			state.setInt(11, property.getFeePeriod());
			state.setString(12, id);  //set a property id better
			state.setString(13, property.getLandlordID());
		
			state.executeUpdate();
			state.close();
			return true;
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
    	
    }
    /**
     * change the state of a property
     * @param PID the property id
     * @param state the satate to change the property to
     * @return true or false
     */
    public boolean changePropertyState(String PID, String state){
		
		try {
    		Statement state1 = dbConnect.createStatement();
    		state1.executeUpdate("UPDATE property SET Status='"+ state +"'WHERE PID = '" + PID +"'");  		
    		state1.close();
    		return true;
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return false;
	}
    
    /**
     * returns active properties that match the specifed constraints
     * @param houseType
     * @param bedrooms
     * @param bathrooms
     * @param furnished
     * @param quadrant
     * @param budget
     * @return a list of properties matching the thing.
     */
    public ArrayList<Property> fetchActiveProperty(String houseType,int bedrooms,int bathrooms,int furnished,String quadrant, int budget){
    	return null; //finish this guy
    }
    
}
