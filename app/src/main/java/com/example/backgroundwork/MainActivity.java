package com.example.backgroundwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobScheduler;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.backgroundwork.AsyncTask.AsyncTaskThread;
import com.example.backgroundwork.ForgroundService.ForgroundServiceActivity;
import com.example.backgroundwork.IntentService.IntentServiceActivity;
import com.example.backgroundwork.JavaThreadWithHandler.JavaThreadWithHandler;
import com.example.backgroundwork.JobScheduler.JobSchedulerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button JavaThreadWithHandlerBtn, asymcTaskBtn, jobScudlerBtn, forgroundServiceBtn, intentServiceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JavaThreadWithHandlerBtn = findViewById(R.id.java_thread_btn);
        asymcTaskBtn = findViewById(R.id.async_task_btn);
        jobScudlerBtn = findViewById(R.id.job_schudler_btn);
        forgroundServiceBtn = findViewById(R.id.forground_service_btn);
        intentServiceBtn = findViewById(R.id.intent_service_btn);


        asymcTaskBtn.setOnClickListener(this);
        JavaThreadWithHandlerBtn.setOnClickListener(this);
        jobScudlerBtn.setOnClickListener(this);
        forgroundServiceBtn.setOnClickListener(this);
        intentServiceBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == JavaThreadWithHandlerBtn.getId()) {
            goToJavaThreadWithHandler();
        } else if (v.getId() == asymcTaskBtn.getId()) {
            goToaAsyncTask();
        } else if (v.getId() == jobScudlerBtn.getId()) {
            goToaJobSchdulerTask();
        } else if (v.getId() == forgroundServiceBtn.getId()) {
            goToaForgroundService();
        } else if (v.getId() == intentServiceBtn.getId()) {
            goToaIntentService();
        }
    }

    private void goToaIntentService() {
        startActivity(new Intent(this, IntentServiceActivity.class));
    }


    private void goToaAsyncTask() {
        startActivity(new Intent(this, AsyncTaskThread.class));

    }

    private void goToaJobSchdulerTask() {
        startActivity(new Intent(this, JobSchedulerActivity.class));

    }

    private void goToJavaThreadWithHandler() {
        startActivity(new Intent(this, JavaThreadWithHandler.class));
    }

    private void goToaForgroundService() {
        startActivity(new Intent(this, ForgroundServiceActivity.class));

    }
}
