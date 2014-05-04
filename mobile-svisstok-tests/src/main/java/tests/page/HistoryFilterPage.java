package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class HistoryFilterPage extends BasePage {

	public HistoryFilterPage(NativeDriver driver) {
		this.driver = driver;
	}

	public abstract HistoryFilterPage clickAllContacts();

	public abstract HistoryFilterPage clickMissedCalls();

	public abstract HistoryFilterPage clickIncomingCalls();

	public abstract HistoryFilterPage clickOutcommingCalls();

	public abstract HistoryFilterPage clickRejectedCalls();

	public abstract void checkHistoryFilter();

	public abstract void checkVisibleShortName();
}
