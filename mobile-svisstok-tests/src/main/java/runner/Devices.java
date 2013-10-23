package runner;

public enum Devices {

	IPHONE("iPhone Simulator"), IPAD("iPad Simulator");

	private final String text;

	private Devices(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
