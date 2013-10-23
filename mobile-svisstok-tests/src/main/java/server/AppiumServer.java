package server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.log4j.Logger;

import runner.DeviceConfig;

public class AppiumServer {
	private static Process process;

	private String appiumDir;
	private String flags;

	private static final Logger LOGGER = Logger.getLogger(AppiumServer.class);

	public AppiumServer() {
		flags = DeviceConfig.getFlags();
		appiumDir = DeviceConfig.getAppiumDir();
	}

	public static boolean isSessionIdExist(String urlToRead) {
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try {
			url = new URL(urlToRead + "/sessions");
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
		return result.contains("session");
	}

	public void startServerWithFlags() throws IOException, InterruptedException {
		LOGGER.info("Starting appium server with flags " + flags);
		String commandStr = "/usr/local/bin/node server.js " + flags;

		String[] command = commandStr.split(" ");

		runCommand(command, null, appiumDir);
	}

	public void stopServer() throws IOException, InterruptedException {
		LOGGER.info("Stopping appium server");
		String[] command = { "killall", "node" };
		runCommand(command, null, null);
	}

	public static void shutdownLaunchedEmulators() throws IOException,
			InterruptedException {
		String[] command = { "killall", "iPhone Simulator" };
		runCommand(command, null, null);
	}

	public static void runCommand(String[] command, String[] environm,
			String fileDir) throws IOException, InterruptedException {
		if (null == fileDir) {
			process = Runtime.getRuntime().exec(command, environm);
		} else {
			process = Runtime.getRuntime().exec(command, environm,
					new File(fileDir));
		}
		LOGGER.info("Proccess complete");
	}

}
