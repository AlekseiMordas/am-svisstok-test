package tests.page.android;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import tests.page.HistoryPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;

public class HistoryPageAndroid extends HistoryPage {

	private static final String ACTIVE_PAGE = "//div[contains(@class,'ui-page-active')]";

	@FindBy(locator = ACTIVE_PAGE
			+ "//div[@id='activeCallView-call-avatar-panlel-status']")
	private UIView timerCall;

	@FindBy(locator = ACTIVE_PAGE
			+ "//ul[contains(@id,'historyViewul')]//li[1]//h1")
	private UIView firstContact;

	@FindBy(locator = ACTIVE_PAGE + "//a[contains(@class,'ui-btn-color-red')]")
	private UIView cancelCallButton;

	@FindBy(locator = ACTIVE_PAGE
			+ "//a[contains(@id,'historyView-tab-btn-dialpad')]")
	private UIView callTabButton;

	@FindBy(locator = ACTIVE_PAGE + "//a[@id='historyView-btn-filter']")
	private UIView historyFilter;

	@FindBy(locator = ACTIVE_PAGE + "//a[@id='historyView-btn-trash']")
	private UIView deleteAllButton;

	@FindBy(locator = ACTIVE_PAGE + "//a[@id='historyView-btn-cancel']")
	private UIView cancelDelete;

	@FindBy(locator = ACTIVE_PAGE + "//a[@id='historyView-btn-apply']")
	private UIView applyDelete;

	@FindBy(locator = ACTIVE_PAGE + "//a[@id='historyView-btn-edit']")
	private UIView editContactsButton;
	
	@FindBy(locator = ACTIVE_PAGE + "//a[@id='historyView-btn-filter']")
	private UIView filterButton;

	private static final String CURRENT_USER = "//div[contains(@class,'ui-page-active')]//li//h1[contains(.,'%s')]";

	private static final String LIST_USERS = "//div[contains(@class,'ui-page-active')]//ul[contains(@id,'historyViewul')]//li";

	private static final String TRASH_CURRENT_USER = "//li[1]//span[contains(@class,'ui-icon-trash')]";
	
	private static final String MESSAGE_EMPTY_LIST = "Список пустой.";

	public HistoryPageAndroid(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clickFirstContact() {
		firstContact.touch();
	}

	@SuppressWarnings("unchecked")
	@Override
	public HistoryPageAndroid cancelCall() {
		List<WebElement> elements = AppiumDriver.class.cast(driver).getDriver()
				.findElements(By.xpath(cancelCallButton.getFoundBy()));
		elements.get(elements.size() - 1).click();
		return PageFactory.initElements(driver, HistoryPageAndroid.class);
	}

	@Override
	public String getTimer() {
		return timerCall.getText();
	}

	@Override
	public void clickCallTab() {
		callTabButton.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
		callTabButton.touch();
	}

	@Override
	public void clickEdit() {
		// TODO Auto-generated method stub

	}

	private void clickTrash() {	
		((AppiumDriver) driver).getDriver()
				.findElement(By.xpath(TRASH_CURRENT_USER)).click();
	}

	@Override
	public int deleteCall() {
		int count = getCountUsers();
		editContactsButton.touch();
		clickTrash();
		applyDelete.touch();
		return count;
	}

	@Override
	public void deleteAllCalls() {
		editContactsButton.touch();
		deleteAllButton.touch();
		applyDelete.touch();
	}

	@Override
	public int getCountUsers() {
		List<WebElement> elements = ((AppiumDriver) driver).getDriver()
				.findElements(By.xpath(LIST_USERS));
		return elements.size();
	}

	@Override
	public void findDeleteContacts() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getMessageEmptyList() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public HistoryFilterPageAndroid openFilter() {
		filterButton.touch();
		return PageFactory.initElements(driver, HistoryFilterPageAndroid.class);
	}
}
