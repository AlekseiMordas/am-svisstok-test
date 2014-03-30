package tests.page.ios;

import java.awt.Rectangle;

import tests.page.SettingsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class SettingsPageIos extends SettingsPage {

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[3]")
	private UIView autoLoginSlider;
	
	@FindBy(locator = "Все контакты")
	private UIView allContacts;
	
	@FindBy(locator = "Контакты в Swisstok")
	private UIView swisstokContacts;
	
	@FindBy(locator = "Избранные")
	private UIView favourContacts;
	
	@FindBy(locator = "Сохраненные номера")
	private UIView savedContacts;
	
	@FindBy(locator = "Заблокированные")
	private UIView block;
	

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
		return autoLoginSlider.getAttribute("value").equals("0.00");
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public CardContactsPageIos clickAllContacts(){
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = allContacts.getLocation();
		allContacts.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}
	
	//use coordinats, because dynamic xPath
	@Override
	@SuppressWarnings("unchecked")
	public CardContactsPageIos clickSwisstokContacts(){
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = swisstokContacts.getLocation();
		swisstokContacts.touchWithCoordinates(point.getX(), 200);
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public BlockPageIos clickBlock() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = block.getLocation();
		block.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, BlockPageIos.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public FavoritePageIos clickFavorite(){
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = favourContacts.getLocation();
		favourContacts.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, FavoritePageIos.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public SavedContactsPageIos clickSavedContacts(){
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = savedContacts.getLocation();
		savedContacts.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, SavedContactsPageIos.class);
	}

	@Override
	public void setZRTPconnection() {
		throw new RuntimeException("Need Implement this method");
	}

	@Override
	public void setSRTPconnection() {
		throw new RuntimeException("Need Implement this method");
	}


	@Override
	public <T> T clickCall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setConnectionByDefault() {
		throw new RuntimeException("Need Implement this method");
	}

}
