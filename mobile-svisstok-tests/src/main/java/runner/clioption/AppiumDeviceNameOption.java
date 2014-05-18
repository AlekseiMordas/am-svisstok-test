package runner.clioption;

import org.apache.commons.cli.Option;

import runner.AppiumDevices;
import runner.DeviceConfig;

import com.clioption.ICliOption;

public class AppiumDeviceNameOption implements ICliOption {
	
	private static final String DEFAULT_DEVICE = AppiumDevices.IPHONE.toString(); 

	@Override
	public String[] getDefaultValue() {

		return new String[] { DEFAULT_DEVICE };
	}

	@Override
	public Option getOption() {
		return new Option("deviceName", "deviceName", true, "AppiumDevice name");
	}

	@Override
	public void parse(String[] values) {
		DeviceConfig.setAppiumDevice(values[0].toUpperCase());
	}
}
