package genericUtilities;

/**
 * This enum store all the tab names of vtiger application
 * @author Vandana
 *
 */

public enum TabNames {
	ORGANIZATIONS("Accounts"), CONTACTS("Contacts"), LEADS("Leads");
	private String tabName;
	
	private TabNames(String tabName)
	{
		this.tabName = tabName;
		
	}
	
	public String getTabName()
	{
		return tabName;
	}
	

}
