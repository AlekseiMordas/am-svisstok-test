package tests.page.ios;

import org.openqa.selenium.support.FindAll;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;

import tests.page.SettingsPage;
import tests.page.ios.BasePage;

public class SettingsPageIos extends SettingsPage {

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[3]")
	private UIView autoLoginSlider;

	public SettingsPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void checkPage() {
	}

	@Override
	public void setAutoLogin(boolean flag) {
		if (flag) {
			if (autoLoginSlider.getAttribute("value") == "Нет") {
				autoLoginSlider.touch();
			}
		} else {
			if (autoLoginSlider.getAttribute("value") == "Да") {
				autoLoginSlider.touch();
			}
		}
	}

}
