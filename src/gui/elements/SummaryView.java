/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * Panel that shows the summary over a specified number of months 
 * for a Manager to view.
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import gui.elements.PropertyList;
import gui.elements.ElementList;
import gui.elements.PropertyEdit;

import Employee.Property;


package gui.elements;

public class SummaryView extends JPanel  {
	private GridBagLayout panelLayout;
	private int months;

	public SummaryView(int months) {
		super();
		this.months = months;
		init();
	}

	/**
	 * Initialize the summary view for Manager
	 */
	private void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// Labels
		JLabel summaryLabel = new JLabel("RPMS Summary", JLabel.CENTER);
        intro.setForeground(Color.BLACK);
        intro.setFont(new Font("Avenir", Font.PLAIN, 30));

		JLabel descriptionLabel = new JLabel("Over the past " + months + "months: ", JLabel.CENTER);
        intro.setForeground(Color.GRAY);
        intro.setFont(new Font("Avenir", Font.PLAIN, 15));
        
        

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
		usernameField.setActionCommand(USERNAME_INPUT_ID);
		usernameField.addActionListener(GUI.buttonListener);
		add(usernameField, gbc);

		gbc = FocusPanel.generateConstraints(1, 2, 2, 1);
		gbc.fill = GridBagConstraints.NONE;
		passwordField.setActionCommand(PASSWORD_INPUT_ID);
		passwordField.addActionListener(GUI.buttonListener);
		add(passwordField, gbc);

		// Adding button
		gbc = FocusPanel.generateConstraints(0, 3, 3, 1);
		loginButton.setActionCommand(LOGIN_BUTTON_ID);
		loginButton.addActionListener(GUI.buttonListener);
		add(loginButton, gbc);
//	setLoginListener();
	}

}

	public static String getUsernameField() {
		return usernameField.getText();
	}

public static String getPasswordField() {
	return String.valueOf(passwordField.getPassword());
}