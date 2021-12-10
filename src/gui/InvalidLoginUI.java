/**
 * @author Rachel Renegado
 * <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 *
 * The user interface users trying to login will view if they put in 
 * incorrect login information that is not in the database.
 *
 */

package gui;

import gui.elements.InvalidEntryView;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;

public class InvalidLoginUI extends FocusPanel{

	  public InvalidLoginUI(){
	    super();
	    init();
	  }

	  /**
	   * Initializes the Landlord graphical user interface for usage.
	   */
	  private void init(){
	    panelLayout = new GridBagLayout();
	    setLayout(panelLayout);

	    // Create necessary elements
	    InvalidEntryView invalid = new InvalidEntryView();

	    // populate window
	    GridBagConstraints gbc;
	    gbc = generateConstraints(0, 0, 1, 1);
	    add(invalid, gbc);
	  }
}
