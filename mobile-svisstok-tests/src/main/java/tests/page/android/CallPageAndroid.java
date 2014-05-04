package tests.page.android;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import tests.page.CallPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class CallPageAndroid extends CallPage {

	private static final Logger LOGGER = Logger
			.getLogger(CallPageAndroid.class);

	@FindBy(locator = "//div[text()='Зарегистрирован']")
	private UIView status;

	@FindBy(locator = "//div[text()='1']")
	private UIView one;

	@FindBy(locator = "//div[text()='2']")
	private UIView two;

	@FindBy(locator = "//div[text()='3']")
	private UIView three;

	@FindBy(locator = "//div[text()='4']")
	private UIView four;

	@FindBy(locator = "//div[text()='5']")
	private UIView five;

	@FindBy(locator = "//div[text()='6']")
	private UIView six;

	@FindBy(locator = "//div[text()='7']")
	private UIView seven;

	@FindBy(locator = "//div[text()='8']")
	private UIView eight;

	@FindBy(locator = "//div[text()='9']")
	private UIView nine;

	@FindBy(locator = "//div[text()='*']")
	private UIView star;

	@FindBy(locator = "//div[text()='0']")
	private UIView zero;

	@FindBy(locator = "//div[text()='#']")
	private UIView grill;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='activeCallView-call-avatar-panlel-status']")
	private UIView timer;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//input[@class='ui-input-text ui-body-c']")
	public UIView fieldNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//td[@class='left addContact']/a")
	private UIView contactButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@id, 'contacts')]")
	private UIView contactTabButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@id, 'history')]")
	private UIView historyTabButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@id, 'setting')]")
	private UIView settingsTabButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//td[@class='center call']/a/span")
	private UIView callButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//td[@class='right backspace']")
	private UIView deleteButton;

	@FindBy(locator = "//div[contains(@class,'status orange')]")
	private UIView nameConnection;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@class,'ui-btn-color-red')]")
	private UIView cancelCallButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[contains(@class, 'title')]")
	private UIView nameAbonent;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@id,'tab-btn-microphone')]")
	private UIView microphoneButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@id,'activeCallView-tab-btn-speaker')]")
	private UIView speakerButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-menu' and @data-icon='edit']")
	private UIView editContactProfile;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-menu-panel']//h1[text()='Удалить']")
	private UIView deleteFromList;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-favour-contact']")
	// h1[@id='contactCardView-title']
	private UIView contactName;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[contains(@class,'ui-btn-color-green')]")
	private UIView answerButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[text()='Входящий вызов...']")
	private UIView incommingCallText;

	public CallPageAndroid(NativeDriver driver) {
		super(driver);
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
		container.add(zero);
		return container;
	}

	@Override
	public boolean isStatusAvailable() {
		try {
			status.waitForElement(WAIT_WHILE_LOGIN);
		} catch (TimeoutException e) {
			LOGGER.error("Login was unsuccessfull. Can't find " + status);
			throw new com.mobile.driver.wait.exception.TimeoutException(
					"Call page didn't download");
		}
		return status.isExists();
	}

	@Override
	public void checkPage() {
		try {
			status.waitForElement(WAIT_WHILE_LOGIN);
		} catch (TimeoutException e) {
			LOGGER.error("Login was unsuccessfull. Can't find " + status);
			throw new com.mobile.driver.wait.exception.TimeoutException(
					"Call page didn't download");
		}
	}

	@Override
	public void inputAllDigites() {
		for (UIView digit : dial()) {
			digit.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(500);
		}

	}

	@Override
	public void inputFromNativeKeyboard(String text) {
		// inputAllDigites(); TODO: BUG!
		fieldNumber.clear();
		fieldNumber.type(text);
	}

	@Override
	public void deleteLastSymbol() {
		int length = getTextFieldDigitDisplay().length();
		deleteButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		if (getTextFieldDigitDisplay().length() == length) {
			deleteButton.touch();
		}

	}

	@Override
	public String getTextFieldDigitDisplay() {
		return fieldNumber.getAttribute("value");
	}

	@Override
	public void clearField() {
		fieldNumber.clear();
	}

	@Override
	public void clickCallButton() {
		callButton.touch();
	}

	@Override
	public String getNameConnection() {
		// return nameConnection.getText();
		// TODO: cant catch this string in android
		return "Подключение...";
	}

	@Override
	public CallPageAndroid cancelCall() {
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(cancelCallButton.getFoundBy()));
		if (elements.size() > 0) {
			elements.get(elements.size() - 1).click();
		} else
			elements.get(elements.size()).click();
		LOGGER.info("Click cancel call");
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}

	@Override
	public String getNameAbonent() {
		return nameAbonent.getText();
	}

	@Override
	public SettingsPageAndroid navigateToSettingsTab() {
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(settingsTabButton.getFoundBy()));
		for (WebElement element : elements) {
			try {
				element.click();
				LOGGER.info("Click on settings tab");
				return PageFactory.initElements(driver,
						SettingsPageAndroid.class);
			} catch (ElementNotVisibleException e) {

			}
		}
		throw new RuntimeException("Can't click on settings tab");

	}

	@Override
	public String getTimer() {
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		return timer.getText();
	}

	@Override
	public boolean isMicrophoneWork() {
		microphoneButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		microphoneButton.touch();
		return true;
	}

	@Override
	public boolean isSpeakerWork() {
		speakerButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		speakerButton.touch();
		return true;
	}

	public void clickBack() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickCall() {
		// TODO Auto-generated method stub

	}

	@Override
	public CardContactsPageAndroid clickContact() {
		contactTabButton.waitForElement(WAIT_CONTACTS);
		contactTabButton.touch();
		return PageFactory.initElements(driver, CardContactsPageAndroid.class);
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
	public String getContactNumber() {
		return contactName.getText();
	}

	@Override
	public HistoryPageAndroid clickHistoryTab() {
		Sleeper.SYSTEM_SLEEPER.sleep(4000);
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(historyTabButton.getFoundBy()));
		for (WebElement element : elements) {
			try {
				element.click();
				LOGGER.info("Click on history tab");
				return PageFactory.initElements(driver,
						HistoryPageAndroid.class);
			} catch (ElementNotVisibleException e) {

			}
		}
		// elements.get(elements.size()-1).click();

		// historyTabButton.touch();
		throw new RuntimeException("Can't click on history tab");
	}

	@Override
	public String isAnswerIncommingCall() {
		incommingCallText.waitForElement(WAIT_WHILE_LOGIN);
		answerButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		return getTimer();
	}

	@Override
	public CallPageAndroid endCall() {
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(cancelCallButton.getFoundBy()));
		elements.get(elements.size() - 1).click();
		LOGGER.info("Click cancel call");
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}

	@Override
	public CallPageAndroid isIncommingCallReset() {
		incommingCallText.waitForElement(WAIT_WHILE_LOGIN);
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(cancelCallButton.getFoundBy()));
		elements.get(elements.size() - 1).click();
		LOGGER.info("Click cancel call");
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}
	
    @Override
	public  boolean isAccessContacts(){
    	//TODO
    	return false;
    }
	
	@Override
	public CallPageAndroid clickOk(){
		//TODO
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}

}
