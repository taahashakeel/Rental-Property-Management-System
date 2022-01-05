/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * The user interface Managers can view displaying the summary over a set
 * period of time.
 *
 */

package gui;

import gui.elements.SummaryView;
import gui.elements.ElementList;
import gui.elements.PropertyView;

import gui.FocusPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

import gui.elements.PropertyList;
import gui.elements.ElementList;
import gui.elements.PropertyEdit;

import Employee.Property;

public class SummaryUI extends FocusPanel {
	private SummaryView summary;
//	private ArrayList<Property> rented;
	private Property[] listedProperties;
	private int numRented;

	public SummaryUI(int months, int numListed, int numActive, int numRented) {
		super();
		// Create necessary elements
//		this.rented = rented;
		this.numRented = numRented;
		this.summary = new SummaryView(months, numListed, numActive, numRented);
		init();

	}

	/**
	 * Initializes the Landlord graphical user interface for usage.
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// create dummy properties for now.
		listedProperties = new Property[numRented];
		PropertyView[] dummyList = new PropertyView[numRented];

		for (int i = 0; i < numRented; i++) {
			Property currProperty = new Property();

			currProperty.setAddress("415" + "i" + " Eagle Drive");
			currProperty.setQuadrant("NE");
			currProperty.setHouseType("Condo");
			currProperty.setIfFurnished(i % 2 == 0);
			currProperty.setPropertyID("P12");
			currProperty.setRentCost(1000 * i);
			currProperty.setStatus("Active");

			listedProperties[i] = currProperty;
			/*
			 * / dummyList[i] = new PropertyView("415" + i + " Eagle Drive", "NE", "Condo",
			 * i % 2 == 0, 415, i); //
			 */
			dummyList[i] = new PropertyView(currProperty, i);
		}

		ElementList<PropertyView> results = new ElementList<PropertyView>(dummyList);

		// populate window
		GridBagConstraints gbc;
		gbc = generateConstraints(0, 0, 1, 1);
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weighty = 100;
		add(summary, gbc);

		gbc = generateConstraints(0, 1, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(results, gbc);
	}
}