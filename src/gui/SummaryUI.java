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

	public SummaryUI(int months, int numListed, int numRented, ) {
		super();
		// Create necessary elements
		SummaryView summary = new SummaryView(months, numListed, numRented, 
				ArrayList<Property> active);
		init();
	}

	/**
	 * Initializes the Landlord graphical user interface for usage.
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// populate window assuming a 4-column, 5-row grid.
		GridBagConstraints gbc;
		gbc = generateConstraints(0, 0, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(summary, gbc);
	}
}