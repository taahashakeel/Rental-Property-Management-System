/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * This page will show all the details for a specified property.
 *
 * Property details will contain all information about a property with exception
 * to:
 * - feePaid
 * - landlord id
 *
 * possibility:
 * ~~~~~~~~~~~
 * All other data attributes are going to be visible to Renters. If a landlord
 * or manager views the page (when entering from their respective UI, they
 * should have access to edit the details of the property as needed.
 */
package gui;

import javax.swing.JLabel;
import javax.swing.JButton;

public class PropertyDetails extends FocusPanel{
  // private Property propertyRep;
  // Determine if the user should have the option to email the renter
  private boolean viewer;

  // this empty constructor should not need to exist.
  public PropertyDetails(boolean viewer){
    super();
    this.viewer = viewer;
  } // */

  /*/ this is the constructor that is needed
  public PropertyDetails(Property propertyRep, boolean viewer){
    super();
    this.propertyRep = propertyRep;
    this.viewer = viewer;
    init();
  } // */

  /**
   * Initializes the current property details panel.
   *
   * This panel displays all information about a selected property
   */
  private void init(){
    // create all necessary elements
    JLabel idLabel = new JLabel(propertyRep.getPropertyID());
    JLabel addressLabel = new JLabel(propertyRep.getAddress()
        + " " + propertyRep.getQuadrant());
    JLabel bedroomLabel = new JLabel("Number of bedrooms: ");
    JLabel bedroomCount = new JLabel(propertyRep.getNumBedrooms());
    JLabel bathroomLabel = new JLabel("Number of bathrooms: ");
    JLabel bathroomCount = new JLabel(propertyRep.getNumBathrooms());
    JLabel costLabel = new JLabel(propertyRep.getRentCost());
  }
}
