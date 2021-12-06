/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * The user interface an unregistered renter will view when they enter the
 * application.
 *
 * Unregistered renters should have the ability to search for and view
 * listed properties.
 */
package gui;

import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class UnregisteredRenterUI extends FocusPanel{
  private static final int PADDING = 5;

  public UnregisteredRenterUI(){
    super();
    init();
  }

  /**
   * Initialize the current user interface for unregistered renters.
   */
  public void init(){
    panelLayout = new GridBagLayout();
    panelConstraints = new GridBagConstraints();
    panelConstraints.insets = new Insets(PADDING, PADDING, PADDING, PADDING);
  }

  @Override
  public void renderDisplay(GUI frame){
    return;
  }
}
