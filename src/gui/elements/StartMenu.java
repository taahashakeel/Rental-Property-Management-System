/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * The user interface all entered users will use when entering the 
 * Rental Property Management sustem
 *
 * Users will have the option to press buttons that will prompt a login 
 * or to enter as a Guest User.
 */

package gui;

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

//	// background image
//	private ImageIcon backgroundImg = new ImageIcon("./images/backgroundMenu.png");
//
//	// button images
//	private ImageIcon loginIcon = new ImageIcon("./images/loginButton.png");
//	private ImageIcon guestIcon = new ImageIcon("./images/guestButton.png");
//	private int buttonW = 280;
//	private int buttonH = 175;

	// button action flag
//	private boolean buttonPressed = false;

	public StartMenu() {
		super();
		init();
//		initializeMenuGUI();
		setVisible(true);
	}

	/**
	 * Initialize the start menu to be used in all UI
	 */
	public void init() {
//		private Container con;
//		private JLabel background;
//		private JLabel header;
//		private JPanel buttons;
//
//		private JButton loginButton;
//		private JButton guestAccessButton;
//		
//		loginButton = new JButton(transformImage(loginIcon, buttonW, buttonH));
//		guestAccessButton = new JButton(transformImage(guestIcon, buttonW, buttonH));
//
//		buttons = new JPanel();
//
//		buttons.setOpaque(false);
//		// buttons.setLayout(null);
//
//		con = getContentPane();
//
//		getContentPane();
//
//		setTitle("Rental Property Management System");
//		setSize(width, height);
//		setResizable(false);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
//		setLocationRelativeTo(null); // Makes window open in middle of screen
//
//		setBackground();
//		setButtons();

		panelLayout = new GridBagLayout();
		setLayout(panelLayout);

//		JButton loginButton = new JButton(transformImage(loginIcon, buttonW, buttonH));
//		JButton guestAccessButton = new JButton(transformImage(guestIcon, buttonW, buttonH));

		JButton loginButton = new JButton("Login");
		JButton guestAccessButton = new JButton("Enter as Guest");
//		JButton guestAccessButton = n

		// place items within a 5-column grid.
		GridBagConstraints gbc;

		// Search and possibly subscribe buttons
		gbc = FocusPanel.generateConstraints(0, 0, 1, 1);
		add(loginButton, gbc);

		gbc = FocusPanel.generateConstraints(2, 1, 1, 1);
//		gbc.anchor = GridBagConstraints.WEST;
		add(guestAccessButton, gbc);
//
//		setBackground();
//		setButtons();
	}

//
//	private ImageIcon transformImage(ImageIcon image, int w, int h) {
//		Image imageNew = image.getImage(); // transform it
//		Image imageTrans = imageNew.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
//		ImageIcon newImageIcon = new ImageIcon(imageTrans); // assign to a new ImageIcon instance
//
//		return newImageIcon;
//	}
//
//	void setBackground() {
//		JLabel background = new JLabel(transformImage(backgroundImg, 1000, 800));
//		background.setLayout(new GridBagLayout());
//
//		gbc = FocuxPanel.generateConstraints(0, 0, 0, 0);
//		add(background);
//	}
//
//	void setButtons() {
//		setButton(loginButton, 100, 100, buttonW, buttonH);
//		setButton(guestAccessButton, 0, 200, buttonW, buttonH);
//
////		addButtonListener(loginButton, 0, "login button was pressed!");
////		addButtonListener(guestAccessButton, 1, "guest button was pressed");
//	}
//
//	void setButton(JButton but, int x, int y, int w, int h) {
//		but.setBounds(x, y, w, h);
//		but.setBorderPainted(false);
//		but.setContentAreaFilled(false);
//		but.setOpaque(false);
//
//		buttons.add(but);
//		background.add(buttons, new GridBagConstraints());
//	}

//	void addButtonListener(JButton but, int actionNum, String words) { // not working yet
//		but.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (!buttonPressed) { // if button has not yet been pressed
//					buttonPressed = !buttonPressed; // toggle button pressed
//					if (actionNum == 0) // login
//					{
////						Login();
//					} else // guest access go straight to guest UI
//					{
//						UnregisteredRenterUI();
//					}
//				}
//			}
//		});
//	}

}
