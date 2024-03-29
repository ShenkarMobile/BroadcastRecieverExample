package mobile.shenkar.com.broadcastrecieverexample;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;

import mobile.shenkar.com.broadcastrecieverexample.activities.MainActivity;
import mobile.shenkar.com.broadcastrecieverexample.common.AppConst;

public class NotificationBroadCastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// Create the Notification.
		// Fetch the message from the bundle.
		String message = intent.getStringExtra(AppConst.Extra_Message);
		// crate the notification.
		createNotification(context, message);
	}

	/*
	 * Crate notification with a specific message.
	 */
	public void createNotification(Context context, String message) {

        //User support library
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context).setSmallIcon(R.drawable.
                        ic_insert_emoticon_white_18dp)
                        .setAutoCancel(true)
                        .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_weekend_white_48dp))
                        .setContentTitle(context.getString(R.string.new_notification))
                        .setContentText(message);

        Intent resultIntent = new Intent(context, MainActivity.class);


        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        context,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);

        int mNotificationId = 001;
// Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
// Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());
    }
}
