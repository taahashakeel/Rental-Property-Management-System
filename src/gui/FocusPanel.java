/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * All user-panels will extend this class.
 */
package gui;

import javax.swing.Component;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public abstract class FocusPanel extends JPanel{
  protected GridBagLayout panelLayout;
  protected GridBagConstraints panelConstraints;

  public FocusPanel(){
    super();
  }

  public abstract void renderDisplay(GUI frame);

  /**
   * Adds a specified widget into the panel at the specified position
   * and size.
   *
   * @param widget The widget to add within the window
   * @param x The horizontal index within the grid to place the widget at.
   * @param y The vertical index within the grid to place the widget at.
   * @param w The width of the widget.
   * @param h The height of the widget.
   */
  public void addWidget(Component widget, int x, int y, int w, int h){
    panelConstraints.gridx = x;
    panelConstraints.gridy = y;
    panelConstraints.gridwidth = w;
    panelConstraints.gridheight = h;

    panelLayout.setConstraints(widget, panelConstraints);
    add(widget);
  }
}
