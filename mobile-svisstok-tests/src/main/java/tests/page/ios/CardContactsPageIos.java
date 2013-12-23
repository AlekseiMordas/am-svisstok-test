package tests.page.ios;

import java.awt.Rectangle;

import tests.page.CardContactsPage;
import tests.page.SettingsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class CardContactsPageIos extends CardContactsPage{
	
	public CardContactsPageIos(NativeDriver driver) {
		super(driver);
	}

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;
	
	@FindBy(locator = "//window[2]/toolbar[1]/button[1]")
	private UIView doneButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView addContactsFromList;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[2]")
	private UIView nameField;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[3]")
	private UIView contactField;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[16]")
	private UIView contactNumber;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[14]")
	private UIView contactName;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[17]/link[1]")
	private UIView delete;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView firstContact;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView secondContact;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	private UIView searchFiled;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[4]")
	private UIView contactSecondField;
	
	@FindBy(locator = "Профиль")
	private UIView profileFromList;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[20]")
	private UIView secondNumber;
	
	@FindBy(locator = "Удалить")
	private UIView deleteNumber;
	
	@FindBy(locator = "/window[1]/scrollview[1]/webview[1]/text[14]")//"//window[1]/scrollview[1]/webview[1]/text[28]")
	private UIView messageDelete;
	
	public void clickAddContacts(){
		Rectangle point = webview.getLocation();
		double x = 270;
		webview.touchWithCoordinates(point.getX() + x, point.getY());
	}
	
	public void clickAddContactsFromList(){
		addContactsFromList.touch();
	}
	
	public void inputName(String text){
		nameField.touch();
		nameField.type(text);
	}
	
	public void inputContact(String contact){
		contactField.touch();
		contactField.type(contact);
		doneButton.touch();
	}
	
	@Override	
	public void inputSecondContact(String contact){
		contactSecondField.touch();
		contactSecondField.type(contact);
		doneButton.touch();
	}
	
	public void clickBack(){
		Rectangle point = webview.getLocation();
		double x = 10;
		double y = 5;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}
	
	public String getContactNumber(){
		return contactNumber.getAttribute("label");
	}
	
	public String getContactName(){
		return contactName.getAttribute("label");
	}
	
	public void clickEditContacts(){
		Rectangle point = webview.getLocation();
		double x = 270;
		webview.touchWithCoordinates(point.getX() + x, point.getY());
		
	}
	
	public void clickDeletefromList(){
		Rectangle point = webview.getLocation();
		double x = 116;
		webview.touchWithCoordinates(point.getX() + x, point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(5000);
	}
	
	public void clickDelete(){
		//delete.touch();
		Rectangle point = webview.getLocation();
		double x = 20;
		double y = 245;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
		//Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
	
	public void clickCall(){
		Rectangle point = webview.getLocation();
		double x = 160;
		double y = 406;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}
	
	public void clickFirstContact(){
		//firstContact.touch(); dynamic xPath
		Rectangle point = webview.getLocation();
		double y = 113;
		webview.touchWithCoordinates(point.getX(), point.getY() + y);
		
	}
	
	public boolean checkVisibleContactNumber(){
		
		return checkVisibleText(getContactNumber());
	}
	
    public boolean checkVisibleContactName(){
		
		return checkVisibleText(getContactName());
	}
    
    public boolean checkVisibleListContacts(){
    	boolean first = checkVisibleText((firstContact.getAttribute("name").split(" ")[0]));
    	boolean second = checkVisibleText((secondContact.getAttribute("name").split(" ")[0]));
    	System.out.println("qq"+ second);
    	if(first && second)
    	 return true;
    	else
    		return false;
    }
    
   public SettingsPageIos clickSettings(){
	   Rectangle point = webview.getLocation();
		double x = 10;
		double y = 5;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	return PageFactory.initElements(driver, SettingsPageIos.class);
    }
   
   public void searchContacts(String text){
	   searchFiled.touch();
	   searchFiled.type(text);
	   doneButton.touch();
   }
   
   public CallPageIos clickSearchResult(){
	   Rectangle point = webview.getLocation();
		double y = 88;
		webview.touchWithCoordinates(point.getX(), point.getY() + y);
	 return PageFactory.initElements(driver, CallPageIos.class);
   }
   
   public void clickEditFromList(){
	   Rectangle point = webview.getLocation();
		double x = 116;
		double y = 129;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
   }

   public void clickProfile(){
	   profileFromList.touchByName();
   }
   
   public String getSecondNumber(){
	   //secondNumber.touchByName();
	   return secondNumber.getAttribute("label");
   }
   
   public void secondDelete(){
	   Rectangle point = webview.getLocation();
		double x = 25;
		double y = 191;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
   }
   
   public void deleteNumber(){
	   deleteNumber.touchByName();
   }
   
   public String getMessageDelete(){
	   return messageDelete.getAttribute("label");
   }
   
	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
			

}
