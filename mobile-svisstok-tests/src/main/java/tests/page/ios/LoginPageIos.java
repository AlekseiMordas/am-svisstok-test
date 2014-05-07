package tests.page.ios;

import org.apache.log4j.Logger;

import tests.page.LoginPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class LoginPageIos extends LoginPage {

	private static final Logger LOGGER = Logger.getLogger(LoginPageIos.class);

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	public UIView loginTextfield;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/secure[1]")
	public UIView passwordTextfield;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[1]")
	private UIView savePasswordSlider;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[2]")
	private UIView autoLoginSlider;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView loginButton;

	@FindBy(locator = "//window[2]/toolbar[1]/button[1]", ios7 = "//window[2]/toolbar[1]/button[3]")
	private UIView doneButton;

	@FindBy(locator = "Select All")
	private UIView selectAll;

	@FindBy(locator = "Cut")
	private UIView cutButton;

	@FindBy(locator = "//window[2]/UIAKeyboard[1]/UIAKey[28]")
	private UIView deleteButton;
	
	@FindBy(locator = "//window[2]/UIAKeyboard[1]")
	private UIView keyBoard;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[3]", ios7="//window[1]/scrollview[1]/webview[1]/text[5]")
	private UIView errorMessage;

	public LoginPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void setSavePassword(boolean flag) {
		if (flag) {
			if (savePasswordSlider.getAttribute("value").equals("0.00")) {
				savePasswordSlider.touch();
			}
		}
		else {
			if (savePasswordSlider.getAttribute("value").equals("1")) {
				savePasswordSlider.touch();
			}
		}
	}

	@Override
	public void setAutoLogin(boolean flag) {
		if (flag) {
			if (autoLoginSlider.getAttribute("value").equals("0.00")) {
				autoLoginSlider.touch();
			}
		} else {
			if (autoLoginSlider.getAttribute("value").equals("1")) {
				autoLoginSlider.touch();
			}
		}
	}

	@Override
	public void clickLogin() {
		loginButton.touch();
	}

	@Override
	public CallPageIos simpleLogin(String login, String password, boolean isSavePassword, boolean isAutoLogin) {
		inputLoginTextfield(login);
		inputPasswordTextfield(password);
		setSavePassword(isSavePassword);
		setAutoLogin(isAutoLogin);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		loginButton.touch();
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@Override
	public void inputLoginTextfield(String text) {
		loginTextfield.touch();
		clearField(loginTextfield);
		loginTextfield.type(text);
	}

	@Override
	public boolean isErrorMessageAppears() {
		errorMessage.waitForElement(WAIT_WHILE_LOGIN);
		return errorMessage.isExists();
	}

	@Override
	public void clearField(UIView element) {
		if (!(element.getText().contains("Логин"))) {
			element.touchLong();
			selectAll.touch();
			cutButton.touch();
		}
	}

	public void clearPasswordField(UIView element) {
		if (!(element.getText().contains("Пароль"))) {
			element.touchLong();
			selectAll.touch();
			deleteButton.touch();
		}
	}

	@Override
	public String getLoginFieldText() {
		return loginTextfield.getText();
	}

	@Override
	public String getPasswordFieldText() {
		return passwordTextfield.getText();
	}

	@Override
	public void inputPasswordTextfield(String text) {
		passwordTextfield.touch();;
		clearPasswordField(passwordTextfield);
		passwordTextfield.type(text);
		doneButton.touch();
	}

	@Override
	public void checkPage() {
		loginTextfield.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
	}

	@Override
	public boolean isSavePasswordCorrect() {
		return passwordTextfield.getText().length() > 0
				&& loginTextfield.getText().length() > 0;
	}

}
