package tests.page.ios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.Page;

public abstract class BasePage extends Page {

	protected NativeDriver driver;

	protected static final int WAIT_FOR_ELEMENT_TIMEOUT = 10;

	protected static final int WAIT_FOR_AD = 90;

	protected static final long WAIT_SLEPPER_TIMEOUT = 7000;

	protected void makeScreenshot() {
		AppiumDriver.class.cast(driver).takeScreenshot("");
	}

	public String getFieldText(UIView element) {
		try {
			return element.getText();
		} catch (Exception e) {
			return element.getAttribute("value");
		}
	}
}