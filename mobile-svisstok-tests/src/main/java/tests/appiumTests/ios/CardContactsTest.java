package tests.appiumTests.ios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import runner.DeviceConfig;
import runner.Devices;
import runner.annotation.IgnoreTest;
import tests.page.BlockPage;
import tests.page.CallPage;
import tests.page.CardContactsPage;
import tests.page.FavoritePage;
import tests.page.HistoryPage;
import tests.page.LoginPage;
import tests.page.SavedContactsPage;
import tests.page.SettingsPage;
import tests.page.android.CardContactsPageAndroid;
import tests.page.android.LoginPageAndroid;
import tests.page.exceptions.XmlParametersException;
import tests.page.ios.CardContactsPageIos;
import tests.page.ios.LoginPageIos;
import utils.ApplicationStorage;

import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import driver.IosDriverWrapper;

public class CardContactsTest {

	protected static String SAVED_NAME;
	protected static String OTHER_NAME;
	protected static String CONTACT;
	protected static String SECOND_NUMBER;
	protected static final String MSG_DELETE = "Удалено";
	protected static final String MSG_BLOCK = "Контакт заблокирован";
	protected static final String STATUS_BLOCK = "Заблокирован";

	protected static final String DELIMETER = ":";

	protected static final String HOST = DeviceConfig.getHost();

	protected static final String PORT = DeviceConfig.getPort();

	protected static final String DEVICE = DeviceConfig.getDevice();

	protected static final String USER_NAME_SEARCH = "sipnet";

	protected static final String USER_NAME = ApplicationStorage
			.getDefaultUsername();

	protected static final String USER_PASSWORD = ApplicationStorage
			.getDefaultPassword();

	protected static final String ABONENT_NAME = ApplicationStorage
			.getDefaultPassword();

	protected static final String INCORRECT_USER_NAME = "7812001245@211.195.68.250";

	protected static final String INCORRECT_PASSWORD = "70mNZcEy05G123";

	protected static final String PHONE_NUMBER = ApplicationStorage
			.getCallerNumberYourself();

	protected NativeDriver driver;

	protected LoginPage main;

	protected CallPage call;

	protected CardContactsPage cardContacts;

	protected SettingsPage setting;

	protected BlockPage block;

	protected FavoritePage favorite;

	protected SavedContactsPage savedContacts;

	protected HistoryPage history;

