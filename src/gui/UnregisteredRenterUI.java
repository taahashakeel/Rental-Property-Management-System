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

    // populate window assuming a 4-column, 5-row grid.
    addWidget(search, 0, 0, 1, 5);
  }
}
