/**
 * @author Ethan Sengsavang
 * <a href="mailto:ethan.sengsavang@ucalgary.ca">email</a>
 *
 * This page will show all the details for a specified property.
 *
 * Property details will contain all information about a property with exception
 * to:
 * - feePaid
 * - landlord id
 *
 * possibility:
 * ~~~~~~~~~~~
 * All other data attributes are going to be visible to Renters. If a landlord
 * or manager views the page (when entering from their respective UI, they
 * should have access to edit the details of the property as needed.
 */
package gui;

public class PropertyDetails extends FocusPanel{
  // private Property focusProperty;

  public PropertyDetails(){
    super();
  }
}
