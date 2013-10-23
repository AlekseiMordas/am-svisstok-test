package runner;


public enum UserAgent {

	USER_AGENT_IPAD("User-Agent=Mozilla/5.0 (iPad; CPU OS 6_1 like Mac OS X)"), USER_AGENT_IPHONE(
			"User-Agent=Mozilla/5.0 (iPhone; CPU iPhone OS 6_1 like Mac OS X)");

	private final String text;

	private UserAgent(final String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
