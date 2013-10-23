package tests.adSDK.page.nonmraid;

import java.awt.Rectangle;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.wait.Sleeper;

import tests.adSDK.page.AdvertisingPage;
import tests.adSDK.page.AdvertisingPageIpad;
import tests.adSDK.page.exceptions.AdSDKLoadException;

public class AdvertisingPageIpadNonMraid extends AdvertisingPage{

	public AdvertisingPageIpadNonMraid(NativeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	private static final Logger LOGGER = Logger
			.getLogger(AdvertisingPageIpad.class);

	@FindBy(locator = "//window[1]/scrollview[2]/webview[1]/link[1]/image[1]")
	private UIView adElement;
	
	@FindBy(locator = "//window[1]/scrollview[2]/webview[1]/link[2]")
	private UIView closeButton;
	
	@FindBy(locator = "//window[1]/scrollview[2]/webview[1]/image[1]")
	private UIView adIndicator;
	
	@Override
	public void checkPage() {
		if (!adElement.isExists()) {
			makeScreenshot();
			LOGGER.error("Some elements don't exist on AdvertisingPage");
			throw new AdSDKLoadException("Advertising wasn't loaded correctly");
		}
	}

	@Override
	public boolean isAdIndecatorVisible() {
		return adIndicator.isExists();
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

	public void openAdInBrowser() {
		try {
			adElement.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			adElement.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
			LOGGER.debug("Open AD in browser.");
		} catch (TimeoutException e) {
			LOGGER.error("Ad isn't found.");
			throw new AdSDKLoadException("Browser wasn't open.");
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
	public void collapseAd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void expandAd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void openExpandableAdInBrowser() {
		// TODO Auto-generated method stub
		
	}
}
