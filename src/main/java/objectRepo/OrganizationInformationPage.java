package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	//Declaration
	@FindBy(css="span.dvHeaderText")
	private WebElement pageHeard;
	
	@FindBy(xpath="//input[@name='Delete']")
	private WebElement deleteBTN;
	
	//Initialization
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	/**
	 * This method fetches the Page header 
	 * @return
	 */
	public String getPageHeader()
	{
		return pageHeard.getText();
	}
	
	/**
	 * This method is used to click on delete button 
	 */
	
	public void DeleteBTN() {
		deleteBTN.click();
	}

	
	

}
