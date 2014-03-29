package tests.page;

import java.awt.Rectangle;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class HistoryPage extends BasePage {

	public HistoryPage(NativeDriver driver) {
		this.driver = driver;
	}

	public abstract void clickFirstContact();

	public abstract <T> T cancelCall();

	public abstract String getTimer();

	public abstract void clickCall();

	public abstract void clickEdit();

	public abstract void findDeleteContacts();

	public abstract int deleteCall();

	public abstract void deleteAllCalls();

	public abstract int getCountUsers();
	
	public abstract String getMessageEmptyList();

}
