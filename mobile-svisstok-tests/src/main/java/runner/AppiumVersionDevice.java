package runner;

public enum AppiumVersionDevice {

	V_6_0("6.0"),
	V_6_1("6.1"),
	V_7_0_3("7.0.3"),
	V_7_1("7.1");

	private final String text;

	private AppiumVersionDevice(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
