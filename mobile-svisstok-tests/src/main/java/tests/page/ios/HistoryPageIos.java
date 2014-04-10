package tests.page.ios;

import java.awt.Rectangle;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import runner.DeviceConfig;
import runner.Devices;
import tests.page.HistoryPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;

public class HistoryPageIos extends HistoryPage {
	
	protected static final String DEVICE = DeviceConfig.getDevice();

	public HistoryPageIos(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[4]")
	private UIView timerCall;

	@FindBy(locator = "Позвонить", ios7 = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView callTab;

	// @FindBy(locator = "")
	// private UIView editButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView trashButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView arrowButton;

	@FindBy(locator = FIRST_RESULT)
	private UIView contact;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]/link[1]",
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView cancelCallButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[3]")
	private UIView messageEmptyList;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView allContacts;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView settingButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView filterButton;

	private static final String FIRST_RESULT = "//window[1]/scrollview[1]/webview[1]/link";//link[3]

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickFirstContact() {
		Rectangle point = webview.getLocation();
		double y = 42;
		webview.touchWithCoordinates(point.getX(), point.getY() + y);
	}

	@Override
	public HistoryPageIos cancelCall() {
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
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}

	@Override
	public String getTimer() {
		return timerCall.getAttribute("label");
	}

	@Override
	public void clickCall() {
		Rectangle point = callTab.getLocation();
		callTab.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickEdit() {
		Rectangle point = arrowButton.getLocation();
		arrowButton.touchWithCoordinates(point.getX(), point.getY() - 35);
	}

	public void clickConfirmation() {
		Rectangle point = trashButton.getLocation();
		trashButton.touchWithCoordinates(point.getX(), point.getY() - 35);
	}

	public void clickTrash() {
		Rectangle point = trashButton.getLocation();
		trashButton.touchWithCoordinates(point.getX(), point.getY());

	}

	@Override
	public void findDeleteContacts() {
		Rectangle point = contact.getLocation();

	}

	@Override
	public int deleteCall() {
		int count = getCountUsers();
		clickTrash();
		clickConfirmation();
		return count;
	}

	@Override
	public void deleteAllCalls() {
		Rectangle point = allContacts.getLocation();
		allContacts.touchWithCoordinates(point.getX(), point.getY());
		clickConfirmation();
	}

	@Override
	public int getCountUsers() {
		List<WebElement> elements = ((AppiumDriver) driver).getDriver()
				.findElements(By.xpath(FIRST_RESULT));
		return elements.size();
	}

	@Override
	public String getMessageEmptyList() {
		return messageEmptyList.getAttribute("name");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public HistoryFilterPageIos openFilter() {
		Rectangle point = filterButton.getLocation();
		filterButton.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, HistoryFilterPageIos.class);
	}

}
