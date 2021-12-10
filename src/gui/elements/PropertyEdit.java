/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * Each instance of this element will represent an instance of Property.
 * When viewing a list of properties, the list should create multiple instances
 * of this object for users to see properties they wish to see.
 *
 * This element is based off PropertyView, but allows landlords to change the
 * state of the property.
 *
 * This element briefly summarizes information on the property, including:
 * - city quadrant
 * - housing type
 * - furnish state
 */
package gui.elements;

// import Employee.Property;

import gui.FocusPanel;

import javax.swing.JComboBox;

public class PropertyEdit extends PropertyView(){
  private String propertyStatus;

  /*/ constructor to use
  public PropertyEdit(Property propertyRep){
    super(propertyRep);
  } // */

  public PropertyView(
      String address,
      String quadrant,
      String housingType,
      boolean furnished,
      int id,
      String propertyStatus){
    super();
    this.propertyStatus = propertyStatus;
  }
}
