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

import javax.swing.JFrame;

public class GUI extends JFrame{
  private static final int INIT_WIDTH = 600;
  private static final int INIT_HEIGHT = 400;

  private int width;
  private int height;

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
  }
}
