package Employee;

import java.util.ArrayList;
import BackEnd.DatabaseController;
/**
 * A class that represents a property
 * @author Alexander
 *
 */
public class Property {

	private String propertyID;
	private String status;
	private String houseType;
	private int numBedrooms;
	private int numBathrooms;
	private int ifFurnished;
	private String quadrant;
	private int rentCost;
	private int propertyFee;
	private int feePaid;
	private int feePeriod;
	private int budget;
	private String address; 
	private String dateListed;
	private String dateRented;
	//private String landlordEmail;
	private String landlordID;
	 private ArrayList<Property> newProperty;
	
	private DatabaseController dbControl;
	/**
	 * default constructor
	 */
	public Property(){} 
	/**
	 * getter for property ID
	 * @return propertyID
	 */
	public String getPropertyID()
	{
		return propertyID;
	}
	/**
	 * getter for status
	 * @return status
	 */
	public String getStatus()
	{
		return status;
	}
	/**
	 * getter for house type
	 * @return houseType
	 */
	public String getHouseType()
	{
		return houseType;
	}
	/**
	 * getter for number of Bedrooms
	 * @return
	 */
	public int getNumBedrooms()
	{
		return numBedrooms;
	}
	/**
	 * getter for number of bedrooms
	 * @return
	 */
	public int getNumBathrooms() 
	{
		return numBathrooms;
	}
	/**
	 * getter for ifFurnished
	 * @return ifFurnished
	 */
	public int getIfFurnished()
	{
		return ifFurnished;
	}
	/**
	 * getter for quadrant
	 * @return quadrant
	 */
	public String getQuadrant() 
	{
		return quadrant;
	}
	/**
	 * getter for rentCost
	 * @return rentCost
	 */
	public int getRentCost() 
	{
		return rentCost;
	}
	/**
	 * getter for propertyFee
	 * @return
	 */
	public int getPropertyFee()
	{
		return propertyFee;
	}
	/**
	 * getter for fee paid
	 * @return
	 */
	public int getFeePaid()
	{
		return feePaid;
	}
	/**
	 * getter for landlordID
	 * @return landlordID
	 */
	public String getLandlordID()
	{
		return landlordID;
	}
	/**
	 * getter for budget
	 * @return
	 */
	public int getBudget()
	{
		return budget;
	}
	/**
	 * getter for address
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}
	/**
	 * setter for propertyID
	 * @param string
	 */
	public void setPropertyID(String string) 
	{
		this.propertyID = string;
	}
	/**
	 * setter for status
	 * @param status
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
	/**
	 * setter for houseType
	 * @param houseType
	 */
	public void setHouseType(String houseType) 
	{
		this.houseType = houseType;
	}
	/**
	 * setter for number of bedrooms
	 * @param numBedrooms
	 */
	public void setNumBedrooms(int numBedrooms)
	{
		this.numBedrooms = numBedrooms;
	}
	/**
	 * setter for number of bathrooms
	 * @param numBathrooms
	 */
	public void setNumBathrooms(int numBathrooms)
	{
		this.numBathrooms = numBathrooms;
	}
	/**
	 * setter for ifFurnished
	 * @param i
	 */
	public void setIfFurnished (int i)
	{		
		this.ifFurnished = i;
		
	}
	/**
	 * setter for quadrant
	 * @param quadrant
	 */
	public void setQuadrant(String quadrant) 
	{
		this.quadrant = quadrant;
	}
	/**
	 * setter for rentCost
	 * @param rentCost
	 */
	public void  setRentCost(int rentCost ) 
	{
		this.rentCost = rentCost;
	}
	/**
	 * setter for property fee
	 * @param propertyFee
	 */
	public void setPropertyFee(int propertyFee) 
	{
		this.propertyFee = propertyFee;
	}
	/**
	 * setter for FeePaid
	 * @param i, 0 or 1
	 */
	public void setFeePaid(int i)
	{
		this.feePaid = i;
	}
	/**
	 * setter for LandlordID
	 * @param string
	 */
	public void setLandlordID(String string) 
	{
		this.landlordID = string;
	}
	/**
	 * setter for budget
	 * @param budget
	 */
	public void setBudget(int budget)
	{
		this.budget = budget;
	}
	
	/**
	 * creates a property
	 */
	public void createProperty()
	{
		newProperty = new ArrayList<Property>();
	}
	/**
	 * 
	 * @param propertyID
	 * @param date
	 * @return
	 */
	public boolean registerProperty(int propertyID, String date)
	{
		return this.dbControl.saveNewProperty(this);

	}
	/**
	 * setter for address
	 * @param string
	 */
	public void setAddress(String string) {
		this.address = string;
		
	}
	/**
	 * getter for fee period
	 * @return feePeriod
	 */
	public int getFeePeriod() {
		return this.feePeriod;
	}
	/**
	 * setter for feePeriod
	 * @param i
	 */
	public void setFeePeriod(int i) {
		// TODO Auto-generated method stub
		this.feePeriod = i;
	}
	/**
	 * getter for date rented
	 * @return dateRented
	 */
	public String getDateRented() {
		return dateRented;
	}
	/**
	 * setter for date rented
	 * @param dateRented
	 */
	public void setDateRented(String dateRented) {
		this.dateRented = dateRented;
	}
	/**
	 * getter for DateListed
	 * @return datelisted
	 */
	public String getDateListed() {
		return dateListed;
	}
	/**
	 * setter for DateListed
	 * @param dateListed
	 */
	public void setDateListed(String dateListed) {
		this.dateListed = dateListed;
	}
	
	
	
}
