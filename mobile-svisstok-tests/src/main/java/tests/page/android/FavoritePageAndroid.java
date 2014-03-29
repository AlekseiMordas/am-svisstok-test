package tests.page.android;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tests.page.FavoritePage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.wait.Sleeper;

public class FavoritePageAndroid extends FavoritePage {

	public FavoritePageAndroid(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//input[@id='contactsView-search']")
	private UIView searchFiled;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//ul[@data-role='listview']//h1[text()='Удалить']")
	private UIView deleteFromList;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsView-tab-btn-dialpad']")
	private UIView callTabButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-call']")
	private UIView callingButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-favour-contact']")
	private UIView contactNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//h1[contains(.,'%s')]" +
			"//ancestor::li[contains(@id, 'contactsView-ul-li')]//span[@data-icon='arrow-r']")
	private UIView searchedContact;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@data-icon='edit']")
	private UIView editFromList;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='activeCallView-call-avatar-panlel-status']")
	private UIView timerCall;

	@FindBy(locator = "//a[contains(@class,'ui-btn-color-red')]")
	private UIView cancelCallButton;

	private static final Logger LOGGER = Logger
			.getLogger(FavoritePageAndroid.class);

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
	}

	@Override
	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void clickSearchResult(String name) {
		String locator = String.format(searchedContact.getFoundBy(), name);
		((AppiumDriver) driver).getDriver().findElement(By.xpath(locator)).click();
	}

	@Override
	public String getContactName() {
		return contactNumber.getText();
	}

	@Override
	public void clickEditContacts() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		editFromList.touch();
	}

	@Override
	public void clickDeletefromList() {
		deleteFromList.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		deleteFromList.touch();
	}

	@Override
	public void clickDelete() {
		deleteNumber.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		deleteNumber.touch();
	}

	@Override
	public void clickCall() {
		callTabButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callTabButton.touch();
	}

	@Override
	public void clickCallingButton() {
		callingButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}

	@Override
	public void cancelCall() {
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(cancelCallButton.getFoundBy()));
		elements.get(elements.size() - 1).click();
		LOGGER.info("Click cancel call");
	}

	@Override
	public String getTimer() {
		return timerCall.getText();
	}

}
