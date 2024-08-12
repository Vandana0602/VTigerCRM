package TestNGImplementation;

import java.util.Map;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.TabNames;
import objectRepo.CreateNewLeadPage;
import objectRepo.DuplicatingPage;
import objectRepo.LeadInformationPage;
import objectRepo.LeadsPage;

   public class CreateandDuplicateLeadTest extends BaseClass{
	
		@Test(groups = "leads")
		
		public void createAndDuplicateLeadTest() {
			LeadsPage leads = pageObjectManager.getLead();
			CreateNewLeadPage createLead = pageObjectManager.getCreateLead();
			DuplicatingPage duplicateLead = pageObjectManager.getDublicateLead();
			LeadInformationPage leadInfo = pageObjectManager.getLeadInfo();

			home.clicRequiredTab(driverUtil, TabNames.LEADS);

			soft.assertTrue(driver.getTitle().contains("Leads"));

			leads.clickCreateLeadBTN();

			soft.assertTrue(createLead.getPageHeader().equalsIgnoreCase("creating new lead"));
				
			Map<String, String> map = excel.readFromExcel("LeadsTestData", "Create and Duplicate Lead");
			String lastName = map.get("Last Name") + jutil.generateRandomNum(100);
			createLead.setLeadLastName(lastName);
			createLead.setCompanyName(map.get("Company"));
			createLead.clickSaveBTN();

			soft.assertTrue(leadInfo.getPageHeader().contains(lastName));
				
			leadInfo.clickDuplicateBTN();
			soft.assertTrue(duplicateLead.getPageHeader().contains("Duplicating"));
				
			String newLastName = map.get("New Last Name") + jutil.generateRandomNum(100);
			duplicateLead.setLeadLastName(newLastName);
			duplicateLead.clickSaveBTN();

			soft.assertTrue(leadInfo.getPageHeader().contains(newLastName));
			if(leadInfo.getPageHeader().contains(newLastName)) 
				excel.writeToExcel("LeadsTestData", "Create and Duplicate Lead", "Pass");
			else 
				excel.writeToExcel("LeadsTestData", "Create and Duplicate Lead", "Fail");
			soft.assertAll();
		

	}
}
