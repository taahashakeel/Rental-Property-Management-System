/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.0
 *  @since 1.0
 */
package gui;

import gui.elements.LoginMenu;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

public class Login extends FocusPanel {

	private String loginType;
	
	public Login(String loginType) {
		super();
		this.loginType = loginType;
		init();
	}

	/**
	 * Initialize the UI for user.
	 */
	public void init() {
		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

		// Create necessary elements
		LoginMenu loginPanel = new LoginMenu();

		// populate window assuming a 4-column, 5-row grid.
		GridBagConstraints gbc;
		gbc = generateConstraints(0, 0, 1, 1);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 100;
		gbc.weighty = 100;
		add(loginPanel, gbc);
	}

}
