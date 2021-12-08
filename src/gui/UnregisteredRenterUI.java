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
    JButton[] dummyList = new JButton[4];

    for(int i = 0; i < 4; i++){
      dummyList[i] = new JButton("Property " + i);
    }

    PropertyList<JButton> results = new PropertyList<JButton>(dummyList);

    results.setBackground(Color.red);

    // populate window assuming a 4-column, 5-row grid.
    GridBagConstraints gbc;
    gbc = generateConstraints(0, 0, 1, 5);
    gbc.fill = GridBagConstraints.VERTICAL;
    gbc.anchor = GridBagConstraints.WEST;
    add(search, gbc);

    gbc = generateConstraints(1, 0, 3, 5);
    gbc.fill = GridBagConstraints.BOTH;
    add(results, gbc);
  }
}
