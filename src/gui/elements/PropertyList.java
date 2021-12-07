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

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;

public class PropertyList extends JPanel{
  private ArrayList<JButton> propertyList;

  public PropertyList(){
    super();
    this.propertyList = new ArrayList<JButton>();
  }

  public PropertyList(JButton[] propertyList){
    super();
    this.propertyList = new ArrayList<JButton>(propertyList);
  }

  /**
   * Updates propertyList with a new array of properties to show.
   *
   * @param propertyList A list of buttons representing different properties.
   */
  public void updateList(ArrayList<JButton> propertyList){
    this.propertyList = propertyList;
  }

  /**
   * Updates propertyList with a new array of properties to show.
   *
   * @param propertyList A list of buttons representing different properties.
   */
  public void updateList(JButton[] propertyList){
    this.propertyList = new ArrayList<JButton>(propertyList);
  }
}
