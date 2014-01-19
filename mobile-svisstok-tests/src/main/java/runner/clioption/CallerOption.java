package runner.clioption;

import org.apache.commons.cli.Option;

import com.clioption.ICliOption;

import runner.DeviceConfig;

public class CallerOption implements ICliOption {
	private static final String DEFAULT_CALLER = "skustov2";

	public String[] getDefaultValue() {
		return new String[] { DEFAULT_CALLER };
	}

	public Option getOption() {
		return new Option("c", "caller", true, "Default caller number");
	}

	public void parse(String[] values) {
		DeviceConfig.setCaller(values[0]);
	}
}
