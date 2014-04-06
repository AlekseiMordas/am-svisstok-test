package tests.page.ios;

import java.awt.Rectangle;

import org.testng.Assert;

import tests.page.HistoryFilterPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class HistoryFilterPageIos extends HistoryFilterPage{
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[1]")
	private UIView header;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[1]")
	private UIView filterButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]/link[1]/text[1]")
	private UIView allCalls;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView missed;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[5]")
	private UIView incoming;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[6]")
	private UIView outgoing;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[7]")
	private UIView rejected;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]")
	private UIView editButton;

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
		allCalls.touch();
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
	private String getTitle() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		return header.getAttribute("label");
	}
	
	private boolean isExistElement(UIView element){
		return element.isExists();
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

}
