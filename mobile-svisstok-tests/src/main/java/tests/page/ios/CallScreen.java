package tests.page.ios;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;

public class CallScreen extends BasePage{

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[1]")
	public UIView status;
	
	public CallScreen(NativeDriver driver) {
		this.driver = driver;
	}
	
	@Override
	public void checkPage() {
		status.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		status.getText().equals("LinphoneRegistrationOk");
	}

}
