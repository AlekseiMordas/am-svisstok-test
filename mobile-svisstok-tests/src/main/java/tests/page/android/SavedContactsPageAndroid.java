package tests.page.android;

import java.awt.Rectangle;

import org.openqa.selenium.By;

import tests.page.SavedContactsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class SavedContactsPageAndroid extends SavedContactsPage {

	public SavedContactsPageAndroid(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-menu-panel']//h1[text()='Удалить']")
	private UIView deleteFromList;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//input[@id='contactsView-search']")
	private UIView searchFiled;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//h1[@id='contactCardView-title']")
	private UIView contactName;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//h1[contains(.,'%s')]")
	private UIView searchedContact;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@data-icon='star']")
	private UIView starButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-menu' and @data-icon='edit']")
	private UIView editContactProfile;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-back']")
	private UIView backButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-call']")
	private UIView callButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsView-btn-filter']")
	private UIView settings;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsView-tab-btn-dialpad']")
	private UIView callTabButton;

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
		return contactName.getAttribute("name");
	}

	public void clickEditContacts() {
		editContactProfile.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		editContactProfile.touch();
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

	public void clickStar() {
		starButton.touch();
	}

	@Override
	public void clickBack() {
		backButton.touch();

	}

	@SuppressWarnings("unchecked")
	public SettingsPageAndroid clickSettings() {
		settings.touch();
		return PageFactory.initElements(driver, SettingsPageAndroid.class);
	}

}
