package tests.page.ios;

import java.awt.Rectangle;

import org.testng.Assert;

import tests.page.HistoryPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class HistoryPageIos extends HistoryPage{
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[1]")
	private UIView header;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]/link[1]",
			ios7 = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView filterButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]",
			ios7 = "Все звонки")
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
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]/link[1]")
	private UIView backFromAllContacts;

	public HistoryPageIos(NativeDriver driver) {
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

	
	public HistoryPageIos clickAllContacts() {
//		List<WebElement> list = ((AppiumDriver) driver).getDriver().findElements(By.name("Все звонки"));
//		Point point=  list.get(list.size()-1).getLocation();
		Rectangle point=  allCalls.getLocation();
		allCalls.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}


	public HistoryPageIos clickMissedCalls() {
		missed.touch();
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}

	
	public HistoryPageIos clickIncomingCalls() {
		incoming.touch();
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}

	
	public HistoryPageIos clickOutcommingCalls() {
		outgoing.touch();
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}

	
	public HistoryPageIos clickRejectedCalls() {
		rejected.touch();
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public HistoryPageIos openFilter() {
		Rectangle point = filterButton.getLocation();
		filterButton.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, HistoryPageIos.class);
	}

	
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


	@Override
	public void clickFirstContact() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <T> T cancelCall() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getTimer() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void clickCallTab() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void clickEdit() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void findDeleteContacts() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int deleteCall() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void deleteAllCalls() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getCountUsers() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getMessageEmptyList() {
		// TODO Auto-generated method stub
		return null;
	}


}
