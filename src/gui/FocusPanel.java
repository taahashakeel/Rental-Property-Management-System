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
import java.awt.Insets;

import javax.swing.JPanel;

public abstract class FocusPanel extends JPanel{
  private static final int PADDING = 5;
  protected GridBagLayout panelLayout;
  protected static GridBagConstraints panelConstraints;

  public FocusPanel(){
    super();

    panelConstraints = new GridBagConstraints();
    panelConstraints.insets = new Insets(PADDING, PADDING, PADDING, PADDING);
    panelConstraints.fill = GridBagConstraints.BOTH;
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
    panelConstraints.anchor = GridBagConstraints.FIRST_LINE_START;

    panelConstraints.gridx = x;
    panelConstraints.gridy = y;
    panelConstraints.gridwidth = w;
    panelConstraints.gridheight = h;
    panelConstraints.weightx = 1;
    panelConstraints.weighty = 1;

    // panelLayout.setConstraints(widget, panelConstraints);
    add(widget, panelConstraints);
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
      GridBagLayout panelLayout){
    panelConstraints.gridx = x;
    panelConstraints.gridy = y;
    panelConstraints.gridwidth = w;
    panelConstraints.gridheight = h;

    panelConstraints.anchor = (x == 0)? GridBagConstraints.WEST : GridBagConstraints.EAST;

    panel.add(widget, panelConstraints);
  }
}
