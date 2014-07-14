package tests.page.ios;

import java.awt.Rectangle;

import org.openqa.selenium.Dimension;

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

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	private UIView searchFiled;

	@FindBy(locator = "Done")
	private UIView doneButton;

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]")
	private UIView webview;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[5]")
	private UIView contactName;

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]")
	private UIView searchResult;

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[10]",
			ios7 = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[10]")
	private UIView star;
	
	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]/UIALink[1]",
			ios7 = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]")
	private UIView settingTab;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView deleteFromList;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[16]")
	private UIView deleteButton;
	
	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]/UIALink[1]",
			ios7 = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[5]")
	private UIView backTab;

	@Override
	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		doneButton.touch();
	}

	@Override
	public CallPageIos clickSearchResult(String name) {
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		Dimension dim = webview.getSize();
		webview.touchWithCoordinates(dim.getWidth() / 2, dim.getHeight() / dim.getHeight() + 120);
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@Override
	public String getContactName() {
		return contactName.getAttribute("name");
	}

	@Override
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

	@Override
	public void clickCall() {
		Rectangle point = webview.getLocation();
		double x = 160;
		double y = 406;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}

	@Override
	public void clickStar() {
		Rectangle point = star.getLocation();
		star.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
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
