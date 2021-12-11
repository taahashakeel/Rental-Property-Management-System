/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * The user interface landlords will use to use the Rental Property Management
 * System.
 *
 * This UI should allow Landlords to create properties and view existing
 * property details.
 */
package gui;

import gui.FocusPanel;
import gui.ButtonListener;
import gui.GUI;

import gui.elements.PropertyList;
import gui.elements.ElementList;
import gui.elements.PropertyEdit;

import Employee.Property;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

public class LandlordUI extends FocusPanel{
	public static final String CREATE_PROP_BUTTON = "createPropertyButton";

  // private Landlord userRepresentation;
  private Property[] listedProperties;
  public static final int LIST_SIZE = 7;

  public LandlordUI(){
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
    JButton createPropertyButton = new JButton("List a new property for rent");
    String[] statuses = {
      "Active",
      "Rented",
      "Cancelled",
      "Suspended"
    };

    // create dummy properties for now.
    listedProperties = new Property[LIST_SIZE];
    PropertyEdit[] dummyList = new PropertyEdit[LIST_SIZE];

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
      dummyList[i] = new PropertyEdit(currProperty, i);
    }

    ElementList<PropertyEdit> results = new ElementList<PropertyEdit>(dummyList);

    // populate window
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 100;
    gbc.weighty = 100;
    add(results, gbc);

    gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
    createPropertyButton.setActionCommand(CREATE_PROP_BUTTON);
    createPropertyButton.addActionListener(GUI.buttonListener);
    add(createPropertyButton, gbc);
  }
}
