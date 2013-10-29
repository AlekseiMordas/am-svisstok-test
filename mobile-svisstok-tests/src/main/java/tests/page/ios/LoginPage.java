package tests.page.ios;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;

import tests.page.exceptions.AdSDKLoadException;
import tests.page.exceptions.AdSDKToolbarException;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class LoginPage extends BasePage {

	private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	public UIView loginTextfield;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/secure[1]")
	public UIView passwordTextfield;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[1]")
	private UIView savePasswordSlider;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView loginButton;

	@FindBy(locator = "//window[2]/toolbar[1]/button[1]")
	private UIView doneButton;

	@FindBy(locator = "Select All")
	private UIView selectAll;

	@FindBy(locator = "Delete")
	private UIView deleteButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[5]")
	private UIView errorMessage;

	public LoginPage(NativeDriver driver) {
		this.driver = driver;
	}

	public void savePasswordFalse() {
		if (savePasswordSlider.getAttribute("value") == "Нет") {
			savePasswordSlider.touch();
		}
	}

	public void clickLogin() {
		loginButton.touch();
	}
	
	public CallScreen simpleLogin(String login, String password) {
		loginTextfield.touch();
		loginTextfield.type(login);
		passwordTextfield.touch();
		passwordTextfield.type(password);
		savePasswordFalse();
		loginButton.touch();
		return PageFactory.initElements(driver, CallScreen.class);
	}

	public void inputLoginTextfield(String text) {
		loginTextfield.touch();
		clearField(loginTextfield);
		loginTextfield.type(text);
	}

	public boolean isErrorMessageAppears() {
		errorMessage.waitForElement(WAIT_FOR_AD);
		return errorMessage.isExists();
	}
	
	public void clearField(UIView element) {
		if (!(element.getText().isEmpty())) {
			element.touchLong();
			selectAll.touchByName();
			deleteButton.touchByName();
		}
	}
	
	public void inputPasswordTextfield(String text) {
		passwordTextfield.touch();
		clearField(passwordTextfield);
		passwordTextfield.type(text);
	}

	@Override
	public void checkPage() {
		loginTextfield.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);

	}

}
