package tests.page.android;

import org.openqa.selenium.By;

import tests.page.CardContactsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class CardContactsPageAndroid extends CardContactsPage {

	public CardContactsPageAndroid(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsView-tab-btn-dialpad']")
	private UIView callTabButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsView-btn-addPhone']")
	private UIView addContactsFromList;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@data-icon='add-contact-wr']")
	private UIView addContact;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//input[@id='contactCardView-form-title']")
	private UIView nameField;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@class='ui-block-c']//input")
	private UIView contactField;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-back']")
	private UIView backButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-favour-contact']")
	private UIView contactNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//h1[@id='contactCardView-title']")
	private UIView contactName;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-menu-panel']//h1[text()='Удалить']")
	private UIView deleteFromList;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-menu-panel']//h1[text()='Заблокировать']")
	private UIView blockFromList;

	@FindBy(locator = "//a[contains(@id,'confirm-btn-ok')]")
	private UIView block;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-call']")
	private UIView callButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//li[@id='contactsView-ul-li-1']")
	private UIView firstContact;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//h1[contains(.,'%s')]")
	private UIView searchedContact;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//h1[contains(.,'Sipnet contact 1')]")
	private UIView sipnetContact;
	
	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//li[@id='contactsView-ul-li-2']")
	private UIView secondContact;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//input[@id='contactsView-search']")
	private UIView searchFiled;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsView-btn-filter']")
	private UIView settings;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//li[@id='contactCardView-contacts-edit-list-li-1']//input")
	private UIView contactSecondField;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-menu-panel']//h1[text()='Профиль']")
	private UIView profileFromList;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-menu-panel']//h1[text()='Изменить']")
	private UIView editFromList;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[contains(.,'%s')]")
	private UIView secondNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-menu' and @data-icon='edit']")
	private UIView editContactProfile;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@data-icon='trash'][2]")
	private UIView deleteSecondNumber;

	@FindBy(locator = "//div[@id='toast']")
	private UIView messageDelete;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@data-icon='star']")
	private UIView starButton;

	@Override
	public void clickAddContacts() {
		addContact.touch();
	}

	@Override
	public void clickAddContactsFromList() {
		addContactsFromList.touch();
	}

	@Override
	public void inputName(String text) {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		nameField.touch();
		nameField.clear();
		nameField.type(text);
	}

	@Override
	public void inputContact(String contact) {
		contactField.touch();
		contactField.clear();
		contactField.type(contact);
	}

	@Override
	public void inputSecondContact(String contact) {
		contactSecondField.touch();
		contactSecondField.type(contact);
	}

	@Override
	public void clickSave() {
		backButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		backButton.touch();
	}

	@Override
	public void clickBack() {
		backButton.touch();

	}

	@Override
	public boolean isContactNumberExist(String name) {
		return ((AppiumDriver) driver).getDriver().findElementByName(name).isDisplayed();
		//return contactNumber.getText();
	}
	

	@Override
	public String getContactNumber(String name) {
		return ((AppiumDriver) driver).getDriver().findElementByName(name).getText();
	}

	@Override
	public String getContactName(String name) {
		return ((AppiumDriver) driver).getDriver().findElementByName(name).getText();
	}

	@Override
	public void clickEditContacts() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		editContactProfile.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		editContactProfile.touch();
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
	public void clickCallTab() {
		callTabButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callTabButton.touch();
	}

	@Override
	public void clickFirstContact() {
		firstContact.touch();
	}

	@Override
	public boolean checkVisibleContactNumber(String name) {
		return checkVisibleText(getContactNumber( name));
	}

	@Override
	public boolean checkVisibleContactName(String name) {
		return checkVisibleText(getContactName( name));
	}

	@Override
	public boolean checkVisibleListContacts() {
		boolean first = checkVisibleText((firstContact.getText().split(" ")[0]));
		boolean second = checkVisibleText((secondContact.getText().split(" ")[0]));
		return (first && second);
	}

	@Override
	@SuppressWarnings("unchecked")
	public SettingsPageAndroid clickSettings() {
		settings.touch();
		return PageFactory.initElements(driver, SettingsPageAndroid.class);
	}

	@Override
	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	@SuppressWarnings("unchecked")
	public CallPageAndroid clickSearchResultAndCall(String name) {
		((AppiumDriver) driver)
				.getDriver()
				.findElement(
						By.xpath(String.format(searchedContact.getFoundBy(),
								name))).click();
		callButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callButton.touch();
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public CallPageAndroid clickSearchResult(String name) {
		((AppiumDriver) driver)
				.getDriver()
				.findElement(
						By.xpath(String.format(searchedContact.getFoundBy(),
								name))).click();
		callButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}

	@Override
	public void clickEditFromList() {
		editFromList.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		editFromList.touch();
	}

	@Override
	public void clickProfile() {
		profileFromList.touch();
	}

	@Override
	public String getSecondNumber(String name) {
		if (((AppiumDriver) driver)
				.getDriver()
				.findElement(
						By.xpath(String.format(secondNumber.getFoundBy(), name)))
				.isDisplayed()) {
			return name;
		} else
			return "";

	}

	@Override
	public void secondDelete() {
		
	}

	@Override
	public void deleteNumber() {
		deleteNumber.touch();
	}

	@Override
	public boolean isMessageDeleteAppears(String message) {
		return messageDelete.getText().equals(message);
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickBlockFromList() {
		blockFromList.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		blockFromList.touch();
	}

	@Override
	public void clickBlock() {
		block.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		block.touch();
	}

	@Override
	public boolean isMessageBlockAppears(String message) {
		return messageDelete.getText().equals(message);
	}

	@Override
	public void clickStar() {
		starButton.touch();
	}
	
	@Override
	public boolean isContactListDownloaded() {
		sipnetContact.waitForElement(WAIT_CONTACTS);
		return sipnetContact.isExists();
	}

	

	@Override
	public void callFromContactCard() {
		throw new RuntimeException("need implementation");
		
	}


}
