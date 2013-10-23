package runner;

public enum Coppa {

	FALSE("requireCOPPACompliance: false"), TRUE("requireCOPPACompliance: true");

	private final String text;

	private Coppa(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
