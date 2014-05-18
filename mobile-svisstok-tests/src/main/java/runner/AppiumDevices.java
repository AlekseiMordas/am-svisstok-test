package runner;

public enum AppiumDevices {

	IPHONE("iPhone"),
	IPHONE_RETINA_3_5("iPhone Retina (3.5-inch)"),
	IPHONE_RETINA_4("iPhone Retina (4-inch)"),
	IPHONE_RETINA_4_64("iPhone Retina (4-inch 64-bit)"),
	IPAD("iPad"),
	IPAD_RETINA("iPad Retina"), 
	IPAD_RETINA_64("iPad Retina (64-bit)");

	private final String text;

	private AppiumDevices(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
