package server;

public class RunAppiumServer implements Runnable {

	private AppiumServer appiumServer = new AppiumServer();
	
	private boolean stopFlg = false;

	public void run() {
		
		try {
			//appiumServer.startServerWithFlags();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		while(!stopFlg)
		{
			
		}
	}
	

	public void stopMe() {
		stopFlg = true;
	}

}
