package driver;

import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import factory.CapabilitiesFactory;

/**
 * @author aleksei_mordas
 * 
 */
public class IosDriverWrapper {

	private static final String URL = "http://%s:%s/wd/hub";

	private static NativeDriver instance;

	public static NativeDriver getIphone(String host, String port) {
		instance = new AppiumDriver(String.format(URL, host, port),
				CapabilitiesFactory.createIphoneCapabilities());
		return instance;
	}

	public static NativeDriver getAndroid(String host, String port) {
		instance = new AppiumDriver(String.format(URL, host, port),
				CapabilitiesFactory.createAndroidCapabilities());
		return instance;
	}


}
