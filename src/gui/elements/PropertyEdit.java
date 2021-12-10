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

import Employee.Property;

import gui.FocusPanel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class PropertyEdit extends PropertyView{
  private String propertyStatus;

  private String[] statuses = {
    "Active",
    "Rented",
    "Cancelled",
    "Suspended"
  };

  // constructor to use
  public PropertyEdit(Property propertyRep, int index){
    super(propertyRep, index);
    this.propertyStatus = propertyRep.getStatus();
    init();
  } // */

  /*/
  public PropertyEdit(
      String address,
      String quadrant,
      String housingType,
      boolean furnished,
      int id,
      int index,
      String propertyStatus){
    super(address, quadrant, housingType, furnished, id, index);
    this.propertyStatus = propertyStatus;
    init();
  }// */

  /**
   * Initializes the current PropertyEdit instance.
   */
  private void init(){
    JComboBox<String> statusMenu = new JComboBox<String>(statuses);

    statusMenu.setSelectedItem(propertyStatus);

    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(1, 0, 1, 1);
    add(statusMenu, gbc);
  }
}
