package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class SettingsPage extends BasePage {
	
	public SettingsPage(NativeDriver driver) {
		this.driver = driver;
	}
	
	public abstract void setAutoLogin(boolean flag);
	
	public abstract boolean isAutoLoginFlagEnable();
}
