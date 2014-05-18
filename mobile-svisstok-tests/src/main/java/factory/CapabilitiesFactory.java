package factory;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import runner.AppiumDevices;
import runner.AppiumVersionDevice;
import runner.DeviceConfig;
import utils.ApplicationStorage;

/**
 * @author aleksei_mordas
 * 
 */
public class CapabilitiesFactory {

	private static final String PREFERENCES_APP = "Preferences.app";

	private static String VERSION = DeviceConfig.getAppiumDeviceVersion();

	private static String DEVICE_NAME = DeviceConfig.getAppiumDevice();

	public static DesiredCapabilities capabilities = new DesiredCapabilities();

	private static final Logger LOGGER = Logger
			.getLogger(CapabilitiesFactory.class);

	public static DesiredCapabilities createDefaultCapabilities() {
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, AppiumVersionDevice.valueOf(VERSION));
		// capabilities.setCapability("app",
		// ApplicationStorage.getDefaultPathToApp() );
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("deviceName", AppiumDevices.valueOf(DEVICE_NAME));
		LOGGER.info("CAPABILITY PATH: "
				+ ApplicationStorage.getDefaultPathToApp());
		return capabilities;
	}

	public static DesiredCapabilities createAndroidCapabilities() {
		// capabilities.setCapability("app",
		// ApplicationStorage.getDefaultPathToApk() );
		capabilities.setCapability("automationName", "selendroid");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app-package",
				ApplicationStorage.getDefaultPackage());
		capabilities.setCapability("app-activity",
				ApplicationStorage.getDefaultActivity());
		LOGGER.info("CAPABILITY PATH: "
				+ ApplicationStorage.getDefaultPathToApk());
		return capabilities;
	}

	public static DesiredCapabilities createIosCapabilities() {
		return createDefaultCapabilities();
	}

}
