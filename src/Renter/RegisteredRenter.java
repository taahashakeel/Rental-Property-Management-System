package Renter;

import Services.ConcreteSubscriptionServiceSubject;
import Services.SearchCriteria;
import BackEnd.EmailSystem;
import BackEnd.DatabaseController;
import Employee.Property;

/**
 * A class representing a registered renter
 * @author Alexander
 *
 */
public class RegisteredRenter {
	
		private String username; 
		private String password; 
		private int isSubscribed;
		private String email;
		private SearchCriteria search;
		private EmailSystem emailSystem;
		private DatabaseController dbControl;
		private String RRID;
		/**
		 * default constructor
		 */
		public RegisteredRenter()
		{
			
		}
		/**
		 * Constructor
		 * @param username
		 * @param password
		 */
		public RegisteredRenter(String username, String password)
		{
			this.username = username;
			this.password = password;
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
			 this.password=password;
		 } 
		////
		 /**
		  * creates a search cirteria
		  */
		public void createSearchCriteria()
		{
			SearchCriteria search = new SearchCriteria();
		}
		/**
		 * saves a search criteria
		 */
		public void saveSearchCriteria()
		{
			//this needs to be defined
		}
		/**
		 * checks if property is a match
		 * @param newProperty
		 * @return
		 */
		public boolean isMatch(Property newProperty)
		{
			if(newProperty.getHouseType() != search.getHouseType())
				{
					return false;
				}
			
			if(newProperty.getNumBedrooms() != search.getNumBedrooms())
			{
				return false;
			}
			if(newProperty.getNumBathrooms() != search.getNumBathrooms())
			{
				return false;
			}
			if(newProperty.getIfFurnished()  != search.getIfFurnished())
			{
				return false;
			}
			
			if(newProperty.getQuadrant() != search.getQuadrant())
			{
				return false;
			}
			

			if(newProperty.getBudget() != search.getBudget())
			{
				return false;
			}
			
			return true;
		}
		/**
		 * 
		 * @param newProperty
		 */
		public void update(Property newProperty)
		{
			if (this.isSubscribed == 1 && isMatch(newProperty) == true)
				emailSystem.sendEmail(email, email, newProperty.getLandlordID(), newProperty.getPropertyID());
		}

		public void setRRID(String string) {
			this.RRID = string;
			
		}

		public void setEmail(String string) {
			this.email = string;
		}

		public void setIsSubscribed(int int1) {
			// TODO Auto-generated method stub
			this.isSubscribed = int1;
		}
}
