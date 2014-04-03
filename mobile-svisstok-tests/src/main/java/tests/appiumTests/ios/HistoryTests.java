package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.Test;

import runner.Devices;
import tests.page.HistoryFilterPage;
import tests.page.exceptions.XmlParametersException;

import com.mobile.driver.wait.Sleeper;

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
		clearField();
		callOneself();
		history = call.clickHistory();
		history.clickEdit();
		int count = history.deleteCall();
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			Assert.assertEquals(history.getCountUsers(), count - 3,
					"User didn't delete");
			break;
		case IOS7:
			Assert.assertEquals(history.getCountUsers(), count -3,
					"User didn't delete");
			break;
		case ANDROID:
			Assert.assertEquals(history.getCountUsers(), count - 1,
					"User didn't delete");
			break;
		default:
			throw new XmlParametersException("Invalid device");
		}
		history.clickCall();
	}

	@Test(priority = 3)
	public void deleteAllCallsFromHistory() {
		clearField();
		callOneself();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		call.clearField();
		callOneself();
		history = call.clickHistory();
		int count = history.getCountUsers();
		history.clickEdit();
		history.deleteAllCalls();
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			Assert.assertEquals(history.getCountUsers(), count - 4,
					"User didn't delete");
			break;
		case IOS7:
			Assert.assertEquals(history.getCountUsers(), count -4,
					"User didn't delete");
			break;
		case ANDROID:
			Assert.assertEquals(history.getCountUsers(), 0,
					"User didn't delete");
			break;
		default:
			throw new XmlParametersException("Invalid device");
		}
		history.clickCall();
	}
/*
	@Test(priority = 4)
	public void checkGroupingCallsInHistory() {
		history = call.clickHistory();
		HistoryFilterPage historyFilter = history.openFilter();
		historyFilter.checkHistoryFilter();
	}
*/
	private void callOneself() {
		call.inputFromNativeKeyboard(USER_NAME);
		call.clickCallButton();
		call.cancelCall();
	}

	private void clearField() {
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		call.clearField();
	}

}
