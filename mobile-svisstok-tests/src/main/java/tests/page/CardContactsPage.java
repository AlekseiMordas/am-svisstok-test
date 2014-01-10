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
	
	public abstract String getContactName();
	
	public abstract String getContactNumber();
	
	public abstract void clickEditContacts();
	
	public abstract void clickDeletefromList();
	
	public abstract void clickDelete();
	
	public abstract void clickCall();
	
	public abstract void clickFirstContact();
	
	public abstract boolean checkVisibleContactNumber();
	
	public abstract boolean checkVisibleContactName();
	
	public abstract boolean checkVisibleListContacts();
	
	public abstract <T> T clickSettings();
	
	public abstract void searchContacts(String text);
	
	public abstract <T> T clickSearchResultAndCall(String result);
	
	public abstract void clickEditFromList();
	
	public abstract void clickProfile(); 
	
	public abstract String getSecondNumber(String name);
	
	public abstract void secondDelete();
	
	public abstract void deleteNumber(); 
	
	public abstract void inputSecondContact(String text); 
	
	public abstract String getMessageDelete();
	
	public abstract void clickBlockFromList();
	
	public abstract void clickBlock();
	
	public abstract String getMessageBlock();
	
	public abstract void clickStar();
}
