package tests.page.ios;

import java.awt.Rectangle;

import org.testng.Assert;

import runner.DeviceConfig;
import tests.page.HistoryFilterPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class HistoryFilterPageIos extends HistoryFilterPage{
	
	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[1]")
	private UIView header;
	
	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]/UIALink[1]",
			ios7 = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]")
	private UIView filterButton;
	
	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[3]",
			ios7 = "//UIALink[@name='Все звонки']")
	private UIView allCalls;
	
	@FindBy(locator = "Пропущенные звонки")
	private UIView missed;
	
	@FindBy(locator = "Входящие звонки")
	private UIView incoming;
	
	@FindBy(locator = "Исходящие звонки")
	private UIView outgoing;
	
	@FindBy(locator = "Несостоявшиеся вызовы")
	private UIView rejected;
	
	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[2]")
	private UIView editButton;
	
	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]/UIALink[3]/UIAStaticText[1]")
	private UIView nameContact;
	
	private static String NAME = "//UIALink[@name='%s']";
	
	@FindBy(locator = "//UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[1]/UIALink[1]")
	private UIView backFromAllContacts;

	public HistoryFilterPageIos(NativeDriver driver) {
		super(driver);
	}
	
	public enum Headers {
		ALL_CALLS("Все звонки"), MISSED("Пропущенные звонки"), INCOMING(
				"Входящие звонки"), OUTGOING("Исходящие звонки"), REJECTED(
				"Несостоявшиеся вызовы");

		private final String text;

		private Headers(final String text) {
			this.text = text;
		}

		@Override
		public String toString() {
			return text;
		}
	};

	@Override
	public HistoryFilterPageIos clickAllContacts() {
//		List<WebElement> list = ((AppiumDriver) driver).getDriver().findElements(By.name("Все звонки"));
//		Point point=  list.get(list.size()-1).getLocation();
		Rectangle point=  allCalls.getLocation();
		allCalls.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		return PageFactory.initElements(driver, HistoryFilterPageIos.class);
	}

	@Override
	public HistoryFilterPageIos clickMissedCalls() {
		missed.touch();
		return PageFactory.initElements(driver, HistoryFilterPageIos.class);
	}

	@Override
	public HistoryFilterPageIos clickIncomingCalls() {
		incoming.touch();
		return PageFactory.initElements(driver, HistoryFilterPageIos.class);
	}

	@Override
	public HistoryFilterPageIos clickOutcommingCalls() {
		outgoing.touch();
		return PageFactory.initElements(driver, HistoryFilterPageIos.class);
	}

	@Override
	public HistoryFilterPageIos clickRejectedCalls() {
		rejected.touch();
		return PageFactory.initElements(driver, HistoryFilterPageIos.class);
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
	public HistoryFilterPageIos openFilter() {
		Rectangle point = filterButton.getLocation();
		filterButton.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, HistoryFilterPageIos.class);
	}

	@Override
	public void checkHistoryFilter() {
		Assert.assertEquals(Headers.ALL_CALLS.toString(), clickAllContacts()
				.getTitle());
		openFilter();
		Assert.assertTrue(clickMissedCalls().isExistElement(header));
		openFilter();
		Assert.assertTrue(clickIncomingCalls().isExistElement(header));
		openFilter();
		Assert.assertTrue(clickOutcommingCalls().isExistElement(header));
		openFilter();
		Assert.assertTrue(clickRejectedCalls().isExistElement(header));
	}
	
	@Override
	public void checkVisibleShortName(){
		//TODO: strange naming of contacts
		String name = DeviceConfig.getCaller();
		((AppiumDriver) driver).getDriver().findElementByXPath(String.format(NAME, "Auto9893")).isDisplayed();
		//Assert.assertEquals(name, clickAllContacts()
			//	.getName(nameContact));
		openFilter();
		((AppiumDriver) driver).getDriver().findElementByXPath(String.format(NAME, name)).isDisplayed();
		//Assert.assertEquals(name, clickMissedCalls()
		//		.getName(nameContact));
		openFilter();
		((AppiumDriver) driver).getDriver().findElementByXPath(String.format(NAME, name)).isDisplayed();
		//Assert.assertEquals(name, clickIncomingCalls()
		//		.getName(nameContact));
		openFilter();
		((AppiumDriver) driver).getDriver().findElementByXPath(String.format(NAME, name)).isDisplayed();
		//Assert.assertEquals(name, clickOutcommingCalls()
		//		.getName(nameContact));
		openFilter();
		((AppiumDriver) driver).getDriver().findElementByXPath(String.format(NAME, name)).isDisplayed();
		//Assert.assertEquals(name, clickRejectedCalls()
		//		.getName(nameContact));
	}
	
	private String getTitle() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		return header.getAttribute("label");
	}
	
	private boolean isExistElement(UIView element){
		return element.isExists();
	}
	
	private String getName(UIView element){
		return element.getAttribute("name");
	}

}
