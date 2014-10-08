package tests.page.ios;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import runner.Devices;
import tests.page.CallPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class CallPageIos extends CallPage {

	@FindBy(locator = "Зарегистрирован")
	public UIView status;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[1]")
	public UIView online;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView one;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView two;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView three;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView four;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[5]")
	private UIView five;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[6]")
	private UIView six;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[7]")
	private UIView seven;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[8]")
	private UIView eight;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[9]")
	private UIView nine;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[10]")
	private UIView star;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[11]")
	private UIView zero;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[12]")
	private UIView grill;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	private UIView digitDisplay;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	public UIView fieldNumber;

	@FindBy(locator = "//window[2]/UIAKeyboard[1]/UIAKey[29]")
	private UIView moreNumber;

	@FindBy(locator = "Удалить", ios7 = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[15]/UIAStaticText[1]")
	private UIView deleteButton;

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[15]")
	private UIView deleteButtonFromKeyboard;

	@FindBy(locator = "Select All")
	private UIView selectAll;

	@FindBy(locator = "Cut")
	private UIView cutButton;

	@FindBy(locator = "Done")
	private UIView doneButton;

	@FindBy(locator = "Подключение...")
	private UIView nameConnection;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[3]")
	private UIView nameAbonent;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]")
	private UIView webview;

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[14]/UIALink[1]", ios7 = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[14]")
	private UIView callButton;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]/UIALink[1]", ios7 = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]")
	private UIView cancelCallButton;

	@FindBy(locator = "Отклонить")
	private UIView resetCallButton;

	@FindBy(locator = "Контакты", ios7 = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[16]")
	private UIView contactsTab;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[4]")
	private UIView timerCall;

	// @FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[5]",
	// ios7 = "//window[1]/scrollview[1]/webview[1]/text[3]")
	// private UIView contactNumber;

	@FindBy(locator = "Позвонить", ios7 = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[18]")
	private UIView callTab;

	@FindBy(locator = " ,  ")
	private UIView callLinkButton;

	@FindBy(locator = "История")
	private UIView historyButton;

	@FindBy(locator = "Ответить")
	private UIView answerButton;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[3]")
	private UIView endCallButton;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]/UIALink[1]")
	private UIView settingTab;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]")
	private UIView microphone;

	@FindBy(locator = "OK")
	private UIView okButton;

	@FindBy(locator = "//UIAAlert[1]/UIAScrollView[1]/UIAStaticText[1]")
	private UIView alertAccessContacts;

	@FindBy(locator = "//UIALink[@name='Отмена']")
	private UIView alertUpdateBuild;

	@FindBy(locator = "Входящий вызов...")
	// Входящий вызов...
	private UIView incommingCall;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView moreButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView speakerButton;

	@FindBy(locator = "Отмена")
	private UIView cancelButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[3]")
	private UIView nameText;
	private static final Logger LOGGER = Logger.getLogger(CallPageIos.class);

	public CallPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void checkPage() {
		try {
			callTab.waitForElement(WAIT_WHILE_LOGIN);
		} catch (TimeoutException e) {
			LOGGER.error("Login was unsuccessfull.");
			throw new com.mobile.driver.wait.exception.TimeoutException(
					"Call page didn't download");
		}
	}

	@Override
	public String isAnswerIncommingCall() {
		incommingCall.waitForElement(WAIT_WHILE_LOGIN);
		Rectangle point = answerButton.getLocation();
		answerButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		return getTimer();
	}

	@Override
	public CallPageIos isIncommingCallReset() {
		incommingCall.waitForElement(WAIT_WHILE_LOGIN);
		Rectangle point = endCallButton.getLocation();
		resetCallButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@Override
	public boolean isStatusAvailable() {
		return star.isExists();
	}

	private List<UIView> dial() {
		List<UIView> container = new ArrayList<UIView>();
		container.add(one);
		container.add(two);
		container.add(three);
		container.add(four);
		container.add(five);
		container.add(six);
		container.add(seven);
		container.add(eight);
		container.add(nine);
		container.add(star);
		container.add(zero);
		container.add(grill);
		return container;
	}

	@Override
	public void inputAllDigites() {

		for (UIView digit : dial()) {
			digit.touch();
		}

	}

	@Override
	public void inputFromNativeKeyboard(String text) {
		fieldNumber.touchLong();
		fieldNumber.type(text);
		doneButton.touch();
	}

	@Override
	public String getTextFieldDigitDisplay() {
		return digitDisplay.getAttribute("value");
	}

	@Override
	public void clearField() {
		try {
			while (!fieldNumber.getAttribute("value").isEmpty()) {
				deleteLastSymbol();
			}
		} catch (NoSuchElementException e) {

		}
	}

	@Override
	public void deleteLastSymbol() {
		Rectangle point = deleteButtonFromKeyboard.getLocation();
		deleteButtonFromKeyboard.touchWithCoordinates(point.getX(),
				point.getY());
	}

	@Override
	public CardContactsPageIos clickContact() {
		contactsTab.touch();
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}

	@Override
	public SettingsPageIos navigateToSettingsTab() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Dimension dim = webview.getSize();
		webview.touchWithCoordinates(dim.width / 4 * 3 + 10, dim.height - 10);
		return PageFactory.initElements(driver, SettingsPageIos.class);
	}

	@Override
	public void clickCallButton() {
		Dimension dim = webview.getSize();
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			webview.touchWithCoordinates(dim.width / 2, dim.height / 6 * 5);
			break;
		case IOS7:
			// Rectangle point = callButton.getLocation();
			webview.touchWithCoordinates(dim.width / 2, dim.height / 9 * 7);
			break;
		default:
			break;
		}
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}

	@Override
	public String getNameConnection() {
		return nameConnection.getFoundBy().toString();
	}

	@Override
	public CallPageIos cancelCall() {
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			Dimension dim = webview.getSize();
			webview.touchWithCoordinates(dim.width / 2, dim.height - 30);
			break;
		case IOS7:
			cancelCallButton.touch();
		default:
			break;
		}
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public CallPageIos endCall() {
		Rectangle point = endCallButton.getLocation();
		endCallButton.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@Override
	public String getNameAbonent() {
		return nameAbonent.getAttribute("label");
	}

	@Override
	public boolean isMicrophoneWork() {
		Rectangle point = microphone.getLocation();
		microphone.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		microphone.touchWithCoordinates(point.getX(), point.getY());
		return true;

	}

	@Override
	public String getTimer() {
		return timerCall.getAttribute("label");
	}

	/*
	 * @Override public void clickBack() { Rectangle point =
	 * webview.getLocation(); double x = 10; double y = 5;
	 * webview.touchWithCoordinates(point.getX() + x, point.getY() + y); }
	 */

	@Override
	public void clickCall() {
		Rectangle point = callButton.getLocation();
		callButton.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickEditContacts() {
		Rectangle point = settingTab.getLocation();
		settingTab.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickDeletefromList() {
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}

	@Override
	public void clickDelete() {
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public String getContactNumber(String name) {
		return ((AppiumDriver) driver).getDriver().findElementByName(name)
				.getAttribute("name");
	}

	@Override
	public HistoryPageIos clickHistoryTab() {
		Dimension dim = webview.getSize();
		historyButton.touchWithCoordinates(dim.width / 4 + 10, dim.height - 10);
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}

	@Override
	public boolean isSpeakerWork() {
		Rectangle point = moreButton.getLocation();
		moreButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle pointSpeaker = speakerButton.getLocation();
		speakerButton.touchWithCoordinates(pointSpeaker.getX(),
				pointSpeaker.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		speakerButton.touchWithCoordinates(pointSpeaker.getX(),
				pointSpeaker.getY());
		// Rectangle pointName = nameText.getLocation();
		// nameText.touchWithCoordinates(pointName.getX(), pointName.getY());
		return true;
	}

	@Override
	public CallPageIos clickOk() {
		okButton.touch();
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@Override
	public boolean isAccessContacts() {
		if (alertAccessContacts.isExists()) {
			return alertAccessContacts.getAttribute("name").equals(
					"“Swisstok” Would Like to Access Your Contacts");
		}
		return false;
	}

	@Override
	public boolean isAlertUpdate() {
		if (alertUpdateBuild.isExists())
			return true;
		else
			return false;
	}

	@Override
	public void clickCancel() {
		cancelButton.touch();
	}
}
