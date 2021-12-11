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

import gui.FocusPanel;
import gui.ButtonListener;
import gui.GUI;

import gui.elements.ElementList;
import gui.elements.PropertyEdit;

import Employee.Property;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ManagerUI extends FocusPanel {
	// private Manager userRepresentation;
	private Property[] listedProperties;
	public static final int LIST_SIZE = 9;
	public static final String GET_SUMMARY_BUTTON = "getSummaryButton";
//	private static JTextField months = new JTextField(5); // allow for a 2 digit value

	private static final String[] MONTHS = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
	private static JComboBox<String> monthsMenu = new JComboBox<String>(MONTHS);

	public ManagerUI() {
		super();
		init();
	}

	/**
	 * Initializes the Landlord graphical user interface for usage.
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// Create elements
		JButton summaryButton = new JButton("Generate Summary");
		JLabel monthsLabel = new JLabel("How many months?", JLabel.CENTER);

		String[] statuses = { "Active", "Rented", "Cancelled", "Suspended" };

		// create dummy properties for now.
		listedProperties = new Property[LIST_SIZE];
		PropertyEdit[] dummyList = new PropertyEdit[LIST_SIZE];

		for (int i = 0; i < LIST_SIZE; i++) {
			Property currProperty = new Property();

			currProperty.setAddress("415" + "i" + " Eagle Drive");
			currProperty.setQuadrant("NE");
			currProperty.setHouseType("Condo");
			currProperty.setIfFurnished(0);
			currProperty.setPropertyID("P12");
			currProperty.setStatus(statuses[i % 4]);

			listedProperties[i] = currProperty;
			/*
			 * / dummyList[i] = new PropertyView("415" + i + " Eagle Drive", "NE", "Condo",
			 * i % 2 == 0, 415, i); //
			 */
			dummyList[i] = new PropertyEdit(currProperty, i);
		}

		ElementList<PropertyEdit> results = new ElementList<PropertyEdit>(dummyList);

		// populate window
		GridBagConstraints gbc;

		// monthsLabel drop down menu
		gbc = FocusPanel.generateConstraints(0, 0, 2, 1);
		add(monthsLabel, gbc);

		gbc = FocusPanel.generateConstraints(0, 1, 2, 1);
		add(monthsMenu, gbc);

		gbc = FocusPanel.generateConstraints(0, 2, 2, 1);
		gbc.weighty = 0;
//		gbc.fill = GridBagConstraints.NONE;
		gbc.anchor = GridBagConstraints.CENTER;
		summaryButton.setActionCommand(GET_SUMMARY_BUTTON);
		summaryButton.addActionListener(GUI.buttonListener);
		add(summaryButton, gbc);

		gbc = FocusPanel.generateConstraints(0, 3, 2, 2);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(results, gbc);
	}

	public static String getMonths() {
		return (String) monthsMenu.getSelectedItem();
	}
}
