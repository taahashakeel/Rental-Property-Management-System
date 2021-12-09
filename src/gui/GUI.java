/**
 * @author Ethan Sengsavang <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.2
 *  @since 1.0
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
import gui.UnregisteredRenterUI;
import gui.Login;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.util.Stack;

// <<<<<<< HEAD
/*/
public class GUI extends JFrame {
	private static final int INIT_WIDTH = 1000;
	private static final int INIT_HEIGHT = 800;

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
	private int buttonH = 175;

	// button action flag
	private boolean buttonPressed = false;

	public GUI(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		initializeMenuGUI();
		setVisible(true);
	}

  public GUI(){
    this(INIT_WIDTH, INIT_HEIGHT);
  }

	/**
	 * Initialize the current GUI window.
	 *
	 * This will simply create a window to the provided size.
	 */ /*
	void initializeMenuGUI() {

		loginButton = new JButton(transformImage(loginIcon, buttonW, buttonH));
		guestAccessButton = new JButton(transformImage(guestIcon, buttonW, buttonH));

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

	protected ImageIcon transformImage(ImageIcon image, int w, int h) {
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
					if (actionNum == 0) // login
					{
            System.out.println("Login clicked");
						new Login();
					}
					else // guest access go straight to guest UI
					{
            System.out.println("Guest clicked");
						new UnregisteredRenterUI();
					}
				}
			}
		});
	}
// ======= // */
//*
public class GUI extends JFrame{
  private static final int INIT_WIDTH = 600;
  private static final int INIT_HEIGHT = 400;
  private static final String title = "Rental Properties";

  protected static final String BACK_BUTTON_ID = "backButton";

  private int width;
  private int height;

  private GridBagLayout windowLayout;

  private Stack<FocusPanel> panelHistory;
  // panelHistory.peek() would be the panel to display (the top most panel)

  public GUI(int width, int height){
    super();
    this.width = width;
    this.height = height;
    panelHistory = new Stack<FocusPanel>();
    init();
  }

  public GUI(){
    this(INIT_WIDTH, INIT_HEIGHT);
  }

  /**
   * Initialize the current GUI window.
   *
   * This will simply create a window to the provided size.
   */ //*
  private void init(){
    setSize(width, height);
    windowLayout = new GridBagLayout();
    setLayout(windowLayout);

    // set up back button within main GUI
    JButton backButton = new JButton("< Back");
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 0, 1, 1);

    ButtonListener bl = new ButtonListener(this);

    backButton.setActionCommand(BACK_BUTTON_ID);
    backButton.addActionListener(bl);
    add(backButton, gbc);

    FocusPanel currUI = new RegisteredRenterUI();

    setCurrentPanel(currUI);
    setCurrentPanel(new UnregisteredRenterUI());
  }

  /**
   * Sets the panel to view.
   */ //*
  protected void setCurrentPanel(FocusPanel panel){
    if(!panelHistory.empty()) remove(panelHistory.peek());
    panelHistory.push(panel);
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    add(panel, gbc);
    SwingUtilities.updateComponentTreeUI(this);
  }

  /**
   * Pops panelHistory by one element, and update the display with the next
   * element on the stack.
   */
  protected void popHistoryStack(){
    if(panelHistory.size() < 2) return; // do nothing if no history
    FocusPanel currPanel = panelHistory.pop();
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.BOTH;
    remove(currPanel);
    add(panelHistory.peek(), gbc);
    SwingUtilities.updateComponentTreeUI(this);
  } //  */
// >>>>>>> 488ba39a7b6585ae98ed43c0340835d385e600da
}
