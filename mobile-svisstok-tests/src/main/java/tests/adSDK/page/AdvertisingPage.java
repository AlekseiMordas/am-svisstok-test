package tests.adSDK.page;

import java.awt.Rectangle;

import org.openqa.selenium.Dimension;

import com.mobile.driver.nativedriver.NativeDriver;

public abstract class AdvertisingPage extends BasePage {

	public AdvertisingPage(NativeDriver driver) {
		this.driver = driver;
	}

	public abstract void closeAd();

	public abstract Dimension getSize();

	public abstract void checkPage();

	public abstract void collapseAd();

	public abstract void expandAd();

	public abstract void openExpandableAdInBrowser();
	
	public abstract void openAdInBrowser();
	
	public abstract Rectangle getElementLocation();

	public abstract boolean isAdIndecatorVisible();

}