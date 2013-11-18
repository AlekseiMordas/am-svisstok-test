package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.page.CallPage;

public class CallTest extends BaseTest {

	private static final String EXPECTED_CALL_NAME = "Подключение...";

	private static final String EXPECTED_TYPE_VALUE = "1234567890";

	protected static final String PHONE_NUMBER = "0041930291";
	
	protected static final String USER_NAME = "skustov2";

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

	@Test(priority = 3, description = "Checck call name, check Phone number")
	public void checkConnectAnotherAbonent() {
		call.inputFromNativeKeyboard(PHONE_NUMBER);
		call.clickCallButton();
		String callNameConnection = call.getNameConnection();
		String actualAbonentName = call.getNameAbonent();
		((CallPage) call.cancelCall()).checkPage();
		Assert.assertEquals(EXPECTED_CALL_NAME, callNameConnection);
		Assert.assertEquals(PHONE_NUMBER, actualAbonentName);
	}
	
	@Test(priority = 4, description = "Check timer call")
	public void checkTimerCall() {
		call.inputFromNativeKeyboard(USER_NAME);
		call.clickCallButton();
		boolean actualTimer = checkTimer(call.getTimer());
		call.cancelCall();
		Assert.assertTrue(actualTimer);
	}
	
	@Test(priority = 5, description = "Check button cancel in currently call")
	public void checkCancelCallButtonInCall() {
		call.inputFromNativeKeyboard(USER_NAME);
		call.clickCallButton();
		call.cancelCall();
		Assert.assertEquals(USER_NAME, call.getTextFieldDigitDisplay());
	}


	/*
	 * TODO Dublicate methods
	 * 
	 * @Test(priority=4) public void checkCancelCallButton() {
	 * call.inputFromNativeKeyboard(PHONE_NUMBER, DIGITS);
	 * call.clickCallButton(); call.getNameConnection(); call.cancelCall();
	 * Assert.assertEquals(PHONE_NUMBER, call.getTextFieldDigitDisplay()); }
	 * 
	 * 
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
