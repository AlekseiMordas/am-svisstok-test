package tests.page.android;

import java.awt.Rectangle;

import org.openqa.selenium.By;

import tests.page.CardContactsPage;
import tests.page.SettingsPage;

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

	@FindBy(locator = "//a[@id='contactsView-tab-btn-dialpad']")
	private UIView callTabButton;

	@FindBy(locator = "//a[@id='contactsView-btn-addPhone']")
	private UIView addContactsFromList;

	@FindBy(locator = "//a[@data-icon='add-contact-wr']")
	private UIView addContact;

	@FindBy(locator = "//input[@id='contactCardView-form-title']")
	private UIView nameField;

	@FindBy(locator = "//div[@class='ui-block-c']//input")
	private UIView contactField;

	@FindBy(locator = "//a[@id='contactCardView-btn-back']")
	private UIView backButton;

	@FindBy(locator = "//div[@id='contactCardView-favour-contact']")
	private UIView contactNumber;

	@FindBy(locator = "//h1[@id='contactCardView-title']")
	private UIView contactName;

	@FindBy(locator = "//ul[@data-role='listview']//h1[text()='Удалить']")
	private UIView deleteFromList;

	@FindBy(locator = "//ul[@data-role='listview']//h1[text()='Заблокировать']")
	private UIView blockFromList;

	@FindBy(locator = "//a[contains(@id,'confirm-btn-ok')]")
	private UIView block;

	@FindBy(locator = "//a[@id='contactCardView-btn-call']")
	private UIView callButton;

	@FindBy(locator = "//li[@id='1']")
	private UIView firstContact;

	@FindBy(locator = "//h1[contains(.,'%s')]")
	private UIView searchedContact;

	@FindBy(locator = "//li[@id='2']")
	private UIView secondContact;

	@FindBy(locator = "//input[@id='contactsView-search']")
	private UIView searchFiled;

	@FindBy(locator = "//a[@id='contactsView-btn-filter']")
	private UIView settings;

	@FindBy(locator = "//li[@id='contactCardView-contacts-edit-list-li-1']//input")
	private UIView contactSecondField;

	@FindBy(locator = "//ul[@data-role='listview']//h1[text()='Профиль']")
	private UIView profileFromList;

	@FindBy(locator = "//ul[@data-role='listview']//h1[text()='Изменить']")
	private UIView editFromList;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[20]")
	private UIView secondNumber;

	@FindBy(locator = "//a[@data-icon='edit']")
	private UIView editContactProfile;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "//div[@data-icon='trash'][2]")
	private UIView deleteSecondNumber;

	@FindBy(locator = "//div[@id='toast']")
	private UIView messageDelete;

	@FindBy(locator = "//a[@data-icon='star']")
	private UIView starButton;
	
	public void clickAddContacts() {
		addContact.touch();
	}

	public void clickAddContactsFromList() {
		addContactsFromList.touch();
	}

	public void inputName(String text) {
		nameField.touch();
		nameField.type(text);
	}

	public void inputContact(String contact) {
		contactField.touch();
		contactField.type(contact);
	}

	@Override
	public void inputSecondContact(String contact) {
		System.out.println(((AppiumDriver) driver).getDriver().getPageSource());
		contactSecondField.touch();
		contactSecondField.type(contact);
	}

	public void clickBack() {
		backButton.touch();
	}

	public String getContactNumber() {
		return contactNumber.getText();
	}

	public String getContactName() {
		return contactName.getText();
	}

	public void clickEditContacts() {
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

	public void clickFirstContact() {
		firstContact.touch();
	}

	public boolean checkVisibleContactNumber() {
		return checkVisibleText(getContactNumber());
	}

	public boolean checkVisibleContactName() {
		return checkVisibleText(getContactName());
	}

	public boolean checkVisibleListContacts() {
		boolean first = checkVisibleText((firstContact.getText().split(" ")[0]));
		boolean second = checkVisibleText((secondContact.getText().split(" ")[0]));
		return (first && second);
	}

	@SuppressWarnings("unchecked")
	public SettingsPageAndroid clickSettings() {
		settings.touch();
		return PageFactory.initElements(driver, SettingsPageAndroid.class);
	}

	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

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

	public void clickEditFromList() {
		editFromList.touch();
	}

	public void clickProfile() {
		profileFromList.touch();
	}

	public String getSecondNumber() {
		secondNumber.touchByName();
		return secondNumber.getText();
	}

	public void secondDelete() {
		//
	}

	public void deleteNumber() {
		deleteNumber.touchByName();
	}

	public String getMessageDelete() {
		return messageDelete.getText();
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
	public String getMessageBlock() {
		return messageDelete.getText();
	}

	@Override
	public void clickStar() {
		starButton.touch();
	}

}
