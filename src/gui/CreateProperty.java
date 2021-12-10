/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * the user interface that the landlord can use to generate new Properties.
 *
 * Within this section, a new property instance will be created by the Landlord
 * that will be associated to whichever landlord created it.
 *
 * Landlords have the ability to specify the following details of a property:
 * - Address
 * - Quadrant
 * - Number of bathrooms
 * - Number of bedrooms
 * - if the property is furnished
 * - Monthy rental cost
 */
package gui;

import Employee.Landlord;
import Employee.Property;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateProperty extends FocusPanel{
  private Landlord propertyOwner;

  public CreateProperty(Landlord propertyOwner){
    this.propertyOwner = propertyOwner;
  }
}
