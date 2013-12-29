package tests.appiumTests.ios;

import java.util.Locale;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import runner.Devices;
import tests.page.android.CardContactsPageAndroid;
import tests.page.android.LoginPageAndroid;
import tests.page.exceptions.XmlParametersException;
import tests.page.ios.CardContactsPageIos;
import tests.page.ios.LoginPageIos;

import com.ios.AppiumDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import driver.IosDriverWrapper;

public class CardContactsTest extends BaseTest {

	protected static String SAVED_NAME;
	protected static final String OTHER_NAME = "Qwerty12";
	protected static String CONTACT;
	protected static final String SECOND_NUMBER = "2222";
	protected static final String MSG_DELETE = "Удалено";
	protected static final String MSG_BLOCK = "Контакт заблокирован";

	@BeforeMethod(description = "Init and check page")
	public void init() throws Exception {

		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			driver = IosDriverWrapper.getIphone(HOST, PORT);
			main = PageFactory.initElements(driver, LoginPageIos.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			cardContacts = PageFactory.initElements(driver, CardContactsPageIos.class);
			Sleeper.SYSTEM_SLEEPER.sleep(5000);
			break;
		case ANDROID:
			driver = IosDriverWrapper.getAndroid(HOST, PORT);
			Sleeper.SYSTEM_SLEEPER.sleep(10000);
			main = PageFactory.initElements(driver, LoginPageAndroid.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			cardContacts = PageFactory.initElements(driver, CardContactsPageAndroid.class);
			call.checkPage();
			break;
		default:
			throw new XmlParametersException("Invalid device");
		}
	}
	
	@AfterMethod
	public void close() {
		((AppiumDriver)driver).quit();
	}

	
	@BeforeMethod
	public void generateNewUser() {
		SAVED_NAME = "AutoTest" + String.valueOf(new Random().nextInt(9999));
		CONTACT = String.valueOf(new Random().nextInt(99999));
	}

	@Test(priority = 1, description = "Check name contact")
	public void checkListContacts() {
		cardContacts = call.clickContact();
		boolean visibleListContacts = cardContacts.checkVisibleListContacts();
		cardContacts.clickCall();
		Assert.assertTrue(visibleListContacts);
	}

	@Test(priority = 2, description = "Check add contact. Android -bug")
	public void checkAddContact() {
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		String savedContact = cardContacts.getContactNumber();
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		cardContacts.clickCall();
		Assert.assertEquals(savedContact, CONTACT);
	}

	@Test(priority = 3, description = "Check number contact")
	public void checkNumberContact() {
		cardContacts = call.clickContact();
		cardContacts.clickFirstContact();
		boolean visibleContact = cardContacts.checkVisibleContactNumber();
		cardContacts.clickBack();
		cardContacts.clickCall();
		Assert.assertTrue(visibleContact);
	}

	@Test(priority = 4, description = "Check name contact")
	public void checkNameContact() {
		cardContacts = call.clickContact();
		cardContacts.clickFirstContact();
		boolean visibleContact = cardContacts.checkVisibleContactName();
		cardContacts.clickBack();
		cardContacts.clickCall();
		Assert.assertTrue(visibleContact, "Contact not visible");
	}

	@Test(priority = 5, description = "Check call contact")
	public void checkCallContact() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickAllContacts();
		cardContacts.searchContacts(USER_NAME);
		call = cardContacts.clickSearchResultAndCall(USER_NAME);
		boolean actualTimer = checkTimer(call.getTimer());
		call.cancelCall();
		call.clickBack();
		call.clickCall();
		Assert.assertTrue(actualTimer, "Call timer not started");
	}

