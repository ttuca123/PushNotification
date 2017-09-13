package com.mobile.zenus.pushnotification.com.mobile.zenus.firebase;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.iid.FirebaseInstanceIdService;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mobile.zenus.pushnotification.MainActivity;
import com.mobile.zenus.pushnotification.R;

/**
 * Created by Tuca on 11/09/2017.
 */

public class MyFireBaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Intent intent = new Intent(this, MainActivity.class);

        intent.putExtra("mensagem", remoteMessage.getNotification().getBody());

        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 , intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

        notificationBuilder.setContentTitle(remoteMessage.getNotification().getTitle());

        notificationBuilder.setContentText(remoteMessage.getNotification().getBody());

        notificationBuilder.setAutoCancel(true);

        notificationBuilder.setSmallIcon(R.mipmap.ic_launcher);

        notificationBuilder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }
}