	@BeforeMethod(description = "Init and check page")
	public void initPages() throws Exception {
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			driver = IosDriverWrapper.getIos(HOST, PORT);
			driver.setDriverType(DEVICE);
			main = PageFactory.initElements(driver, LoginPageIos.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			checkUpdateAlert();
			cardContacts = PageFactory.initElements(driver,
					CardContactsPageIos.class);
			Sleeper.SYSTEM_SLEEPER.sleep(5000);
			break;
		case IOS7:
			driver = IosDriverWrapper.getIos(HOST, PORT);
			driver.setDriverType(DEVICE);
			main = PageFactory.initElements(driver, LoginPageIos.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			cardContacts = PageFactory.initElements(driver,
					CardContactsPageIos.class);
			Sleeper.SYSTEM_SLEEPER.sleep(5000);
			if (call.isAccessContacts())
				call.clickOk();
			checkUpdateAlert();
			break;
		case ANDROID:
			driver = IosDriverWrapper.getAndroid(HOST, PORT);
			Sleeper.SYSTEM_SLEEPER.sleep(10000);
			driver.setDriverType(DEVICE);
			main = PageFactory.initElements(driver, LoginPageAndroid.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			cardContacts = PageFactory.initElements(driver,
					CardContactsPageAndroid.class);
			call.checkPage();
			break;
		default:
			throw new XmlParametersException("Invalid device");
		}

	}

	@AfterMethod
	public void tearDown() throws Exception {
		AppiumDriver.class.cast(driver).quit();

	}

	@BeforeMethod
	public void generateNewUser() {
		SAVED_NAME = "Auto" + String.valueOf(new Random().nextInt(9999));
		CONTACT = String.valueOf(new Random().nextInt(99999));
		OTHER_NAME = "Other" + String.valueOf(new Random().nextInt(99999));
		SECOND_NUMBER = String.valueOf(new Random().nextInt(99999));
	}

	@Test(priority = 1, description = "Check name contact")
	public void checkListContacts() {
		cardContacts = call.clickContact();
		cardContacts.isContactListDownloaded();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickAllContacts();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		boolean visibleListContacts = cardContacts.checkVisibleListContacts();
		Assert.assertTrue(visibleListContacts, "Contact List not do");
	}

	@Test(priority = 2, description = "Check add contact.", enabled = true)
	public void checkAddContact() {
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		boolean result = cardContacts.isContactNumberExist(CONTACT);
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		Assert.assertTrue(result, "Contact number isn't exist");
	}

	@Test(priority = 3, description = "Check number contact, Check name contact", enabled = true)
	public void checkNumberContact() {
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		boolean visibleContact = cardContacts
				.checkVisibleContactNumber(CONTACT);
		Assert.assertTrue(visibleContact, "Contact number not visible");
		boolean visibleContactName = cardContacts
				.checkVisibleContactName(SAVED_NAME);
		Assert.assertTrue(visibleContactName, "Contact name not visible");
		// cardContacts.clickEditContacts();
		// cardContacts.clickDeletefromList();
		// cardContacts.clickDelete();
	}

	// TODO wait CI
	@Test(priority = 5, description = "Check call contact", enabled = false)
	public void checkCallContact() {
		// main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		// goToSwisstokList();
		// createUser(SAVED_NAME, PHONE_NUMBER);
		// cardContacts.callFromContactCard();
		// boolean actualTimer = checkTimer(call.getTimer());
		// call.cancelCall();
		// cardContacts.clickEditContacts();
		// cardContacts.clickDeletefromList();
		// cardContacts.clickDelete();
		// Assert.assertTrue(actualTimer, "Call timer not started");
	}

	@Test(priority = 6, description = "Check add number's contact", enabled = true)
	public void checkAddNumberContact() {
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.inputSecondContact(SECOND_NUMBER);
		cardContacts.clickSave();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		String secondNumber = cardContacts.getSecondNumber(SECOND_NUMBER);
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		Assert.assertEquals(SECOND_NUMBER, secondNumber);
	}

	@Test(priority = 7, description = "Check delete contact", enabled = true)
	public void checkDeleteContact() {
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		Assert.assertTrue(cardContacts.isMessageDeleteAppears(MSG_DELETE),
				"Delete Message user is incorrect");
	}

	@Test(priority = 8, description = "Check blocks contact", enabled = true)
	public void checkBlockContact() {
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickBlockFromList();
		cardContacts.clickBlock();
		Assert.assertTrue(cardContacts.isMessageBlockAppears(MSG_BLOCK),
				"Block Message user is incorrect");
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		setting = cardContacts.clickSettings();
		block = setting.clickBlock();
		block.searchContacts(SAVED_NAME);
		block.clickSearchResult(SAVED_NAME);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		boolean result = block.isContactStatusBlockAppears(STATUS_BLOCK);
		block.clickEditContacts();
		block.clickDeletefromList();
		block.clickDelete();
		Assert.assertTrue(result, "Block status user is incorrect");
	}

	@IgnoreTest(device = "ios7")
	@Test(priority = 9, description = "Check edit name contact", enabled = true)
	public void checkEditContact() {
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.inputName(OTHER_NAME);
		cardContacts.clickSave();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickAllContacts();
		cardContacts.searchContacts(OTHER_NAME);
		call = cardContacts.clickSearchResult(OTHER_NAME);
		String otherName = call.getContactNumber(CONTACT);
		call.clickEditContacts();
		call.clickDeletefromList();
		call.clickDelete();
		Assert.assertEquals(otherName, CONTACT);
	}

	@Test(priority = 10, description = "Check edit number contact", enabled = true)
	public void checkEditNumberContact() {
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.inputContact(SECOND_NUMBER);
		cardContacts.clickSave();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		boolean result = cardContacts.isContactNumberExist(SECOND_NUMBER);
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		Assert.assertTrue(result, "Second number not exist");
	}

	@Test(priority = 11, description = "Check add to favorite contact", enabled = true)
	public void checkAddToFavotite() {
		goToSwisstokList();
		createUser(USER_NAME, USER_NAME);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickStar();
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		favorite = setting.clickFavorite();
		favorite.searchContacts(USER_NAME);
		favorite.openFirstContact();
		boolean result = cardContacts.isContactNumberExist(USER_NAME);
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Assert.assertTrue(result, "Contact not exist in Favourites");
	}

	@Test(priority = 12, description = "Check add to favorite for saved contact", enabled = true)
	public void checkAddToFavotiteSavedContact() {
		goToSwisstokList();
		createUser(SAVED_NAME, SAVED_NAME);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		savedContacts = setting.clickSavedContacts();
		savedContacts.searchContacts(SAVED_NAME);
		savedContacts.clickSearchResult(SAVED_NAME);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		savedContacts.clickStar();
		savedContacts.clickBack();
		setting = savedContacts.clickSettings();
		favorite = setting.clickFavorite();
		favorite.searchContacts(SAVED_NAME);
		favorite.openFirstContact();
		boolean result = cardContacts.isContactNumberExist(SAVED_NAME);
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Assert.assertTrue(result, "Contact not exist in Favourites");
	}

	// TODO need to create special user for this test
	@Test(priority = 13, description = "Check add to favorite for saved contact", enabled = false)
	public void checkSearchByNameBookPhone() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickPhoneBook();
		cardContacts.searchContacts("Anna Haro");
		call = cardContacts.clickSearchResult("Anna Haro");
		String contactNumber = call.getContactNumber("5555228243");
		Assert.assertEquals(contactNumber, "5555228243");
	}

	@Test(priority = 14, enabled = true)
	public void checkGroupingContactsBookName() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		cardContacts.checkGroupingContacts();
	}

	private void createUser(String name, String contact) {
		// cardContacts = call.clickContact();
		cardContacts.clickAddContacts();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(name);
		cardContacts.inputContact(contact);
		cardContacts.clickSave();
	}

	private void goToSwisstokList() {
		cardContacts = call.clickContact();
		cardContacts.isContactListDownloaded();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickSwisstokContacts();
	}

	private void checkUpdateAlert() {
		if (call.isAlertUpdate())
			call.clickCancel();
	}

}
