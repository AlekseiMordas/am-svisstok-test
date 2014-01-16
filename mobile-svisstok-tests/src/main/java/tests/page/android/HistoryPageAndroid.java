package tests.page.android;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import tests.page.HistoryPage;

public class HistoryPageAndroid extends HistoryPage {

	public HistoryPageAndroid(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='activeCallView-call-avatar-panlel-status']")
	private UIView timerCall;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//ul[contains(@id,'historyViewul')]//li[1]//h1")
	private UIView firstContact;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@class,'ui-btn-color-red')]")
	private UIView cancelCallButton;
	
	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@id,'historyView-tab-btn-dialpad')]")
	private UIView callTabButton;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickFirstContact() {
		firstContact.touch();
	}

	@Override
	public void cancelCall() {
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(cancelCallButton.getFoundBy()));
		elements.get(elements.size() - 1).click();
	}

	public String getTimer() {
		return timerCall.getText();
	}

	public void clickCall() {
		callTabButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callTabButton.touch();
	}

}
