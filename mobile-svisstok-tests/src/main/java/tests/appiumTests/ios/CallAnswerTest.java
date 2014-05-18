package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import runner.DeviceConfig;
import runner.Devices;
import tests.page.CallPage;
import tests.page.LoginPage;
import tests.page.android.LoginPageAndroid;
import tests.page.exceptions.XmlParametersException;
import tests.page.ios.LoginPageIos;
import utils.ApplicationStorage;

import com.ios.AppiumDriver;
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
			driver = IosDriverWrapper.getIos(HOST, PORT);
			driver.setDriverType(DEVICE);
			main = PageFactory.initElements(driver, LoginPageIos.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			Sleeper.SYSTEM_SLEEPER.sleep(5000);
			break;
		case IOS7:
			driver = IosDriverWrapper.getIos(HOST, PORT);
			driver.setDriverType(DEVICE);
			main = PageFactory.initElements(driver, LoginPageIos.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			Sleeper.SYSTEM_SLEEPER.sleep(5000);
			if(call.isAccessContacts())
			  call.clickOk();
			break;
		case ANDROID:
			driver = IosDriverWrapper.getAndroid(HOST, PORT);
			Sleeper.SYSTEM_SLEEPER.sleep(10000);
			driver.setDriverType(DEVICE);
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
	
	@Test( description = "Create call")
	public void createMissedCall() {
		call.inputFromNativeKeyboard(PHONE_NUMBER);
		call.clickCallButton();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		call.cancelCall();
		Assert.assertTrue(call.isStatusAvailable());
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		AppiumDriver.class.cast(driver).quit();
		
	}
}
