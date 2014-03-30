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
	
	public abstract <T> T clickContact();
	
	public abstract void clickCallButton();
	
	public abstract String getNameConnection();
	
	public abstract <T> T cancelCall();
	
	public abstract <T> T navigateToSettingsTab();
	
	public abstract String getNameAbonent();
	
	public abstract String getTimer();
	
	public abstract boolean isMicrophoneWork();
	
	public abstract boolean isSpeakerWork();
	
	//public abstract void clickBack();
	
	public abstract void clickCall();
	
	public abstract void clickEditContacts();
	
	public abstract void clickDeletefromList();
	
	public abstract void clickDelete();
	
	public abstract String getContactNumber();
	
	public abstract <T> T clickHistory();

	public abstract String isAnswerIncommingCall();

	public abstract <T> T endCall();

	public abstract <T> T isIncommingCallReset();
	
	public abstract boolean isAccessContacts();
	
	public abstract <T> T clickOk();
}
