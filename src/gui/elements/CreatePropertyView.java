/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * The Landlord user interface for when they wish to create a new property
 * to be added to the RPMS
 *
 * Landlord has the ability to make changes before the property is saved
 * to the database
 */

package gui.elements;

import gui.FocusPanel;
import gui.ButtonListener;
import gui.GUI;

import java.awt.Color;
import java.awt.Font;
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

public class CreatePropertyView extends JPanel {

	private GridBagLayout panelLayout;
	private boolean registered;
	public static final String SAVE_BUTTON_ID = "saveButton1";

	private static final String[] QUADRANTS = { "NE", "NW", "SW", "SE" };
	private static String[] housingTypes = { "Apartment", "Attached House", "Detached House", "Townhouse", "Condo" };

	// Feilds that collect user input
	private static JComboBox<String> cityQuadMenu = new JComboBox<String>(QUADRANTS);
	private static JComboBox<String> houseTypeMenu = new JComboBox<String>(housingTypes);
	private static JTextField bedrooms = new JTextField(2); // allow for a 2 digit value
	private static JTextField bathrooms = new JTextField(2);
	private static JTextField costField = new JTextField(5); // max = $999,999
	private static JTextField addressField = new JTextField(20); // allow for a 2 digit value

	// Checkboxes
	private static JCheckBox furnishCheckbox = new JCheckBox("Furnished");

	public CreatePropertyView() {
		super();
		init();
	}

	/**
	 * Initializes the property creation view to be used within a landlord user
	 * interface.
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// Populate CreatePropertyView with necessary elements
		JLabel instructLabel1 = new JLabel("Please fill in below fields and click save when ready to submit the property for approval.", JLabel.CENTER);
		instructLabel1.setForeground(Color.BLACK);
		instructLabel1.setFont(new Font("Avenir", Font.PLAIN, 12));
		
		JLabel instructLabel2 = new JLabel("You can expect an email notifying you of your property approval and your property fee in the next 3 days.", JLabel.CENTER);
		instructLabel2.setForeground(Color.GRAY);
		instructLabel2.setFont(new Font("Avenir", Font.PLAIN, 10));
		
		JLabel addressLabel = new JLabel("Address: ");

		JLabel houseTypeLabel = new JLabel("Housing type: ");

		JLabel cityQuadLabel = new JLabel("City Quadrant: ");

		// Numeric menus
		JLabel bedroomLabel = new JLabel("Number of Bedrooms: ");

		JLabel bathroomLabel = new JLabel("Number of Bathrooms: ");

		JLabel costLabel = new JLabel("Cost of Rent($) :");

		JButton saveButton = new JButton("Save Property");

		// place items within a 5-column grid.
		GridBagConstraints gbc;
		
		// Instructions
		gbc = FocusPanel.generateConstraints(0, 0, 2, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(instructLabel1, gbc);

		gbc = FocusPanel.generateConstraints(0, 1, 2, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(instructLabel2, gbc);
		
		// Address text feild
		gbc = FocusPanel.generateConstraints(0, 2, 1, 1);
		add(addressLabel, gbc);
		gbc = FocusPanel.generateConstraints(1, 2, 2, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		add(addressField, gbc);
		
		// Quadrant drop menu
		gbc = FocusPanel.generateConstraints(0, 3, 1, 1);
		add(cityQuadLabel, gbc);
		gbc = FocusPanel.generateConstraints(1, 3, 2, 1);
		add(cityQuadMenu, gbc);

		// House type drop down menu
		gbc = FocusPanel.generateConstraints(0, 4, 1, 1);
		add(houseTypeLabel, gbc);
		gbc = FocusPanel.generateConstraints(1, 4, 2, 1);
		add(houseTypeMenu, gbc);

		// Number of bedrooms text feild
		gbc = FocusPanel.generateConstraints(0, 5, 1, 1);
		add(bedroomLabel, gbc);
		gbc = FocusPanel.generateConstraints(1, 5, 2, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		add(bedrooms, gbc);

		// Number of bathrooms text feild
		gbc = FocusPanel.generateConstraints(0, 6, 1, 1);
		add(bathroomLabel, gbc);
		gbc = FocusPanel.generateConstraints(1, 6, 2, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		add(bathrooms, gbc);

		// Cost of rent
		gbc = FocusPanel.generateConstraints(0, 7, 1, 1);
		add(costLabel, gbc);
		gbc = FocusPanel.generateConstraints(1, 7, 2, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.WEST;
		add(costField, gbc);

		// furnished checkbox
		// FocusPanel.addWidgetTo(this, furnishCheckbox, 0, 4, 5, 1, panelLayout);
		gbc = FocusPanel.generateConstraints(0, 8, 2, 1);
		gbc.anchor = GridBagConstraints.CENTER;
		add(furnishCheckbox, gbc);

		// Save button
		gbc = FocusPanel.generateConstraints(0, 9, 2, 1);
		saveButton.setActionCommand(SAVE_BUTTON_ID);
		saveButton.addActionListener(GUI.buttonListener);
		gbc.anchor = GridBagConstraints.CENTER;
		add(saveButton, gbc);
	}

	public static String getAddress() {
		return addressField.getText();
	}
	
	public static String getHouseType() {
		return (String) houseTypeMenu.getSelectedItem();// get the selected item as a string
	}
	// JComboBox<String> houseTypeMenu = new JComboBox<String>(housingTypes);

	public static int getBedroom() {
		return Integer.parseInt(bedrooms.getText());
	}
	// bedroomLower = new JTextField(2); // allow for a 2 digit value
	// JTextField bedroomUpper = new JTextField(2);

	public static String getQuadrant() {
		return (String) cityQuadMenu.getSelectedItem();// get the selected item as a string
	}
	// JComboBox<String> cityQuadMenu = new JComboBox<String>(QUADRANTS);

	public static int getBathroom() {
		return Integer.parseInt(bathrooms.getText());
	}
	// JTextField bathroomLower = new JTextField(2);
	// JTextField bathroomUpper = new JTextField(2);

	public static int getCost() {
		return Integer.parseInt(costField.getText());
	}// private static JTextField budget= new JTextField(5); // max = $999,999

	public static boolean getIfFurnished() {
		return furnishCheckbox.isSelected();
	}
//		private static JCheckBox furnishCheckbox = new JCheckBox("Furnished");

}
