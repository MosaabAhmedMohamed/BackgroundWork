package com.example.backgroundwork.AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.backgroundwork.R;

public class AsyncTaskThread extends AppCompatActivity {

    protected ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        progressBar = findViewById(R.id.progress_bar);
    }

    public void startAsyncTask(View v) {
        ExampleAsyncTask task = new ExampleAsyncTask(this);
        task.execute(10);
    }
}
