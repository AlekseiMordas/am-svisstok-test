package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.Test;

import runner.Devices;
import runner.annotation.IgnoreTest;
import tests.page.HistoryFilterPage;
import tests.page.exceptions.XmlParametersException;

import com.mobile.driver.wait.Sleeper;

public class HistoryTests extends BaseTest {

	private static final int DEFAULT_COUNT_LINKS_IN_EMPTY_HISTORY = 5;
	private static final String MESSAGE_EMPTY_LIST = "Список пустой.";

	@Test(priority = 1, enabled = true)
	public void checkCallFromHistory() {
		callOneself();
		history = call.clickHistoryTab();
		history.clickFirstContact();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		boolean actualTimer = checkTimer(history.getTimer());
		history.cancelCall();
		history.clickEdit();
		history.deleteAllCalls();
		history.clickCallTab();
		Assert.assertTrue(actualTimer);
	}

	@Test(priority = 2, enabled = true)
	public void deleteCallFromHistory() {
		clearField();
		callOneself();
		history = call.clickHistoryTab();
		history.clickEdit();
		int count = history.deleteCall();
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			Assert.assertEquals(history.getCountUsers(), count - 3,
					"User didn't delete");
			break;
		case IOS7:
			Assert.assertEquals(history.getCountUsers(), count - 3,
					"User didn't delete");
			break;
		case ANDROID:
			Assert.assertEquals(history.getCountUsers(), count - 1,
					"User didn't delete");
			break;
		default:
			throw new XmlParametersException("Invalid device");
		}
		history.clickCallTab();
	}

	@Test(priority = 3, enabled = true)
	public void deleteAllCallsFromHistory() {
		clearField();
		callOneself();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		call.clearField();
		callOneself();
		history = call.clickHistoryTab();
		history.clickEdit();
		history.deleteAllCalls();
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			Assert.assertEquals(history.getCountUsers(), DEFAULT_COUNT_LINKS_IN_EMPTY_HISTORY,
					"User didn't delete");
			break;
		case IOS7:
			Assert.assertEquals(history.getCountUsers(), DEFAULT_COUNT_LINKS_IN_EMPTY_HISTORY,
					"User didn't delete");
			break;
		case ANDROID:
			Assert.assertEquals(history.getCountUsers(), 0,
					"User didn't delete");
			break;
		default:
			throw new XmlParametersException("Invalid device");
		}
		history.clickCallTab();
	}

	@Test(priority = 4, enabled = true)
	public void checkGroupingCallsInHistory() {
		history = call.clickHistoryTab();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		HistoryFilterPage historyFilter = history.openFilter();
		historyFilter.checkHistoryFilter();
		history.clickCallTab();
	}

	@IgnoreTest(device="ios7")
	@Test(priority = 5, enabled = false)
	public void checkShortNumber() {
		clearField();
		callOneself();
		history = call.clickHistoryTab();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		// TODO generate test data
		HistoryFilterPage historyFilter = history.openFilter();
		historyFilter.checkVisibleShortName();
	}

	private void callOneself() {
		call.inputFromNativeKeyboard(PHONE_NUMBER);
		call.clickCallButton();
		call.cancelCall();
	}

	private void clearField() {
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		call.clearField();
	}

}
