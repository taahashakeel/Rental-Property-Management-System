/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * The user interface registred users will use to login to the 
 * Rental Property Management System (RPMS).
 *
 * Users can input their username and password. Once vaidated, they will have
 * appropriate access to the RPMS according to their role (Manager, Landlord, 
 * or Registered Reneter)
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

public class LoginMenu extends JPanel {
	private GridBagLayout panelLayout;
	public static final String LOGIN_BUTTON_ID = "loginButton1";
	public static final String USERNAME_INPUT_ID = "usernameInput";
	public static final String PASSWORD_INPUT_ID = "passwordInput";

	public LoginMenu() {
		super();
		init();
	}

	/**
	 * Initialize the login menu to be used in all users who have an account
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		
		// Labels
		JLabel welcomeLabel = new JLabel("Welcome to the Rental Property Management System!");
		JLabel usernameLabel = new JLabel("Username");
		JLabel passwordLabel = new JLabel("Password");

		// Text Feilds - allow for 15 value max
		JTextField usernameFeild = new JTextField(10);
		JTextField passwordFeild = new JTextField(10);

		// Button
		JButton loginButton = new JButton("Login");

		// place items on grid.
		GridBagConstraints gbc;

		// Adding Labels
		gbc = FocusPanel.generateConstraints(0, 0, 3, 1);
		add(welcomeLabel, gbc);
		gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
		add(usernameLabel, gbc);
		gbc = FocusPanel.generateConstraints(0, 2, 1, 1);
		add(passwordLabel, gbc);

		// Adding text feilds
		gbc = FocusPanel.generateConstraints(1, 1, 2, 1);
		gbc.fill = GridBagConstraints.NONE;
		add(usernameFeild, gbc);
		gbc = FocusPanel.generateConstraints(1, 2, 2, 1);
		gbc.fill = GridBagConstraints.NONE;
		add(passwordFeild, gbc);

		// Adding button
		gbc = FocusPanel.generateConstraints(0, 3, 3, 1);
		add(loginButton, gbc);

	}
//	/**
//	 * Creates action listeners for the actions on the login menu
//	 *
//	 * @param startMenuListener
//	 * 
//	 */
//	public void setLoginListener(ButtonListener loginListener) {
//		usernameFeild.setActionCommand(USERNAME_INPUT_ID);
//		usernameFeild.setActionListener(startMenuListener);
//		
//		passwordFeild.setActionCommand(PASSWORD_INPUT_ID);
//		passwordFeild.setActionListener(startMenuListener);
//	
//		loginButton.setActionCommand(LOGIN_BUTTON_ID);
//		loginButton.setActionListener(startMenuListener);
//	}
}