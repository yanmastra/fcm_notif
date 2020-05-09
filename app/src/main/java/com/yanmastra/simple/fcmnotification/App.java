package com.yanmastra.simple.fcmnotification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

/**
 * @author iwayanmastra on 07/05/20
 * @project FCM Notification
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate: app");
        regNotificationChanel(this);
    }

    public static void regNotificationChanel(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && notificationManager != null) {
            NotificationChannel mChannel = notificationManager.getNotificationChannel(Const.NOTIFICATION_CHANEL_ID);
            if (mChannel == null) {
                String id = Const.NOTIFICATION_CHANEL_ID;
                CharSequence name = Const.NOTIFICATION_CHANEL_NAME;
                String description = Const.NOTIFICATION_CHANEL_DESCRIPTION;
                int importance = NotificationManager.IMPORTANCE_HIGH;
                mChannel = new NotificationChannel(id, name, importance);
                mChannel.setDescription(description);
            }
            mChannel.setShowBadge(true);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{1000, 0, 1000, 0, 1000, 0, 1000, 0, 1000, 0, 1000, 0, 1000});
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            notificationManager.createNotificationChannel(mChannel);
        }
    }
}
