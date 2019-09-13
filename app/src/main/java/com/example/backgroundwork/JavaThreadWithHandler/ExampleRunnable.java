package com.example.backgroundwork.JavaThreadWithHandler;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class ExampleRunnable implements java.lang.Runnable {
    private static final String TAG = "ExampleRunnable";
    int secound;

    public ExampleRunnable(int secound) {
        this.secound = secound;
    }

    @Override
    public void run() {
        Log.d(TAG, "run: ");
        for (int i = 0; i <secound ; i++) {



                  /*  Handler threadHandler = new Handler(Looper.getMainLooper());
                    threadHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });*/

                    /*
                    buttonStartThread.post(new ExampleRunnable() {
                        @Override
                        public void run() {
                            buttonStartThread.setText("50%");
                        }
                    });
                    */
            /*runOnUiThread(new ExampleRunnable() {
                @Override
                public void run() {
                    buttonStartThread.setText("50%");
                }
            });*/

            Log.d(TAG, "run: "+i);
            try {
                ExampleThread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
