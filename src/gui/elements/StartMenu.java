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
import gui.ButtonListener;
import gui.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartMenu extends JPanel {
	private GridBagLayout panelLayout;
	public static final String RENTER_BUTTON_ID = "loginRenterButton";
	public static final String LANDLORD_BUTTON_ID = "loginLandlordButton";
	public static final String MANAGER_BUTTON_ID = "loginManagerButton";
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

		// place items on grid.
		GridBagConstraints gbc;

		// creating buttons
		JButton loginRenterButton = new JButton("Renter Login");
		JButton loginLandlordButton = new JButton("Landlord Login");
		JButton loginManagerButton = new JButton("Manager Login");
		JButton guestAccessButton = new JButton("Enter as Guest");

		// creating Labels
		JLabel intro = new JLabel("WELCOME TO", JLabel.CENTER);
        intro.setForeground(Color.GRAY);
        intro.setFont(new Font("Avenir", Font.PLAIN, 12));

		JLabel title = new JLabel("The Rental Property Management System", JLabel.CENTER);
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Avenir", Font.PLAIN, 30));

		JLabel projectInfo = new JLabel("Fall 2021 ENSF 480 Final Project", JLabel.CENTER);
		projectInfo.setForeground(Color.DARK_GRAY);
		projectInfo.setFont(new Font("Avenir", Font.PLAIN, 15));
		
		JLabel authorInfo = new JLabel("Created by Rachel Renegado, Alexander Sembrat, "
				+ "Ethan Sengsavang, and Muhammad Shakeel", JLabel.CENTER);
		authorInfo.setForeground(Color.DARK_GRAY);
		authorInfo.setFont(new Font("Avenir", Font.PLAIN, 12));
		
		JLabel instructions = new JLabel("Please choose one of the below options to enter:", JLabel.CENTER);
		instructions.setForeground(Color.RED);
		instructions.setFont(new Font("Avenir", Font.PLAIN, 12));


		// Labels
		gbc = FocusPanel.generateConstraints(0, 0, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(intro, gbc);

		gbc = FocusPanel.generateConstraints(0, 1, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(title, gbc);
		
		gbc = FocusPanel.generateConstraints(0, 2, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(projectInfo, gbc);
		
		gbc = FocusPanel.generateConstraints(0, 3, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(authorInfo, gbc);
		
		gbc = FocusPanel.generateConstraints(0, 5, 4, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(instructions, gbc);

		// Adding buttons
		gbc = FocusPanel.generateConstraints(0, 6, 1, 1);
		loginRenterButton.setActionCommand(RENTER_BUTTON_ID);
		loginRenterButton.addActionListener(GUI.buttonListener);
		add(loginRenterButton, gbc);

		gbc = FocusPanel.generateConstraints(1, 6, 1, 1);
		loginLandlordButton.setActionCommand(LANDLORD_BUTTON_ID);
		loginLandlordButton.addActionListener(GUI.buttonListener);
		add(loginLandlordButton, gbc);

		gbc = FocusPanel.generateConstraints(2, 6, 1, 1);
		loginManagerButton.setActionCommand(MANAGER_BUTTON_ID);
		loginManagerButton.addActionListener(GUI.buttonListener);
		add(loginManagerButton, gbc);

		gbc = FocusPanel.generateConstraints(3, 6, 1, 1);
		guestAccessButton.setActionCommand(GUEST_BUTTON_ID);
		guestAccessButton.addActionListener(GUI.buttonListener);
		add(guestAccessButton, gbc);
	}
}
