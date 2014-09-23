package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class CardContactsPage extends  BasePage{

	public CardContactsPage(NativeDriver driver) { 
		this.driver = driver;
	}

	public abstract void clickAddContacts();
	
	public abstract void clickAddContactsFromList();

	public abstract void inputName(String savedName);
	
	public abstract void inputContact(String contact);
	
	public abstract void clickBack();
	
	public abstract void clickSave();
	
	public abstract String getContactName(String name);
	
	public abstract boolean isContactNumberExist(String name);
	
	public abstract String getContactNumber(String name);
	
	public abstract void clickEditContacts();
	
	public abstract void clickDeletefromList();
	
	public abstract void clickDelete();
	
	public abstract void clickCallTab();
	
	public abstract void clickFirstContact();
	
	public abstract boolean checkVisibleContactNumber(String name);
	
	public abstract boolean checkVisibleContactName(String name);
	
	public abstract boolean checkVisibleListContacts();
	
	public abstract SettingsPage clickSettings();
	
	public abstract void searchContacts(String text);
	
	public abstract <T> T clickSearchResultAndCall(String result);
	
	public abstract <T> T clickSearchResult(String result);
	
	public abstract void clickEditFromList();
	
	public abstract void clickProfile(); 
	
	public abstract String getSecondNumber(String name);
	
	public abstract void secondDelete();
	
	public abstract void deleteNumber(); 
	
	public abstract void inputSecondContact(String text); 
	
	public abstract boolean isMessageDeleteAppears(String message);
	
	public abstract void clickBlockFromList();
	
	public abstract void clickBlock();
	
	public abstract boolean isMessageBlockAppears(String message);
	
	public abstract void clickStar();
	
	public abstract boolean isContactListDownloaded();

	public abstract void callFromContactCard();
	
	public abstract void checkGroupingContacts();
}
