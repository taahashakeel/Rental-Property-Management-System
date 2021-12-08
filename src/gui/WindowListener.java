/**
 * @author Ethan Sengsavang <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * Listens for events that occur to a specific window.
 *
 * More specifically, listen for the event to close the current window.
 */

package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowListener extends WindowAdapter{
  /**
   * Listen for any window closing events.
   */
  public void windowClosing(WindowEvent evt){
    JFrame focusWindow = (JFrame) evt.getWindow();
    focusWindow.setVisible(false);
    focusWindow.dispose();
  }
}
