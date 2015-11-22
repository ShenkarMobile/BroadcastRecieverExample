package mobile.shenkar.com.broadcastrecieverexample.bl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import java.util.concurrent.TimeUnit;

import mobile.shenkar.com.broadcastrecieverexample.NotificationBroadCastReceiver;
import mobile.shenkar.com.broadcastrecieverexample.common.AppConst;

public class AlarmHelper {
	public static void setAlarm(Context c,int secondsFromNow,String message ){
		// create the intent, with the receiver that should handle the alarm.
		AlarmManager alarmMgr = (AlarmManager) c.getSystemService(Context.ALARM_SERVICE);
		Intent intent = new Intent(c, NotificationBroadCastReceiver.class);
		intent.setAction(AppConst.ACTION_ALARM);
		intent.putExtra(AppConst.Extra_Message, message);
		PendingIntent alarmIntent = PendingIntent.getBroadcast(c, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

		alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
				SystemClock.elapsedRealtime() +
						TimeUnit.SECONDS.toMillis(secondsFromNow), alarmIntent);
	}

	public void cancelAlarm() {
		//Now you will have to deal with it.

	}

}
