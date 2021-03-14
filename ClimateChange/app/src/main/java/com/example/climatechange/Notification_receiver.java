package com.example.climatechange;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;


public class Notification_receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder;
        PendingIntent pendingIntent;
        String channel_Id = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Your App Name", "You app Package Name", NotificationManager.IMPORTANCE_HIGH);
            channel_Id = channel.getId();
            channel.setDescription("Make entry of today's spending now");
            channel.enableLights(true);
            channel.setAllowBubbles(true);
            channel.setShowBadge(true);
            channel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
        }

        builder = new NotificationCompat.Builder(context,channel_Id)
                .setSmallIcon(R.drawable.quize)
                .setChannelId(channel_Id)
                .setContentTitle("Grow Buds")
                .setContentText("Time To Feed Your Bud")
                .setOnlyAlertOnce(false)
                .setAutoCancel(true);

        Intent repeatingIntent = new Intent(context, MainActivity.class);
        pendingIntent = PendingIntent.getActivity(context, 100, repeatingIntent,    PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        notificationManager.notify(100, builder.build());
    }
}