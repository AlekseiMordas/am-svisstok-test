package tests.page;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;


import tests.page.ios.BasePage;


public abstract class LoginPage extends BasePage {
	public LoginPage(NativeDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param flag
	 */
	public abstract void setSavePassword(boolean flag);
	
	/**
	 * @param flag
	 */
	public abstract void setAutoLogin(boolean flag);

	public abstract void clickLogin();

	public abstract <T> T simpleLogin(String login, String password, boolean isSavePassword, boolean isAutoLogin);
	
	public abstract boolean isSavePasswordCorrect();

	public abstract void inputLoginTextfield(String text);

	public abstract boolean isErrorMessageAppears();

	public abstract void clearField(UIView element);

	public abstract void inputPasswordTextfield(String text);
	
	public abstract String getLoginFieldText();

	public abstract String getPasswordFieldText();
}
