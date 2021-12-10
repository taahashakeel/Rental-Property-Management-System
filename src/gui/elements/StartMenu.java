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

import java.awt.Component;
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

	JButton loginRenterButton = new JButton("Renter Login");
	JButton loginLandlordButton = new JButton("Landlord Login");
	JButton loginManagerButton = new JButton("Manager Login");
	JButton guestAccessButton = new JButton("Enter as Guest");

	JLabel title = new JLabel("Rental Property Management System");

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

		// Title
		gbc = FocusPanel.generateConstraints(0, 0, 10, 5);
	    gbc.fill = GridBagConstraints.BOTH;
		add(title, gbc);

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

//	/**
//	 * Creates action listeners for the 4 buttons on the start menu
//	 *
//	 * @param startMenuListener
//	 * 
//	 */
//	public void setStartMenuListener() {
//		loginRenterButton.setActionCommand(RENTER_BUTTON_ID);
//		loginRenterButton.setActionListener(GUI.buttonListener);
//
//		loginLandlordButton.setActionCommand(LANDLORD_BUTTON_ID);
//		loginLandlordButton.setActionListener(GUI.buttonListener);
//
//		loginManagerButton.setActionCommand(MANAGER_BUTTON_ID);
//		loginManagerButton.setActionListener(GUI.buttonListener);
//
//		guestAccessButton.setActionCommand(GUEST_BUTTON_ID);
//		guestAccessButton.setActionListener(GUI.buttonListener);
//	}
}
