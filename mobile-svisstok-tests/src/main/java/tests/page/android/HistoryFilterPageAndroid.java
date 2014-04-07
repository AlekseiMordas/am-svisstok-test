package tests.page.android;

import org.apache.log4j.Logger;
import org.testng.Assert;

import tests.page.HistoryFilterPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class HistoryFilterPageAndroid extends HistoryFilterPage {

	private static final String ACTIVE_PAGE = "//div[contains(@class,'ui-page-active')]";

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='historyFilterView-btn-ALL']")
	private UIView allContactsButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='historyFilterView-btn-MISSED']")
	private UIView missedCalls;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='historyFilterView-btn-INCOMING']")
	private UIView incommingCalls;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='historyFilterView-btn-OUTGOING']")
	private UIView outgoingCalls;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='historyFilterView-btn-REJECTED']")
	private UIView rejectedCalls;

	@FindBy(locator = ACTIVE_PAGE + "//a[@id='historyView-btn-filter']")
	private UIView filterButton;

	@FindBy(locator = "//div[contains(@class,'ui-header ui-bar-a')]//h1[@id='historyView-title']")
	private UIView header;

	private static final Logger LOGGER = Logger.getLogger(AppiumDriver.class);

	public HistoryFilterPageAndroid(NativeDriver driver) {
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

	@SuppressWarnings("unchecked")
	@Override
	public HistoryFilterPageAndroid clickAllContacts() {
		allContactsButton.touch();
		return PageFactory.initElements(driver, HistoryFilterPageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HistoryFilterPageAndroid clickMissedCalls() {
		missedCalls.touch();
		return PageFactory.initElements(driver, HistoryFilterPageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HistoryFilterPageAndroid clickIncomingCalls() {
		incommingCalls.touch();
		return PageFactory.initElements(driver, HistoryFilterPageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HistoryFilterPageAndroid clickOutcommingCalls() {
		outgoingCalls.touch();
		return PageFactory.initElements(driver, HistoryFilterPageAndroid.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HistoryFilterPageAndroid clickRejectedCalls() {
		rejectedCalls.touch();
		return PageFactory.initElements(driver, HistoryFilterPageAndroid.class);
	}

	private String getTitle() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		return header.getText();
	}

	@Override
	public void checkHistoryFilter() {
		Assert.assertEquals(Headers.ALL_CALLS.toString(), clickAllContacts()
				.getTitle());
		openFilter();
		Assert.assertEquals(Headers.MISSED.toString(), clickMissedCalls()
				.getTitle());
		openFilter();
		Assert.assertEquals(Headers.INCOMING.toString(), clickIncomingCalls().getTitle());
		openFilter();
		Assert.assertEquals(Headers.OUTGOING.toString(), clickOutcommingCalls().getTitle());
		openFilter();
		Assert.assertEquals(Headers.REJECTED.toString(), clickRejectedCalls().getTitle());
	}

	private void openFilter() {
		filterButton.touch();
		PageFactory.initElements(driver, HistoryFilterPageAndroid.class);
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}
	
	public void checkVisibleShortName(){
		throw new RuntimeException("need to implement");
	}

}
