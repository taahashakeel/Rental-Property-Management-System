package Renter;

import Employee.ConcreteSubscriptionServiceSubject;

public class RegisteredRenter {
	
		private String username; 
		private String password; 
		private boolean isSubscribed;
		//private String email;
		private SearchCriteria search;
		private EmailSystem email;
		private DatabaseController dbControl;
		private String RRID;
		
		public RegisteredRenter()
		{
			
		}

		public RegisteredRenter(String username, String password)
		{
			
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
		////

		public void createSearchCriteria()
		{
			SearchCriteria search = new SearchCriteria();
		}
		//<---->//
		public void saveSearchCriteria()
		{
			search.saveToDatabase();
			
			ConcreteSubscriptionServiceSubject

		}
		//<---->//
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
				if(newProperty.getIfFurnished()  != search.getIfFurnished()
				{
					return false;
				}
				
				if(newProperty.getQuadrant() != search.getQuadrant())
				{
					return false;
				}
				

				if(newProperty.getbudget() != search.getbudget())
				{
					return false;
				}
				
				return true;
		
			
		}
		////
		public void update(Property newProperty)
		{
			if (this.isSubscribed == true && isMatch(newProperty) == true)
				sendEmail(email, newProperty.getLandlordEmail(), newProperty);
		}
}
