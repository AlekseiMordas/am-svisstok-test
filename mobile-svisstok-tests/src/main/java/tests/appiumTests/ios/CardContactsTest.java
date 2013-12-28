package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ios.AppiumDriver;
import com.mobile.driver.wait.Sleeper;

public class CardContactsTest extends BaseTest {
	
	protected static final String SAVED_NAME = "Qwerty";
	protected static final String OTHER_NAME = "Qwerty12";
	protected static final String CONTACT = "1234";
	protected static final String SECOND_NUMBER = "2222";
	protected static final String MSG_DELETE = "Удалено";
	protected static final String MSG_BLOCK = "Контакт заблокирован";
	
	@Test(priority = 1, description = "Check name contact")
	public void checkListContacts() {
		cardContacts = call.clickContact();
		boolean visibleListContacts = cardContacts.checkVisibleListContacts();
		cardContacts.clickCall();
		Assert.assertTrue(visibleListContacts);
	}
	
	@Test(priority = 2, description = "Check add contact")
	public void checkAddContact() {
		cardContacts = call.clickContact();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(SAVED_NAME);
		cardContacts.inputContact(CONTACT);
		cardContacts.clickBack();
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
		Assert.assertTrue(visibleContact);
	}
	
	@Test(priority = 5, description = "Check call contact")
	public void checkCallContact() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickAllContacts();
		cardContacts.searchContacts(USER_NAME);
		call = cardContacts.clickSearchResult();
		call.clickCallButton();
		boolean actualTimer = checkTimer(call.getTimer());
		call.cancelCall();
		call.clickBack();
		call.clickCall();
		Assert.assertTrue(actualTimer);
	}  
	
	@Test(priority = 6, description = "Check add number's contact")
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
	public void checkDeleteContact() {
		cardContacts = call.clickContact();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(SAVED_NAME);
		cardContacts.inputContact(CONTACT);
		cardContacts.clickBack();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickEditContacts();
		cardContacts.clickDeletefromList();
		cardContacts.clickDelete();
		String messageDelete = cardContacts.getMessageDelete();
		cardContacts.clickCall();
		Assert.assertEquals(messageDelete, MSG_DELETE);
	}
	
	@Test(priority = 8, description = "Check blocks contact")
	public void checkBlockContact() {
		cardContacts = call.clickContact();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(SAVED_NAME);
		cardContacts.inputContact(CONTACT);
		cardContacts.clickBack();
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
		block.clickSearchResult();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		String blockContact = block.getContactName();
		System.out.println("block0 " + blockContact);
		block.clickEditContacts();
		block.clickDeletefromList();
		block.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		block.clickCall();
		Assert.assertEquals(blockContact, CONTACT);
	}
	
	@Test(priority = 9, description = "Check edit name contact")
	public void checkEditContact() {
		cardContacts = call.clickContact();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(SAVED_NAME);
		cardContacts.inputContact(CONTACT);
		cardContacts.clickBack();
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
		call = cardContacts.clickSearchResult();
		
		String otherName = call.getContactNumber();		
		call.clickEditContacts();
		call.clickDeletefromList();
		call.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		call.clickCall();
		Assert.assertEquals(CONTACT, otherName);
	}
	
	@Test(priority = 10, description = "Check edit number contact")
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
	public void checkAddToFavotite() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickSwisstokContacts();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(SAVED_NAME);
		cardContacts.inputContact(CONTACT);
		cardContacts.clickBack();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		
		cardContacts.swipe(0.5, 0.8, 0.5, 0.1, 0.5);

		cardContacts.clickStar();
		cardContacts.clickBack();
		setting = cardContacts.clickSettings();
		favorite = setting.clickFavorite();
		favorite.searchContacts(SAVED_NAME);
		favorite.clickSearchResult();
		String number = favorite.getContactName();
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		cardContacts.clickCall();
		Assert.assertEquals(CONTACT, number);
	}

	@Test(priority = 11, description = "Check add to favorite for saved contact")
	public void checkAddToFavotiteSavedContact() {
		cardContacts = call.clickContact();
		setting = cardContacts.clickSettings();
		cardContacts = setting.clickSwisstokContacts();
		cardContacts.clickAddContacts();
		cardContacts.clickAddContactsFromList();
		cardContacts.inputName(SAVED_NAME);
		cardContacts.inputContact(CONTACT);
		cardContacts.clickBack();
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
		favorite.clickSearchResult();
		String number = favorite.getContactName();
		favorite.clickEditContacts();
		favorite.clickDeletefromList();
		favorite.clickDelete();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		
		cardContacts.clickCall();
		Assert.assertEquals(CONTACT, number);
	}

}
