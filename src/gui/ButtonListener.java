/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * This listener will listen for any necessary button presses and then call
 * methods that correspond to the actions the button has.
 *
 * Most often, ButtonListener instances will call methods within GUI, which
 * will all appropreate class methods as necessary.
 *
 * all buttons will contain their own button listener instance.
 *
 * eg.
 * Selecting a property to view:
 * 1. user presses button
 * 2. listener reacts to event and calls method in GUI
 * 3. gui creates and uses a PropertyDetails instance.
 *
 * eg.
 * Subscribing to a search criteria:
 * 1. user presses button
 * 2. listener reacts to event and calls method in GUI
 * 3. GUI calls method within panel instance
 * 4. Panel instance invokes "saveSearchCriteria" in RegisteredRenter instance.
 */
package gui;

import java.awt.ActionEvent;
import java.awt.ActionListener;
import java.awt.Component;

public class ButtonListener extends ActionListener{
  private GUI mainGui;

  public ButtonListener(GUI mainGui){
    this.mainGui = mainGui;
  }
}
