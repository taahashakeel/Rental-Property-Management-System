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

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import java.util.ArrayList;

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
    ArrayList<JButton> dummyList = new ArrayList<JButton>(4);

    for(int i = 0; i < 4; i++){
      dummyList.set(i, new JButton("Property " + i));
    }

    PropertyList<JButton> results = new PropertyList<JButton>(dummyList);

    // populate window assuming a 4-column, 5-row grid.
    addWidget(search, 0, 0, 1, 5);
    addWidget(results, 0, 1, 3, 5);
  }
}
