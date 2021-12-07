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

import javax.swing.JCheckBox;
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
    init();
  }

  /**
   * Initializes the search menu to be used within a user interface.
   */
  private void init(){
    panelLayout = new GridBagLayout();
    panelConstraints = new panelConstraints();
    panelConstratins.insets = new Insets(PADDING, PADDING, PADDING, PADDING);

    // Populate SearchMenu with necessary elements
    JLabel cityQuadLabel = new JLabel("City Quadrant: ");
    JComboBox<String> cityQuadMenu = new JComboBox<String>(QUADRANTS);
    Jabel houseTypeLabel = new JLabel("Housing type: ");
    JComboBox<String> houseTypeMenu = new JComboBox<String>(housingTypes);

    // Numeric menus
    JLabel bedroomLabel = new JLabel("No. Bedrooms");
    JTextField bedroomInput = new JTextField(2); // allow for a 2 digit value

    JLabel bathroomLabel = new JLabel("No. Bathrooms");
    JTextField bathroomInput = new JTextField(2);

    // Checkboxes
    JCheckBox furnishCheckbox = new JCheckbox("Furnished");

    // place items within a 5-column grid.
    // Quadrant menu
    FocusPanel.addWidgetTo(this, cityQuadLabel, 0, 0, 4, 1, panelConstraints, panelLayout);
    FocusPanel.addWidgetTo(this, cityQuadMenu, 0, 4, 1, 1, panelConstraints, panelLayout);

    // House type menu
    FocusPanel.addWidgetTo(this, houseTypeLabel, 0, 1, 4, 1, panelConstraints, panelLayout);
    FocusPanel.addWidgetTo(this, houseTypeMenu, 4, 1, 1, 1, panelConstraints, panelLayout);

    // Bedroom + Bathroom count
    FocusPanel.addWidgetTo(this, bedroomLabel, 0, 2, 4, 1, panelConstraints, panelLayout);
    FocusPanel.addWidgetTo(this, bedroomInput, 4, 2, 1, 1, panelConstraints, panelLayout);

    FocusPanel.addWidgetTo(this, bathroomLabel, 0, 3, 4, 1, panelConstraints, panelLayout);
    FocusPanel.addWidgetTo(this, bathroomInput, 4, 3, 1, 1, panelConstraints, panelLayout);

    // furnished checkbox
    FocusPanel.addWidgetTo(this, furnishCheckbox, 0, 4, 5, 1, panelConstraints, panelLayout);
  }
}
