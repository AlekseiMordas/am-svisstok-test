package tests.page.ios;

import java.awt.Rectangle;

import tests.page.SavedContactsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class SavedContactsPageIos extends SavedContactsPage {

	public SavedContactsPageIos(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	private UIView searchFiled;

	@FindBy(locator = "//window[2]/toolbar[1]/button[1]")
	private UIView doneButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[5]")
	private UIView contactName;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]/link[1]")
	private UIView searchResult;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[10]")
	private UIView star;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[12]")//window[1]/scrollview[1]/webview[1]/link[1]
	private UIView settingTab;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView deleteFromList;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[16]")
	private UIView deleteButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]/link[1]")
	private UIView backTab;

	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		doneButton.touch();
	}

	@Override
	public void clickSearchResult(String name) {
		Rectangle point = webview.getLocation();
		double y = 113;
		webview.touchWithCoordinates(point.getX(), point.getY() + y);
	}

	public String getContactName() {
		return contactName.getAttribute("name");
	}

	public void clickEditContacts() {
		Rectangle point = webview.getLocation();
		double x = 270;
		webview.touchWithCoordinates(point.getX() + x, point.getY());
	}

	@Override	
	public void clickDeletefromList(){
		Rectangle point = deleteFromList.getLocation();
		deleteFromList.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
	
	@Override	
	public void clickDelete(){
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
	}

	public void clickCall() {
		Rectangle point = webview.getLocation();
		double x = 160;
		double y = 406;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}

	public void clickStar() {
		star.touch();
	}

	public void clickBack() {
		Rectangle point = backTab.getLocation();
		backTab.touchWithCoordinates(point.getX(), point.getY());
	}

	@SuppressWarnings("unchecked")
	@Override
	public SettingsPageIos clickSettings() {
		Rectangle point = settingTab.getLocation();
		settingTab.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, SettingsPageIos.class);
	}

}
