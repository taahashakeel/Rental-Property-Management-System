/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * The user interface all users will view when they enter the
 * application.
 *
 * Users have the ability to choose to login or enter the RPMS as
 * guest
 */
package gui;

import gui.elements.StartMenu;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class StartUI extends FocusPanel {
	public StartUI() {
		super();
		init();
	}

	/**
	 * Initialize the UI for user.
	 */
	public void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// Create necessary elements
		StartMenu start = new StartMenu();

		// populate window assuming a 4-column, 5-row grid.
		GridBagConstraints gbc;
		gbc = generateConstraints(0, 0, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(start, gbc);
	}
}
