/**
 * @author Taaha Shakeel <a href="mailto:muhammad.shakeel1@ucalgary.ca">email</a>
 * 
 *  @version 1.0 
 *  @since 1.0
 *  
 *  
 */
package Renter;
import Services.SearchCriteria;
import BackEnd.DatabaseController;
import BackEnd.EmailSystem;

public class UnregisteredRenter {

	private DatabaseController dbControl;
	private SearchCriteria search;
	private EmailSystem email;
	 
	 public UnregisteredRenter()
	 {
		this.dbControl = new DatabaseController();
	 }
	////
	 public void createSearchCriteria()
	 {
		 SearchCriteria search = new SearchCriteria();
	 }
	 
}
