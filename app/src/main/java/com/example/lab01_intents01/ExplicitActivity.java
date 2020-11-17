package com.example.lab01_intents01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ExplicitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        Intent intent = getIntent();
        EditText editText = findViewById(R.id.editTextMessage);
        Button sendMessage = findViewById(R.id.btnOkay);
        Button cancel = findViewById(R.id.btnCancel);
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("message",message);
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

    }
}