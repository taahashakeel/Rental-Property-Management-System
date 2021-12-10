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

import gui.elements.PropertyList;
import gui.elements.PropertyEdit;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ManagerUI extends FocusPanel {
	public static final String GET_SUMMARY_BUTTON = "getSummaryButton";
	private static JTextField months = new JTextField(2); // allow for a 2 digit value

	// private Manager userRepresentation;

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
		JLabel monthsLabel = new JLabel("How many months?");

		// create dummy properties for now.
		PropertyEdit[] dummyList = new PropertyEdit[10];

		String[] statuses = { "Active", "Rented", "Cancelled", "Suspended" };

		for (int i = 0; i < 10; i++) {
			dummyList[i] = new PropertyEdit("415" + i + " Eagle Drive", "NE", "Condo", i % 2 == 0, 415, i,
					statuses[i % 4]);
		}

		PropertyList<PropertyEdit> results = new PropertyList<PropertyEdit>(dummyList);

		// populate window
		GridBagConstraints gbc;

		// Address text feild
		gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
		add(monthsLabel, gbc);
		gbc.anchor = GridBagConstraints.SOUTH;

		gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
//		gbc.weighty = 0;
		gbc.anchor = GridBagConstraints.SOUTH;
//		gbc.anchor = GridBagConstraints.WEST;
		add(months, gbc);

		gbc = FocusPanel.generateConstraints(0, 2, 1, 1);
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		summaryButton.setActionCommand(GET_SUMMARY_BUTTON);
		summaryButton.addActionListener(GUI.buttonListener);
		add(summaryButton, gbc);

		gbc = FocusPanel.generateConstraints(1, 0, 1, 3);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(results, gbc);
	}
}
