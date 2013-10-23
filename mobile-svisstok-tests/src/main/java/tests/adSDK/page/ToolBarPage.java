package tests.adSDK.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

import tests.adSDK.page.exceptions.AdSDKLoadException;
import tests.adSDK.page.exceptions.AdSDKToolbarException;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;

public class ToolBarPage extends BasePage {

	private static final int WAIT_FOR_ELEMENT_TIMEOUT = 5;

	
	public ToolBarPage(NativeDriver driver) {
		this.driver = driver;
	}

	private static final Logger LOGGER = Logger.getLogger(ToolBarPage.class);

	@FindBy(locator = "//toolbar[1]")
	private UIView toolBar;

	@FindBy(locator = "//toolbar[1]/textfield[1]")
	private UIView urlField;

	@FindBy(locator = "//toolbar[1]/button[1]")
	private UIView goButton;

	@FindBy(locator = "//toolbar[1]/button[2]")
	private UIView clearButton;

	@FindBy(locator = "//toolbar[1]/button[4]")
	private UIView closeButton;

	public void setUrl(String url) {
		try {
			urlField.clear();
			LOGGER.info("Clear Url Field");
			urlField.type(url);
			LOGGER.info("URL typed " + url);
		} catch (TimeoutException e) {
			LOGGER.error("Url Field isn't found.");
			throw new AdSDKLoadException("Toolbar wasn't loaded correctly.");
		} finally {
			makeScreenshot();
		}
	}

	public void clearLog() {
		try {
			clearButton.touch();
			LOGGER.info("Clear Test Log");
		} catch (WebDriverException e) {
			makeScreenshot();
			LOGGER.error("Clear button isn't found. It can be blocked by expanded ad.");
			throw new AdSDKLoadException("Clear button isn't loaded or not found. It can be blocked by expanded ad.");
		}
	}

	public void clickGOButton() {
		try {
			goButton.touch();
			LOGGER.info("Go button pressed.");
		} catch (TimeoutException e) {
			LOGGER.error("Go button isn't found.");
			throw new AdSDKLoadException("Toolbar wasn't loaded correctly.");
		} finally {
			makeScreenshot();
		}
	}

	public void closeBrowser() {
		try {
			closeButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
			closeButton.touch();
			LOGGER.info("Close Browser");
		} catch (TimeoutException e) {
			LOGGER.error("Close button doesn't exist on page");
			throw new AdSDKLoadException(
					"AD SDK main page is not loaded correctly");
		} finally {
			makeScreenshot();
		}
	}

	@Override
	public void checkPage() {
		LOGGER.info("Check Page");
		if (!toolBar.isExists() || !urlField.isExists() || !goButton.isExists()
				|| !clearButton.isExists()) {
			LOGGER.error("Some elements don't exist on ToolBar");
			makeScreenshot();
			throw new AdSDKToolbarException(
					"AD SDK main page is not loaded correctly");
		}

	}

}
