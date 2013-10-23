package tests.adSDK.page;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.Page;

public abstract class BasePage extends Page {

	protected NativeDriver driver;

	protected static final int WAIT_FOR_ELEMENT_TIMEOUT = 10;

	protected static final int WAIT_FOR_AD = 60;

	protected static final long WAIT_SLEPPER_TIMEOUT = 7000;

	protected void makeScreenshot() {
		AppiumDriver.class.cast(driver).takeScreenshot("");
	}

	protected String sendGetRequest(String urlToread) {
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try {
			url = new URL(urlToread);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}