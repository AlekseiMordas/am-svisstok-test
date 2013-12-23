package tests.page.ios;

import java.awt.Rectangle;

import org.openqa.selenium.support.FindAll;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import tests.page.SettingsPage;
import tests.page.ios.BasePage;

public class SettingsPageIos extends SettingsPage {

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[3]")
	private UIView autoLoginSlider;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[14]")
	private UIView swisstokContacts;
	

	public SettingsPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void checkPage() {
	}

	@Override
	public void setAutoLogin(boolean flag) {
		if (flag) {
			if (autoLoginSlider.getAttribute("value").equals("0.00")) {
				autoLoginSlider.touch();
			}
		}
		else {
			if (autoLoginSlider.getAttribute("value").equals("1")) {
				autoLoginSlider.touch();
			}
		}
	}

	@Override
	public boolean isAutoLoginFlagEnable() {
		return autoLoginSlider.getAttribute("value").equals("0.00") ? true:false;
	}
	
	public CardContactsPageIos clickAllContacts(){
		Rectangle point = webview.getLocation();
		double x = 11;
		double y = 63;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}
	
	//use coordinats, because dynamic xPath
	public CardContactsPageIos clickSwisstokContacts(){
		Rectangle point = webview.getLocation();
		double x = 11;
		double y = 170;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}

}
