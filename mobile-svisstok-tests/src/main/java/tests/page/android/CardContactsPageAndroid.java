package tests.page.android;

import java.awt.Rectangle;

import tests.page.CardContactsPage;
import tests.page.SettingsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class CardContactsPageAndroid extends CardContactsPage {

	public CardContactsPageAndroid(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//a[@id='contactsView-tab-btn-dialpad']")
	private UIView callTabButton;

	@FindBy(locator = "//window[2]/toolbar[1]/button[1]")
	private UIView doneButton;

	@FindBy(locator = "//a[@id='contactsView-btn-addPhone']")
	private UIView addContactsFromList;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[2]")
	private UIView nameField;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[3]")
	private UIView contactField;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[16]")
	private UIView contactNumber;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[14]")
	private UIView contactName;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[17]/link[1]")
	private UIView delete;

	@FindBy(locator = "//li[@id='1']")
	private UIView firstContact;

	@FindBy(locator = "//li[@id='2']")
	private UIView secondContact;

	@FindBy(locator = "//input[@id='contactsView-search']")
	private UIView searchFiled;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[4]")
	private UIView contactSecondField;

	@FindBy(locator = "Профиль")
	private UIView profileFromList;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[20]")
	private UIView secondNumber;

	@FindBy(locator = "Удалить")
	private UIView deleteNumber;

	@FindBy(locator = "/window[1]/scrollview[1]/webview[1]/text[14]")
	private UIView messageDelete;

	public void clickAddContacts() {
		addContactsFromList.touch();
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
		doneButton.touch();
	}

	@Override
	public void inputSecondContact(String contact) {
		contactSecondField.touch();
		contactSecondField.type(contact);
		doneButton.touch();
	}

	public void clickBack() {
		//
	}

	public String getContactNumber() {
		return contactNumber.getAttribute("label");
	}

	public String getContactName() {
		return contactName.getAttribute("label");
	}

	public void clickEditContacts() {
		//

	}

	public void clickDeletefromList() {
		//
	}

	public void clickDelete() {
		//
	}

	public void clickCall() {
		callTabButton.touch();
	}

	public void clickFirstContact() {
		//

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
		if (first && second)
			return true;
		else
			return false;
	}

	public SettingsPageAndroid clickSettings() {
		return null;
		//
	}

	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		doneButton.touch();
	}

	public CallPageAndroid clickSearchResult() {
		return null;
		//
	}

	public void clickEditFromList() {
		// /
	}

	public void clickProfile() {
		profileFromList.touchByName();
	}

	public String getSecondNumber() {
		// secondNumber.touchByName();
		return secondNumber.getAttribute("label");
	}

	public void secondDelete() {
		//
	}

	public void deleteNumber() {
		deleteNumber.touchByName();
	}

	public String getMessageDelete() {
		return messageDelete.getAttribute("label");
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

}
