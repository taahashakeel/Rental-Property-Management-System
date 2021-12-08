/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.0
 *  @since 1.0
 */

package Services;

import java.io.*;
import java.util.*;
import BackEnd.DatabaseController;
import Employee.Property;

/**
 * SearchCriteria is a class that each renter (regular and register) has when
 * entering Rental Property Management Service.
 */
public class SearchCriteria {

	private DatabaseController dbControl;
	private String houseType;
	private int []numBedrooms = new int[2]; // saves min and max num bedrooms
	private int []numBathrooms = new int[2]; // saves min and max num bedrooms
	private boolean ifFurnished;
	private String address;
	private String quadrant;
	private int budget;

// Constructors
	public SearchCriteria(String houseType, int minNumBedrooms,int maxNumBedrooms, int minNumBathrooms, int maxNumBathrooms, boolean ifFurnished, String address, String quadrant,
			int budget) {
		super();
		this.houseType = houseType;
		this.numBedrooms[0] = minNumBedrooms;
		this.numBedrooms[1] = maxNumBedrooms;
		this.numBathrooms[0] = minNumBathrooms;
		this.numBathrooms[1] = maxNumBathrooms;
		this.ifFurnished = ifFurnished;
		this.address = address;
		this.quadrant = quadrant;
		this.budget = budget;
		this.isSaved = false;
	}

	public boolean editSearchCriteria(String houseType, int [] numBedrooms, int [] numBathrooms, boolean ifFurnished, String address, 
			String quadrant, int budget) {
		setHouseType(houseType);
		setNumBedrooms(numBedrooms);
		setNumBathrooms(numBathrooms);
		setIfFurnished(ifFurnished);
		setAddress(address);
		setQuadrant(quadrant);
		setBudget(budget);
	}

	public ArrayList<Property> searchProperties() {
		return dbControl.fetchActiveProperty(this.houseType, this.numBedrooms, this.numBathrooms, this.ifFurnished,
				this.address, this.quadrant, this.budget);
	}

// Setters and Getters			 
	public DatabaseController getDbControl() {
		return dbControl;
	}

	public void setDbControl(DatabaseController dbControl) {
		this.dbControl = dbControl;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public int[] getNumBedrooms() {
		return numBedrooms;
	}

	public void setNumBedrooms(int minNumBedrooms, int maxNumBedrooms) {
		this.numBedrooms[0] = minNumBedrooms;
		this.numBedrooms[1] = maxNumBedrooms;
	}

	public int[] getNumBathrooms() {
		return numBathrooms;
	}

	public void setNumBathrooms(int minNumBathrooms, int maxNumBathrooms) {
		this.numBathrooms[0] = minNumBathrooms;
		this.numBathrooms[1] = maxNumBathrooms;
	}

	public boolean isIfFurnished() {
		return ifFurnished;
	}

	public void setIfFurnished(boolean ifFurnished) {
		this.ifFurnished = ifFurnished;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQuadrant() {
		return quadrant;
	}

	public void setQuadrant(String quadrant) {
		this.quadrant = quadrant;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

}
