/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * Each instance of this element will represent an instance of Property.
 * When viewing a list of properties, the list should create multiple instances
 * of this object for users to see properties they wish to see.
 *
 * This element briefly summarizes information on the property, including:
 * - city quadrant
 * - housing type
 * - furnish state
 */
package gui.elements;

// import Employee.Property

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PropertyView extends JPanel{
  // private Property representedProperty;
  String address;
  String quadrant;
  String housingType;
  boolean furnished;
  int id;

  public PropertyView(){
    super();
  }

  /*/
  public PropertyView(Property representedProperty){
    this.representedProperty = representedProperty;
  }
  // */

  public PropertyView(
      String address,
      String quadrant,
      String housingType,
      boolean furnished,
      int id){
    super();
    this.address = address;
    this.quadrant = quadrant;
    this.housingType = housingType;
    this.furnished = furnished;
    this.id = id;
  }
}
