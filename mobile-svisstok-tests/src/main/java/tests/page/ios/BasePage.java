package tests.page.ios;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import runner.DeviceConfig;
import runner.Devices;

import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.Page;

public abstract class BasePage extends Page {

	protected static NativeDriver driver;

	protected static final int WAIT_FOR_ELEMENT_TIMEOUT = 10;

	protected static final int WAIT_CONTACTS= 30;
	
	protected static final int WAIT_WHILE_LOGIN = 90;

	protected static final long WAIT_SLEPPER_TIMEOUT = 7000;
	
	protected static final String DEVICE = DeviceConfig.getDevice();

	protected void makeScreenshot() {
		AppiumDriver.class.cast(driver).takeScreenshot("");
	}

	public static boolean checkVisibleText(String element) {
		Pattern p = Pattern.compile("^.+$");
		Matcher m = p.matcher(element);
		return m.matches();
	}

	/**
	 * For Android Implementation
	 * 
	 * @param element
	 * @return
	 */
	public String getFieldText(UIView element) {
		try {
			return element.getText();
		} catch (Exception e) {
			return element.getAttribute("value");
		}
	}

	public void swipe(double startX, double startY, double endX, double endY,
			double duration) {
		if (!Devices.ANDROID.toString().toUpperCase().equals((DeviceConfig.getDevice()))) {
			JavascriptExecutor js = ((AppiumDriver) driver)
					.getDriver();
			HashMap<String, Double> swipeObject = new HashMap<String, Double>();
			swipeObject.put("startX", Double.valueOf(startX));
			swipeObject.put("startY", Double.valueOf(startY));
			swipeObject.put("endX", Double.valueOf(endX));
			swipeObject.put("endY", Double.valueOf(endY));
			swipeObject.put("duration", Double.valueOf(duration));
			js.executeScript("mobile: swipe", new Object[] { swipeObject });
		}
	}
	
	public static void scrollDown(String locator) {
		
		JavascriptExecutor js =((AppiumDriver) driver)
				.getDriver();
		WebElement element = ((AppiumDriver) driver)
				.getDriver().findElementByXPath(locator);
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		scrollObject.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile: scroll", new Object[] { scrollObject });
		
	}
}