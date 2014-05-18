package runner;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.uncommons.reportng.FailuresHTMLReporter;
import org.uncommons.reportng.HTMLReporter;

import runner.clioption.AbonentOption;
import runner.clioption.AppiumDeviceNameOption;
import runner.clioption.AppiumDeviceVersionOption;
import runner.clioption.CallerOption;
import runner.clioption.DeviceHostOption;
import runner.clioption.DeviceNameOption;
import runner.clioption.DevicePortOtion;

import com.clioption.CliParser;
import com.runner.Runner;


public class TestRunner extends Runner {

	private static final Logger LOGGER = Logger.getLogger(TestRunner.class);

	public TestRunner(String[] args) {
		super(args);
	}

	public static void main(String[] args) {
		try {
			Runner tr = new TestRunner(args);
			printAppiumCapabilityOptions();
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

	@Override
	public void addCommandLineOptions() {
		super.addCommandLineOptions();
		CliParser.getCmdLineOptions().add(new DeviceNameOption());
		CliParser.getCmdLineOptions().add(new DevicePortOtion());
		CliParser.getCmdLineOptions().add(new DeviceHostOption());
		CliParser.getCmdLineOptions().add(new CallerOption());
		CliParser.getCmdLineOptions().add(new AbonentOption());
		CliParser.getCmdLineOptions().add(new AppiumDeviceVersionOption());
		CliParser.getCmdLineOptions().add(new AppiumDeviceNameOption());
	}
	
	private static void printAppiumCapabilityOptions() {
		String deviceName="";
		for(AppiumDevices device: AppiumDevices.values()) {
			deviceName = deviceName.concat( device.name()+ "={" +device.toString()+ "}" + "; ");
		}
		String versionDevice="";
		for(AppiumVersionDevice version: AppiumVersionDevice.values()) {
			versionDevice = versionDevice.concat(version.name() + "={" +version.toString()+ "}" + "; ");
		}
		LOGGER.info("Available cli '--deviceName': " + deviceName);
		LOGGER.info("Available cli '--deviceVersion': " + versionDevice);
	}

}