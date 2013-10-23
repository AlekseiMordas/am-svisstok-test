package tests.adSDK.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;

import tests.adSDK.page.exceptions.AdSDKLoadException;
import tests.adSDK.page.exceptions.AdSDKToolbarException;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.wait.Sleeper;

public class InternalBrowserPage extends BrowserPage{
	
	private static final Logger LOGGER = Logger.getLogger(InternalBrowserPage.class);

	public InternalBrowserPage(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//window[1]/toolbar[1]")
	private UIView toolBar;

	@FindBy(locator = "//window[1]/toolbar[1]/button[1]")
	private UIView rightArrowButton;

	@FindBy(locator = "//window[1]/toolbar[1]/button[2]")
	private UIView leftArrowButton;

	@FindBy(locator = "//window[1]/toolbar[1]/button[3]")
	private UIView reloadButton;

	@FindBy(locator = "//window[1]/toolbar[1]/button[4]")
	private UIView browserCloseButton;
	
	@FindBy(locator = "//window[1]/toolbar[1]/button[4]")
	private UIView browserMainAdModule;
			
	@FindBy(locator = "//window[1]/toolbar[1]/button[4]")
	private UIView browserSmallAdModule;
	
	public void closeBrowser() {
		try {
			browserCloseButton.waitImplicitly(WAIT_FOR_ELEMENT_TIMEOUT);
			browserCloseButton.touch();
			LOGGER.info("Close Internal Browser");
			Sleeper.SYSTEM_SLEEPER.sleep(WAIT_SLEPPER_TIMEOUT);
		} catch (TimeoutException e) {
			LOGGER.error("Browser close button isn't found.");
			throw new AdSDKLoadException("Browser wasn't closed.");
		} finally {
			makeScreenshot();
		}
	}

	@Override
	public void checkPage() {
		LOGGER.info("Check Page");
		if (!toolBar.isExists() || !browserCloseButton.isExists() || !browserMainAdModule.isExists()
				|| !browserSmallAdModule.isExists()) {
			LOGGER.error("Some elements don't exist on InternalBrowserPage");
			makeScreenshot();
			throw new AdSDKToolbarException(
					"AD SDK internal browser page wasn't loaded correctly");
		}
	}
}
