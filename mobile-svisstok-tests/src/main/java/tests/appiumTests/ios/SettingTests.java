package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.ios.AppiumDriver;
import com.mobile.driver.wait.Sleeper;

public class SettingTests extends BaseTest {
	
	@Test(priority = 1, enabled = true)
	public void checkBalance(){
		setting = call.navigateToSettingsTab();
		Assert.assertTrue(setting.isBalance());
		setting.clickCallTab();
	}
	
	@Test(priority = 2, enabled = true)
	public void checkHelpandAboutApp(){
		setting = call.navigateToSettingsTab();
		setting.clickAboutApp();
		String actualURLAboutApp = setting.getUrlAboutApp();
		String expectedURLAboutApp = "Loading...";
		setting.clickDone();
		Assert.assertEquals(actualURLAboutApp, expectedURLAboutApp);
		setting.clickHelp();
		String expectedURLHelp = "http://files.swisstok.ru/Swisstok_iOS_UserGuide.pdf";
		String actualURLHelp = setting.getUrlHelp();
		Assert.assertEquals(actualURLHelp, expectedURLHelp);
		setting.clickDone();
		setting.clickCallTab();
	}
	
	@Test(priority = 4, enabled = true)
	public void changeLanguage(){
		setting = call.navigateToSettingsTab();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		setting.changeLanguageToEnglish();
		Assert.assertEquals(setting.getLanguage(), "Английский");
		setting.changeLanguageToRussian();
		setting.clickCallTab();
	}
	
	@Test(priority = 5, enabled = true)
	public void checkLog(){
		setting = call.navigateToSettingsTab();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		setting.openLogApp();
		Assert.assertTrue(setting.validateLogs(), "Log is EMPTY");
		setting.clickCallTab();
	}
	
	@AfterClass(alwaysRun=true)
	public void quit() {
		((AppiumDriver) driver).quit();
	}

}
