package runner;

public class DeviceConfig {

	private static String host;

	private static String port;

	private static int proxyPort;

	private static String device;

	private static String flags;

	private static String appiumDir;
	
	private static String version;
	
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

	public static int getProxyPort() {
		return proxyPort;
	}

	public static void setProxyPort(int proxyPort) {
		DeviceConfig.proxyPort = proxyPort;
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
