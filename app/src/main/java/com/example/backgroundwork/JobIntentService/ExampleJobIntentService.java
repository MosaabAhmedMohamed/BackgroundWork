package com.example.backgroundwork.JobIntentService;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import com.example.backgroundwork.IntentService.ExampleIntentService;

public class ExampleJobIntentService extends JobIntentService {
    private static final String TAG = "ExampleJobIntentService";

    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, ExampleJobIntentService.class, 123, work);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(TAG, "onHandleWork: ");

        String message = intent.getStringExtra("message");

        for (int i = 0; i < 10; i++) {
            Log.d(TAG, "onHandleWork: " + message + " - " + i);

            if (isStopped()) return;

            SystemClock.sleep(1000);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}
