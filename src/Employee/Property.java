package Employee;

import java.util.ArrayList;
// import BackEnd.DatabaseController;

public class Property {

	private String propertyID;
	private String status;
	private String houseType;
	private int numBedrooms;
	private int numBathrooms;
	private boolean ifFurnished;
	private String quadrant;
	private int rentCost;
	private int propertyFee;
	private boolean feePaid;
	private int budget;
	private String landlordEmail;
	private String address; 
	private int landlordID;

//	private DatabaseController dbControl;

	public Property() {
	}

	public String getPropertyID() {
		return propertyID;
	}

	public String getStatus() {
		return status;
	}

	public String getHouseType() {
		return houseType;
	}

	public int getNumBedrooms() {
		return numBedrooms;
	}

	public int getNumBathrooms() {
		return numBathrooms;
	}

	public boolean getIfFurnished() {
		return ifFurnished;
	}

	public String getQuadrant() {
		return quadrant;
	}

	public int getRentCost() {
		return rentCost;
	}

	public int getPropertyFee() {
		return propertyFee;
	}

	public boolean getFeePaid() {
		return feePaid;
	}

	public int getLandlordID()
	{
		return landlordID;
	}
	public int getBudget()
	{
		return budget;
	}
	public String getAddress()
	{
		return address;
	}
	public void setPropertyID(String propertyID) 
	{
		this.propertyID = propertyID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
	}

	public void setNumBathrooms(int numBathrooms) {
		this.numBathrooms = numBathrooms;
	}

	public void setIfFurnished(boolean ifFurnished) {
		this.ifFurnished = ifFurnished;

	}

	public void setQuadrant(String quadrant) {
		this.quadrant = quadrant;
	}

	public void setRentCost(int rentCost) {
		this.rentCost = rentCost;
	}

	public void setPropertyFee(int propertyFee) {
		this.propertyFee = propertyFee;
	}

	public void setFeePaid(boolean feePaid) {
		this.feePaid = feePaid;
	}
	
	public void setLandlordID(int landlordID) 
	{
		this.landlordID = landlordID;
	}
	
	public void setBudget(int budget)
	{
		this.budget = budget;
	}
	public void getAddress(String address)
	{
		this.address = address;
	}
	////
	public void createProperty()
	{
//		newProperty = new ArrayList<Property>();
	}
	
}
