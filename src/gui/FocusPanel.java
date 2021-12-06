/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * All user-panels will extend this class.
 */
package gui;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public interface FocusPanel extends JPanel{
  private GridBagLayout panelLayout;
  private GridBagConstraints panelConstraints;

  public renderDisplay(GUI frame);
}