	@Test(priority = 6, description = "Check add number's contact")
	// Android Bug. Second number not saved
	public void checkAddNumberContact() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickSwisstokContacts();
		cardContacts.clickFirstContact();
		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.inputSecondContact(SECOND_NUMBER);
		cardContacts.clickBack();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.swipe(0.5, 0.8, 0.5, 0.1, 0.5);
		String secondNumber = cardContacts.getSecondNumber();
		cardContacts.clickBack();
		cardContacts.clickFirstContact();
		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.secondDelete();
		cardContacts.deleteNumber();
		cardContacts.clickBack();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickBack();
		call.clickCall();
		Assert.assertEquals(SECOND_NUMBER, secondNumber);
	}

	@Test(priority = 7, description = "Check delete contact")
	// Android Bug
	public void checkDeleteContact() {
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		String messageDelete = cardContacts.getMessageDelete();
		cardContacts.clickCall();
		Assert.assertEquals(messageDelete, MSG_DELETE);
	}

	@Test(priority = 8, description = "Check blocks contact")
	// Android Bug
	public void checkBlockContact() {
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickBlockFromList();
		cardContacts.clickBlock();
		String messageBlock = cardContacts.getMessageBlock();
		Assert.assertEquals(messageBlock, MSG_BLOCK);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		setting = cardContacts.clickSettings();
		block = setting.clickBlock();
		block.searchContacts(SAVED_NAME);
		block.clickSearchResult(SAVED_NAME.toLowerCase());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		String blockContact = block.getContactName();
		System.out.println("block0 " + blockContact);
		block.clickEditContacts();
		block.clickDeletefromList();
		block.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		block.clickCall();
		Assert.assertEquals(blockContact, CONTACT.toLowerCase());
	}

	@Test(priority = 9, description = "Check edit name contact")
	// Android Bug
	public void checkEditContact() {
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.inputName(OTHER_NAME);
		cardContacts.clickBack();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickAllContacts();
		cardContacts.searchContacts(OTHER_NAME);
		call = cardContacts.clickSearchResultAndCall(SAVED_NAME.toLowerCase());

		String otherName = call.getContactNumber();
		call.clickEditContacts();
		call.clickDeletefromList();
		call.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		call.clickCall();
		Assert.assertEquals(otherName, CONTACT );
	}

	@Test(priority = 10, description = "Check edit number contact")
	// Android Bug
	public void checkEditNumberContact() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickSwisstokContacts();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(SAVED_NAME);
		cardContacts.inputContact(CONTACT);
		cardContacts.clickBack();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);

		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.inputContact(SECOND_NUMBER);
		cardContacts.clickBack();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		String otherNumber = cardContacts.getContactNumber();
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickCall();
		Assert.assertEquals(SECOND_NUMBER, otherNumber);
	}
	
	@Test(priority = 10, description = "Check add to favorite contact")
	// Android Bug
	public void checkAddToFavotite() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickSwisstokContacts();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.swipe(0.5, 0.8, 0.5, 0.1, 0.5);
		cardContacts.clickStar();
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		favorite = setting.clickFavorite();
		favorite.searchContacts(SAVED_NAME);
		favorite.clickSearchResult(SAVED_NAME);
		String number = favorite.getContactName();
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickCall();
		Assert.assertEquals(CONTACT, number);
	}

	@Test(priority = 11, description = "Check add to favorite for saved contact")
	// Android Bug
	public void checkAddToFavotiteSavedContact() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickSwisstokContacts();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);

		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		savedContacts = setting.clickSavedContacts();
		savedContacts.searchContacts(SAVED_NAME);
		savedContacts.clickSearchResult();
		savedContacts.swipe(0.5, 0.8, 0.5, 0.1, 0.5);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);

		savedContacts.clickStar();
		savedContacts.clickBack();
		setting = savedContacts.clickSettings();
		favorite = setting.clickFavorite();
		favorite.searchContacts(SAVED_NAME);
		favorite.clickSearchResult(SAVED_NAME);
		String number = favorite.getContactName();
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);

		cardContacts.clickCall();
		Assert.assertEquals(CONTACT, number);
	}

	private void createUser(String name, String contact) {
		cardContacts = call.clickContact();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(name);
		cardContacts.inputContact(contact);
		cardContacts.clickBack();
	}
}
