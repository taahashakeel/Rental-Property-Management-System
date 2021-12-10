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

import gui.elements.PropertyView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

// button listener imports
import gui.elements.StartMenu;
import gui.elements.LoginMenu;
import gui.elements.SearchMenu;
//import gui.elements.InvalidEntryView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import BackEnd.DatabaseController;
//import Renter.RegisteredRenter;
//import Renter.UnregisteredRenter;
//import Employee.Landlord;
//import Employee.Manager;

public class ButtonListener implements ActionListener {
	private GUI mainGui;
	private String userType;
	private boolean usernameInvalid = true;
	// Users
//	private RegisterRenter regRenter;
//	private UnregisteredRenter unregRenter;
//	private Landlord landlord;
//	private Manager manager;

	private Pattern propertyLinkEvent = Pattern.compile(PropertyView.PROPERTY_LINK_ID + "\\d++");

//	private DatabaseController dbConnect;

	public ButtonListener(GUI mainGui) {
		this.mainGui = mainGui;
	}

	/**
	 * Listen for button actions that have been made.
	 *
	 * As all buttons contain an instance of this ButtonListener, this method will
	 * be invoked whenever a button is pressed. As such, this method will need to
	 * determine which button called it and act accordingly.
	 */
	public void actionPerformed(ActionEvent evt) {
		String id = evt.getActionCommand();

		System.out.println("Pressed: id = " + id);

    Matcher m = propertyLinkEvent.matcher(id);
    if(m.matches()){
      // Switch to specified property to view.
      int index = Integer.parseInt(id.substring(PropertyView.PROPERTY_LINK_ID.length()));
      System.out.println("Switching to property " + index);
    }

		switch (id) {
		// Main GUI frame buttons
		case (GUI.BACK_BUTTON_ID):
			mainGui.popHistoryStack();
			break;
//		case (GUI.DATE_BUTTON_ID):
//			mainGui.refreshDate(); // recalls the date function
//			break;
		// Start menu panel buttons
		case (StartMenu.RENTER_BUTTON_ID):
			userType = "renter";
			mainGui.setCurrentPanel(new Login(userType));
			break;
		case (StartMenu.LANDLORD_BUTTON_ID):
			userType = "landlord";
			mainGui.setCurrentPanel(new Login(userType));
			break;
		case (StartMenu.MANAGER_BUTTON_ID):
			userType = "manager";
			mainGui.setCurrentPanel(new Login(userType));
			break;
		case (StartMenu.GUEST_BUTTON_ID):
			userType = "guest";
			mainGui.setCurrentPanel(new UnregisteredRenterUI());
			break;
		// Login menu buttons
		case (LoginMenu.LOGIN_BUTTON_ID):
			String username = LoginMenu.getUsernameField();
			System.out.println("Username: " + username);
			String password = LoginMenu.getPasswordField();
			System.out.println("Password: " + password);
			if (usernameInvalid)
			{
				usernameInvalid = !usernameInvalid;
				System.out.println("Found invalid entry!");
				mainGui.setCurrentPanel(new InvalidLoginUI());
			}
			else if (userType == "renter") {
				usernameInvalid = !usernameInvalid;
//				regRenter = checkUserLogin(username, password, userType);
//				if (regRenter != NULL)
				mainGui.setCurrentPanel(new RegisteredRenterUI());
			} else if (userType == "landlord") {
				usernameInvalid = !usernameInvalid;
//				landlord = checkUserLogin(username, password, userType);
//				if (landlord != NULL)
				mainGui.setCurrentPanel(new LandlordUI());
			} else if (userType == "manager") {
				usernameInvalid = !usernameInvalid;
//				manager = checkUserLogin(username, password, userType);
//				if (manager != NULL)
				mainGui.setCurrentPanel(new ManagerUI());
			}
			break;
		case (SearchMenu.SEARCH_BUTTON_ID):
//			fetchActiveProperty(houseType: String, numBedrooms: int [], numBathrooms: int [], 
//					ifFurnished: boolean, address: String, quadrant: String): Property []);
			break;
		case (SearchMenu.SUBSCRIBE_BUTTON_ID):
			break;
	    case(PropertyDetails.EMAIL_LANDLORD_ID):
	      break;
		}
	}
}
