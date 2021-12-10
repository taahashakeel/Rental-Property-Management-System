/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * The user interface managers will use to use the Rental Property Management
 * System.
 *
 * This UI should allow Managers to create properties and view existing
 * property details.
 */
package gui;

import gui.elements.ElementList;
import gui.elements.PropertyEdit;

import Employee.Property;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

public class ManagerUI extends FocusPanel{
  // private Manager userRepresentation;
  private Property[] listedProperties;
  public static final int LIST_SIZE = 4;

  public ManagerUI(){
    super();
    init();
  }

  /**
   * Initializes the Landlord graphical user interface for usage.
   */
  private void init(){
    panelLayout = new GridBagLayout();
    setLayout(panelLayout);

    // Create elements
    JButton summaryButton = new JButton("Generate Summary");

    String[] statuses = {
      "Active",
      "Rented",
      "Cancelled",
      "Suspended"
    };

    // create dummy properties for now.
    listedProperties = new Property[LIST_SIZE];
    PropertyEdit[] dummyList = new PropertyEdit[4];

    for(int i = 0; i < LIST_SIZE; i++){
      Property currProperty = new Property();

      currProperty.setAddress("415" + "i" + " Eagle Drive");
      currProperty.setQuadrant("NE");
      currProperty.setHouseType("Condo");
      currProperty.setIfFurnished(i % 2 == 0);
      currProperty.setPropertyID("P12");
      currProperty.setStatus(statuses[i % 4]);

      listedProperties[i] = currProperty;
      /*/
      dummyList[i] = new PropertyView("415" + i + " Eagle Drive",
          "NE",
          "Condo",
          i % 2 == 0,
          415,
          i);
      // */
      dummyList[i] = new PropertyEdit(currProperty);
    }

    ElementList<PropertyEdit> results = new ElementList<PropertyEdit>(dummyList);

    // populate window
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.NONE;
    add(summaryButton, gbc);
    gbc = FocusPanel.generateConstraints(1, 0, 1, 1);
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 100;
    gbc.weighty = 100;
    add(results, gbc);
  }
}
