package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains elements, locators and respective business  of organizations  
 * @author Vandana
 *
 */
public class OrganizationsPage {
	// Declaration
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement createOrgBTN;
	
	//Initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	
	/**
	 * This method click on the create organization button
	 */
	
	public void clickCreateOrgBTN() {
		createOrgBTN.click();
	}

}
