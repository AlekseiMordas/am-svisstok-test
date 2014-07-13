package tests.page.ios;

import java.awt.Rectangle;

import org.openqa.selenium.By;

import tests.page.BlockPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.wait.Sleeper;

public class BlockPageIos extends BlockPage {
	public BlockPageIos(NativeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
	private UIView searchFiled;

	@FindBy(locator = "Done")
	private UIView doneButton;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]")
	private UIView contactName;

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]")
	private UIView searchResult;

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]/UIALink[1]")
	private UIView settingTab;

	@FindBy(locator = "Удалить",
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[5]")
	private UIView deleteFromList;

	@FindBy(locator = "Удалить")
	// window[1]/scrollview[1]/webview[1]/link[23]
	private UIView deleteButton;

	@FindBy(locator = " //window[1]/scrollview[1]/webview[1]/text[4]")
	private UIView contactStatusBlock;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		doneButton.touch();
	}

	@Override
	public void clickSearchResult(String name) {
		Rectangle point = searchResult.getLocation();
		searchResult.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public String getContactName() {
		return contactName.getAttribute("name");
	}

	@Override
	public boolean isContactStatusBlockAppears(String message) {
		return ((AppiumDriver) driver).getDriver()
				.findElements(By.name(message)).size() > 0;
	}

	@Override
	public void clickEditContacts() {
		Rectangle point = settingTab.getLocation();
		settingTab.touchWithCoordinates(point.getX(), point.getY());
	}

	@Override
	public void clickDeletefromList() {
		Rectangle point = deleteFromList.getLocation();
		deleteFromList.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}

	@Override
	public void clickDelete() {
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void clickCall() {

	}
}
