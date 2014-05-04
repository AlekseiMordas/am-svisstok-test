package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class FavoritePage extends BasePage{

	public FavoritePage(NativeDriver driver) { 
		this.driver = driver;
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
	
    public abstract void searchContacts(String text);
	
	public abstract void clickSearchResult(String name);
	
	public abstract String getContactName();
	
	public abstract void clickEditContacts();
	
	public abstract void clickDeletefromList();
	
	public abstract void clickDelete();
	
	public abstract void clickCall();
	
	public abstract void clickCallingButton();
	
	public abstract void cancelCall();
	
	public abstract String getTimer();
	
	public abstract void deleteAllCalls();

	public abstract void  openFirstContact();
 	
}
