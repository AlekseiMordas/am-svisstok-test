package tests.page.ios;

import java.awt.Rectangle;

import tests.page.BlockPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class BlockPageIos extends BlockPage {
	public BlockPageIos(NativeDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	private UIView searchFiled;
	
	@FindBy(locator = "//window[2]/toolbar[1]/button[1]")
	private UIView doneButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]")
	private UIView contactName;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView searchResult;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[2]")
	private UIView settingTab;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[5]")
	private UIView deleteFromList;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[17]")//window[1]/scrollview[1]/webview[1]/link[23]
	private UIView deleteButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[3]")
	private UIView contactStatusBlock;

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
		   Rectangle point = searchResult.getLocation();
		   searchResult.touchWithCoordinates(point.getX(), point.getY());
	   }
 
   public String getContactName(){
		return contactName.getAttribute("name");
	}
   public String getContactStatusBlock(){
	   return contactStatusBlock.getAttribute("name");
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
	
	@Override	
	public void clickDelete(){
		Rectangle point = deleteButton.getLocation();
		deleteButton.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}
	
	public void clickCall() {
		
	}
}
