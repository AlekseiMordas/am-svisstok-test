package helpers;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.mobile.driver.wait.Sleeper;

import server.AppiumServer;

public class AppleScriptHelper {

	public static void cleanCache() throws IOException, InterruptedException {
		String path = "";
		path = new File("scripts/cleanCacheScript.scpt").getAbsolutePath();
		String[] command = { "osascript", path };
		AppiumServer.runCommand(command, null, null);
		Sleeper.SYSTEM_SLEEPER.sleep(20000); // TODO: Will fix
	}

}
