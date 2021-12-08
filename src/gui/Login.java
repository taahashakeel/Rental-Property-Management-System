/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.0
 *  @since 1.0
 */

package gui;

import java.awt.Component;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.tools.StandardJavaFileManager.PathFactory;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.JFrame;

public class Login extends GUI {
	private static final int INIT_WIDTH = 1000;
	private static final int INIT_HEIGHT = 800;

	private int width;
	private int height;
	
	private Container con;
	private JLabel background;
	private JLabel header;
	private JPanel buttons;

	private static JLabel password1, label;
	private static JTextField username;
	private static JPasswordField password;

	private JButton loginButton;

	// background image
	private ImageIcon backgroundImg = new ImageIcon("./images/blankBackground.png");

	// button images
	private ImageIcon loginIcon = new ImageIcon("./images/loginButton.png");
	private int buttonW = 280;
	private int buttonH = 175;

	// button action flag
	private boolean buttonPressed = false;

	public Login() {
		super();
		initializeLoginGUI();
		setVisible(true);
	}
	
	/**
	 * Initialize the current GUI window.
	 *
	 * This will simply create a window to the provided size.
	 */
	void initializeLoginGUI() {

		loginButton = new JButton(transformImage(loginIcon, buttonW, buttonH));

		buttons = new JPanel();

		buttons.setOpaque(false);

		con = getContentPane();

		getContentPane();

		setTitle("Login Page");
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
		setLocationRelativeTo(null); // Makes window open in middle of screen

		setBackground();
		setScreen();
	}

	
	@Override
	void setBackground() {
		background = new JLabel(transformImage(backgroundImg, 1000, 800));
		background.setLayout(new GridBagLayout());

		con.add(background);
	}
	
	void setScreen()
	{
		// Username label constructor
		label = new JLabel("Username");
		label.setBounds(100, 8, 70, 20);
		background.add(label);
		
		// Username TextField constructor
		username = new JTextField();
		username.setBounds(100, 27, 193, 28);
		background.add(username);
		
		// Password Label constructor
		password1 = new JLabel("Password");
		password1.setBounds(100, 55, 70, 20);
		background.add(password1);
		
		// Password TextField
		password = new JPasswordField();
		password.setBounds(100, 75, 193, 28);
		background.add(password);
		
		// Button constructor
		loginButton = new JButton("Login");
		loginButton.setBounds(100, 110, 90, 25);
		loginButton.setForeground(Color.WHITE);
		loginButton.setBackground(Color.BLACK);
		// loginButton.addActionListener((ActionListener) new Java_GUI());
		background.add(loginButton);
	}
	
	// Imlementing an action event listener class with conditional statement
	// @Override
	public void actionPerformed(ActionEvent e) {
		String Username = username.getText();
		String Password1 = password.getText();

		if (Username.equals("rachel") && Password1.equals("renegado"))
			JOptionPane.showMessageDialog(null, "Login Successful");
		else
			JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
	}

}
