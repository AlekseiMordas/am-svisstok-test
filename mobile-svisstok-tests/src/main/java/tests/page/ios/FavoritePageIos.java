package tests.page.ios;

import java.awt.Rectangle;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import tests.page.FavoritePage;

public class FavoritePageIos extends FavoritePage{

	public FavoritePageIos(NativeDriver driver) {
		super(driver);
	}
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	private UIView searchFiled;
	
	@FindBy(locator = "//window[2]/toolbar[1]/button[1]")
	private UIView doneButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[5]")
	private UIView contactName;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]/link[1]")
	private UIView searchResult;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]")
	private UIView timerCall;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[9]/link[1]")
	private UIView callingButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[14]/link[1]")
	private UIView callButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[5]/link[1]")
	private UIView cancelCallButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView trashButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView settingTab;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView deleteFromList;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView firstResult;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
	
	public void searchContacts(String text){
		   searchFiled.touch();
		   searchFiled.type(text);
		   doneButton.touch();
	   }
	
    public void clickSearchResult(String name){
		   Rectangle point = firstResult.getLocation();
			//double y = 113;
			firstResult.touchWithCoordinates(point.getX(), point.getY());
	   }
 
   public String getContactName(){
		return contactName.getAttribute("name");
	}
   
   public void clickEditContacts(){
		Rectangle point = settingTab.getLocation();
		settingTab.touchWithCoordinates(point.getX(), point.getY());
	}
	
	@Override	
	public void clickDeletefromList(){
		Rectangle point = deleteFromList.getLocation();
		deleteFromList.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
		
	public void clickDelete(){
		Rectangle point = trashButton.getLocation();
		trashButton.touchWithCoordinates(point.getX(), point.getY());
	}
	
	
	public void clickCall(){
		Rectangle point = callButton.getLocation();
		callButton.touchWithCoordinates(point.getX(), point.getY());
	}
	
	public void clickCallingButton(){
		callingButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
	
	public void cancelCall() {
		Rectangle point = cancelCallButton.getLocation();
		cancelCallButton.touchWithCoordinates(point.getX(), point.getY());
	}
	
	public String getTimer() {
		return timerCall.getAttribute("label");
	}

}
