package tests.adSDK.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;

import tests.adSDK.page.exceptions.AdSDKLoadException;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;

public class AdMainPage extends BasePage { 
	
	private static final Logger LOGGER = Logger.getLogger(AdMainPage.class);

	public AdMainPage(NativeDriver driver) {
		this.driver = driver;
	}

	@FindBy(locator = "//textview[1]")
	private UIView logField;
	
	@FindBy(locator = "//window[1]")
	private UIView appWindow;	

	public String getLogFieldText() {
		LOGGER.debug("Get text log");
		return logField.getText();
	}

	@Override
	public void checkPage() {
		if (!logField.isExists()) {
			LOGGER.error("Some elements don't exist on AdMainPage");
			makeScreenshot();
			throw new AdSDKLoadException(
					"AD SDK main page isn't loaded correctly");
		}
		
	}
	
	public Dimension getAppWindowSize(){
		return appWindow.getSize();
	}

}
