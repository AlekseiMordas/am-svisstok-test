package tests.adSDK.page;

import org.apache.log4j.Logger;

import tests.adSDK.page.exceptions.AdSDKLoadException;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;

public class BumperPage extends BasePage {

	private static final Logger LOGGER = Logger
			.getLogger(InternalBrowserPage.class);

	private static long BUMPER_WAIT = 5000;

	private static final String BUMPER_TEXT = "Remember:";

	public BumperPage(NativeDriver driver) {
		this.driver = driver;
	}

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[3]")
	public UIView bumper;

	public boolean isBumperExistFiveSeconds() {
		long time = System.currentTimeMillis();
		while (bumper.isExists() && bumper.getText().equals(BUMPER_TEXT)) {
			LOGGER.info("Bumper shows");
		}
		long endTime = System.currentTimeMillis();
		if (endTime - time > BUMPER_WAIT) {
			throw new AdSDKLoadException("Bumper shows more than 5 seconds");
		}
		return true;
	}

	public boolean isBumperVisible() {
		return bumper.getText().equals(BUMPER_TEXT);
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

}
