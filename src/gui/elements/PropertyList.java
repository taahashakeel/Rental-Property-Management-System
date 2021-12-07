/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * This will list core deatils of properties within a list.
 * This list will be composed of multiple boxes with different properties.
 *
 * Each of these properties will be contained within a clickable button, which
 * will update the display to show more details about the property.
 */
package gui.elements;

import gui.FocusPanel;

import java.util.ArrayList;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PropertyList<T extends Component> extends JPanel{
  private ArrayList<T> propertyList;
  private GridBagLayout panelLayout;

  public PropertyList(){
    super();
    this.propertyList = new ArrayList<T>();
  }

  public PropertyList(T[] propertyList){
    super();
    this.propertyList = new ArrayList<T>(propertyList.length);

    for(int index = 0; index < propertyList.length; index++){
      this.propertyList.set(index, propertyList[index]);
    }
  }

  /**
   * Updates propertyList with a new array of properties to show.
   *
   * @param propertyList A list of buttons representing different properties.
   */
  public void updateList(ArrayList<T> propertyList){
    this.propertyList = propertyList;
  }

  /**
   * Updates propertyList with a new array of properties to show.
   *
   * @param propertyList A list of buttons representing different properties.
   */
  public void updateList(T[] propertyList){
    this.propertyList = new ArrayList<T>(propertyList.length);

    for(int index = 0; index < propertyList.length; index++){
      this.propertyList.set(index, propertyList[index]);
    }
  }

  /**
   * Initializes the current property list
   */
  private void init(){
    panelLayout = new GridBagLayout();
    setLayout(panelLayout);
  }

  /**
   * Updates the current list to whatever propertyList is.
   */
  private void update(){
    getContentPane().removeAll();

    // add every property to list
    for(int propertyPos = 0; propertyPos < propertyList.size(); propertyPos++){
      T currProperty = propertyList.get(propertyPos);
      GridBagConstraints gbc = FocusPanel.generateConstraints(0, propertyPos, 1, 1);

      gbc.fill = GridBagConstraints.HORIZONTAL;
      add(currProperty, gbc);
    }
  }
}
