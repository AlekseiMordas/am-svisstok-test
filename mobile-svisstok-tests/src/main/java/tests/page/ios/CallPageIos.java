package tests.page.ios;

import tests.page.CallPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;

public class CallPageIos extends CallPage{

	@FindBy(locator = "LinphoneRegistrationOk")
	public UIView status;
	
	public CallPageIos(NativeDriver driver) {
		super(driver);
	}
	
	@Override
	public void checkPage() {
		status.waitForElementByName(WAIT_WHILE_LOGIN);
	}

	@Override
	public boolean isStatusAvailable() {
		// TODO Auto-generated method stub
		return true;
	}

}
