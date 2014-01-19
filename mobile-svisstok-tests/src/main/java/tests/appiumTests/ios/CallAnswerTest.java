package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import runner.DeviceConfig;
import runner.Devices;
import tests.page.BlockPage;
import tests.page.CallPage;
import tests.page.CardContactsPage;
import tests.page.FavoritePage;
import tests.page.HistoryPage;
import tests.page.LoginPage;
import tests.page.SavedContactsPage;
import tests.page.SettingsPage;
import tests.page.android.CardContactsPageAndroid;
import tests.page.android.LoginPageAndroid;
import tests.page.exceptions.XmlParametersException;
import tests.page.ios.CardContactsPageIos;
import tests.page.ios.LoginPageIos;
import utils.ApplicationStorage;

import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import driver.IosDriverWrapper;

public class CallAnswerTest 
{

	protected static final String PHONE_NUMBER = DeviceConfig.getAbonent();

	protected static final String DEVICE = DeviceConfig.getDevice();
	
	protected static final String HOST = DeviceConfig.getHost();

	protected static final String PORT = DeviceConfig.getPort();

	protected static final String USER_NAME =  DeviceConfig.getCaller();

	protected static final String USER_PASSWORD = ApplicationStorage.getDefaultPassword();
	
	protected NativeDriver driver;

	protected LoginPage main;

	protected CallPage call;

	@BeforeClass(description = "Init and check page")
	public void initPages() throws Exception {

		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			driver = IosDriverWrapper.getIphone(HOST, PORT);
			main = PageFactory.initElements(driver, LoginPageIos.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			Sleeper.SYSTEM_SLEEPER.sleep(5000);
			break;
		case ANDROID:
			driver = IosDriverWrapper.getAndroid(HOST, PORT);
			Sleeper.SYSTEM_SLEEPER.sleep(10000);
			main = PageFactory.initElements(driver, LoginPageAndroid.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			call.checkPage();
			break;
		default:
			throw new XmlParametersException("Invalid device");
		}

	}
	
	@Test( description = "Check call to another abonent")
	public void checkConnectAnotherAbonent() {
		call.inputFromNativeKeyboard(PHONE_NUMBER);
		call.clickCallButton();
		Sleeper.SYSTEM_SLEEPER.sleep(15000);
	}
}
