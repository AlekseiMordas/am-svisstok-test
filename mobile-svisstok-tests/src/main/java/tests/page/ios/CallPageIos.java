package tests.page.ios;

import tests.page.CallPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;

public class CallPageIos extends CallPage{

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[1]")
	public UIView status;
	
	public CallPageIos(NativeDriver driver) {
		super(driver);
	}
	
	@Override
	public void checkPage() {
		status.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		status.getText().equals("LinphoneRegistrationOk");
	}

	@Override
	public boolean isStatusAvailable() {
		// TODO Auto-generated method stub
		return false;
	}

}
