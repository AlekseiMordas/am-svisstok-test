package tests.appiumTests.ios;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import runner.DeviceConfig;
import runner.Devices;
import tests.page.BlockPage;
import tests.page.CallPage;
import tests.page.CardContactsPage;
import tests.page.FavoritePage;
import tests.page.HistoryPage;
import tests.page.LoginPage;
import tests.page.SavedContactsPage;
import tests.page.SettingsPage;
import tests.page.android.CallPageAndroid;
import tests.page.android.CardContactsPageAndroid;
import tests.page.android.LoginPageAndroid;
import tests.page.exceptions.XmlParametersException;
import tests.page.ios.CallPageIos;
import tests.page.ios.CardContactsPageIos;
import tests.page.ios.LoginPageIos;
import utils.ApplicationStorage;

import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;
import com.sun.jna.platform.win32.BaseTSD;

import driver.IosDriverWrapper;

public class CardContactsTest{
	
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

	protected static final String USER_NAME = ApplicationStorage.getDefaultUsername();;//"skustov4";// //"sip:skustov2@sipnet.ru";//"7812009957@217.195.69.250";
															// 7789 pas 1246

	protected static final String USER_PASSWORD = ApplicationStorage.getDefaultPassword();//vstarshinin psw: 6Terminator6// //"zzzzzz";//"JNcW5qTBaRvy";

	protected static final String ABONENT_NAME = ApplicationStorage.getDefaultPassword();
	
	protected static final String INCORRECT_USER_NAME = "7812001245@211.195.68.250";

