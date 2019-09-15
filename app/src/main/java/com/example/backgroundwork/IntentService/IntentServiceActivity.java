package com.example.backgroundwork.IntentService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.backgroundwork.R;

public class IntentServiceActivity extends AppCompatActivity {
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
        editText = findViewById(R.id.edit_text_input);
    }

    public void startService(View view) {
        String input = editText.getText().toString();

        Intent intent = new Intent(this,ExampleIntentService.class);
        intent.putExtra("message",input);
        ContextCompat.startForegroundService(this,intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this,ExampleIntentService.class);
       stopService(intent);
    }
}
