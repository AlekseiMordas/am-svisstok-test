package utils;

public class ApplicationStorage {

	private static final String DEFAULT_CALLER_NUMBER = "caller_number";

	private static final String AUT_PROPERTIES = "local.properties";

	private static final String DEFAULT_PATH_TO_APP = "default_path_to_app";
	
	private static final String DEFAULT_PATH_TO_APK = "default_path_to_apk";

	private static final String DEFAULT_ACTIVITY = "default_app_activity";

	private static final String DEFAULT_PACKAGE = "default_app_package";
	
	private static final String DEFAULT_USERNAME = "default_username";
	
	private static final String DEFAULT_PASSWORD = "default_password";
	
	private static final String DEFAULT_CALLER = DEFAULT_CALLER_NUMBER;

	public static String getDefaultPathToApp() {
		return getFromFile(DEFAULT_PATH_TO_APP);
	}

	public static String getDefaultPathToApk() {
		return getFromFile(DEFAULT_PATH_TO_APK);
	}
	
	public static String getDefaultActivity() {
		return getFromFile(DEFAULT_ACTIVITY);
	}

	public static String getDefaultPackage() {
		return getFromFile(DEFAULT_PACKAGE);
	}

	public static String getCallerNumber() {
		return getFromFile(DEFAULT_CALLER_NUMBER);
	}
	
	public static String getCallerName() {
		return getFromFile(DEFAULT_CALLER);
	}
	
	public static String getDefaultUsername() {
		return getFromFile(DEFAULT_USERNAME);
	}
	
	public static String getDefaultPassword() {
		return getFromFile(DEFAULT_PASSWORD);
	}
	
	private static String getFromFile(String key) {
		String autName = PropertyReader.getInstance().getProperty(
				AUT_PROPERTIES, key);
		return autName;
	}

}
