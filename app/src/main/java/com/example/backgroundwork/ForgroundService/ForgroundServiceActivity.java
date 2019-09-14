package com.example.backgroundwork.ForgroundService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.backgroundwork.R;

public class ForgroundServiceActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forground_service);
        editText = findViewById(R.id.edit_text_input);

    }

    public void startService(View view) {
        String input = editText.getText().toString();

        Intent intent = new Intent(this, ExampleService.class);
        intent.putExtra("message", input);
        startService(intent);

    }

    public void stopService(View view) {
        Intent intent = new Intent(this, ExampleService.class);
        stopService(intent);
    }
}
