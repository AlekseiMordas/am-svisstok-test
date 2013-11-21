package tests.appiumTests.ios;

import org.openqa.selenium.html5.ApplicationCache;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.mobile.driver.wait.Sleeper;

import tests.page.CallPage;
import utils.ApplicationStorage;

public class CallTest extends BaseTest {

	private static final String EXPECTED_CALL_NAME = "Подключение...";

	private static final String EXPECTED_TYPE_VALUE = "1234567890";

	protected static final String PHONE_NUMBER = ApplicationStorage.getCallerNumber();
	
	protected static final String USER_NAME = ApplicationStorage.getCallerName();

	@Test(priority = 1)
	public void checkNumberFieldDigits() {
		call.inputFromNativeKeyboard(EXPECTED_TYPE_VALUE);
		Assert.assertEquals(call.getTextFieldDigitDisplay(),
				EXPECTED_TYPE_VALUE, "Digits in field are not equasls");
	}

	@Test(priority = 2)
	public void checkDeleteLastSymbol() {
		call.inputFromNativeKeyboard(PHONE_NUMBER);
		call.deleteLastSymbol();
		Assert.assertEquals(
				PHONE_NUMBER.substring(0, PHONE_NUMBER.length() - 1),
				call.getTextFieldDigitDisplay(),
				"Last symbol not clear successfull");
	}

	@Test(priority = 3, description = "Checck call name")
	public void checkConnectAnotherAbonent() {
		call.inputFromNativeKeyboard(PHONE_NUMBER);
		call.clickCallButton();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		String callNameConnection = call.getNameConnection();
	//	String actualAbonentName = call.getNameAbonent();
		((CallPage) call.cancelCall()).checkPage();
		Assert.assertEquals(EXPECTED_CALL_NAME, callNameConnection);
	//	Assert.assertEquals(PHONE_NUMBER, actualAbonentName);
	}
	
	@Test(priority = 8, description = "Check timer call")
	public void checkTimerCall() {
		call.inputFromNativeKeyboard(USER_NAME);
		call.clickCallButton();
		boolean actualTimer = checkTimer(call.getTimer());
		call.cancelCall();
		Assert.assertTrue(actualTimer);
	}
	
	@Test(priority = 5, description = "Check button cancel in currently call", enabled=false)
	public void checkCancelCallButtonInCall() {
		call.inputFromNativeKeyboard(USER_NAME);
		call.clickCallButton();
		call.cancelCall();
		Assert.assertTrue(call.isStatusAvailable());
	}

	  @Test(priority=6) 
	  public void checkCancelCallButton() {
		  call.inputFromNativeKeyboard(PHONE_NUMBER);
		  call.clickCallButton(); 
		  call.cancelCall();
		  Sleeper.SYSTEM_SLEEPER.sleep(3000);
		  Assert.assertTrue(call.isStatusAvailable()); 
	  }
	 
	 @Test(priority = 7, description = "Check display name abonent in time call")
		public void checkDisplayNameAbonentInCall() {
			call.inputFromNativeKeyboard(USER_NAME);
			call.clickCallButton();
			String actualAbonentName = call.getNameAbonent();
			((CallPage) call.cancelCall()).checkPage();
			Assert.assertTrue(!actualAbonentName.isEmpty(), "Incorrect abonent name");
		}
	  
	 
	/* * TODO Dublicate methods
	 * @Test(priority=5) public void checkDisplayNameAbonent() {
	 * 
	 * call.inputFromNativeKeyboard(PHONE_NUMBER, DIGITS);
	 * call.clickCallButton(); call.getNameConnection(); String
	 * actualAbonentName = call.getNameAbonent(); call.cancelCall();
	 * Assert.assertEquals(PHONE_NUMBER, actualAbonentName); }
	 */
	@AfterMethod
	public void clearField() {
		call.clearField();
	}
}
