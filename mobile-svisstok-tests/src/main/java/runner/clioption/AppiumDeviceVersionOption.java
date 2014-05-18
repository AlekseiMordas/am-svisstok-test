package runner.clioption;

import org.apache.commons.cli.Option;

import runner.AppiumVersionDevice;
import runner.DeviceConfig;

import com.clioption.ICliOption;

public class AppiumDeviceVersionOption implements ICliOption {
	
	private static final String DEFAULT_DEVICE = AppiumVersionDevice.V_6_1.toString(); 

	@Override
	public String[] getDefaultValue() {

		return new String[] { DEFAULT_DEVICE };
	}

	@Override
	public Option getOption() {
		return new Option("deviceVersion", "deviceVersion", true, "AppiumDevice version");
	}

	@Override
	public void parse(String[] values) {
		DeviceConfig.setAppiumDeviceVersion(values[0].toUpperCase());
	}
}
