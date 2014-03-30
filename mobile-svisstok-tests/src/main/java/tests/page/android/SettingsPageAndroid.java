package tests.page.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tests.page.SettingsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;

public class SettingsPageAndroid extends SettingsPage {

	private static final String ACTIVE_PAGE = "//div[contains(@class,'ui-page-active')]";

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//select[@id='settingsView-form-autoLogin']/ancestor::div[@class='right']")
	private UIView autoLoginSlider;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-ALL']")
	private UIView allContactsButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-SWISSTOK']")
	private UIView swisstokContacts;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-BLOCKED']")
	private UIView blockedContacts;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-FAVOUR']")
	private UIView favourContacts;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-SAVED']")
	private UIView savedContacts;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//select[@id='settingsView-form-encryption']")
	private UIView enctyptionDropdown;

	@FindBy(locator = ACTIVE_PAGE
			+ "//a[contains(@id,'settingsView-tab-btn-dialpad')]")
	private UIView callTabButton;

	public SettingsPageAndroid(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void checkPage() {
	}

	@Override
	public void setAutoLogin(boolean flag) {
		if (flag) {
			if (autoLoginSlider.getText().equals("Нет")) {
				autoLoginSlider.touch();
			}
		} else {
			if (autoLoginSlider.getText().equals("Да")) {
				autoLoginSlider.touch();
			}
		}

	}

	@Override
	public boolean isAutoLoginFlagEnable() {
		return autoLoginSlider.getText().equals("Да");
	}

	@Override
	@SuppressWarnings("unchecked")
	public CardContactsPageAndroid clickAllContacts() {
		allContactsButton.touch();
		return PageFactory.initElements(driver, CardContactsPageAndroid.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public CardContactsPageAndroid clickSwisstokContacts() {
		swisstokContacts.touch();
		return PageFactory.initElements(driver, CardContactsPageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BlockPageAndroid clickBlock() {
		blockedContacts.touch();
		return PageFactory.initElements(driver, BlockPageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public FavoritePageAndroid clickFavorite() {
		favourContacts.touch();
		return PageFactory.initElements(driver, FavoritePageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SavedContactsPageAndroid clickSavedContacts() {
		savedContacts.touch();
		return PageFactory.initElements(driver, SavedContactsPageAndroid.class);
	}

	@Override
	public void setZRTPconnection() {
		WebElement dropdown = ((AppiumDriver) driver).getDriver()
				.findElementByXPath(enctyptionDropdown.getFoundBy());
		Select select = new Select(dropdown);
		select.selectByVisibleText("ZRTP");

	}

	@Override
	public void setSRTPconnection() {
		WebElement dropdown = ((AppiumDriver) driver).getDriver()
				.findElementByXPath(enctyptionDropdown.getFoundBy());
		Select select = new Select(dropdown);
		select.selectByVisibleText("SRTP");

	}

	@Override
	public void setConnectionByDefault() {
		WebElement dropdown = ((AppiumDriver) driver).getDriver()
				.findElementByXPath(enctyptionDropdown.getFoundBy());
		Select select = new Select(dropdown);
		select.selectByVisibleText("Отключено");

	}

	@SuppressWarnings("unchecked")
	@Override
	public CallPageAndroid clickCall() {
		callTabButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callTabButton.touch();
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}

}
