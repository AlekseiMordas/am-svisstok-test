package tests.appiumTests.ios;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.testng.annotations.Test;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.wait.Sleeper;

public class CallTest extends BaseTest {
	
	protected static final String PHONE_NUMBER = "0041930291";
	
	protected static final String DIGITS = "digits";
	
	@Test(priority=1)
	public void  checkNumberFieldDigits() {
		
		call.inputFromNativeKeyboard("1234567", "digits");
		Assert.assertEquals(call.getTextFieldDigitDisplay(), "1234567");
		//return pre-test state
		call.clearField();
	}
	
	@Test(priority=2)
	public void  checkDeleteLastSymbol() {
		
		call.inputFromNativeKeyboard(PHONE_NUMBER, DIGITS);
		call.deleteLastSymbol();
		Assert.assertEquals("004193029", call.getTextFieldDigitDisplay());
		//return pre-test state
		call.clearField();
	}
	
	
	@Test(priority=3)
	public void  checkConnectAnotherAbonent() {

		call.inputFromNativeKeyboard(PHONE_NUMBER, DIGITS);
		call.clickCallButton();
		call.getNameConnection();
		Assert.assertEquals("Подключение...", call.getNameConnection());
		//return pre-test state
		call.cancelCall();
		call.clearField();
	}
	
	@Test(priority=4)
	public void  checkCancelCallButton() {

		call.inputFromNativeKeyboard(PHONE_NUMBER, DIGITS);
		call.clickCallButton();
		call.getNameConnection();
		call.cancelCall();
		Assert.assertEquals(PHONE_NUMBER, call.getTextFieldDigitDisplay());		
		//return pre-test state
		call.clearField();
	}
	
	@Test(priority=5)
	public void  checkDisplayNameAbonent() {

		call.inputFromNativeKeyboard(PHONE_NUMBER, DIGITS);
		call.clickCallButton();
		call.getNameConnection();
		Assert.assertEquals(PHONE_NUMBER, call.getNameAbonent());		
		//return pre-test state
		call.cancelCall();
		call.clearField();
	}

}
