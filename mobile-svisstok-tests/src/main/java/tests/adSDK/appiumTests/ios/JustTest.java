package tests.adSDK.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;

import driver.IosDriverWrapper;

import runner.DeviceConfig;
import runner.Devices;
import tests.adSDK.page.CallScreen;
import tests.adSDK.page.LoginPage;
import tests.adSDK.page.exceptions.AdSDKXmlParametersException;

/**
 * @author aleksei_mordas
 * 
 */
public class JustTest {

	private static final String DELIMETER = ":";

	private static final String HOST = DeviceConfig.getHost();

	private static final String PORT = DeviceConfig.getPort();
	
	private static final String USER_NAME = "9986";
	
	private static final String USER_PASSWORD = "70mNZcEy05G3";

	private NativeDriver driver;

	private LoginPage main;
	
	private CallScreen call;

	@Parameters("device")
	@BeforeClass(description = "Init and check page")
	public void initPages(String device) throws Exception {
		switch (Devices.valueOf(device)) {
		case IPHONE:
			driver = IosDriverWrapper.getIphone(HOST, PORT);
			break;
		case IPAD:
			driver = IosDriverWrapper.getIpad(HOST, PORT);
			break;
		default:
			throw new AdSDKXmlParametersException("Invalid device");
		}
		main = PageFactory.initElements(driver, LoginPage.class);

	}

	@Test
	public void  simpleLogin() {
		main.checkPage();
		call = main.simpleLogin(USER_NAME, USER_PASSWORD);
		call.checkPage();
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		AppiumDriver.class.cast(driver).quit();
	}
}
