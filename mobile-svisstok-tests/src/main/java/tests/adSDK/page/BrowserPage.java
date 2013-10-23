package tests.adSDK.page;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class BrowserPage extends BasePage{

	public BrowserPage(NativeDriver driver) {
		this.driver = driver;
	}
	
	public abstract void closeBrowser();

	public abstract void checkPage();

}
