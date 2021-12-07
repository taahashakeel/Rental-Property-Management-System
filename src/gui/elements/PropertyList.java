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

  public PropertyList(JButton[] propertyList){
    super();
    this.propertyList = new ArrayList<JButton>(propertyList);
  }
}
