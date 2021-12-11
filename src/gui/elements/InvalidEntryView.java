/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * If a user input an incorrect username or password, they will be sent here. 
 */

package gui.elements;

import gui.FocusPanel;
import gui.ButtonListener;
import gui.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class InvalidEntryView extends JPanel{
	private GridBagLayout panelLayout;
	
	public InvalidEntryView() {
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
		JLabel invalidMessage = new JLabel("Invalid login. Please click 'back' and try again.", JLabel.CENTER);
		invalidMessage.setForeground(Color.RED);
		invalidMessage.setFont(new Font("Avenir", Font.PLAIN, 30)); 
		
		// place items on grid.
		GridBagConstraints gbc;

		// Adding Labels
		gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		add(invalidMessage, gbc);
	}
}