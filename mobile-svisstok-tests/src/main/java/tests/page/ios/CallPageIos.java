package tests.page.ios;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.TimeoutException;

import tests.page.CallPage;

import com.annotation.FindBy;
import com.element.UIView;
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

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[10]")
	private UIView star;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[11]")
	private UIView zero;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[12]")
	private UIView grill;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	private UIView digitDisplay;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	public UIView fieldNumber;

	@FindBy(locator = "//window[2]/UIAKeyboard[1]/UIAKey[29]")
	private UIView moreNumber;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[16]")
	private UIView deleteButton;

	@FindBy(locator = "Select All")
	private UIView selectAll;

	@FindBy(locator = "Cut")
	private UIView cutButton;

	@FindBy(locator = "//window[2]/toolbar[1]/button[1]", 
			ios7 = "//window[2]/toolbar[1]/button[3]")
	private UIView doneButton;

	@FindBy(locator = "Подключение...")
	private UIView nameConnection;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[1]",
			ios7 = "//window[1]/scrollview[1]/webview[1]/text[3]")
	private UIView nameAbonent;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;

	@FindBy(locator = "Настройки",
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[20]")
	private UIView settingsTab;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[15]")
	private UIView callButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView cancelCallButton;

	@FindBy(locator = "Контакты",
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[17]")
	private UIView contactsTab;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[4]")
	private UIView timerCall;

	@FindBy(locator =  "//window[1]/scrollview[1]/webview[1]/text[3]")
	private UIView contactNumber;

	@FindBy(locator = "Позвонить")
	private UIView callTab;
	
	@FindBy(locator = "История", 
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[18]")
	private UIView historyButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView answerButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView endCallButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView settingTab;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[5]")
	private UIView deleteFromList;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView microphone;
	
	@FindBy(locator = "OK")
	private UIView okButton;
	
	@FindBy(locator = "//window[4]/alert[1]/scrollview[1]/text[1]")
	private UIView alertAccessContacts;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]")
	// Входящий вызов...
	private UIView incommingCall;

	private static final Logger LOGGER = Logger.getLogger(CallPageIos.class);

	public CallPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void checkPage() {
		try {
			status.waitForElementByName(WAIT_WHILE_LOGIN);
		} catch (TimeoutException e) {
			LOGGER.error("Login was unsuccessfull. Can't find " + status);
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
		endCallButton.touchWithCoordinates(point.getX(), point.getY());
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
		while (!fieldNumber.getAttribute("value").isEmpty()) {
			deleteLastSymbol();
		}
	}

	@Override
	public void deleteLastSymbol() {
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
	}

	@SuppressWarnings("unchecked")
	@Override
	public CardContactsPageIos clickContact() {
		Rectangle point = contactsTab.getLocation();
		contactsTab.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SettingsPageIos navigateToSettingsTab() {
		Rectangle point = settingsTab.getLocation();
		settingsTab.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, SettingsPageIos.class);
	}

	@Override
	public void clickCallButton() {
		Rectangle point = callButton.getLocation();
		callTab.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}

	@Override
	public String getNameConnection() {
		return nameConnection.getFoundBy().toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CallPageIos cancelCall() {
//		Rectangle point = cancelCallButton.getLocation();
//		cancelCallButton.touchWithCoordinates(point.getX(), point.getY());
		cancelCallButton.touch();
		return PageFactory.initElements(driver, CallPageIos.class);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CallPageIos endCall() {
		Rectangle point = endCallButton.getLocation();
		endCallButton.touchWithCoordinates(point.getX() , point.getY() );
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@Override
	public String getNameAbonent() {
		return nameAbonent.getAttribute("label");
	}

	@Override
	public boolean isMicrophoneWork() {
		/*Rectangle point = webview.getLocation();
		double x = 100;
		double y = 355;
		if ((point.getX() + x) == 100) {
			webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
			Sleeper.SYSTEM_SLEEPER.sleep(1000);
			webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
			return true;
		} else
			return false; */
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

	/*@Override
	public void clickBack() {
		Rectangle point = webview.getLocation();
		double x = 10;
		double y = 5;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}*/

	@Override
	public void clickCall() {
		Rectangle point = callButton.getLocation();
		callButton.touchWithCoordinates(point.getX(), point.getY());
	}

	public void clickEditContacts(){
		Rectangle point = settingTab.getLocation();
		settingTab.touchWithCoordinates(point.getX(), point.getY());
	}
	
	@Override	
	public void clickDeletefromList(){
		Rectangle point = deleteFromList.getLocation();
		deleteFromList.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
	
	@Override	
	public void clickDelete(){
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public String getContactNumber() {
		return contactNumber.getAttribute("label");
	}

	@Override
	public HistoryPageIos clickHistory() {
		Rectangle point = historyButton.getLocation();
		historyButton.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}

	@Override
	public boolean isSpeakerWork() {
		// For IOS this button inactive
		return true;
	}
	
	public CallPageIos clickOk(){
		okButton.touchByName();
		return PageFactory.initElements(driver, CallPageIos.class);
	}
	public boolean isAccessContacts(){
		return alertAccessContacts.getAttribute("name").equals("“Swisstok” Would Like to Access Your Contacts");
	}
}
