package tests.page.ios;

import java.awt.Rectangle;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import tests.page.HistoryFilterPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class HistoryFilterPageIos extends HistoryFilterPage{
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[1]")
	private UIView header;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView filterButton;
	
	@FindBy(locator = "Все звонки")
	private UIView allCalls;
	
	@FindBy(locator = "Пропущенные звонки")
	private UIView missed;
	
	@FindBy(locator = "Входящие звонки")
	private UIView incoming;
	
	@FindBy(locator = "Исходящие звонки")
	private UIView outgoing;
	
	@FindBy(locator = "Несостоявшиеся вызовы")
	private UIView rejected;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]")
	private UIView editButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]/link[3]/text[1]")
	private UIView nameContact;

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
		List<WebElement> list = ((AppiumDriver) driver).getDriver().findElements(By.name("Все звонки"));
		Point point=  list.get(list.size()-1).getLocation();
		allCalls.touchWithCoordinates(point.getX(), point.getY());
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
//		String name = DeviceConfig.getCaller();
//		Assert.assertEquals(name, clickAllContacts()
//				.getName(nameContact));
//		openFilter();
//		Assert.assertEquals(name, clickMissedCalls()
//				.getName(nameContact));
//		openFilter();
//		Assert.assertEquals(name, clickIncomingCalls()
//				.getName(nameContact));
//		openFilter();
//		Assert.assertEquals(name, clickOutcommingCalls()
//				.getName(nameContact));
//		openFilter();
//		Assert.assertEquals(name, clickRejectedCalls()
//				.getName(nameContact));
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
