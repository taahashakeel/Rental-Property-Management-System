import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseController {

	public final String DBURL; //store the database url information
    public final String USERNAME; //store the user's account username
    public final String PASSWORD; //store the user's account password
    
    private Connection dbConnect;
    
    DatabaseController(String DUBRL, String USERNAME, String PASSWORD){
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
    				temp.sethouseType(result.getString("HouseType"));
    				temp.setNumBedrooms(result.getInt("BedroomNumber"));
    				temp.setNumBathrooms(result.getInt("BathroomNumber"));
    				temp.setIfFurnished(result.getInt("Furnished"));
    				temp.setQuardrant(result.getString("Quadrant"));
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
     * 
     * @return
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
				temp.sethouseType(result.getString("HouseType"));
				temp.setNumBedrooms(result.getInt("BedroomNumber"));
				temp.setNumBathrooms(result.getInt("BathroomNumber"));
				temp.setIfFurnished(result.getInt("Furnished"));
				temp.setQuardrant(result.getString("Quadrant"));
				temp.setRentCost(result.getInt("RentCost"));
				temp.setPropertyFee(result.getInt("Fee"));
				temp.setFeePaid(result.getInt("FeePaid"));
				temp.setLandlordID(result.getString("LLID"));
				
				all.add(temp);	//adds the active property to the list
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return all;
	}
    
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
    				temp.sethouseType(result.getString("HouseType"));
    				temp.setNumBedrooms(result.getInt("BedroomNumber"));
    				temp.setNumBathrooms(result.getInt("BathroomNumber"));
    				temp.setIfFurnished(result.getInt("Furnished"));
    				temp.setQuardrant(result.getString("Quadrant"));
    				temp.setRentCost(result.getInt("RentCost"));
    				temp.setPropertyFee(result.getInt("Fee"));
    				temp.setFeePaid(result.getInt("FeePaid"));
    				temp.setLandlordID(result.getString("LLID"));
    				
    				properties.add(temp);	//adds the active property to the list
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return properties;
	}
    
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
    				temp.sethouseType(result.getString("HouseType"));
    				temp.setNumBedrooms(result.getInt("BedroomNumber"));
    				temp.setNumBathrooms(result.getInt("BathroomNumber"));
    				temp.setIfFurnished(result.getInt("Furnished"));
    				temp.setQuardrant(result.getString("Quadrant"));
    				temp.setRentCost(result.getInt("RentCost"));
    				temp.setPropertyFee(result.getInt("Fee"));
    				temp.setFeePaid(result.getInt("FeePaid"));
    				temp.setLandlordID(result.getString("LLID"));
    				
    				properties.add(temp);	//adds the active property to the list
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return properties;
	}
    
    public ArrayList<Property> fetchHouseRentedNum(){
    	return fetchHouseRentedData().size();
    }
    
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
    				temp.sethouseType(result.getString("HouseType"));
    				temp.setNumBedrooms(result.getInt("BedroomNumber"));
    				temp.setNumBathrooms(result.getInt("BathroomNumber"));
    				temp.setIfFurnished(result.getInt("Furnished"));
    				temp.setQuardrant(result.getString("Quadrant"));
    				temp.setRentCost(result.getInt("RentCost"));
    				temp.setPropertyFee(result.getInt("Fee"));
    				temp.setFeePaid(result.getInt("FeePaid"));
    				temp.setLandlordID(result.getString("LLID"));
    				
    				properties.add(temp);	//adds the active property to the list
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return properties;
	}
    
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
			edit.setProperties(fetchLandlordProperties(edit.LLID));
			all.add(i,edit);
		}

		return all;
	}
    
    public ArrayList<RegisteredRenter> fetchRegisteredRenters(){ //incomplete
		
		ArrayList<RegisteredRenter> all = new ArrayList<RegisteredRenter>();		//the list of propertys to be returned
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "landlord"); //selects all data from the table property
    		
    		while(result.next()) {	
				
				RegisteredRenter temp = new RegisteredRenter();
				temp.setUsername(result.getString("Username"));
				temp.setPassword(result.getString("Password"));
				temp.setRRID(result.getString("RRID"));
				temp.setEmail(result.getString("Email"));
				temp.setIsSubscribed(result.getInt("Subscribed"));
				
				all.add(temp);	//adds the active property to the list
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return all;
	}
   
  
    
}
