package tests.page.android;

import java.awt.Rectangle;

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
	
	@FindBy(locator="//a[@id='contactCardView-btn-back']")
	private UIView backButton;
	
	@FindBy(locator = "//div[@id='contactCardView-favour-contact']")
	private UIView contactNumber;

	@FindBy(locator = "//h1[@id='contactCardView-title']")
	private UIView contactName;

	@FindBy(locator = "//ul[@data-role='listview']//h1[text()='Удалить']")
	private UIView delete;

	@FindBy(locator = "//li[@id='1']")
	private UIView firstContact;

	@FindBy(locator = "//li[@id='2']")
	private UIView secondContact;

	@FindBy(locator = "//input[@id='contactsView-search']")
	private UIView searchFiled;
	
	@FindBy(locator = "//a[@id='contactsView-btn-filter']")
	private UIView settings;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[4]")
	private UIView contactSecondField;

	@FindBy(locator = "Профиль")
	private UIView profileFromList;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[20]")
	private UIView secondNumber;
	
	@FindBy(locator = "//a[@data-icon='edit']")
	private UIView editContactProfile;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "/window[1]/scrollview[1]/webview[1]/text[14]")
	private UIView messageDelete;

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
		contactSecondField.touch();
		contactSecondField.type(contact);
	}

	public void clickBack() {
		backButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
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
		delete.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		delete.touch();
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

	public SettingsPageAndroid clickSettings() {
		settings.touch();
		return PageFactory.initElements(driver, SettingsPageAndroid.class);
	}

	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
	}

	public CallPageAndroid clickSearchResult() {
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}

	public void clickEditFromList() {
		deleteNumber.touchByName();
	}

	public void clickProfile() {
		profileFromList.touchByName();
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

}
