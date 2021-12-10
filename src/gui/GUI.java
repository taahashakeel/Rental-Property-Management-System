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

//import java.awt.Component;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.concurrent.Flow;
//import javax.swing.*;
//import java.awt.image.BufferedImage;
//import javax.swing.JComponent;
//import javax.tools.StandardJavaFileManager.PathFactory;
//import javax.imageio.ImageIO;
//import java.io.IOException;
//import java.io.File;

import gui.UnregisteredRenterUI;
import gui.Login;
import gui.StartUI;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.util.Stack;

// For window closing 
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;

public class GUI extends JFrame{
  private static final int INIT_WIDTH = 600;
  private static final int INIT_HEIGHT = 400;
  private static final String title = "Rental Properties";

  protected static final String BACK_BUTTON_ID = "backButton";
  public static ButtonListener buttonListener;

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
    buttonListener = new ButtonListener(this);
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
    addWindowListener(new WindowAdapter() {
    	@Override
    	public void windowClosing(WindowEvent e) {
    		System.exit(0);
    	}
    });

    // set up back button within main GUI
    JButton backButton = new JButton("< Back");
    GridBagConstraints gbc;
    gbc = FocusPanel.generateConstraints(0, 0, 1, 1);

    backButton.setActionCommand(BACK_BUTTON_ID);
    backButton.addActionListener(buttonListener);
    add(backButton, gbc);

    FocusPanel currUI = new StartUI();

    setCurrentPanel(currUI);
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
  } // 
}
