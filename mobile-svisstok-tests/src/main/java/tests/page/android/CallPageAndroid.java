package tests.page.android;

import java.util.ArrayList;
import java.util.List;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import tests.page.CallPage;

public class CallPageAndroid extends CallPage {

	@FindBy(locator = "//div[text()='LinphoneRegistrationOk']")
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

	@FindBy(locator = "//input[@class='ui-input-text ui-body-c']")
	public UIView fieldNumber;

	@FindBy(locator = "//td[@class='left addContact']/a")
	private UIView contactButton;

	@FindBy(locator = "//td[@class='center call']/a/span")
	private UIView callButton;

	@FindBy(locator = "//td[@class='right backspace']")
	private UIView deleteButton;

	@FindBy(locator = "//div[contains(@class,'status')]")
	private UIView nameConnection;

	@FindBy(locator = "//a[@id='outgoingCallView-btn-hangup']")
	private UIView cancelCallButton;

	@FindBy(locator = "//div[contains(@class, 'title')]")
	private UIView nameAbonent;

	public CallPageAndroid(NativeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
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
		status.waitForElement(WAIT_WHILE_LOGIN);
		return status.isExists();
	}

	@Override
	public void checkPage() {
		status.waitForElement(WAIT_WHILE_LOGIN);
	}

	@Override
	public void inputAllDigites() {
		for (UIView digit : dial()) {
			digit.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(500);
		}

	}

	@Override
	public void inputFromNativeKeyboard(String text, String digits) {
		// inputAllDigites(); TODO: BUG!
		fieldNumber.clear();
		fieldNumber.type(text);
	}

	@Override
	public void deleteLastSymbol() {
		int length = getTextFieldDigitDisplay().length();
		deleteButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		if(getTextFieldDigitDisplay().length() ==length ) {
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
	public void clickContact() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickCallButton() {
		callButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(8000);
		if (status.isExists()) {
			callButton.touch();
		}

	}

	@Override
	public String getNameConnection() {
		nameConnection.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		return nameConnection.getText();
	}

	@SuppressWarnings("unchecked")
	@Override
	public CallPageAndroid cancelCall() {
		cancelCallButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(5000);
		if (!status.isExists()) {
			cancelCallButton.touch();
		}
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}

	@Override
	public String getNameAbonent() {
		return nameAbonent.getText();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T navigateToSettingsTab() {
		// TODO Auto-generated method stub
		return null;
	}

}
