package tests.adSDK.page.preferences;

import org.apache.log4j.Logger;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import tests.adSDK.page.BasePage;

public class PreferencesPage extends BasePage {

	public PreferencesPage(NativeDriver driver) {
		this.driver = driver;
	}

	private static final Logger LOGGER = Logger
			.getLogger(PreferencesPage.class);

	@FindBy(locator = "//window[1]/tableview[1]/cell[2]")
	private UIView generalButton;

	@FindBy(locator = "//window[1]/tableview[1]/cell[2]")
	private UIView keyboardButton;

	@FindBy(locator = "//window[1]/tableview[1]/cell[2]/switch[1]")
	private UIView autocorrectSwitch;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	public void setUserPreferences() {
		LOGGER.info("Disable auto-correct in iOS Settings");
		generalButton.touch();
		keyboardButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		keyboardButton.touch();
		autocorrectSwitch.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		autocorrectSwitch.touch();
		autocorrectSwitch.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
	}

}
