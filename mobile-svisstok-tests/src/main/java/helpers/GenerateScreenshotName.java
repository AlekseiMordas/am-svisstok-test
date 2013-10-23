package helpers;

public final class GenerateScreenshotName {

	private GenerateScreenshotName() {
	}

	/**
	 * Get Screenshot name.
	 * 
	 * @param device
	 *            - iPad or iPhone
	 * @param orientation
	 * @param testmode
	 */
	public static String getScreenshotName(final String device,
			final String orientation, final String testmode) {
		return String.format("%s_%s_%S_%d", device, testmode, orientation,
				System.currentTimeMillis());
	}

}
