package driver;

import utils.HttpClient;

import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;

import factory.CapabilitiesFactory;

/**
 * @author aleksei_mordas
 * 
 */
public class IosDriverWrapper {

	private static final String SESSION_ID_MATCHER = "capabilities";

	private static final String STATUS_APPIUM = "/sessions";

	private static final String URL = "http://%s:%s/wd/hub";

	private static boolean isSeesionExist;

	private static NativeDriver instance;

	public static NativeDriver getIphone(String host, String port) {
		  isSeesionExist = isSessionExist(host, port);
		if (!isSeesionExist) {
			instance = new AppiumDriver(String.format(URL, host, port),
					CapabilitiesFactory.createIphoneCapabilities());
		}
		return instance;
	}

	public static NativeDriver getAndroid(String host, String port) {
		  isSeesionExist = isSessionExist(host, port);
		if (!isSeesionExist) {
			instance = new AppiumDriver(String.format(URL, host, port),
					CapabilitiesFactory.createAndroidCapabilities());
		}
		return instance;
	}

	public static NativeDriver getDriver() {
		return instance;
	}
	
	public static boolean isSessionExist(String host, String port) {
		return HttpClient
				.getInstance(String.format(URL, host, port) + STATUS_APPIUM)
				.getRequest().contains(SESSION_ID_MATCHER);
	}
}
