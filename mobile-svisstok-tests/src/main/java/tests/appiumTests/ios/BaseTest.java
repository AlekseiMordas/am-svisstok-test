package tests.appiumTests.ios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import driver.IosDriverWrapper;

import runner.DeviceConfig;
import runner.Devices;
import tests.page.CallPage;
import tests.page.LoginPage;
import tests.page.android.LoginPageAndroid;
import tests.page.exceptions.XmlParametersException;
import tests.page.ios.CallPageIos;
import tests.page.ios.LoginPageIos;
import utils.ApplicationStorage;

/**
 * @author aleksei_mordas
 * 
 */
public class BaseTest { 

	protected static final String DELIMETER = ":";

	private static final String HOST = DeviceConfig.getHost();

	private static final String PORT = DeviceConfig.getPort();
	
	private static final String DEVICE = DeviceConfig.getDevice();
	
	protected static final String USER_NAME = ApplicationStorage.getDefaultUsername();//"sip:skustov2@sipnet.ru";//"7812009957@217.195.69.250"; 7789 pas 1246
	
	protected static final String USER_PASSWORD = ApplicationStorage.getDefaultPassword();//"zzzzzz";//"JNcW5qTBaRvy";
	
	protected static final String INCORRECT_USER_NAME = "7812001245@211.195.68.250";
	
	protected static final String INCORRECT_PASSWORD = "70mNZcEy05G123";

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
	
	public static boolean checkTimer(String element){ 
        Pattern p = Pattern.compile("^[0-9][0-9]\\s.\\s[0-9][0-9]$");
        Matcher m = p.matcher(element); 
        return m.matches(); 
    }
	
	@AfterClass
	public void tearDown() throws Exception {
		AppiumDriver.class.cast(driver).quit();
	}
}
