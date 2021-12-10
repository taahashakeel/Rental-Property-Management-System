/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * The user interface Managers can view displaying the summary over a set
 * period of time.
 *
 */

package gui;

import gui.FocusPanel;
import gui.ButtonListener;
import gui.GUI;

import gui.elements.PropertyList;
import gui.elements.PropertyEdit;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

public class SummaryUI  extends FocusPanel{
  // private Manager userRepresentation;

  public SummaryUI(){
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

    PropertyList<PropertyEdit> results = new PropertyList<PropertyEdit>(dummyList);

    // populate window
    GridBagConstraints gbc;
    
    gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
    gbc.weighty = 0;
    gbc.fill = GridBagConstraints.NONE;
    summaryButton.setActionCommand(GET_SUMMARY_BUTTON);
    summaryButton.addActionListener(GUI.buttonListener);
    add(summaryButton, gbc);
    
    gbc = FocusPanel.generateConstraints(1, 0, 1, 1);
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 100;
    gbc.weighty = 100;
    add(results, gbc);
  }