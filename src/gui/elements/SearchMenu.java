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

import gui.FocusPanel;
import gui.ButtonListener;
import gui.GUI;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SearchMenu extends JPanel {
	private GridBagLayout panelLayout;
	private boolean registered;
	public static final String SEARCH_BUTTON_ID = "searchButton1";
	public static final String SUBSCRIBE_BUTTON_ID = "subscribeButton";

	private static final String[] QUADRANTS = { "NE", "NW", "SW", "SE" };
	private static String[] housingTypes = { "Apartment", "Attached House", "Detached House", "Townhouse", "Condo" };

	// Feilds that collect user input
	private static JTextField bedroomLower = new JTextField(2); // allow for a 2 digit value
	private static JTextField bedroomUpper = new JTextField(2);
	private static JComboBox<String> cityQuadMenu = new JComboBox<String>(QUADRANTS);
	private static JComboBox<String> houseTypeMenu = new JComboBox<String>(housingTypes);
	private static JTextField bathroomLower = new JTextField(2);
	private static JTextField bathroomUpper = new JTextField(2);
	private static JTextField budget= new JTextField(5); // max = $999,999

	// allow for boundries to be set
	private JLabel bathroomRangeLabel = new JLabel("<");

	// Checkboxes
	private static JCheckBox furnishCheckbox = new JCheckBox("Furnished");

	public SearchMenu() {
		super();
		registered = false;
		init();
	}

	public SearchMenu(boolean registered) {
		super();
		this.registered = registered;
		init();
	}

	/**
	 * Initializes the search menu to be used within a user interface.
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);
		
		// Populate SearchMenu with necessary elements
		JLabel cityQuadLabel = new JLabel("City Quadrant: ");
		JLabel houseTypeLabel = new JLabel("Housing type: ");
		JButton searchButton = new JButton("Search");
		JButton subscribeButton = new JButton("Subscribe");

		// Numeric menus
		JLabel bedroomLabel = new JLabel("Bedrooms");

		// allow for boundries to be set
		JLabel bedroomRangeLabel = new JLabel("<");

		JLabel bathroomLabel = new JLabel("Bathrooms");
		
		JLabel budgetLabel = new JLabel("Budget ($)");

		// place items within a 5-column grid.
		GridBagConstraints gbc;
		// Quadrant menu
		// FocusPanel.addWidgetTo(this, cityQuadLabel, 0, 0, 4, 1, panelLayout);
		// FocusPanel.addWidgetTo(this, cityQuadMenu, 4, 0, 1, 1, panelLayout);
		gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
		add(cityQuadLabel, gbc);
		gbc = FocusPanel.generateConstraints(1, 0, 2, 1);
		add(cityQuadMenu, gbc);

		// House type menu
		// FocusPanel.addWidgetTo(this, houseTypeLabel, 0, 1, 4, 1, panelLayout);
		// FocusPanel.addWidgetTo(this, houseTypeMenu, 4, 1, 1, 1, panelLayout);
		gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
		add(houseTypeLabel, gbc);
		gbc = FocusPanel.generateConstraints(1, 1, 2, 1);
		add(houseTypeMenu, gbc);

		// Bedroom + Bathroom count
		// FocusPanel.addWidgetTo(this, bedroomLabel, 0, 2, 4, 1, panelLayout);
		// FocusPanel.addWidgetTo(this, bedroomInput, 4, 2, 1, 1, panelLayout);
		gbc = FocusPanel.generateConstraints(0, 2, 3, 1);
		add(bedroomLabel, gbc);
		gbc = FocusPanel.generateConstraints(0, 3, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		add(bedroomLower, gbc);
		gbc = FocusPanel.generateConstraints(1, 3, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		add(bedroomRangeLabel, gbc);
		gbc = FocusPanel.generateConstraints(2, 3, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		add(bedroomUpper, gbc);

		// FocusPanel.addWidgetTo(this, bathroomLabel, 0, 3, 4, 1, panelLayout);
		// FocusPanel.addWidgetTo(this, bathroomInput, 4, 3, 1, 1, panelLayout);
		gbc = FocusPanel.generateConstraints(0, 4, 3, 1);
		add(bathroomLabel, gbc);
		gbc = FocusPanel.generateConstraints(0, 5, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.EAST;
		add(bathroomLower, gbc);
		gbc = FocusPanel.generateConstraints(1, 5, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		add(bathroomRangeLabel, gbc);
		gbc = FocusPanel.generateConstraints(2, 5, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		add(bathroomUpper, gbc);
		
		// Budget Max
		gbc = FocusPanel.generateConstraints(0, 6, 3, 1);
		add(budgetLabel, gbc);
		gbc = FocusPanel.generateConstraints(0, 7, 5, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		add(budget, gbc);

		// furnished checkbox
		// FocusPanel.addWidgetTo(this, furnishCheckbox, 0, 4, 5, 1, panelLayout);
		gbc = FocusPanel.generateConstraints(0, 8, 3, 1);
		add(furnishCheckbox, gbc);

		// Search and possibly subscribe buttons
		gbc = FocusPanel.generateConstraints(0, 9, 1, 1);
		searchButton.setActionCommand(SEARCH_BUTTON_ID);
		searchButton.addActionListener(GUI.buttonListener);
		add(searchButton, gbc);
		
		if (registered) {
			gbc = FocusPanel.generateConstraints(2, 9, 1, 1);
			gbc.anchor = GridBagConstraints.WEST;
			subscribeButton.setActionCommand(SUBSCRIBE_BUTTON_ID);
			subscribeButton.addActionListener(GUI.buttonListener);
			add(subscribeButton, gbc);
		}
	}

	public static String getHouseType() {
		return (String) houseTypeMenu.getSelectedItem();// get the selected item as a string
	}
	// JComboBox<String> houseTypeMenu = new JComboBox<String>(housingTypes);

	public static int[] getBedroom() {
		int[] numBedroom = new int[2];
		numBedroom[0] = Integer.parseInt(bedroomLower.getText());
		numBedroom[1] = Integer.parseInt(bedroomUpper.getText());
		return numBedroom;
	}
	// bedroomLower = new JTextField(2); // allow for a 2 digit value
	// JTextField bedroomUpper = new JTextField(2);

	public static String getQuadrant() {
		return (String) cityQuadMenu.getSelectedItem();// get the selected item as a string
	}
	//	JComboBox<String> cityQuadMenu = new JComboBox<String>(QUADRANTS);


	public static int[] getBathroom() {
		int[] numBathroom = new int[2];
		numBathroom[0] = Integer.parseInt(bathroomLower.getText());
		numBathroom[1] = Integer.parseInt(bathroomUpper.getText());
		return numBathroom;
	}
	//	JTextField bathroomLower = new JTextField(2);
	//  JTextField bathroomUpper = new JTextField(2);
	
	public static int getBudget() {
		return Integer.parseInt(budget.getText());
	}//	private static JTextField budget= new JTextField(5); // max = $999,999
	
	public static boolean getIfFurnished() {
		return furnishCheckbox.isSelected();
	}
//	private static JCheckBox furnishCheckbox = new JCheckBox("Furnished");

}
