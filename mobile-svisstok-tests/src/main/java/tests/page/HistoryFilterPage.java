package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class HistoryFilterPage extends BasePage{

	public HistoryFilterPage(NativeDriver driver) {
		this.driver = driver;
	}

	public abstract <T> T clickAllContacts();

	public abstract <T> T clickMissedCalls();

	public abstract <T> T clickIncomingCalls();

	public abstract <T> T clickOutcommingCalls();

	public abstract <T> T clickRejectedCalls();
	
	public abstract void checkHistoryFilter();
}
