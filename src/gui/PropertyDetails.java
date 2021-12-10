/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * This page will show all the details for a specified property.
 *
 * Property details will contain all information about a property with exception
 * to:
 * - feePaid
 * - landlord id
 *
 * possibility:
 * ~~~~~~~~~~~
 * All other data attributes are going to be visible to Renters. If a landlord
 * or manager views the page (when entering from their respective UI, they
 * should have access to edit the details of the property as needed.
 */
package gui;

import Employee.Property;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PropertyDetails extends FocusPanel{
  private Property propertyRep;
  // Determine if the user should have the option to email the renter
  private boolean viewer;

  public static final String EMAIL_LANDLORD_ID = "emailLandlordButton";

  /*/ this empty constructor should not need to exist.
  public PropertyDetails(boolean viewer){
    super();
    this.viewer = viewer;
  } // */

  // this is the constructor that is needed
  public PropertyDetails(Property propertyRep, boolean viewer){
    super();
    this.propertyRep = propertyRep;
    this.viewer = viewer;
    init();
  } // */

  /**
   * Initializes the current property details panel.
   *
   * This panel displays all information about a selected property
   */
  private void init(){
    GridBagLayout panelLayout = new GridBagLayout();
    setLayout(panelLayout);

    // nest a JTabbedPane here.
    JTabbedPane tabbedPane = new JTabbedPane();

    JPanel detailPanel = detailComponent();
    JPanel emailPanel = emailComponent();

    tabbedPane.add(detailPanel);
    tabbedPane.add(emailPanel);

    // Add pane to current page
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
    add(tabbedPane, gbc);
  }

  /**
   * Generate the JPanel with the details of the property.
   */
  private JPanel detailComponent(){
    // create all necessary elements
    JPanel centerPanel = new JPanel();
    centerPanel.setName("Property Details");

    GridBagLayout centerLayout = new GridBagLayout();
    centerPanel.setLayout(centerLayout);

    JLabel idLabel = new JLabel("Id: ");
    JLabel idValue = new JLabel("#" + String.valueOf(propertyRep.getPropertyID()));
    JLabel addressLabel = new JLabel(propertyRep.getAddress()
        + " " + propertyRep.getQuadrant());
    JLabel bedroomLabel = new JLabel("Number of bedrooms: ");
    JLabel bedroomCount = new JLabel(String.valueOf(propertyRep.getNumBedrooms()) + " bed");
    JLabel bathroomLabel = new JLabel("Number of bathrooms: ");
    JLabel bathroomCount = new JLabel(String.valueOf(propertyRep.getNumBathrooms()) + " bath");
    JLabel costLabel = new JLabel("$" + String.valueOf(propertyRep.getRentCost()) + " / Month");
    JLabel furnishedLabel = new JLabel(propertyRep.getIfFurnished()? "Furnished" : "Unfurnished");

    // place items as necessary
    // property identifiers
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 0, 2, 1);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    centerPanel.add(addressLabel, gbc);

    gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
    gbc.anchor = GridBagConstraints.WEST;
    centerPanel.add(idLabel, gbc);
    gbc = FocusPanel.generateConstraints(1, 1, 1, 1);
    gbc.anchor = GridBagConstraints.EAST;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    centerPanel.add(idValue, gbc);

    // property cost
    gbc = FocusPanel.generateConstraints(1, 0, 1, 1);
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.weightx = 1;
    centerPanel.add(costLabel, gbc);

    // property composition
    gbc = FocusPanel.generateConstraints(0, 2, 1, 1);
    gbc.anchor = GridBagConstraints.WEST;
    centerPanel.add(bedroomLabel, gbc);
    gbc = FocusPanel.generateConstraints(1, 2, 1, 1);
    gbc.anchor = GridBagConstraints.EAST;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    centerPanel.add(bedroomCount, gbc);

    gbc = FocusPanel.generateConstraints(0, 3, 1, 1);
    gbc.anchor = GridBagConstraints.WEST;
    centerPanel.add(bathroomLabel, gbc);
    gbc = FocusPanel.generateConstraints(1, 3, 1, 1);
    gbc.anchor = GridBagConstraints.EAST;
    gbc.weightx = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    centerPanel.add(bathroomCount, gbc);

    gbc = FocusPanel.generateConstraints(0, 4, 2, 1);
    gbc.anchor = GridBagConstraints.WEST;
    centerPanel.add(furnishedLabel, gbc);

    return centerPanel;
  }

  /**
   * Generate the component with the text area to write messages to the landlord.
   */
  private JPanel emailComponent(){
    JPanel emailPanel = new JPanel();
    emailPanel.setName("Contact Landlord");

    JButton contactLandlord = new JButton("Email Landlord");
    /// TODO: Add email textbox to write message to the landlord

    // gbc = FocusPanel.generateConstraints(0, 5, 2, 1);
    // gbc.weightx = 1;
    // gbc.fill = GridBagConstraints.HORIZONTAL;
    // centerPanel.add(contactLandlord, gbc);
    return emailPanel;
  }
}
