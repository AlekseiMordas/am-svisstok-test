package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class SettingsPage extends BasePage {

	public SettingsPage(NativeDriver driver) {
		this.driver = driver;
	}

	public abstract void setAutoLogin(boolean flag);

	public abstract boolean isAutoLoginFlagDisable();

	public abstract CardContactsPage clickAllContacts();

	public abstract CardContactsPage clickSwisstokContacts();

	public abstract BlockPage clickBlock();

	public abstract FavoritePage clickFavorite();

	public abstract SavedContactsPage clickSavedContacts();

	public abstract void setZRTPconnection();

	public abstract void setSRTPconnection();

	public abstract CallPage clickCallTab();

	public abstract void setConnectionByDefault();

	public abstract CardContactsPage clickPhoneBook();
	
	public abstract boolean isBalance(); 
	
	public abstract void clickAboutApp();
	
	public abstract String getUrlAboutApp();
	
	public abstract String getUrlHelp();
	
	public abstract void clickHelp();
	
	public abstract void clickDone();
	
	public abstract void scrollToText(String text);
	
	public abstract void changeLanguageToEnglish();
	
	public abstract void changeLanguageToRussian();
	
	public abstract void clickLanguage();
	
	public abstract String getLanguage();
	
	public abstract void openLogApp();
	
	public abstract boolean validateLogs();

}
