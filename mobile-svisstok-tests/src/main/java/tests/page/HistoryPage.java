package tests.page;

import tests.page.ios.BasePage;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class HistoryPage extends BasePage{

	public HistoryPage(NativeDriver driver) { 
		this.driver = driver;
	}
	
	public abstract void clickFirstContact();
	
	public abstract void cancelCall();
	
	public abstract String getTimer();
	
	public abstract void clickCall();

}
