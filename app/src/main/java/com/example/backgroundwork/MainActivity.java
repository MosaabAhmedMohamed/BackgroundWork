package com.example.backgroundwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobScheduler;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.backgroundwork.AsyncTask.AsyncTaskThread;
import com.example.backgroundwork.JavaThreadWithHandler.JavaThreadWithHandler;
import com.example.backgroundwork.JobScheduler.JobSchedulerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button JavaThreadWithHandlerBtn, asymcTaskBtn, jobScudlerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JavaThreadWithHandlerBtn = findViewById(R.id.java_thread_btn);
        asymcTaskBtn = findViewById(R.id.async_task_btn);
        jobScudlerBtn = findViewById(R.id.job_schudler_btn);


        asymcTaskBtn.setOnClickListener(this);
        JavaThreadWithHandlerBtn.setOnClickListener(this);
        jobScudlerBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == JavaThreadWithHandlerBtn.getId()) {
            goToJavaThreadWithHandler();
        } else if (v.getId() == asymcTaskBtn.getId()) {
            goToaAsyncTask();
        } else if (v.getId() == jobScudlerBtn.getId()) {
            goToaJobSchdulerTask();
        }
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
}