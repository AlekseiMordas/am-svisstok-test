package runner;

import java.lang.reflect.Method;
import java.util.Map;

import org.apache.log4j.Logger;
import org.testng.IConfigurationListener;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.internal.ConstructorOrMethod;

import runner.annotation.IgnoreTest;
import driver.IosDriverWrapper;

public class SuiteListener implements ISuiteListener, ITestListener,
		IConfigurationListener, IInvokedMethodListener2 {

	private static final Logger LOGGER = Logger.getLogger(SuiteListener.class);

	@Override
	public void onTestFailure(ITestResult result) {
		IosDriverWrapper.getDriver().takeScreenshot("");
		LOGGER.info("================================== TEST "
				+ result.getName()
				+ " FAILED ==================================");
	}

	@Override
	public void onTestStart(ITestResult result) {
		LOGGER.info("================================== TEST "
				+ result.getName()
				+ " STARTED ==================================");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		LOGGER.info("================================== TEST "
				+ result.getName()
				+ " PASSED ==================================");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		LOGGER.info("================================== TEST "
				+ result.getName()
				+ " SKIPPED ==================================");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

	@Override
	public void onStart(ISuite suite) {

	}

	@Override
	public void onFinish(ISuite suite) {

		boolean isFailed = false;

		IResultMap failedConfigs;
		IResultMap failedTests;
		IResultMap skippedConfigs;
		IResultMap skippedTests;

		Map<String, ISuiteResult> suiteResults = suite.getResults();

		for (ISuiteResult res : suiteResults.values()) {
			failedConfigs = res.getTestContext().getFailedConfigurations();
			failedTests = res.getTestContext().getFailedTests();
			skippedConfigs = res.getTestContext().getSkippedConfigurations();
			skippedTests = res.getTestContext().getSkippedTests();

			if (failedConfigs.size() != 0 || failedTests.size() != 0
					|| skippedConfigs.size() != 0 || skippedTests.size() != 0) {
				isFailed = true;
				break;
			}
		}

		if (!isFailed && !suiteResults.isEmpty()) {
			BuildResult.setExitResult(BuildResult.SUCCESS);
		}
	}

	@Override
	public void onStart(ITestContext context) {
		LOGGER.info("================================== TEST "
				+ context.getName().toUpperCase()
				+ " STARTED ==================================");
	}

	@Override
	public void onConfigurationSuccess(ITestResult itr) {

	}

	@Override
	public void onConfigurationFailure(ITestResult itr) {

	}

	@Override
	public void onConfigurationSkip(ITestResult itr) {

	}

	private IgnoreTest getWebTestAnnotation(IInvokedMethod method) {
		if (!method.isTestMethod()) {
			return null;
		}
		ConstructorOrMethod com = method.getTestMethod()
				.getConstructorOrMethod();
		if (com.getMethod() == null) {
			return null;
		}
		Method m = com.getMethod();
		IgnoreTest annotation = m.getAnnotation(IgnoreTest.class);
		return annotation;
	}

	@Override
	public void afterInvocation(IInvokedMethod paramIInvokedMethod,
			ITestResult paramITestResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeInvocation(IInvokedMethod paramIInvokedMethod,
			ITestResult paramITestResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterInvocation(IInvokedMethod paramIInvokedMethod,
			ITestResult paramITestResult, ITestContext paramITestContext) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeInvocation(IInvokedMethod paramIInvokedMethod,
			ITestResult paramITestResult, ITestContext paramITestContext) {
		IgnoreTest ignore = getWebTestAnnotation(paramIInvokedMethod);
		if (ignore != null) {
			if (ignore.device().toUpperCase().equals(DeviceConfig.getDevice())) {
				// paramITestResult.setStatus(ITestResult.SKIP);
				LOGGER.info("This test was skipped, because not actial on this device");
				throw new SkipException(
						"This test was skipped, because not actual on this device");
			}
		}

	}

}
