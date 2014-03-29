package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import runner.Devices;
import tests.page.android.CallPageAndroid;
import tests.page.android.CardContactsPageAndroid;
import tests.page.android.LoginPageAndroid;
import tests.page.exceptions.XmlParametersException;
import tests.page.ios.CallPageIos;
import tests.page.ios.CardContactsPageIos;
import tests.page.ios.LoginPageIos;

import com.ios.AppiumDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import driver.IosDriverWrapper;

public class HistoryTests extends BaseTest {
	
	private static final String MESSAGE_EMPTY_LIST = "Список пустой.";

	@Test(priority = 1)
	public void checkCallFromHistory() {
		callOneself();
		history = call.clickHistory();
		history.clickFirstContact();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		boolean actualTimer = checkTimer(history.getTimer());
		history.cancelCall();
		history.clickEdit();
		history.deleteAllCalls();
		history.clickCall();
		Assert.assertTrue(actualTimer);
	}

	@Test(priority = 2)	
	public void deleteCallFromHistory() {
		callOneself();
		history = call.clickHistory();
		history.clickEdit();
		history.deleteCall();
		Assert.assertEquals(history.getMessageEmptyList(), MESSAGE_EMPTY_LIST);
		history.clickCall();
	}
	
	@Test(priority = 3)
	public void deleteAllCallsFromHistory() {
		callOneself();
		call.clearField();
		callOneself();
		history = call.clickHistory();
		history.clickEdit();
		history.deleteAllCalls();
		Assert.assertEquals(history.getMessageEmptyList(), MESSAGE_EMPTY_LIST);
		history.clickCall();
	}
	
	private void callOneself(){
	   call.inputFromNativeKeyboard(USER_NAME);  
	   call.clickCallButton(); 
	   call.cancelCall();
	}
	
	@AfterMethod
	public void clearField() {
		call.clearField();
	}
	
}
