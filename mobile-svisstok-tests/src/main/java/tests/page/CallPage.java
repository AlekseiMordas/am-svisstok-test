package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class CallPage extends BasePage{

	public CallPage(NativeDriver driver) {
		this.driver = driver;
	}

	public abstract boolean isStatusAvailable();
}
