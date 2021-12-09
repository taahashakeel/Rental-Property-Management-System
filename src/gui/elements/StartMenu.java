/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * The user interface all entered users will use when entering the 
 * Rental Property Management system
 *
 * Users will have the option to press buttons that will prompt a login 
 * or to enter as a Guest User.
 */

package gui.elements;

import gui.FocusPanel;

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

public class StartMenu extends JPanel {
	private GridBagLayout panelLayout;
	public static final String LOGIN_BUTTON_ID = "loginButton0";
	public static final String GUEST_BUTTON_ID = "guestButton";

	public StartMenu() {
		super();
		init();
	}

	/**
	 * Initialize the start menu to be used in all UI
	 */
	public void init() {

		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		JButton loginButton = new JButton("Login");
		JButton guestAccessButton = new JButton("Enter as Guest");

		JLabel title = new JLabel("Rental Property Management System");

		// place items on grid.
		GridBagConstraints gbc;

		// Title
		gbc = FocusPanel.generateConstraints(0, 0, 10, 5);
		add(title, gbc);

		// Adding button
		gbc = FocusPanel.generateConstraints(0, 6, 1, 1);
		add(loginButton, gbc);

		gbc = FocusPanel.generateConstraints(1, 6, 1, 1);
		add(guestAccessButton, gbc);
	}

//	/**
//	 * Creates action listeners for the buttons on the start menu
//	 *
//	 * @param startMenuListener
//	 * 
//	 */
//	public void setStartMenuListener(ButtonListener startMenuListener) {
//		loginButton.setActionCommand(LOGIN_BUTTON_ID);
//		loginButton.setActionListener(startMenuListener);
//
//		guestAccessButton.setActionCommand(GUEST_BUTTON_ID);
//		guestAccessButton.setActionListener(startMenuListener);
//	}
}
