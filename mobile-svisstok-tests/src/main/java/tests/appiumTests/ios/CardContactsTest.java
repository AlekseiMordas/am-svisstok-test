package tests.appiumTests.ios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mobile.driver.wait.Sleeper;

public class CardContactsTest extends BaseTest {
	
	public static final String SAVED_NAME = "Qwerty";
	public static final String CONTACT = "1234";
	public static final String SECOND_NUMBER = "2222";
	public static final String MSG_DELETE = "Удалено";
	
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

}
