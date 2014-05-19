package tests.page.ios;

import java.awt.Rectangle;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import tests.page.CardContactsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class CardContactsPageIos extends CardContactsPage {

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView addContacts;

	@FindBy(locator = "Заблокировать")
	private UIView blockFromList;

	@FindBy(locator = "//window[2]/toolbar[1]/button[1]", ios7 = "//window[2]/toolbar[1]/button[3]")
	private UIView doneButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView addContactsFromList;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[2]")
	private UIView nameField;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[3]")
	private UIView contactField;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[10]")
	private UIView contactNumber;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[10]")
	private UIView contactName;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[17]/link[1]")
	private UIView delete;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]/link[2]/text[1]",
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView firstContact;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]/link[2]/text[1]",
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView secondContact;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	private UIView searchFiled;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[4]")
	private UIView contactSecondField;

	@FindBy(locator = "Профиль")
	private UIView profileFromList;

	@FindBy(locator = "Изменить")
	private UIView editFromList;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[11]",
			ios7 = "//window[1]/scrollview[1]/webview[1]/text[11]")
	private UIView secondNumber;

	@FindBy(locator = "Удалить")
	private UIView deleteNumber;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[6]")
	private UIView messageDelete;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[15]/link[1]", ios7 = "Заблокировать")
	private UIView blockButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[3]")
	private UIView messageBlock;

	@FindBy(locator = "Select All")
	private UIView selectAll;

	@FindBy(locator = "Cut")
	private UIView cutButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[8]", 
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[8]")
	private UIView star;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView backTab;

	@FindBy(locator = "Готово")
	private UIView saveButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView settingTab;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView settingTabRight;

	@FindBy(locator = "Удалить")
	private UIView deleteFromList;

	@FindBy(locator = "Удалить")
	private UIView deleteButton;

	@FindBy(locator = "Позвонить", ios7 = "Позвонить")
	private UIView callTab;

	@FindBy(locator = "OK")
	private UIView okButton;

	@FindBy(locator = "//window[4]/alert[1]")
	private UIView alertAccessContacts;

	@FindBy(locator = "Позвонить \n", ios7 = "Позвонить  , &nbsp;")
	private UIView callButton;

	public CardContactsPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void clickAddContacts() {
		// Rectangle point = webview.getLocation();
		// double x = 270;
		// webview.touchWithCoordinates(point.getX() + x, point.getY());
		Rectangle point = addContacts.getLocation();
		addContacts.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickAddContactsFromList() {
		addContactsFromList.touch();
	}

	@Override
	public void inputName(String text) {
		nameField.touch();
		clearField(nameField);
		nameField.type(text);
		doneButton.touch();
	}

	/*
	 * public void inputOtherName(String text){ nameField.touch();
	 * clearField(nameField); nameField.type(text); doneButton.touch(); }
	 */

	public void clearField(UIView element) {
		if (!(element.getText().isEmpty())) {
			element.touch();
			if(!selectAll.isExists()) {
				element.touchLong();
			}
			selectAll.touch();
			Rectangle point = cutButton.getLocation();
			cutButton.touchWithCoordinates(point.getX(), point.getY());
		}
	}

	@Override
	public void inputContact(String contact) {
		contactField.touch();
		clearField(contactField);
		contactField.type(contact);
		clearField(contactField);
		contactField.type(contact);
		doneButton.touch();
	}

	@Override
	public void inputSecondContact(String contact) {
		contactSecondField.touch();
		contactSecondField.type(contact);
		doneButton.touch();
	}

	@Override
	public void clickBack() {
		Rectangle point = backTab.getLocation();
		// double x = 10;
		// double y = 5;
		backTab.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickSave() {
		saveButton.touch();
		// Rectangle point = webview.getLocation();
		// double x = 10;
		// double y = 5;
		// webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}

	@Override
	public boolean isContactNumberExist(String name) {
		return ((AppiumDriver) driver).getDriver().findElements(By.name(name))
				.size() > 0;
		// return contactNumber.getAttribute("name");
	}

	@Override
	public String getContactNumber(String name) {
		return ((AppiumDriver) driver).getDriver().findElementByName(name)
				.getAttribute("name");
		// return contactNumber.getAttribute("name");
	}

	@Override
	public String getContactName(String name) {
		return ((AppiumDriver) driver).getDriver().findElementByName(name)
				.getAttribute("name");
	}

	@Override
	public void clickEditContacts() {
		Rectangle point = settingTabRight.getLocation();
		settingTabRight.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickDeletefromList() {
		Rectangle point = deleteFromList.getLocation();
		deleteFromList.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void clickDelete() {
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void clickCallTab() {
		Dimension dim = webview.getSize();
		callTab.touchWithCoordinates(dim.width / 4 * 2 + 10, dim.height - 10);
	}

	@Override
	public void clickFirstContact() {
		Rectangle point = firstContact.getLocation();
		firstContact.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void callFromContactCard() {
		callButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}

	@Override
	public boolean checkVisibleContactNumber(String name) {

		return checkVisibleText(getContactNumber(name));
	}

	@Override
	public boolean checkVisibleContactName(String name) {
		// TODO: name abonent invisible
		return true;// ((AppiumDriver)
					// driver).getDriver().findElementByXpath("//Link[contains(.,'AutoTest1118')]").getText().contains(name);
		// return checkVisibleText(getContactName(name));
	}

	@Override
	public boolean checkVisibleListContacts() {
		boolean first = checkVisibleText((firstContact.getAttribute("name")
				.split(" ")[0]));
		boolean second = checkVisibleText((secondContact.getAttribute("name")
				.split(" ")[0]));
		return (first && second);
	}


	@Override
	public SettingsPageIos clickSettings() {
		Rectangle point = settingTab.getLocation();
		settingTab.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, SettingsPageIos.class);
	}

	@Override
	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		doneButton.touch();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CallPageIos clickSearchResultAndCall(String result) {
		Rectangle point = webview.getLocation();
		double y = 88;
		webview.touchWithCoordinates(point.getX(), point.getY() + y);
		CallPageIos call = PageFactory.initElements(driver, CallPageIos.class);
		call.clickCall();
		return call;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CallPageIos clickSearchResult(String result) {
		Rectangle point = webview.getLocation();
		double y = 105;
		webview.touchWithCoordinates(point.getX(), point.getY() + y);
		CallPageIos call = PageFactory.initElements(driver, CallPageIos.class);
		return call;
	}

	@Override
	public void clickEditFromList() {
		Rectangle point = editFromList.getLocation();
		editFromList.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickProfile() {
		profileFromList.touch();
	}

	@Override
	public String getSecondNumber(String name) {
		return secondNumber.getAttribute("label");
	}

	@Override
	public void secondDelete() {
		Rectangle point = webview.getLocation();
		double x = 25;
		double y = 191;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}

	@Override
	public void deleteNumber() {
		deleteNumber.touch();
	}

	@Override
	public boolean isMessageDeleteAppears(String message) {
		return ((AppiumDriver) driver).getDriver().findElementByName(message)
				.isDisplayed();
	}

	@Override
	public void clickBlockFromList() {
		Rectangle point = blockFromList.getLocation();
		blockFromList.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void clickBlock() {
		blockButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public boolean isMessageBlockAppears(String message) {
		return ((AppiumDriver) driver).getDriver().findElementByName(message)
				.isDisplayed();
	}

	@Override
	public void clickStar() {
		Rectangle point = star.getLocation();
		star.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public boolean isContactListDownloaded() {
		// Only for Android
		return true;
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
	}
}