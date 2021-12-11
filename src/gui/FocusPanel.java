/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * All user-panels will extend this class.
 */
package gui;

import Employee.Property;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Image;

import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public abstract class FocusPanel extends JPanel{
  private static final int PADDING = 5;
  protected GridBagLayout panelLayout;
  protected static GridBagConstraints panelConstraints;
  protected Property[] listedProperties;

  public FocusPanel(){
    super();
  }

  /**
   * Generates grid bag constraints with provided values.
   *
   * @param x The horizontal index wihtin a grid to place a widget
   * @param y The vertical index within a grid to place a widget
   * @param w The number of grid cells the widget takes up horizontally
   * @param h The number of grid cells the widget takes up vertically
   *
   * @return The grid bag constraints to add the widget with or modify
   */
  public static GridBagConstraints generateConstraints(int x, int y, int w, int h){
    panelConstraints = new GridBagConstraints();
    panelConstraints.insets = new Insets(PADDING, PADDING, PADDING, PADDING);
    panelConstraints.fill = GridBagConstraints.BOTH;

    panelConstraints.gridx = x;
    panelConstraints.gridy = y;
    panelConstraints.gridwidth = w;
    panelConstraints.gridheight = h;

    panelConstraints.gridx = x;
    panelConstraints.gridy = y;
    panelConstraints.gridwidth = w;
    panelConstraints.gridheight = h;

    return panelConstraints;
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
    panelConstraints = new GridBagConstraints();
    panelConstraints.insets = new Insets(PADDING, PADDING, PADDING, PADDING);
    panelConstraints.fill = GridBagConstraints.BOTH;
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
    panelConstraints.anchor = (x == 0)? GridBagConstraints.WEST : GridBagConstraints.EAST;

    panel.add(widget, panelConstraints);
  }

  /**
   * Transforms and scales an ImageIcon to a specified width and height
   *
   * This method is made static such that any element is able to use it.
   *
   * @param image The image to be resized
   * @param w The desired width of the image.
   * @param h The desired height of the image.
   * 
   * @return The resized ImageIcon
   */
  protected static ImageIcon transformImage(ImageIcon image, int w, int h) {
    Image imageNew = image.getImage(); // transform it
    Image imageTrans = imageNew.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH); // scale it smoothly
    ImageIcon newImageIcon = new ImageIcon(imageTrans); // assign to a new ImageIcon instance

    return newImageIcon;
  }

  /**
   * Gets the Property wihin listedProperties at the provided index.
   *
   * @param index the index to fetch values from.
   */
  public Property getProperty(int index){
    return listedProperties[index];
  }
}
