package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class SettingsPage extends BasePage {
	
	public SettingsPage(NativeDriver driver) {
		this.driver = driver;
	}
	
	public abstract void setAutoLogin(boolean flag);
	
	public abstract boolean isAutoLoginFlagEnable();
	
	public abstract <T> T clickAllContacts();
	
	public abstract <T> T clickSwisstokContacts();
	
	public abstract <T> T clickBlock();
	
	public abstract <T> T clickFavorite();
	
	public abstract <T> T clickSavedContacts();
}
