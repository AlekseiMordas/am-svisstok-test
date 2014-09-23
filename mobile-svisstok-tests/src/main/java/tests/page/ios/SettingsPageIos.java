package tests.page.ios;

import java.awt.Rectangle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Dimension;

import runner.Devices;
import tests.page.CallPage;
import tests.page.SettingsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class SettingsPageIos extends SettingsPage {

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]")
	private UIView webview;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[3]", 
			ios7 = "//window[1]/scrollview[1]/webview[1]/slider[3]")
	public UIView autoLoginSlider;

	@FindBy(locator = "Все контакты")
	private UIView allContacts;

	@FindBy(locator = "Контакты в Swisstok")
	private UIView swisstokContacts;

	@FindBy(locator = "//UIAStaticText[@name='Избранные']")
	private UIView favourContacts;

	@FindBy(locator = "Сохраненные номера")
	private UIView savedContacts;

	@FindBy(locator = "Заблокированные")
	private UIView block;

	@FindBy(locator = "Шифрование")
	private UIView encryption;
	
	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAElement[2]")
	private UIView encryptionButton;

	@FindBy(locator = "//UIAApplication[1]/UIAWindow[2]/UIAPicker[1]")
	private UIView popUpMenu;

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[13]/link[1]")
	private UIView callTab;
	
	@FindBy(locator = "Контактная книга телефона")
	private UIView phoneBook;
	
	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[4]")
	private UIView valueBalance;
	
	@FindBy(locator = "О программе")
	private UIView aboutApp;
	
	@FindBy(locator = "Помощь",
			ios7 = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[6]/UIALink[2]/UIAStaticText[1]")
	private UIView help;
	
	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	private UIView urlPDFfile;
	
	@FindBy(locator = "Done")
	private UIView done;
	
	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[14]")
	private UIView language;
	
	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[11]/UIALink[1]/UIAStaticText[1]",
			ios7 = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[11]")
	private UIView logApp;
	
	@FindBy(locator = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[2]")
	private UIView firstLog;
	
	@FindBy(locator = "Белый список")
	private UIView whiteList;

	public SettingsPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void checkPage() {
	}

	@Override
	public void setAutoLogin(boolean flag) {
		scrollDown(autoLoginSlider.getLocator());
		if (flag) {
			if (autoLoginSlider.getAttribute("value").equals("0.00")) {
				autoLoginSlider.touch();
			}
		} else {
			if (autoLoginSlider.getAttribute("value").equals("1")) {
				autoLoginSlider.touch();
			}
		}
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public boolean isAutoLoginFlagDisable() {
		return autoLoginSlider.getAttribute("value").equals("0.00");
	}

	@Override
	@SuppressWarnings("unchecked")
	public CardContactsPageIos clickAllContacts() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = allContacts.getLocation();
		allContacts.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}

	// use coordinats, because dynamic xPath
	@Override
	@SuppressWarnings("unchecked")
	public CardContactsPageIos clickSwisstokContacts() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = swisstokContacts.getLocation();
		swisstokContacts.touchWithCoordinates(point.getX(), 200);
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public BlockPageIos clickBlock() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = block.getLocation();
		block.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, BlockPageIos.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public FavoritePageIos clickFavorite() {
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
		Rectangle point = favourContacts.getLocation();
		favourContacts.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, FavoritePageIos.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public SavedContactsPageIos clickSavedContacts() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
//		Rectangle point = savedContacts.getLocation();
//		savedContacts.touchWithCoordinates(point.getX(), point.getY());
		savedContacts.touch();
		return PageFactory.initElements(driver, SavedContactsPageIos.class);
	}

	@Override
	public void setZRTPconnection() {
		//((AppiumDriver) driver).scrollToText("Номер голосовой почты");
		scrollDown(language.getLocator());
		scrollDown(encryptionButton.getLocator());
		Rectangle point = encryptionButton.getLocation();
		encryptionButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		Dimension dim = webview.getSize();
		webview.touchWithCoordinates(dim.getWidth() / 2, dim.getHeight() - 80);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void setSRTPconnection() {
		scrollDown(language.getLocator());
		scrollDown(encryptionButton.getLocator());
		Rectangle point = encryptionButton.getLocation();
		encryptionButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		Dimension dim = webview.getSize();
		webview.touchWithCoordinates(dim.getWidth() / 2, dim.getHeight() - 60);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public CallPage clickCallTab() {
		Dimension dim = webview.getSize();
		webview.touchWithCoordinates(dim.width / 4 * 2 + 10, dim.height - 10);
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@Override
	public void setConnectionByDefault() {
		scrollDown(language.getLocator());
		scrollDown(encryptionButton.getLocator());
		Rectangle point = encryptionButton.getLocation();
		encryptionButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		Dimension dim = webview.getSize();
		webview.touchWithCoordinates(dim.getWidth() / 2, dim.getHeight() - 95);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}
	
	@Override
	public CardContactsPageIos clickPhoneBook(){
		phoneBook.touch();
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}
	
	@Override 
	public boolean isBalance(){
		String value = valueBalance.getAttribute("name");
		Pattern p = Pattern.compile("^[0-9]{1,}.руб.$");
		Matcher m = p.matcher(value);
		return m.matches();
	}

	@Override
	public void clickAboutApp() {
		aboutApp.touch();
	}

	@Override
	public String getUrlAboutApp() {
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		return urlPDFfile.getAttribute("name");
	}
	
	@Override
	public void clickHelp() {
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			help.touch();
			break;
		case IOS7:
			Rectangle point = help.getLocation();
			help.touchWithCoordinates(point.getX(), point.getY());
			break;
		default:
			break;
		}
	}
	
	@Override
	public String getUrlHelp(){
		Sleeper.SYSTEM_SLEEPER.sleep(5000);
		return urlPDFfile.getAttribute("name");
	}
	
	@Override
	public void clickDone(){
		done.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
	
	@Override
	public void scrollToText(String text){
		((AppiumDriver) driver).scrollToText(text);
	}
	
	@Override
	public void changeLanguageToEnglish(){
		scrollDown(language.getLocator());
		clickLanguage();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		Dimension dim = webview.getSize();
		
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			webview.touchWithCoordinates(dim.width / 2, dim.height - 50);
			break;
		case IOS7:
			webview.touchWithCoordinates(dim.width / 2, dim.height - 70);
			clickDone();
			break;
		default:
			break;
		}
		
	}
	
	@Override
	public void changeLanguageToRussian(){
		clickLanguage();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		Dimension dim = webview.getSize();
		
		switch (Devices.valueOf(DEVICE)) {
		case IPHONE:
			webview.touchWithCoordinates(dim.width / 2, dim.height / 2 + 100);
			break;
		case IOS7:
			webview.touchWithCoordinates(dim.width / 2, dim.height / 2 + 150);
			clickDone();
			break;
		default:
			break;
		}
	}
	
	@Override
	public void clickLanguage(){
		Rectangle point = language.getLocation();
		language.touchWithCoordinates(point.x, point.y);
	}
	
	@Override
	public String getLanguage(){
		return language.getAttribute("name");
	}
	
	@Override
	public void openLogApp(){
		scrollDown(logApp.getLocator());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		logApp.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}
	
	@Override
	public boolean validateLogs(){
		return checkVisibleText(firstLog.getAttribute("name"));
	}

}
