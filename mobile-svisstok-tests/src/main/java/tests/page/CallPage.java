package tests.page;

import tests.page.ios.BasePage;
import com.mobile.driver.nativedriver.NativeDriver;

public abstract class CallPage extends BasePage{

	public CallPage(NativeDriver driver) { 
		this.driver = driver;
	}

	public abstract boolean isStatusAvailable();
	
	public abstract void inputAllDigites();
	
	public abstract void inputFromNativeKeyboard(String text);
	
	public abstract void deleteLastSymbol();
	
	public abstract String getTextFieldDigitDisplay();
	
	public abstract void clearField();
	
	public abstract void clickContact();
	
	public abstract void clickCallButton();
	
	public abstract String getNameConnection();
	
	public abstract <T> T cancelCall();
	
	public abstract <T> T navigateToSettingsTab();
	
	public abstract String getNameAbonent();
	
	public abstract String getTimer();
	
	public abstract boolean isMicrophoneWork();
}
