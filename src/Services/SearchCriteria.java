/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.2 added documentation
 *  @since 1.0
 *  
 *  This class is used by renters (registred and unregistered) to filter their
 *  search when searching for properties.
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
	private int[] numBedrooms = new int[2]; // saves min and max num bedrooms
	private int[] numBathrooms = new int[2]; // saves min and max num bedrooms
	private boolean ifFurnished;
	private String quadrant;
	private int budget;

// Constructors
	public SearchCriteria(String houseType, int minNumBedrooms, int maxNumBedrooms, int minNumBathrooms,
			int maxNumBathrooms, boolean ifFurnished, String quadrant, int budget) {
		super();
		this.dbControl = new DataDatabaseController();
		this.houseType = houseType;
		this.numBedrooms[0] = minNumBedrooms;
		this.numBedrooms[1] = maxNumBedrooms;
		this.numBathrooms[0] = minNumBathrooms;
		this.numBathrooms[1] = maxNumBathrooms;
		this.ifFurnished = ifFurnished;
		this.quadrant = quadrant;
		this.budget = budget;
		this.isSaved = false;
	}
	

	/**
	 * Changes the search criteria fields
	 *
	 * @param houseType    The single type of house to filter
	 * @param numBedrooms  Min to max range of bedrooms to filter
	 * @param numBathrooms Min to max range of bathrooms to filter
	 * @param ifFurnished  Furnished state to filter
	 * @param quadrant	The desired quadrant of the city to filter
	 * @param budget the budget to remain under in filtering
	 * 
	 */
	public void editSearchCriteria(String houseType, int[] numBedrooms, int[] numBathrooms, boolean ifFurnished,
			String quadrant, int budget) {
		setHouseType(houseType);
		setNumBedrooms(numBedrooms);
		setNumBathrooms(numBathrooms);
		setIfFurnished(ifFurnished);
		setAddress(address);
		setQuadrant(quadrant);
		setBudget(budget);
	}
	
	/**
	 * Changes the search criteria feilds
	 *
	 * @param houseType    The single type of house to filter
	 * @param numBedrooms  Min to max range of bedrooms to filter
	 * @param numBathrooms Min to max range of bathrooms to filter
	 * @param ifFurnished  Furnished state to filter
	 * @param quadrant	The desired quadrant of the city to filter
	 * @param budget the budget to remain under in filtering
	 * 
	 * @return the  properties that match the search criteria
	 */
	public ArrayList<Property> searchProperties() {
		return dbControl.fetchActiveProperty(this.houseType, this.numBedrooms, this.numBathrooms, this.ifFurnished,
				this.quadrant, this.budget);
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
