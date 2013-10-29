package tests.appiumTests.ios;

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
import tests.page.exceptions.AdSDKXmlParametersException;
import tests.page.ios.CallScreen;
import tests.page.ios.LoginPage;

/**
 * @author aleksei_mordas
 * 
 */
public class BaseTest {

	protected static final String DELIMETER = ":";

	private static final String HOST = DeviceConfig.getHost();

	private static final String PORT = DeviceConfig.getPort();
	
	protected static final String USER_NAME = "7812009986@217.195.69.250";
	
	protected static final String USER_PASSWORD = "70mNZcEy05G3";
	
	protected static final String INCORRECT_USER_NAME = "7812001245@211.195.68.250";
	
	protected static final String INCORRECT_PASSWORD = "70mNZcEy05G123";
	
	protected NativeDriver driver;

	protected LoginPage main;
	
	protected CallScreen call;
	
	
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


	
	@AfterClass
	public void tearDown() throws Exception {
		AppiumDriver.class.cast(driver).quit();
	}
}
