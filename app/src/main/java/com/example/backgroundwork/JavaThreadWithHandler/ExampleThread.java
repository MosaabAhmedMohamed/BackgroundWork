package com.example.backgroundwork.JavaThreadWithHandler;

import android.util.Log;

public class ExampleThread extends java.lang.Thread {

    private static final String TAG = "ExampleThread";

    int secound;

    public ExampleThread(int secound) {
        this.secound = secound;
    }

    @Override
    public void run() {
        super.run();

        for (int i = 0; i <secound ; i++) {
            Log.d(TAG, "run: "+i);
            try {
                ExampleThread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
