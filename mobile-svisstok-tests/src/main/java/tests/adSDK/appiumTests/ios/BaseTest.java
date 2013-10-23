package tests.adSDK.appiumTests.ios;


import factory.CapabilitiesFactory;
import helpers.AppleScriptHelper;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import runner.DeviceConfig;
import runner.TestRunner;
import server.Status;
import runner.Devices;
import server.TelnetExecutor;
import tests.adSDK.constants.ErrorMessages;
import tests.adSDK.page.AdvertisingPageIpad;
import tests.adSDK.page.AdvertisingPageIphone;
import tests.adSDK.page.exceptions.AdSDKXmlParametersException;


import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;

import driver.IosDriverWrapper;



public class BaseTest {

	protected static final String DELIMETER = ":";

	public static final String SIZE_DELIMETER = "x";

	public static final String VALUE_DELIMETER = ";";

	public static final String APP_VERSION_DELIMETER = ";";

	public static final String APP_VERSION_MATCH = "ver=v";

	protected static final String METHOD_EXPAND = "MRAID Ad is about to Expand ";

	protected static final String METHOD_CLOSE = "method close() called";

	protected final String MATCH_VALUE = "useExternalBrowser: \\w*";

	protected final String MATCH_VALUE_COPPA = "requireCOPPACompliance: \\w*";

	protected final String DOUBLE_CLICK_URL = "(.*doubleclick.net.*)";

	protected String failureMessage = ErrorMessages.ACCUMULATED_FAILURE_MESSAGE;

	public NativeDriver driver;

	private static final String HOST = DeviceConfig.getHost();

	private static final String PORT = DeviceConfig.getPort();

//	@BeforeClass(description = "clean cache")
//	@Parameters({ "cleanCache" })
//	public void clearCache(@Optional() String cleanCache) throws Exception {
//		if (cleanCache != null) {
//			AppleScriptHelper.cleanCache();
//			CapabilitiesFactory.createIphoneCapabilitiesPreferencesApp();
//			driver = IosDriverWrapper.getSettingsApp(HOST, PORT);
//			preferencesPage = PageFactory.initElements(driver,
//					PreferencesPage.class);
//			preferencesPage.setUserPreferences();
//			AppiumDriver.class.cast(driver).quit();
//		}
//	}


	@BeforeClass(description = "Check is appium server started")
	public void pingAppiumServer() {
		Assert.assertEquals(Status.SUCCESS.toString(), new TelnetExecutor(HOST,
				PORT).getResult().toString(), "Not connected to the server.");
	}

	@Parameters({ "device", "mraidFlag" })
	@BeforeClass(description = "Init and check page", dependsOnMethods = "pingAppiumServer")
	public void initPages(String device, String mraidFlag) throws Exception {
		switch (Devices.valueOf(device)) {
		case IPHONE:
			driver = IosDriverWrapper.getIphone(HOST, PORT);
			//advert = PageFactory.initElements(driver,
				//	AdvertisingPageIphone.class);
			break;
		case IPAD:
			
			driver = IosDriverWrapper.getIpad(HOST, PORT);
			
			break;
		default:
			throw new AdSDKXmlParametersException("Invalid device");
		}
	//	toolBar = PageFactory.initElements(driver, ToolBarPage.class);
	//	adMain = PageFactory.initElements(driver, AdMainPage.class);
	//	browser = PageFactory.initElements(driver, InternalBrowserPage.class);
	//	bumperPage = PageFactory.initElements(driver, BumperPage.class);
	//	toolBar.checkPage();

	}

	@AfterClass
	public void tearDown() throws Exception {
		AppiumDriver.class.cast(driver).quit();
	}

	

}
