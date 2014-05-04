package tests.page.ios;

import java.awt.Rectangle;

import runner.Devices;
import tests.page.FavoritePage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.wait.Sleeper;

public class FavoritePageIos extends FavoritePage {

	public FavoritePageIos(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	private UIView searchFiled;

	@FindBy(locator = "//window[2]/toolbar[1]/button[1]", ios7 = "//window[2]/toolbar[1]/button[3]")
	private UIView doneButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[5]")
	private UIView contactName;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]/link[1]")
	private UIView searchResult;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[4]", ios7 = "//window[1]/scrollview[1]/webview[1]/text[4]")
	private UIView timerCall;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[9]/link[1]")
	private UIView callingButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[14]/link[1]")
	private UIView callButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView cancelCallButton;

	@FindBy(locator = "Удалить", ios7 = "Удалить")
	private UIView deleteButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]", ios7 = "//window[1]/scrollview[1]/webview[1]/text[2]")
	private UIView settingTab;

	@FindBy(locator = "Удалить")
	private UIView deleteFromList;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView firstResult;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView openContactButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView allContacts;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		doneButton.touch();
	}

	@Override
	public void clickSearchResult(String name) {
		Rectangle point = firstResult.getLocation();
		firstResult.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public String getContactName() {
		return contactName.getAttribute("name");
	}

	@Override
	public void clickEditContacts() {
		Rectangle point = settingTab.getLocation();
		settingTab.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickDeletefromList() {
		// Rectangle point = deleteFromList.getLocation();
		// deleteFromList.touchWithCoordinates(point.getX(), point.getY());
		deleteFromList.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}

	@Override
	public void clickDelete() {
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickCall() {
		Rectangle point = callButton.getLocation();
		callButton.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickCallingButton() {
		callingButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}

	@Override
	public void cancelCall() {
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			Rectangle point = cancelCallButton.getLocation();
			cancelCallButton.touchWithCoordinates(point.getX(), point.getY());
			break;
		case IOS7:
			cancelCallButton.touch();
			break;
		default:
			break;
		}
	}

	@Override
	public String getTimer() {
		return timerCall.getAttribute("label");
	}

	@Override
	public void deleteAllCalls() {
		Rectangle point = allContacts.getLocation();
		allContacts.touchWithCoordinates(point.getX(), point.getY());
		clickConfirmation();
	}

	public void clickConfirmation() {
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY() - 35);
	}

	@Override
	public void openFirstContact() {
		Rectangle point = openContactButton.getLocation();
		openContactButton.touchWithCoordinates(point.getX(), point.getY());
	}

}
