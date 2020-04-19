package com.example.dell.rolodex;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;

public class AlarmReceiverActivity extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        int notificationsId = intent.getIntExtra("notificationsID",0);
        String message = intent.getStringExtra("todo");
        String soundmode = intent.getStringExtra("SOUNDmode");

        Intent mainIntent = new Intent(context,OverviewActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent contentIntent = PendingIntent.getActivity(context,notificationsId,mainIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager myNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.ic_event_available_black_24dp);
        builder.setContentText("It's the time..!");
        builder.setContentTitle(message);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setContentIntent(contentIntent);
        builder.setPriority(Notification.PRIORITY_MAX);
        builder.setDefaults(Notification.DEFAULT_ALL);

        myNotificationManager.notify(notificationsId, builder.build());
        String soundmodeType = String.valueOf(soundmode);
        String sound = "SOUND"; String vibrate = "VIBRATE"; String mute = "SILENT";

        if (sound.equals(soundmodeType)){
            audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        }
        if (vibrate.equals(soundmodeType)){
            audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        }
        if (mute.equals(soundmodeType)){
            audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);
        }
    }


}




