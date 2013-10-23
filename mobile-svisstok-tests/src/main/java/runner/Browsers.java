package runner;

public enum Browsers {

	INTERNAL("useExternalBrowser: false"), EXTERNAL("useExternalBrowser: true");

	private final String text;

	private Browsers(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
