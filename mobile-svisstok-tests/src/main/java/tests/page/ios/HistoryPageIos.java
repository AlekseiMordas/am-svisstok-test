package tests.page.ios;

import java.awt.Rectangle;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;

import tests.page.HistoryPage;

public class HistoryPageIos extends HistoryPage{

	public HistoryPageIos(NativeDriver driver) {
		super(driver);
	}
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]")
	private UIView timerCall;
	
	@FindBy(locator = "Позвонить")
	private UIView callTab;
	
//	@FindBy(locator = "")
	//private UIView editButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[4]")
	private UIView trashButton;
	
	@FindBy(locator ="//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView arrowButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]")
	private UIView contact;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clickFirstContact() {
		Rectangle point = webview.getLocation();
		double y = 42;
	webview.touchWithCoordinates(point.getX(), point.getY() + y);
	}

	@Override
	public void cancelCall() {
		Rectangle point = webview.getLocation();
		double x = 24;
		double y = 432;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
		}
	
	public String getTimer() {
		return timerCall.getAttribute("label");
	}
	
	public void clickCall(){
		Rectangle point = callTab.getLocation();
		webview.touchWithCoordinates(point.getX(), point.getY());
	}
	
	 public void clickEdit() {
	    	Rectangle point = arrowButton.getLocation();
	    	arrowButton.touchWithCoordinates(point.getX(), point.getY()-30);
			
		}

	public void clickTrash() {
		Rectangle point = trashButton.getLocation();
		trashButton.touchWithCoordinates(point.getX(), point.getY());
			
		}

	public void findDeleteContacts() {
			Rectangle point = contact.getLocation();
			
		}
	

}
