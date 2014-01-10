package tests.page.android;

import java.awt.Rectangle;

import org.openqa.selenium.By;

import tests.page.BlockPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class BlockPageAndroid extends BlockPage {
	public BlockPageAndroid(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//input[@id='contactsView-search']")
	private UIView searchFiled;

	@FindBy(locator = "//div[@id='contactCardView-menu-panel']//h1[text()='Удалить']")
	private UIView deleteFromList;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "//a[@id='contactsView-tab-btn-dialpad']")
	private UIView callTabButton;

	@FindBy(locator = "//div[@id='contactCardView-favour-contact']")//h1[@id='contactCardView-title']
	private UIView contactName;

	@FindBy(locator = "//h1[contains(.,'%s')]")
	private UIView searchedContact;

	@FindBy(locator = "//a[@id='contactCardView-btn-menu' and @data-icon='edit']")
	private UIView editFromList;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	public void clickSearchResult(String name) {
		((AppiumDriver) driver)
				.getDriver()
				.findElement(
						By.xpath(String.format(searchedContact.getFoundBy(),
								name))).click();
	}

	public String getContactName() {
		return contactName.getText();
	}

	public void clickEditContacts() {
		editFromList.touch();
	}

	public void clickDeletefromList() {
		deleteFromList.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		deleteFromList.touch();
	}

	public void clickDelete() {
		deleteNumber.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		deleteNumber.touch();
	}

	public void clickCall() {
		callTabButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callTabButton.touch();
	}

}
