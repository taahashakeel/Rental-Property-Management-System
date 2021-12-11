/**
 * @author Ethan Sengsavang <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.0
 *  @since 1.0
 *
 * The base GUI frame to be populated with Java AWT Components that perform
 * functions specific to the user who is logged in.
 *
 * Assets to populate the GUI with will be specified by an UserPanel instance
 * found within every user class.
 */

package gui;

// for Date
import java.text.SimpleDateFormat;
import java.util.Calendar;

import gui.UnregisteredRenterUI;
import gui.Login;
import gui.StartUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.util.Stack;

// For window closing 
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class GUI extends JFrame {
	private static final int INIT_WIDTH = 600;
	private static final int INIT_HEIGHT = 400;
	private static final String title = "Rental Properties";

	protected static final String BACK_BUTTON_ID = "backButton";
//	protected static final String DATE_BUTTON_ID = "dateButton";

	public static ButtonListener buttonListener;

	private JButton backButton;
	private JLabel dateLabel;
	private JButton dateRefreshButton;

	private int width;
	private int height;

	private GridBagLayout windowLayout;

	private Stack<FocusPanel> panelHistory;

	// panelHistory.peek() would be the panel to display (the top most panel)

	private static String date; // used for date

	public GUI(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		panelHistory = new Stack<FocusPanel>();
		buttonListener = new ButtonListener(this);
		getDate();
		init();
	}

	public GUI() {
		this(INIT_WIDTH, INIT_HEIGHT);
	}

	/**
	 * Initialize the current GUI window.
	 *
	 * This will simply create a window to the provided size.
	 */ // *
	private void init() {
		setSize(width, height);
		setTitle("Rental Property Management System");
		windowLayout = new GridBagLayout();
		setLayout(windowLayout);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		GridBagConstraints gbc;

		// set up back button within main GUI
		backButton = new JButton("< Back");
		gbc = FocusPanel.generateConstraints(0, 0, 1, 1);

		backButton.setActionCommand(BACK_BUTTON_ID);
		backButton.addActionListener(buttonListener);
		add(backButton, gbc);

		// set up date label within main gui
		dateLabel = new JLabel("Today's date is:" + date);
		dateLabel.setForeground(Color.BLACK);
		dateLabel.setFont(new Font("Avenir", Font.PLAIN, 10));

		gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;
		add(dateLabel, gbc);

		FocusPanel currUI = new StartUI();

		setCurrentPanel(currUI);
	}

	/**
	 * Sets the panel to view.
	 */ // *
	protected void setCurrentPanel(FocusPanel panel) {
		if (!panelHistory.empty())
			remove(panelHistory.peek());
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
	protected void popHistoryStack() {
		if (panelHistory.size() < 2)
			return; // do nothing if no history
		FocusPanel currPanel = panelHistory.pop();
		GridBagConstraints gbc;
		gbc = FocusPanel.generateConstraints(0, 1, 1, 1);
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		remove(currPanel);
		add(panelHistory.peek(), gbc);
		SwingUtilities.updateComponentTreeUI(this);
	} //

	/**
	   * Returns the top-most panel
	   */
	  protected FocusPanel getCurrentPanel(){
	    return panelHistory.peek();
	  }

	/**
	 * Generates the current date
	 */
	protected void getDate() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		date = sdf.format(cal.getTime());
		System.out.println("Today's date is: " + date);
	}
}
