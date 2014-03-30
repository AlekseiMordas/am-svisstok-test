package tests.appiumTests.ios;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import tests.page.HistoryFilterPage;

import com.mobile.driver.wait.Sleeper;

public class HistoryTests extends BaseTest {
	
	private static final String MESSAGE_EMPTY_LIST = "Список пустой.";
/*
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
*/	
	@Test(priority = 3)
	public void checkGroupingCallsInHistory() {
		history = call.clickHistory();
		HistoryFilterPage historyFilter =history.openFilter();
		historyFilter.checkHistoryFilter();
	}
	
	private void callOneself(){
	   call.inputFromNativeKeyboard(USER_NAME);  
	   call.clickCallButton(); 
	   call.cancelCall();
	}
	
	@AfterMethod
	public void clearField() {
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		call.clearField();
	}
	
}
