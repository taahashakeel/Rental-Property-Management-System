
/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * Panel that shows the summary over a specified number of months 
 * for a Manager to view.
 *
 */
package gui.elements;

import gui.FocusPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.elements.ElementList;
import gui.elements.PropertyEdit;

import Employee.Property;

public class SummaryView extends JPanel {
	private GridBagLayout panelLayout;
	private int months;
	private int numListed;
	private int numRented;
	private int numActive;

	public SummaryView(int months, int numListed, int numActive, int numRented) {
		super();
		this.months = months;
		this.numListed = numListed;
		this.numRented = numRented;
		this.numActive = numActive;
		this.numRented = numRented;
		init();
	}

	/**
	 * Initialize the summary view for Manager
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// place items within a 5-column grid.
		GridBagConstraints gbc;

		// Labels
		JLabel summaryLabel = new JLabel("RPMS Summary", JLabel.CENTER);
		summaryLabel.setForeground(Color.BLACK);
		summaryLabel.setFont(new Font("Avenir", Font.PLAIN, 30));

		JLabel descriptionLabel = new JLabel("Over the past " + months + " months: ", JLabel.CENTER);
		descriptionLabel.setForeground(Color.BLACK);
		descriptionLabel.setFont(new Font("Avenir", Font.PLAIN, 15));

		// Summary labels
		JLabel rentedLabel = new JLabel(" - Total number of house rented = " + numRented, JLabel.LEFT);
		rentedLabel.setForeground(Color.GRAY);
		rentedLabel.setFont(new Font("Avenir", Font.PLAIN, 12));

		JLabel activeLabel = new JLabel(" - Total number of house active = " + numActive, JLabel.LEFT);
		activeLabel.setForeground(Color.GRAY);
		activeLabel.setFont(new Font("Avenir", Font.PLAIN, 12));
		
		JLabel listedLabel = new JLabel(" - Total number of house listings = " + numListed, JLabel.LEFT);
		listedLabel.setForeground(Color.GRAY);
		listedLabel.setFont(new Font("Avenir", Font.PLAIN, 12));

		// Adding Labels
		gbc = FocusPanel.generateConstraints(0, 0, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(summaryLabel, gbc);

		gbc = FocusPanel.generateConstraints(0, 1, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(descriptionLabel, gbc);

		gbc = FocusPanel.generateConstraints(0, 2, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(listedLabel, gbc);

		gbc = FocusPanel.generateConstraints(0, 3, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(activeLabel, gbc);

		gbc = FocusPanel.generateConstraints(0, 5, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(rentedLabel, gbc);
	}
}
