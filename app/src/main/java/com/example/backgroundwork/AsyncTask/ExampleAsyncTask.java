package com.example.backgroundwork.AsyncTask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class ExampleAsyncTask extends AsyncTask<Integer, Integer, String> {
    private WeakReference<AsyncTaskThread> activityWeakReference;

    ExampleAsyncTask(AsyncTaskThread activity) {
        activityWeakReference = new WeakReference<AsyncTaskThread>(activity);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        AsyncTaskThread activity = activityWeakReference.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }

        activity.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Integer... integers) {
        for (int i = 0; i < integers[0]; i++) {
            publishProgress((i * 100) / integers[0]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return "Finished!";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        AsyncTaskThread activity = activityWeakReference.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }

        activity.progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        AsyncTaskThread activity = activityWeakReference.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }

        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
        activity.progressBar.setProgress(0);
        activity.progressBar.setVisibility(View.INVISIBLE);
    }
}