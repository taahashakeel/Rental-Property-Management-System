package Employee;

import java.util.ArrayList;

public class Property {

	private int propertyID;
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
	private int landlordID;
//	private ArrayList<Property> newProperty;

	private DatabaseController dbControl;

	public Property() {
	}

	public int getPropertyID() {
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

	public int getlandlordID() {
		return landlordID;
	}

	public int getbudget() {
		return budget;
	}

	public void setPropertyID(int propertyID) {
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

	public void setlandlordID(int landlordID) {
		this.landlordID = landlordID;
	}

	public void setbudget(int budget) {
		this.budget = budget;
	}
}
