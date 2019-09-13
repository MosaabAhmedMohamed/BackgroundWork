package com.example.backgroundwork.JavaThreadWithHandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.backgroundwork.R;

public class JavaThreadWithHandler extends AppCompatActivity {
    private static final String TAG = "JavaThreadWithHandler";
    
    private Button buttonStartThread;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_thread_with_handler);

        buttonStartThread = findViewById(R.id.button_start_thread);
    }


    public void startThread(View view) {
        Log.d(TAG, "startThread: ");
       ExampleRunnable exampleRunnable = new ExampleRunnable(10);
        new Thread(exampleRunnable).start();


      /*  ExampleThread exampleThread = new ExampleThread(10);
        exampleThread.start();*/
        /*
        new ExampleThread(new ExampleRunnable() {
            @Override
            public void run() {
                //work
            }
        }).start();
        */
    }

   /* public void stopThread(View view) {
        stopThread = true;
    }*/

}
