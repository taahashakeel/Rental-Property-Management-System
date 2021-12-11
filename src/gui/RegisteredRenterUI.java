/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * The user interface an unregistered renter will view when they enter the
 * application.
 *
 * Unregistered renters should have the ability to search for and view
 * listed properties.
 */
package gui;

import gui.elements.SearchMenu;
import gui.elements.ElementList;
import gui.elements.PropertyView;

import Employee.Property;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class RegisteredRenterUI extends FocusPanel{
  // private RegisteredRenter userRepresntation;
  private Property[] listedProperties;
  public static final int LIST_SIZE = 5;

  public RegisteredRenterUI(){
    super();
    init();
  }

  /**
   * Initialize the current user interface for unregistered renters.
   */
  public void init(){
    panelLayout = new GridBagLayout();
    setLayout(panelLayout);

    // create dummy properties for now.
    listedProperties = new Property[LIST_SIZE];
    PropertyView[] dummyList = new PropertyView[LIST_SIZE];

    for(int i = 0; i < LIST_SIZE; i++){
      Property currProperty = new Property();

      currProperty.setAddress("415" + i + " Eagle Drive");
      currProperty.setQuadrant("NE");
      currProperty.setHouseType("Condo");
      currProperty.setIfFurnished(i % 2 == 0);
      currProperty.setPropertyID("P12");
      currProperty.setRentCost(1000*i);
      currProperty.setStatus("Active");

      listedProperties[i] = currProperty;
      /*/
      dummyList[i] = new PropertyView("415" + i + " Eagle Drive",
          "NE",
          "Condo",
          i % 2 == 0,
          415,
          i);
      // */
      dummyList[i] = new PropertyView(currProperty, i);
    }

    ElementList<PropertyView> results = new ElementList<PropertyView>(dummyList);

    // Create necessary elements
    SearchMenu search = new SearchMenu(true);

    // populate window assuming a 4-column, 5-row grid.
    GridBagConstraints gbc;
    gbc = generateConstraints(0, 0, 1, 1);
    gbc.fill = GridBagConstraints.VERTICAL;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.weighty = 100;
    add(search, gbc);

    gbc = generateConstraints(1, 0, 1, 1);
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 100;
    gbc.weighty = 100;
    add(results, gbc);
  }
}
