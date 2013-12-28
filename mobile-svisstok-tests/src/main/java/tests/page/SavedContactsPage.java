package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class SavedContactsPage extends BasePage{

	public SavedContactsPage(NativeDriver driver) { 
		this.driver = driver;
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
	
    public abstract void searchContacts(String text);
	
	public abstract void clickSearchResult();
	
	public abstract String getContactName();
	
	public abstract void clickEditContacts();
	
	public abstract void clickDeletefromList();
	
	public abstract void clickDelete();
	
	public abstract void clickCall();
	
	public abstract void clickStar();
	
	public abstract void clickBack();
	
	public abstract <T> T clickSettings();
	
}
