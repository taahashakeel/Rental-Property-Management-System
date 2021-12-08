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
import gui.FocusPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PropertyView extends JPanel{
  // private Property representedProperty;
  String address;
  String quadrant;
  String housingType;
  boolean furnished;
  int id;

  public PropertyView(){
    super();
    init();
  }

  /*/
  public PropertyView(Property representedProperty){
    this.representedProperty = representedProperty;
    init();
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

    init();
  }

  /**
   * Initialies the current PropertyView element.
   */
  private void init(){
    GridBagLayout viewElementLayout = new GridBagLayout();
    setLayout(viewElementLayout);

    // Create main button to link to properties
    GridBagLayout buttonLayout = new GridBagLayout();
    JButton propertyLink = new JButton();
    propertyLink.setLayout(buttonLayout);

    // Create elements that will be added to the button
    JLabel addressLabel = new JLabel(address);
    JLabel cityQuadrantLabel = new JLabel(quadrant);
    JLabel furnishedLabel = new JLabel(furnished ? "Furnished" : "Unfurnished");

    // Add elements to the button
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
    gbc.weightx = 0;
    gbc.anchor = GridBagConstraints.WEST;
    propertyLink.add(addressLabel, gbc);

    gbc = FocusPanel.generateConstraints(1, 0, 1, 1);
    gbc.weightx = 1;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    propertyLink.add(cityQuadrantLabel, gbc);

    gbc = FocusPanel.generateConstraints(0, 1, 2, 1);
    gbc.weightx = 1;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    propertyLink.add(furnishedLabel, gbc);

    // Add button to current element
    gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 0.8;
    add(propertyLink, gbc);
  }
}
