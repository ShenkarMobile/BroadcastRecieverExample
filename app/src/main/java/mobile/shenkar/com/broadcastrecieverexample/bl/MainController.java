package mobile.shenkar.com.broadcastrecieverexample.bl;

import android.content.Context;

public class MainController {
	private Context context;

	public MainController(Context context) {
		this.context = context;
	}
	
	public void createAlarm(String message,int  secondsFromNow)
	{
		AlarmHelper.setAlarm(context,secondsFromNow,message);
	}
}
