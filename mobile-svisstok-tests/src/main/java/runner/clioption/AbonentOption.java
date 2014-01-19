package runner.clioption;

import org.apache.commons.cli.Option;

import com.clioption.ICliOption;

import runner.DeviceConfig;

public class AbonentOption implements ICliOption {
	private static final String DEFAULT_ABONENT = "skustov3";

	public String[] getDefaultValue() {
		return new String[] { DEFAULT_ABONENT };
	}

	public Option getOption() {
		return new Option("a", "abonent", true, "Default abonent number");
	}

	public void parse(String[] values) {
		DeviceConfig.setAbonent(values[0]);
	}
}
