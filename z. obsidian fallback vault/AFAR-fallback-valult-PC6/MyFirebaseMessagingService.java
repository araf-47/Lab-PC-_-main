package com.idb.testnai.services;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    // Triggered whenever a new token is generated for this device instance
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        // Send this token to your backend database to target this device specifically
        sendTokenToServer(token);
    }

    // Handles payloads received while the app is in the foreground
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        if (remoteMessage.getNotification() != null) {
            String title = remoteMessage.getNotification().getTitle();
            String body = remoteMessage.getNotification().getBody();
            showNotification(title != null ? title : "New Notification", body != null ? body : "");
        }
    }

    private void showNotification(String title, String message) {
        String channelId = "default_channel";
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Create a Notification Channel (Required for Android 8.0+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    channelId, "General Notifications", NotificationManager.IMPORTANCE_HIGH
            );
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setAutoCancel(true);

        if (notificationManager != null) {
            notificationManager.notify(101, builder.build());
        }
    }

    private void sendTokenToServer(String token) {
        // Run network operation on a background thread
        new Thread(() -> {
            try {
                // Note: When running on an Android Emulator (AVD), use 10.0.2.2 to refer to the host machine's localhost.
                // Change URL/port as needed for your local running server (e.g., http://10.0.2.2:8080/api/token).
                URL url = new URL("http://192.168.188.11:8080/api/token");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                conn.setRequestProperty("Accept", "application/json");
                conn.setDoOutput(true);
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);

                String jsonInputString = "{\"token\": \"" + token + "\"}";

                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                int code = conn.getResponseCode();
                if (code >= 200 && code < 300) {
                    Log.d("FCM", "Token successfully sent to local server: " + token);
                } else {
                    Log.e("FCM", "Failed to send token to server, response code: " + code);
                }
                conn.disconnect();
            } catch (Exception e) {
                Log.e("FCM", "Exception sending token to server", e);
            }
        }).start();
    }
}

