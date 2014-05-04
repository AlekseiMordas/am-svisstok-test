package tests.page;

import tests.page.android.CallPageAndroid;
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

	public abstract <T> T clickCall();

	public abstract void setConnectionByDefault();

}
