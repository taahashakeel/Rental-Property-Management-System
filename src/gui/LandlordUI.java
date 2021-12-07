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

import java.awt.GridBagLayout;

public class LandlordUI extends FocusPanel{
  // private Landlord userRepresentation;

  public LandlordUI(){
    super();
  }

  /**
   * Initializes the Landlord graphical user interface for usage.
   */
  private void init(){
    panelLayout = new GridBagLayout();
    setLayout(panelLayout);

    // Create elements

    // populate window
  }
}
