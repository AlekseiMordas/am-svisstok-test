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

public class AdvertisingPageIphone extends AdvertisingPage {

	public AdvertisingPageIphone(NativeDriver driver) {
		super(driver);
	}

	private static final Logger LOGGER = Logger
			.getLogger(AdvertisingPageIphone.class);

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]/image[1]")
	private UIView adElement;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView closeButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/image[1]")
	private UIView adIndicator;

	@Override
	public void checkPage() {
		if (!adElement.isExists()) {
			makeScreenshot();
			LOGGER.error("Some elements don't exist on AdvertisingPage");
			throw new AdSDKLoadException("Advertising is not loaded correctly");
		}
	}

	public void collapseAd() {
		try {
			closeButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			closeButton.touch();
			LOGGER.debug("Collapse AD");
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
		} catch (TimeoutException e) {
			LOGGER.error("Close button isn't found.");
			throw new AdSDKLoadException("Ad wasn't collapsed.");
		} finally {
			makeScreenshot();
		}
	}

	public void expandAd() {
		try {
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			adElement.touch();
			LOGGER.debug("Expand AD.");
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Ad wasn't expanded.");
		} finally {
			makeScreenshot();
		}
	}

	public void openExpandableAdInBrowser() {
		try {
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			adElement.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
			LOGGER.debug("Open AD in browser.");
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Ad wasn't opened in browser.");
		} finally {
			makeScreenshot();
		}
	}

	public Dimension getSize() {
		try {
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			LOGGER.info("Get size of advertize");
			return adElement.getSize();
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Ad isn't loaded correctly.");
		}

	}

	@Override
	public void closeAd() {
		try {
			closeButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			closeButton.touch();
			LOGGER.info("Close AD");
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found. Can be concerned with bug (expand-collapse on IPHONE doesn't work)");
			throw new AdSDKLoadException("Ad wasn't closed.");
		} finally {
			makeScreenshot();
		}
	}

	@Override
	public Rectangle getElementLocation() {
		try {
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			LOGGER.info("Get advertize location.");
			return adElement.getLocation();
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Couldn't get ad location.");
		}
	}

	@Override
	public void openAdInBrowser() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean isAdIndecatorVisible() {
		return adIndicator.isExists();
	}

}
