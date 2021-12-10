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
import gui.elements.PropertyList;
import gui.elements.PropertyView;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class UnregisteredRenterUI extends FocusPanel{
  // private UnregisteredRenter userRepresntation;

  public UnregisteredRenterUI(){
    super();
    init();
  }

  /**
   * Initialize the current user interface for unregistered renters.
   */
  public void init(){
    panelLayout = new GridBagLayout();
    setLayout(panelLayout);

    // Create necessary elements
    SearchMenu search = new SearchMenu();

    // create dummy properties for now.
    PropertyView[] dummyList = new PropertyView[4];

    for(int i = 0; i < 4; i++){
      dummyList[i] = new PropertyView("415" + i + " Eagle Drive",
          "NE",
          "Condo",
          i % 2 == 0,
          415);
    }

    PropertyList<PropertyView> results = new PropertyList<PropertyView>(dummyList);

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
