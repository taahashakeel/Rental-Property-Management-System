/**
 *  @author Rachel Renegado
 *  @version 1.0
 *  @since 1.0
 */
/**
 *  @author Rachel Renegado
 *  @version 1.0
 *  @since 1.0
 */

package Services;

import java.io.*;
import java.util.*;
import BackEnd.DatabaseController;
import Employee.Property;

/**
 * SearchCriteria is a class that each renter (regular and register) 
 * has when entering Rental Property Management Service. 
 */
public class SearchCriteria {

	private DatabaseController dbControl; 
	private String houseType;
	private int numBedrooms;
	private int numBathrooms;
	private boolean ifFurnished;
	private String quadrant;
	private int budget;

// Constructors
	public SearchCriteria(String houseType, int numBedrooms, int numBathrooms, boolean ifFurnished, String quadrant,
			int budget) {
		super();
		this.houseType = houseType;
		this.numBedrooms = numBedrooms;
		this.numBathrooms = numBathrooms;
		this.ifFurnished = ifFurnished;
		this.quadrant = quadrant;
		this.budget = budget;
	}

	public boolean editSearchCriteria(String houseType, int numBedrooms, int numBathrooms, boolean ifFurnished,
			String quadrant) {
		setHouseType(houseType);
		setNumBedrooms(numBedrooms);
		setNumBathrooms(numBathrooms);
		setIfFurnished(ifFurnished);
		setQuadrant(quadrant);
	}

	public ArrayList<Property> searchProperties() {
		dbControl.fetchActiveProperty(this.houseType, this.numBedrooms, this.numBathrooms, this.ifFurnished,
				this.quadrant, this.budget);
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

	public int getNumBedrooms() {
		return numBedrooms;
	}

	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
	}

	public int getNumBathrooms() {
		return numBathrooms;
	}

	public void setNumBathrooms(int numBathrooms) {
		this.numBathrooms = numBathrooms;
	}

	public boolean isIfFurnished() {
		return ifFurnished;
	}

	public void setIfFurnished(boolean ifFurnished) {
		this.ifFurnished = ifFurnished;
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
