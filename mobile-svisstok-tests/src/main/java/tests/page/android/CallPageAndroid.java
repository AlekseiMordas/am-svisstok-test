package tests.page.android;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;

import tests.page.CallPage;

public class CallPageAndroid extends CallPage{

	@FindBy(locator="//div[@class='text']")
	private UIView status;
	
	public CallPageAndroid(NativeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isStatusAvailable() {
		return status.isExists();
	}
	
	@Override
	public void checkPage() {
		status.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
	}

}
