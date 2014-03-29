package tests.page.android;

import org.openqa.selenium.By;

import tests.page.BlockPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.wait.Sleeper;

public class BlockPageAndroid extends BlockPage {
	public BlockPageAndroid(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//input[@id='contactsView-search']")
	private UIView searchFiled;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-menu-panel']//h1[text()='Удалить']")
	private UIView deleteFromList;

	@FindBy(locator = "//a[@id='contactCardView-delete-confirm-btn-ok']")
	private UIView deleteNumber;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactsView-tab-btn-dialpad']")
	private UIView callTabButton;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//div[@id='contactCardView-favour-contact']")//h1[@id='contactCardView-title']
	private UIView contactName;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//h1[contains(.,'%s')]")
	private UIView searchedContact;

	@FindBy(locator = "//div[contains(@class,'ui-page-active')]//a[@id='contactCardView-btn-menu' and @data-icon='edit']")
	private UIView editFromList;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void searchContacts(String text) {
		searchFiled.touch();
		searchFiled.type(text);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void clickSearchResult(String name) {
		((AppiumDriver) driver)
				.getDriver()
				.findElement(
						By.xpath(String.format(searchedContact.getFoundBy(),
								name))).click();
	}

	@Override
	public String getContactName() {
		return contactName.getText();
	}

	@Override
	public void clickEditContacts() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		editFromList.touch();
	}

	@Override
	public void clickDeletefromList() {
		deleteFromList.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		deleteFromList.touch();
	}

	@Override
	public void clickDelete() {
		deleteNumber.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		deleteNumber.touch();
	}

	@Override
	public void clickCall() {
		callTabButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callTabButton.touch();
	}

	@Override
	public String getContactStatusBlock() {
		// TODO Auto-generated method stub
		return null;
	}

}
