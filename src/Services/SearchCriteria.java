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

	public SearchCriteria() {}

	public SearchCriteria(String houseType, int minNumBedrooms, int maxNumBedrooms, int minNumBathrooms,
			int maxNumBathrooms, boolean ifFurnished, String quadrant, int budget) {
		super();
		this.dbControl = new DatabaseController();
		this.houseType = houseType;
		this.numBedrooms[0] = minNumBedrooms;
		this.numBedrooms[1] = maxNumBedrooms;
		this.numBathrooms[0] = minNumBathrooms;
		this.numBathrooms[1] = maxNumBathrooms;
		this.ifFurnished = ifFurnished;
		this.quadrant = quadrant;
		this.budget = budget;
	}

	/**
	 * Changes the search criteria fields
	 *
	 * @param houseType    The single type of house to filter
	 * @param numBedrooms  Min to max range of bedrooms to filter
	 * @param numBathrooms Min to max range of bathrooms to filter
	 * @param ifFurnished  Furnished state to filter
	 * @param quadrant     The desired quadrant of the city to filter
	 * @param budget       the budget to remain under in filtering
	 * 
	 */
	public void editSearchCriteria(String houseType, int[] numBedrooms, int[] numBathrooms, boolean ifFurnished,
			String quadrant, int budget) {
		setHouseType(houseType);
		this.numBedrooms = numBedrooms;
		this.numBathrooms = numBathrooms;
		setIfFurnished(ifFurnished);
		setQuadrant(quadrant);
		setBudget(budget);
	}

	/**
	 * Searches the database and returns the array list of matching 
	 * available propertys
	 *
	 * @return the properties that match the search criteria
	 */
	public ArrayList<Property> searchProperties() {
		return dbControl.fetchActiveProperty(this.houseType, this.numBedrooms, this.numBathrooms, this.ifFurnished,
				this.quadrant, this.budget);
	}

	/**
	 * House type getter functoin
	 *
	 * @return search criteria house type
	 */
	public String getHouseType() {
		return houseType;
	}

	/**
	 * House type setter functoin
	 *
	 * @param String representing the desired house type
	 */
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	/**
	 * Num of bedrooms getter function
	 *
	 * @return int array representing min and max num of bedrooms
	 */
	public int[] getNumBedrooms() {
		return numBedrooms;
	}

	/**
	 * Num of bedrooms setter function
	 *
	 * @param minNumBedrooms Min number of desired bedrooms 
	 * @param maxNumBedrooms Max number of desired bedrooms 
	 */
	public void setNumBedrooms(int minNumBedrooms, int maxNumBedrooms) {
		this.numBedrooms[0] = minNumBedrooms;
		this.numBedrooms[1] = maxNumBedrooms;
	}
	
	/**
	 * Num of bathrooms getter function
	 *
	 * @return int array representing min and max num of bathrooms
	 */
	public int[] getNumBathrooms() {
		return numBathrooms;
	}

	/**
	 * Num of bathrooms setter function
	 *
	 * @param minNumBathrooms Min number of desired bathrooms 
	 * @param maxNumBathrooms Max number of desired bathrooms 
	 */
	public void setNumBathrooms(int minNumBathrooms, int maxNumBathrooms) {
		this.numBathrooms[0] = minNumBathrooms;
		this.numBathrooms[1] = maxNumBathrooms;
	}

	/**
	 * isFurnished getter functoin
	 *
	 * @return ifFurnished Saved isFurnish boolean
	 */
	public boolean isIfFurnished() {
		return ifFurnished;
	}

	/**
	 * isFurnished setter functoin
	 *
	 * @param ifFurnished If the desired houses are furnished
	 */
	public void setIfFurnished(boolean ifFurnished) {
		this.ifFurnished = ifFurnished;
	}

	/**
	 * Quadrant getter function
	 *
	 * @return String representing the saved desired quadrant
	 */
	public String getQuadrant() {
		return quadrant;
	}

	/**
	 * Quadrant setter function
	 *
	 * @param quadrant Desired quadrant
	 */
	public void setQuadrant(String quadrant) {
		this.quadrant = quadrant;
	}

	/**
	 * Budget getter function
	 *
	 * @param budget Desired budget to remain under or equal to 
	 */
	public int getBudget() {
		return budget;
	}

	/**
	 * Budget setter function
	 *
	 * @param budget Desired budget to remain under or equal to 
	 */
	public void setBudget(int budget) {
		this.budget = budget;
	}

}
