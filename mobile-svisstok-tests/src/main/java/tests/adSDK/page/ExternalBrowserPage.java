package tests.adSDK.page;

import org.apache.log4j.Logger;

import tests.adSDK.page.exceptions.AdSDKToolbarException;

import com.mobile.driver.nativedriver.NativeDriver;

public class ExternalBrowserPage extends BrowserPage{

	private static final Logger LOGGER = Logger.getLogger(ExternalBrowserPage.class);

	public ExternalBrowserPage(NativeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void closeBrowser() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkPage() {
		LOGGER.info("Check Page");
		
		/*if (!toolBar.isExists() || !browserCloseButton.isExists() || !browserMainAdModule.isExists()
				|| !browserSmallAdModule.isExists()) {
			LOGGER.error("Some elements don't exist on InternalBrowserPage");
			makeScreenshot();
			throw new AdSDKToolbarException(
					"AD SDK internal browser page wasn't loaded correctly");
		}*/
		
	}

}
