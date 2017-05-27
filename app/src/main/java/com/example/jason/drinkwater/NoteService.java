package com.example.jason.drinkwater;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Jason on 5/26/2017.
 */

public class NoteService extends BroadcastReceiver
{

    int MID = 0;
    @Override
    public void onReceive(Context p_context, Intent p_intent)
    {
        NotificationManager notificationManager = (NotificationManager) p_context.getSystemService(Context.NOTIFICATION_SERVICE);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(p_context);

                mNotifyBuilder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Drink Water Title")
                .setContentText("Drink Water!!")
                .setSound(alarmSound)
                //.setAutoCancel(true).setWhen(when)
                //.setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});

        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;
    }
}
