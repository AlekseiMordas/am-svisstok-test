package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class SettingsPage extends BasePage {

	public SettingsPage(NativeDriver driver) {
		this.driver = driver;
	}

	public abstract void setAutoLogin(boolean flag);

	public abstract boolean isAutoLoginFlagDisable();

	public abstract <T> T clickAllContacts();

	public abstract <T> T clickSwisstokContacts();

	public abstract <T> T clickBlock();

	public abstract <T> T clickFavorite();

	public abstract <T> T clickSavedContacts();

	public abstract void setZRTPconnection();

	public abstract void setSRTPconnection();

	public abstract CallPage clickCallTab();

	public abstract void setConnectionByDefault();

	public abstract <T> T clickPhoneBook();
	
	public abstract boolean isBalance(); 
	
	public abstract void clickAboutApp();
	
	public abstract String getUrlAboutApp();
	
	public abstract String getUrlHelp();
	
	public abstract void clickHelp();
	
	public abstract void clickDone();

}
