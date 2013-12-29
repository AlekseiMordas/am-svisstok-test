package tests.page.android;

import java.awt.Rectangle;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import tests.page.FavoritePage;

public class FavoritePageAndroid extends FavoritePage{

	public FavoritePageAndroid(NativeDriver driver) {
		super(driver);
	}
	@FindBy(locator = "//input[@id='contactsView-search']")
	private UIView searchFiled;

	@FindBy(locator = "//ul[@data-role='listview']//h1[text()='Удалить']")
	private UIView deleteFromList;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "//a[@id='contactsView-tab-btn-dialpad']")
	private UIView callTabButton;

	@FindBy(locator = "//a[@id='contactCardView-btn-call']")
	private UIView callingButton;
	
	@FindBy(locator = "//h1[@id='contactCardView-title']")
	private UIView contactName;

	@FindBy(locator = "//h1[contains(.,'%s')]")
	private UIView searchedContact;

	@FindBy(locator = "//a[@data-icon='edit']")
	private UIView editFromList;	
	
	@FindBy(locator = "//div[@id='activeCallView-call-avatar-panlel-status']")
	private UIView timerCall;
	
	@FindBy(locator = "//a[contains(@class,'ui-btn-color-red')]")
	private UIView cancelCallButton;
	
	private static final Logger LOGGER = Logger
			.getLogger(FavoritePageAndroid.class);

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
	}
	
	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void clickSearchResult(String name) {
		((AppiumDriver) driver)
				.getDriver()
				.findElement(
						By.xpath(String.format(searchedContact.getFoundBy(),
								name))).click();
	}

	public String getContactName() {
		return contactName.getText();
	}

	public void clickEditContacts() {
		System.out.println(((AppiumDriver)driver).getDriver().getPageSource());
		editFromList.touch();
	}

	public void clickDeletefromList() {
		deleteFromList.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		deleteFromList.touch();
	}

	public void clickDelete() {
		deleteNumber.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		deleteNumber.touch();
	}
	
	
	public void clickCall() {
		callTabButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callTabButton.touch();
	}
	
	public void clickCallingButton(){
		callingButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
	
	public void cancelCall() {
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(cancelCallButton.getFoundBy()));
		elements.get(elements.size() - 1).click();
		LOGGER.info("Click cancel call");
	}
	
	public String getTimer() {
		return timerCall.getText();
	}



}
