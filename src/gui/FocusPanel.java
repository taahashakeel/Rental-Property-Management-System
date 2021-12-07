/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * All user-panels will extend this class.
 */
package gui;

import java.awt.Component;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public abstract class FocusPanel extends JPanel{
  protected GridBagLayout panelLayout;
  protected GridBagConstraints panelConstraints;

  public FocusPanel(){
    super();
  }

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

  /**
   * Adds a specified widget into the panel at the specified position
   * and size.
   *
   * This method is made static such that any element is able to use it.
   *
   * @param widget The widget to add within the window
   * @param x The horizontal index within the grid to place the widget at.
   * @param y The vertical index within the grid to place the widget at.
   * @param w The width of the widget.
   * @param h The height of the widget.
   * @param panelConstraints The grid constraints of the panel to add the
   * widget to.
   * @param panelLayout The GridBagLayout panel to add the widget to.
   */
  public static void addWidgetTo(
      JPanel panel,
      Component widget,
      int x,
      int y,
      int w,
      int h,
      GridBagConstraints panelConstraints,
      GridBagLayout panelLayout){
    panelConstraints.gridx = x;
    panelConstraints.gridy = y;
    panelConstraints.gridwidth = w;
    panelConstraints.gridheight = h;

    panelConstraints.anchor = (x == 0)? GridBagConstraints.WEST : GridBagConstraints.EAST;

    panelLayout.setConstraints(widget, panelConstraints);
    panel.add(widget);
  }
}
