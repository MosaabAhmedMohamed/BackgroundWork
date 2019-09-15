package com.example.backgroundwork.IntentService;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.backgroundwork.R;

import static com.example.backgroundwork.ForgroundService.App.CHANNEL_ID;

public class ExampleIntentService extends IntentService {
    private static final String TAG = "ExampleIntentService";

    private PowerManager.WakeLock wakeLock;

    public ExampleIntentService() {
        super("ExampleIntentService");
        setIntentRedelivery(true);

    }

    @Override
    public void onCreate() {
        super.onCreate();

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"Example:WakeLock");
        wakeLock.acquire();
        Log.d(TAG, "Wakelock acquired");
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Notification notification = new Notification.Builder(this,CHANNEL_ID)
                    .setContentTitle("Example Intent Service")
                    .setContentText("Running...")
                    .setSmallIcon(R.drawable.ic_android_black_24dp)
                    .build();
            startForeground(2,notification);
        }
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String message = intent.getStringExtra("message");

        for (int i = 0; i < 10; i++) {
            Log.d(TAG, "onHandleIntent: " + message + " - " + i);
            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG, "onDestroy: ");
        wakeLock.release();
        Log.d(TAG, "onDestroy: wakelocak released");
    }
}
