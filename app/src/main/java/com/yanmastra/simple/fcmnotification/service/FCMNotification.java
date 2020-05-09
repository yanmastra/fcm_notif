package com.yanmastra.simple.fcmnotification.service;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * @author iwayanmastra on 07/05/20
 * @project FCM Notification
 */
public class FCMNotification extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String s) {
        Log.e("TAG", "onNewToken: "+s);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        editor.putString("fcm_token", s);
        editor.apply();;

        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
    }
}
