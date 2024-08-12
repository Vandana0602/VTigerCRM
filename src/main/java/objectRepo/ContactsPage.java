package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This Class contains elements, locators and respective business libraries of Contacts Page
 * @author Vandana
 *
 */

public class ContactsPage {

	
		// Declaration
		@FindBy(xpath ="//img[@alt='Create Contact...']")
		private WebElement createContactBTN;
		
		//Initialization
		public ContactsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		//utilization
		
		/**
		 * This method click on the create Contact button
		 */
		
		public void clickCreateContactBTN() {
			createContactBTN.click();
		}

			
		}

	

