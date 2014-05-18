package runner;

public class DeviceConfig {

	private static String host;

	private static String port;

	private static String device;

	private static String flags;

	private static String appiumDir;
	
	private static String version;
	
	private static String caller;
	
	private static String abonent;
	
	private static String appiumDevice;
	
	private static String appiumDeviceVersion;
	
	public static String getAppiumDevice() {
		return appiumDevice;
	}

	public static void setAppiumDevice(String appiumDevice) {
		DeviceConfig.appiumDevice = appiumDevice;
	}

	public static String getAppiumDeviceVersion() {
		return appiumDeviceVersion;
	}

	public static void setAppiumDeviceVersion(String appiumDeviceVersion) {
		DeviceConfig.appiumDeviceVersion = appiumDeviceVersion;
	}

	
	public static String getCaller() {
		return caller;
	}

	public static void setCaller(String caller) {
		DeviceConfig.caller = caller;
	}

	public static String getAbonent() {
		return abonent;
	}

	public static void setAbonent(String abonent) {
		DeviceConfig.abonent = abonent;
	}
	
	public static String getVersion() {
		return version;
	}

	public static void setVersion(String version) {
		DeviceConfig.version = version;
	}
	

	public static String getDevice() {
		return device;
	}

	public static void setDevice(String device) {
		DeviceConfig.device = device;
	}

	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		DeviceConfig.host = host;
	}

	public static String getPort() {
		return port;
	}

	public static void setPort(String port) {
		DeviceConfig.port = port;
	}

	public static void setFlags(String flags) {
		DeviceConfig.flags = flags;
	}

	public static String getFlags() {
		return flags;
	}

	public static void setAppiumDir(String appiumDir) {
		DeviceConfig.appiumDir = appiumDir;
	}

	public static String getAppiumDir() {
		return appiumDir;
	}

}
