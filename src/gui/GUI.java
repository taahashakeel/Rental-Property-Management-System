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

import javax.swing.JFrame;

public class GUI extends JFrame{
  private static final int INIT_WIDTH = 600;
  private static final int INIT_HEIGHT = 400;
  private static final String title = "Rental Properties";

  private int width;
  private int height;

  private FocusPanel currentPanel;

  public GUI(int width, int height){
    super();
    this.width = width;
    this.height = height;
    init();
  }

  public GUI(){
    this(INIT_WIDTH, INIT_HEIGHT);
  }

  /**
   * Initialize the current GUI window.
   *
   * This will simply create a window to the provided size.
   */
  private void init(){
    setSize(width, height);

    UnregisteredRenterUI currUI = new UnregisteredRenterUI();

    setCurrentPanel(currUI);
  }

  /**
   * Sets the panel to view.
   */
  public void setCurrentPanel(FocusPanel panel){
    if(currentPanel != null) remove(currentPanel);
    currentPanel = panel;
    add(currentPanel);
  }
}
