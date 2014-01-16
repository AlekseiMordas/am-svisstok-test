package tests.page.android;

import java.awt.Rectangle;
import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import tests.page.SettingsPage;

public class SettingsPageAndroid extends SettingsPage {

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[3]")
	private UIView autoLoginSlider;
	
	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-ALL']")
	private UIView allContactsButton;
	
	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-SWISSTOK']")
	private UIView swisstokContacts;
	
	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-BLOCKED']")
	private UIView blockedContacts;
	
	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-FAVOUR']")
	private UIView favourContacts;
	
	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsFilterView-btn-SAVED']")
	private UIView savedContacts;
	
	public SettingsPageAndroid(NativeDriver driver) {
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
	
	@SuppressWarnings("unchecked")
	public CardContactsPageAndroid clickAllContacts(){
		allContactsButton.touch();
		return PageFactory.initElements(driver, CardContactsPageAndroid.class);
	}
	
	@SuppressWarnings("unchecked")
	public CardContactsPageAndroid clickSwisstokContacts(){
		swisstokContacts.touch();
		return PageFactory.initElements(driver, CardContactsPageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BlockPageAndroid clickBlock() {
		blockedContacts.touch();
		return PageFactory.initElements(driver, BlockPageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public FavoritePageAndroid clickFavorite() {
		favourContacts.touch();
		return PageFactory.initElements(driver, FavoritePageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public SavedContactsPageAndroid clickSavedContacts() {
		savedContacts.touch();
		return PageFactory.initElements(driver, SavedContactsPageAndroid.class);
	}

}
