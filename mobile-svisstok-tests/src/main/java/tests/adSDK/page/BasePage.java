package tests.adSDK.page;

import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.Page;
import com.mobile.driver.wait.Sleeper;

public abstract class BasePage extends Page{

	protected NativeDriver driver;
		
	protected static final int WAIT_FOR_ELEMENT_TIMEOUT = 5;
	
	protected static final long WAIT_SLEPPER_TIMEOUT = 7000;
	
	protected void makeScreenshot() {
		AppiumDriver.class.cast(driver).takeScreenshot("");
	}
	
	public void setLandscapeOrientation() {
		makeScreenshot();
		driver.setLandscapeOrientation();
		Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
		makeScreenshot();		
	}
	
	public String getOrientation(){
		return AppiumDriver.class.cast(driver).getOrientation();
	}
}
