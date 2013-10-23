package tests.adSDK.page;

import java.awt.Rectangle;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;

import tests.adSDK.page.exceptions.AdSDKLoadException;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.wait.Sleeper;

public class AdvertisingPageIpad extends AdvertisingPage {

	public AdvertisingPageIpad(NativeDriver driver) {
		super(driver);
	}

	private static final Logger LOGGER = Logger
			.getLogger(AdvertisingPageIpad.class);

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView adElement;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]/image[1]")
	private UIView closeButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/image[2]")
	private UIView expandedAd;

	@Override
	public void checkPage() {
		if (!adElement.isExists()) {
			makeScreenshot();
			LOGGER.error("Some elements don't exist on AdvertisingPage");
			throw new AdSDKLoadException("Advertising wasn't loaded correctly");
		}
	}

	public Dimension getSize() {
		try {
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			LOGGER.info("Get size of advertize");
			return adElement.getSize();
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Advertising wasn't loaded correctly");
		} finally {
 			makeScreenshot();
		}
	}

	public void collapseAd() {
		try {
			closeButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			closeButton.touch();
			LOGGER.debug("Collapse AD");
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
		} catch (TimeoutException e) {
			LOGGER.error("Close button isn't found. Can be concerned with bug (expand-collapse on IPHONE doesn't work)");
			throw new AdSDKLoadException("Ad wasn't collapsed.");
		} finally {
			makeScreenshot();
		}
	}

	public void expandAd() {
		try {
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			adElement.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
			LOGGER.debug("Expand AD.");
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Ad wasn't expanded.");
		} finally {
			makeScreenshot();
		}
	}

	public void openAdInBrowser() {
		try {
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			adElement.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
			LOGGER.debug("Open AD in browser.");
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Browser wasn't open.");
		} finally {
			makeScreenshot();
		}
	}
	
	public void openExpandableAdInBrowser() {
		try {
			expandedAd.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			expandedAd.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
			LOGGER.debug("Open AD in browser.");
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Browser wasn't open.");
		} finally {
			makeScreenshot();
		}
	}

	@Override
	public void closeAd() {
		try {
			closeButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			closeButton.touch();
			LOGGER.debug("Close AD");
		} catch (TimeoutException e) {
			LOGGER.error("Close button doesn't exist on page.");
			throw new AdSDKLoadException(
					"AD SDK main page wasn't loaded correctly.");
		} finally {
			makeScreenshot();
		}
	}

	@Override
	public Rectangle getElementLocation() {
		try{
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			LOGGER.info("Get advertize location." );
			return adElement.getLocation();
		} catch(TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Couldn't get ad location.");
		}
	}

	@Override
	public boolean isAdIndecatorVisible() {
		throw new RuntimeException("Doesn't support for this class");
	}
}
