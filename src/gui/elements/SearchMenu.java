/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * The menu for users to search up different types of properties they may be
 * interested in.
 *
 * With this menu, interested renters should be able to filter properties by
 * - Housing type: Apartment, Attached/Detached House, Townhouse, Condo
 * - Number of Bedrooms: (at least, at most, exactly a number)
 * - Number of Bathrooms: (at least, at most exactly)
 * - Furnishing state: Furnished or Unfurnished.
 * - City Quadrant: NE, NW, SW, SE
 */
package gui.elements;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchMenu extends JPanel{
  private static final int PADDING = 2;
  private GridBagLayout panelLayout;
  private GridBagConstraints panelConstraints;

  private static final String[] QUADRANTS = {
    "NE",
    "NW",
    "SW",
    "SE"
  };
  private static String[] housingTypes = {
    "Apartment",
    "Attached House",
    "Detached House",
    "Townhouse",
    "Condo"
  };

  public SearchMenu(){
    super();
  }

  /**
   * Initializes the search menu to be used within a user interface.
   */
  private void init(){
    panelLayout = new GridBagLayout();
    panelConstraints = new panelConstraints();
    panelConstratins.insets = new Insets(PADDING, PADDING, PADDING, PADDING);

    // Populate SearchMenu with necessary elements
    JComboBox<String> cityQuadMenu = new JComboBox<String>(QUADRANTS);
    JComboBox<String> houseTypeMenu = new JComboBox<String>(housingTypes);

    // Numeric menus
    JLabel bedroomLabel = new JLabel("No. Bedrooms");
    JTextField bedroomInput = new JTextField(2); // allow for a 2 digit value

    JLabel bathroomLabel = new JLabel("No. Bathrooms");
    JTextField bathroomInput = new JTextField(2);
  }
}