	protected static final String INCORRECT_PASSWORD = "70mNZcEy05G123";

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
			driver = IosDriverWrapper.getIphone(HOST, PORT);
			driver.setDriverType(DEVICE);
			main = PageFactory.initElements(driver, LoginPageIos.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			cardContacts = PageFactory.initElements(driver, CardContactsPageIos.class);
			Sleeper.SYSTEM_SLEEPER.sleep(5000);
			break;
		case IOS7:
			driver = IosDriverWrapper.getIphone(HOST, PORT);
			driver.setDriverType(DEVICE);
			main = PageFactory.initElements(driver, LoginPageIos.class);
			call = main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
			cardContacts = PageFactory.initElements(driver, CardContactsPageIos.class);
			Sleeper.SYSTEM_SLEEPER.sleep(5000);
			if(call.isAccessContacts())
			  call.clickOk();
			break;
		case ANDROID:
			driver = IosDriverWrapper.getAndroid(HOST, PORT);
			Sleeper.SYSTEM_SLEEPER.sleep(10000);
			driver.setDriverType(DEVICE);
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
	public void tearDown() throws Exception {
		AppiumDriver.class.cast(driver).quit();
		
	}
	@BeforeMethod
	public void generateNewUser() {
		SAVED_NAME = "AutoTest" + String.valueOf(new Random().nextInt(9999));
		CONTACT = String.valueOf(new Random().nextInt(99999));
		OTHER_NAME = "Other" + String.valueOf(new Random().nextInt(99999));
		SECOND_NUMBER = String.valueOf(new Random().nextInt(99999));
	}
/*
	@Test(priority = 1, description = "Check name contact")
	public void checkListContacts() {
		goToSwisstokList();
		boolean visibleListContacts = cardContacts.checkVisibleListContacts();
		//cardContacts.clickCall(); we don't need if use afterMethod for driver quite
		Assert.assertTrue(visibleListContacts, "Contact List not do");
	}

	@Test(priority = 2, description = "Check add contact.")
	public void checkAddContact() {
		//main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		String savedContact = cardContacts.getContactNumber();
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		Assert.assertEquals(savedContact, CONTACT);
	}

	@Test(priority = 3, description = "Check number contact, Check name contact")
	public void checkNumberContact() {
	//	main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		goToSwisstokList();
		cardContacts.clickFirstContact();
		boolean visibleContact = cardContacts.checkVisibleContactNumber();
		Assert.assertTrue(visibleContact, "Contact number not visible");
		boolean visibleContactName = cardContacts.checkVisibleContactName();
		Assert.assertTrue(visibleContactName, "Contact name not visible");
	}

	//TODO wait CI
//	@Test(priority = 5, description = "Check call contact")
//	public void checkCallContact() {
//		main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
//		cardContacts = call.clickContact();
//		setting = cardContacts.clickSettings();
//		cardContacts = setting.clickAllContacts();
//		cardContacts.searchContacts(USER_NAME);
//		call = cardContacts.clickSearchResultAndCall(USER_NAME);
//		Sleeper.SYSTEM_SLEEPER.sleep(3000);
//		boolean actualTimer = checkTimer(call.getTimer());
//		Assert.assertTrue(actualTimer, "Call timer not started");
//	}

	@Test(priority = 6, description = "Check add number's contact")
	public void checkAddNumberContact() {
	//	main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.inputSecondContact(SECOND_NUMBER);
		cardContacts.clickSave();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.swipe(0.5, 0.8, 0.5, 0.1, 0.5);
		String secondNumber = cardContacts.getSecondNumber(SECOND_NUMBER);
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		Assert.assertEquals(SECOND_NUMBER, secondNumber);
	}

	@Test(priority = 7, description = "Check delete contact")
	public void checkDeleteContact() {
	//	main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		String messageDelete = cardContacts.getMessageDelete();
		Assert.assertEquals(messageDelete, MSG_DELETE);
	}

	@Test(priority = 8, description = "Check blocks contact")
	public void checkBlockContact() {
		//main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		goToSwisstokList();
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
		block.clickSearchResult(SAVED_NAME);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		String blockContact = block.getContactStatusBlock();
		block.clickEditContacts();
		block.clickDeletefromList();
		block.clickDelete();
		Assert.assertEquals(blockContact, STATUS_BLOCK);
	}
/*
	@Test(priority = 9, description = "Check edit name contact")
	public void checkEditContact() {
		//main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
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
		String otherName = call.getContactNumber();
		call.clickEditContacts();
		call.clickDeletefromList();
		call.clickDelete();
		Assert.assertEquals(otherName, CONTACT);
	}

	@Test(priority = 10, description = "Check edit number contact")
	public void checkEditNumberContact() {
	//	main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		goToSwisstokList();
		createUser(SAVED_NAME, CONTACT);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickEditFromList();
		cardContacts.inputContact(SECOND_NUMBER);
		cardContacts.clickSave();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		String otherNumber = cardContacts.getContactNumber();
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		Assert.assertEquals(SECOND_NUMBER, otherNumber);
	}*/

	@Test(priority = 11, description = "Check add to favorite contact")
	public void checkAddToFavotite() {
	//	main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		goToSwisstokList();
		createUser(USER_NAME, USER_NAME);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.swipe(0.5, 0.8, 0.5, 0.1, 0.5);
		cardContacts.clickStar();
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		favorite = setting.clickFavorite();
		favorite.searchContacts(USER_NAME);
		favorite.clickSearchResult(USER_NAME);
		//Functionality app was changed
	/*	String number = favorite.getContactName();
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Assert.assertEquals(number, CONTACT );*/
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		boolean actualTimer = checkTimer(call.getTimer());
		call.cancelCall();
		Assert.assertTrue(actualTimer);
	}
/*
	@Test(priority = 12, description = "Check add to favorite for saved contact")
	public void checkAddToFavotiteSavedContact() {
	//	main.simpleLogin(USER_NAME, USER_PASSWORD, false, false);
		goToSwisstokList();
		createUser(USER_NAME, USER_NAME);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		savedContacts = setting.clickSavedContacts();
		savedContacts.searchContacts(USER_NAME);
		savedContacts.clickSearchResult(USER_NAME);
		savedContacts.swipe(0.5, 0.8, 0.5, 0.1, 0.5);
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		savedContacts.clickStar();
		savedContacts.clickBack();
		setting = savedContacts.clickSettings();
		favorite = setting.clickFavorite();
		favorite.searchContacts(USER_NAME);
		favorite.clickSearchResult(USER_NAME);
		//Functionality app was changed
		/*String number = favorite.getContactName();
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Assert.assertEquals(number, CONTACT);*/
		/*Sleeper.SYSTEM_SLEEPER.sleep(3000);
		boolean actualTimer = checkTimer(call.getTimer());
		call.cancelCall();
		Assert.assertTrue(actualTimer);
	}*/

	private void createUser(String name, String contact) {
		// cardContacts = call.clickContact();
		cardContacts.clickAddContacts();
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
	
	private static boolean checkTimer(String element) {
		Pattern p = Pattern.compile("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$");
		Matcher m = p.matcher(element.replace(" ", ""));
		return m.matches();
	}

}
