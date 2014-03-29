package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import tests.page.CallPage;
import utils.ApplicationStorage;

import com.mobile.driver.wait.Sleeper;

public class CallTest extends BaseTest {

	private static final String EXPECTED_CALL_NAME = "Подключение...";

	private static final String EXPECTED_TYPE_VALUE = "1234567890";

	protected static final String PHONE_NUMBER = ApplicationStorage
			.getCallerNumber();

	// protected static final String USER_NAME =
	// ApplicationStorage.getCallerName();
	protected static final String NAME = "Qwerty";
	protected static final String NUMBER = "1234";

	@Test(priority = 1)
	public void checkNumberFieldDigits() {
		call.inputFromNativeKeyboard(EXPECTED_TYPE_VALUE);
		Assert.assertEquals(call.getTextFieldDigitDisplay(),
				EXPECTED_TYPE_VALUE, "Digits in field are not equasls");
	}
/*
	@Test(priority = 2)
	public void checkDeleteLastSymbol() {
		call.inputFromNativeKeyboard(PHONE_NUMBER);
		call.deleteLastSymbol();
		Assert.assertEquals(
				PHONE_NUMBER.substring(0, PHONE_NUMBER.length() - 1),
				call.getTextFieldDigitDisplay(),
				"Last symbol not clear successfull");
	}

	@Test(priority = 3, description = "Check call name")
	public void checkConnectAnotherAbonent() {
		call.inputFromNativeKeyboard(PHONE_NUMBER);
		call.clickCallButton();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		String callNameConnection = call.getNameConnection();
		((CallPage) call.cancelCall()).checkPage();
		Assert.assertEquals(EXPECTED_CALL_NAME, callNameConnection);
	}

	@Test(priority = 8, description = "Check timer call")
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
		Assert.assertTrue(call.isStatusAvailable());
	}

	@Test(priority = 6)
	public void checkCancelCallButton() {
		call.inputFromNativeKeyboard(USER_NAME);
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
		Assert.assertTrue(!actualAbonentName.isEmpty(),
				"Incorrect abonent name");
	}

	@Test(priority = 9, description = "Check microfone, Check speaker")
	public void checkMicrofone() {
		call.inputFromNativeKeyboard(USER_NAME);
		call.clickCallButton();
		boolean isMicrofone = call.isMicrophoneWork();
		boolean isSpeaker = call.isSpeakerWork();
		call.cancelCall();
		Assert.assertTrue(isMicrofone);
		Assert.assertTrue(isSpeaker);
	}

	@Test(priority = 10, description = "Check call from favorite")
	// Android bug
	public void checkCallFromFavotite() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickSwisstokContacts();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(USER_NAME);
		cardContacts.inputContact(USER_NAME);
		cardContacts.clickSave();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.swipe(0.5, 0.8, 0.5, 0.1, 0.5);
		cardContacts.clickStar();
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		favorite = setting.clickFavorite();
		favorite.searchContacts(USER_NAME);
		favorite.clickSearchResult(USER_NAME);//bug, redirected back
		favorite.clickCallingButton();
		boolean actualTimer = checkTimer(favorite.getTimer());
		favorite.cancelCall();
		// after cancel android returns in on favourite page
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickCall();
		Assert.assertTrue(actualTimer);
	}
	
	@Test(priority = 14)
	public void checkCallAndAnswer() {
		// TODO : Ping CI Server to run job
		boolean actualTimer = checkTimer(call.isAnswerIncommingCall());
		call.endCall();
		Assert.assertTrue(actualTimer);
	}

	@Test(priority = 15)
	public void checkCallAndReset() {
		// TODO : Ping CI Server to run job
		CallPage callPage = call.isIncommingCallReset();
		callPage.checkPage();
	}
*/
	@AfterMethod
	public void clearField() {
		call.clearField();
	}
}
