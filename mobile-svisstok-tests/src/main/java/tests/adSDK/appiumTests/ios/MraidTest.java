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
import tests.adSDK.page.AdMainPage;
import tests.adSDK.page.AdvertisingPage;
import tests.adSDK.page.ToolBarPage;
import tests.adSDK.page.exceptions.AdSDKXmlParametersException;

/**
 * @author aleksei_mordas
 * 
 */
public class MraidTest {

	private static final String DELIMETER = ":";

	private static final String HOST = DeviceConfig.getHost();

	private static final String PORT = DeviceConfig.getPort();

	private static final String METHOD_EXPAND = "MRAID Ad is about to Expand ";

	private static final String METHOD_CLOSE = "method close() called";

	private NativeDriver driver;

	private AdvertisingPage advert;

	private ToolBarPage toolBar;

	private AdMainPage adMain;

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
		toolBar = PageFactory.initElements(driver, ToolBarPage.class);
		adMain = PageFactory.initElements(driver, AdMainPage.class);
		advert = PageFactory.initElements(driver, AdvertisingPage.class);
		toolBar.checkPage();
	}

	@Parameters({ "size", "format", "url" })
	@Test(description = "Check close method in AD SDK")
	public void closeTest(String size, String format, String urlForDevice) {
		String[] sizes = size.split(DELIMETER);
		String[] formats = format.split(DELIMETER);
		for (String currentFormat : formats) {
			for (String currentSize : sizes) {
				String url = String.format(urlForDevice, currentFormat,
						currentSize, currentSize);
				toolBar.setUrl(url);
				toolBar.clickGOButton();
				toolBar.clearLog();
				advert.closeAd();
				Assert.assertTrue(adMain.getLogFieldText().contains(
						METHOD_CLOSE));
			}
		}
	}

	@Parameters({ "size", "format", "url" })
	@Test(description = "Check expand method in AD SDK")
	public void expandTest(String size, String format, String urlForDevice) {
		String[] sizes = size.split(DELIMETER);
		String[] formats = format.split(DELIMETER);
		for (String currentFormat : formats) {
			for (String currentSize : sizes) {
				String url = String.format(urlForDevice, currentFormat,
						currentSize, currentSize);
				toolBar.setUrl(url);
				toolBar.clickGOButton();
				toolBar.clearLog();
				advert.expandAd();
				toolBar.closeBrowser();
				Assert.assertTrue(adMain.getLogFieldText().contains(
						METHOD_EXPAND));
			}
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		AppiumDriver.class.cast(driver).quit();
	}
}
