package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreatingNewContactPage {
	
	//Declaration
	
	@FindBy(xpath= "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name="lastname")
	private WebElement contactLastNameTF;
	
	@FindBy(xpath ="//input[contains(@title,'Save')]")
	private WebElement saveBTN;
	
	@FindBy(xpath="//img[contains(@onclick,'Accounts')]")
	private WebElement organizationPluseBTN;
	
	private String organizationPath="//a[text()='%s']";
	
	
	
	//Initialization
	
	
	public CreatingNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	/**
	 * This method fetches the Page harder 
	 * @return
	 */
	public String getPageHeader()
	{
		return pageHeader.getText();
	}
	
	/**
	 * This method sets the organization name into the contact last  Name text field
	 * @param name
	 */
	
	public void setContactnName(String name)
	{
		contactLastNameTF.sendKeys(name);
	}
	
	/**
	 * This method click on save button
	 */
	public void clickSaveBTN() 
	{
		saveBTN.click();
	}
	
	public void selectExistingOrganization(WebDriverUtility driverutil, String orgName) {
		organizationPluseBTN.click();
		driverutil.switchToWindow("Accounts");
		driverutil.convertDynamicXpathToWebElement(organizationPath, orgName).click();
		driverutil.switchToWindow("Contacts");
	
}

	

}
