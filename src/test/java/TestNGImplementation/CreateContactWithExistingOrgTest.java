package TestNGImplementation;

import java.util.Map;


import org.testng.annotations.Test;

import genericUtilities.BaseClass;

import genericUtilities.TabNames;

import objectRepo.ContactInformationPage;
import objectRepo.ContactsPage;
import objectRepo.CreatingNewContactPage;

public class CreateContactWithExistingOrgTest extends BaseClass
{
    @Test(groups="contacts")
	public void createContact()
	{
		
		ContactsPage contact = pageObjectManager.getContact();
		CreatingNewContactPage createContact = pageObjectManager.getCreateContact();
		ContactInformationPage contactInfo = pageObjectManager.getContactInfo();
		
		home.clicRequiredTab(driverUtil, TabNames.CONTACTS);
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		
		contact.clickCreateContactBTN();
		
		soft.assertTrue(createContact.getPageHeader().equalsIgnoreCase("Creating new contact"));
			
		Map<String, String> map = excel.readFromExcel("ContactsTestData", "Create Contact With Organization");
		
		createContact.setContactnName(map.get("Last Name"));
		createContact.selectExistingOrganization(driverUtil, map.get("Organization Name"));
		
		createContact.clickSaveBTN();
				
		soft.assertTrue(contactInfo.getPageHeader().contains(map.get("Last Name")));
		
		contactInfo.clickDeleteBTN();
		driverUtil.handleAlert("ok");
		
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		if(driver.getTitle().contains("Contacts")) {
			
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Pass");
		}
		else {
			driverUtil.quitAllWindows();
			excel.writeToExcel("ContactsTestData", "Create Contact With Organization", "Fail");
		}
		
		soft.assertAll();
	}

}