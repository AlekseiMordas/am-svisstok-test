package runner.clioption;

import org.apache.commons.cli.Option;

import runner.DeviceConfig;

import com.clioption.ICliOption;

public class VersionOption implements ICliOption{
	private static final String DEFAULT_VERSION = "1.2.1";

	public String[] getDefaultValue() {
		return new String[] { DEFAULT_VERSION };
	}

	public Option getOption() {
		return new Option("v", "version", true, "Version of application");
	}

	public void parse(String[] values) {
		DeviceConfig.setVersion(values[0]);
	}
}