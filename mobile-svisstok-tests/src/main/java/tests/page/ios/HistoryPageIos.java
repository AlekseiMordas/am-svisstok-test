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
		double y = 412;
	webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
		}
	
	public String getTimer() {
		return timerCall.getAttribute("label");
	}
	
	public void clickCall(){
		Rectangle point = webview.getLocation();
		double x = 160;
		double y = 406;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}
	

}
