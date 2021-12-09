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


	public StartMenu() {
		super();
		init();
		setVisible(true);
	}

	/**
	 * Initialize the start menu to be used in all UI
	 */
	public void init() {

		panelLayout = new GridBagLayout();
		setLayout(panelLayout);
		JButton loginButton = new JButton("Login");
		JButton guestAccessButton = new JButton("Enter as Guest");
		
		Jlabel title = new JLabel("Rental Property Management System" + date, JLabel.CENTER);
//		title.setForeground(Color.black);
//		title.setBounds(125, 120, 350, 40);
//		title.setFont(new Font("Avenir", Font.PLAIN, 12)); 

		// place items within a 5-column grid.
		GridBagConstraints gbc;
		
		// Title
	    gbc = FocusPanel.generateConstraints(0, 0, 10, 20);
	    add(title, gbc);
	    
		// Search and possibly subscribe buttons
		gbc = FocusPanel.generateConstraints(0, 1, 5, 3);
		add(loginButton, gbc);

		gbc = FocusPanel.generateConstraints(1, 1, 5, 3);
		add(guestAccessButton, gbc);
	}
}
