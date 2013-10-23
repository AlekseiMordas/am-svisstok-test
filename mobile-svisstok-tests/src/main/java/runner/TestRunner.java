package runner;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import org.uncommons.reportng.FailuresHTMLReporter;
import org.uncommons.reportng.HTMLReporter;

import runner.clioption.AppiumDirectory;
import runner.clioption.DeviceHostOption;
import runner.clioption.DeviceNameOption;
import runner.clioption.DevicePortOtion;
import runner.clioption.ServerFlags;
import runner.clioption.VersionOption;
import server.AppiumServer;

import com.clioption.CliParser;

import com.runner.Runner;
import com.runner.TestNgParameters;

public class TestRunner extends Runner {

	private static final Logger LOGGER = Logger.getLogger(TestRunner.class);

	public TestRunner(String[] args) {
		super(args);
	}

	public static void main(String[] args) {
		try {
			// Runtime.getRuntime().addShutdownHook(new
			// QuitDeviceShutdownHook());
			Runner tr = new TestRunner(args);
			@SuppressWarnings("rawtypes")
			List<Class> listeners = new ArrayList<Class>();
			listeners.add(HTMLReporter.class);
			listeners.add(FailuresHTMLReporter.class);
			listeners.add(SuiteListener.class);
			tr.setListeners(listeners);
			tr.run();
		} catch (Exception e) {
			LOGGER.fatal(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		int exitCode = BuildResult.getExitResult();
		LOGGER.info("Exit with code : " + exitCode);
		System.exit(exitCode);

	}

	public void addCommandLineOptions() {
		super.addCommandLineOptions();
		CliParser.getCmdLineOptions().add(new DeviceNameOption());
		CliParser.getCmdLineOptions().add(new DevicePortOtion());
		CliParser.getCmdLineOptions().add(new DeviceHostOption());
		CliParser.getCmdLineOptions().add(new ServerFlags());
		CliParser.getCmdLineOptions().add(new AppiumDirectory());
		CliParser.getCmdLineOptions().add(new VersionOption());
	}

}