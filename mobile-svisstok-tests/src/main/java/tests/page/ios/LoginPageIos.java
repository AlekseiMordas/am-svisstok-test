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

	private static final String VALUE = "value";

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]")
	private UIView webview;

	@FindBy(locator = "//UIATextField[1]")
	public UIView loginTextfield;

	@FindBy(locator = "//UIASecureTextField[1]")
	public UIView passwordTextfield;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASlider[1]")
	private UIView savePasswordSlider;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASlider[2]")
	private UIView autoLoginSlider;

	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]")
	private UIView loginButton;

	@FindBy(locator = "Done")
	private UIView doneButton;

	@FindBy(locator = "Select All")
	private UIView selectAll;

	@FindBy(locator = "Cut")
	private UIView cutButton;

	@FindBy(locator = "//UIAKey[@name='Delete']")
	private UIView deleteButton;

	@FindBy(locator = "//UIAWindow[2]/UIAKeyboard[1]")
	private UIView keyBoard;

	@FindBy(locator = "Не удалось выполнить вход")
	private UIView errorMessage;

	public LoginPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void setSavePassword(boolean flag) {
		if (flag) {
			if (savePasswordSlider.getAttribute(VALUE).equals("0.00")) {
				savePasswordSlider.touch();
			}
		} else {
			if (savePasswordSlider.getAttribute(VALUE).equals("1")) {
				savePasswordSlider.touch();
			}
		}
	}

	@Override
	public void setAutoLogin(boolean flag) {
		if (flag) {
			if (autoLoginSlider.getAttribute(VALUE).equals("0.00")) {
				autoLoginSlider.touch();
			}
		} else {
			if (autoLoginSlider.getAttribute(VALUE).equals("1")) {
				autoLoginSlider.touch();
			}
		}
	}

	@Override
	public void clickLogin() {
		loginButton.touch();
	}

	@Override
	public CallPageIos simpleLogin(String login, String password,
			boolean isSavePassword, boolean isAutoLogin) {
		doLogin(login, password, isSavePassword, isAutoLogin);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		if (savePasswordSlider.isExists()) {
			doLogin(login, password, isSavePassword, isAutoLogin);
		}
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	public void doLogin(String login, String password, boolean isSavePassword,
			boolean isAutoLogin) {
		inputLoginTextfield(login);
		inputPasswordTextfield(password);
		setSavePassword(isSavePassword);
		setAutoLogin(isAutoLogin);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		loginButton.touch();
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
		if (!(element.getAttribute("value").contains("Логин"))) {
			element.touchLong();
			selectAll.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(1000);
			cutButton.touch();
			Sleeper.SYSTEM_SLEEPER.sleep(1000);
		}
	}

	public void clearPasswordField(UIView element) {
		if (!(element.getAttribute("value").contains("Пароль"))) {
			element.touchLong();
			selectAll.touch();
			deleteButton.touch();
		}
	}

	@Override
	public String getLoginFieldText() {
		return loginTextfield.getAttribute(VALUE);
	}

	@Override
	public String getPasswordFieldText() {
		return passwordTextfield.getText();
	}

	@Override
	public void inputPasswordTextfield(String text) {
		passwordTextfield.touch();
		clearPasswordField(passwordTextfield);
		passwordTextfield.type(text);
		doneButton.touch();
	}

	@Override
	public void checkPage() {
		loginTextfield.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
	}

	@Override
	public boolean isPageOpenned() {
		return loginTextfield.isExists();
	}

	@Override
	public boolean isSavePasswordCorrect() {
		return passwordTextfield.getText().length() > 0
				&& loginTextfield.getText().length() > 0;
	}

}
