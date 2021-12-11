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

import Employee.Property;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;

// button listener imports
import gui.elements.StartMenu;
import gui.elements.LoginMenu;
import gui.elements.SearchMenu;
import gui.elements.CreatePropertyView;
import gui.elements.PropertyView;
import gui.elements.PropertyEdit;

import BackEnd.EmailSystem;

//import gui.elements.InvalidEntryView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

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
      FocusPanel currPanel = mainGui.getCurrentPanel();
      Property selectedProperty = currPanel.getProperty(index);
      boolean landlord = (boolean) (currPanel instanceof LandlordUI); // bad practice but oh well
      mainGui.setCurrentPanel(new PropertyDetails(selectedProperty, !landlord));
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
			if (usernameInvalid) {
				usernameInvalid = !usernameInvalid;
				System.out.println("Found invalid entry!");
				mainGui.setCurrentPanel(new InvalidLoginUI());
			} else if (userType == "renter") {
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
			
		// Search Menu actions
		case (SearchMenu.SEARCH_BUTTON_ID):
//			fetchActiveProperty(SearchMenu.getHouseType(), SearchMenu.getBedroom(), SearchMenu.getBathroom(), 
//					SearchMenu.getIfFurnished(), SearchMenu.getQuadrant): Property []);
			break;
		case (SearchMenu.SUBSCRIBE_BUTTON_ID):
			JOptionPane.showMessageDialog(mainGui, "You have been subscribed to the current search criteria!");

			break;
		case (PropertyDetails.EMAIL_LANDLORD_ID):
			if (EmailSystem.sendEmail("ensf480Landlord1@gmail.com", "ensf480Renter1@gmail.com", PropertyDetails.getMessage(), PropertyDetails.getSubject()) ) 
					JOptionPane.showMessageDialog(mainGui, "Email sent successfully!");
			else 
				JOptionPane.showMessageDialog(mainGui, "Email send failure!");
			break;
		
		// LandlordUI
		case (LandlordUI.CREATE_PROP_BUTTON):
			mainGui.setCurrentPanel(new CreatePropertyUI());
			break;
		case (CreatePropertyView.SAVE_BUTTON_ID):
			mainGui.popHistoryStack();
			JOptionPane.showMessageDialog(mainGui, "Property saved successfully!");
			// creating a property to be displayed and saved to database

			break;
		case (PropertyEdit.STATUS_BUTTON_ID):
			// if ()
			JOptionPane.showMessageDialog(mainGui, "Status changed successfully!");
			break;

		// ManagerUI
		case (ManagerUI.GET_SUMMARY_BUTTON):
			int months = Integer.parseInt(ManagerUI.getMonths());
			if (months == 6) {
//			Property[] p = new Property[5];
//			for (Property prop: p)
//			{
//				
//			}
				mainGui.setCurrentPanel(new SummaryUI(months, 11, 11, 5));
//			public SummaryUI(int months, int numListed, int numActive, int numRented, ArrayList<Property> rented) {
			} else if (months == 3)
//			Property[] p = new Property[2];
				mainGui.setCurrentPanel(new SummaryUI(months, 6, 6, 2));
			break;
		}
	}
}
