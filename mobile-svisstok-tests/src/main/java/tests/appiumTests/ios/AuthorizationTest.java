package tests.appiumTests.ios;

import helpers.GenerateRandomString;
import junit.framework.Assert;

import org.testng.annotations.Test;

import tests.constants.ErrorMessages;

public class AuthorizationTest extends BaseTest{
	
	private String VALUE_INPUT = "1234567890";
	
	private String CHARACTERS_INPUT = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	@Test
	public void  simpleLogin() {
		main.checkPage();
		call = main.simpleLogin(USER_NAME, USER_PASSWORD);
		call.checkPage();
	}
	
	@Test
	public void  checkLoginFieldDigits() {
		main.checkPage();
		main.inputLoginTextfield(VALUE_INPUT);
		Assert.assertEquals(main.getFieldText(main.loginTextfield), VALUE_INPUT);
	}
	
	@Test
	public void  checkLoginFieldLetters() {
		main.checkPage();
		main.inputLoginTextfield(CHARACTERS_INPUT);
		Assert.assertEquals(main.getFieldText(main.loginTextfield), CHARACTERS_INPUT);
		main.inputLoginTextfield(CHARACTERS_INPUT.toLowerCase());
		Assert.assertEquals(main.getFieldText(main.loginTextfield), CHARACTERS_INPUT.toLowerCase());
	}
	
	
	@Test
	public void checkLoginWithIncorrectCredentionals() {
		main.checkPage();
		String password = GenerateRandomString.generateString();
		main.inputLoginTextfield(INCORRECT_USER_NAME);
		main.inputPasswordTextfield(password);
		main.clickLogin();
		Assert.assertTrue(main.isErrorMessageAppears());
	}
	
	
}
