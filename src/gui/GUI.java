/**
 * @author Ethan Sengsavang <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * The base GUI frame to be populated with Java AWT Components that perform
 * functions specific to the user who is logged in.
 *
 * Assets to populate the GUI with will be specified by an UserPanel instance
 * found within every user class.
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

public class GUI extends JFrame {
	private static final int INIT_WIDTH = 1000;
	private static final int INIT_HEIGHT = 800;
	private static final String title = "Rental Properties";

	private int width;
	private int height;

	private Container con;
	private JLabel background;
	private JLabel header;
	private JPanel buttons;

	private JButton loginButton;
	private JButton guestAccessButton;

	// background image
	private ImageIcon backgroundImg = new ImageIcon("./images/backgroundMenu.png");

	// button images
	private ImageIcon loginIcon = new ImageIcon("./images/loginButton.png");
	private ImageIcon guestIcon = new ImageIcon("./images/guestButton.png");
	private int buttonW = 280;
	private int buttonH = 150;

	// button action flag
	private boolean buttonPressed = false;

	public GUI(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		loginButton = new JButton(transformImage(loginIcon, buttonW, buttonH));
		guestAccessButton = new JButton(transformImage(guestIcon, buttonW, buttonH));

		initializeMenuGUI();
		setVisible(true);
	}

	/**
	 * Initialize the current GUI window.
	 *
	 * This will simply create a window to the provided size.
	 */
	void initializeMenuGUI() {

		buttons = new JPanel();

		buttons.setOpaque(false);
		// buttons.setLayout(null);

		con = getContentPane();

		getContentPane();
		// con.add(buttons);

		setTitle("Rental Property Management System");
		setSize(width, height);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If window is closed, stop the program
		setLocationRelativeTo(null); // Makes window open in middle of screen

		setBackground();
		setButtons();
	}

	private ImageIcon transformImage(ImageIcon image, int w, int h) {
		Image imageNew = image.getImage(); // transform it
		Image imageTrans = imageNew.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
		ImageIcon newImageIcon = new ImageIcon(imageTrans); // assign to a new ImageIcon instance

		return newImageIcon;
	}

	void setBackground() {
		background = new JLabel(transformImage(backgroundImg, 1000, 800));
		background.setLayout(new GridBagLayout());

		con.add(background);
		// background.add(buttons);
	}

	void setButtons() {
		setButton(loginButton, 100, 100, buttonW, buttonH);
		setButton(guestAccessButton, 0, 200, buttonW, buttonH);

		addButtonListener(loginButton, 0, "login button was pressed!");
		addButtonListener(guestAccessButton, 1, "guest button was pressed");
	}

	void setButton(JButton but, int x, int y, int w, int h) {
		but.setBounds(x, y, w, h);
		but.setBorderPainted(false);
		but.setContentAreaFilled(false);
		but.setOpaque(false);

		buttons.add(but);
		background.add(buttons, new GridBagConstraints());
	}

	void addButtonListener(JButton but, int actionNum, String words) { // not working yet
		but.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!buttonPressed) { // if button has not yet been pressed
					buttonPressed = !buttonPressed; // toggle button pressed
					header.setText(words);
					con.add(header);
				}
			}
		});
	}

}
