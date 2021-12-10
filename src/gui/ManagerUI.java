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

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

public class ManagerUI extends FocusPanel{
  // private Manager userRepresentation;

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

    // create dummy properties for now.
    PropertyEdit[] dummyList = new PropertyEdit[10];

    String[] statuses = {
      "Active",
      "Rented",
      "Cancelled",
      "Suspended"
    };

    for(int i = 0; i < 10; i++){
      dummyList[i] = new PropertyEdit("415" + i + " Eagle Drive",
          "NE",
          "Condo",
          i % 2 == 0,
          415,
          i,
          statuses[i % 4]);
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
