package com.example.lab01_intents01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Button startExplicitActivity = findViewById(R.id.btnStartExplicitActivity);
            Button startImplicitActivity = findViewById(R.id.btnStartImplicitActivity);
            Button selectImage= findViewById(R.id.btnSelectIImage);
            Button share= findViewById(R.id.btnShare);
            textView = findViewById(R.id.tvResultOnScreen);
            startExplicitActivity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ExplicitActivity.class);
                    startActivityForResult(intent, 1);
                }
            });
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendEmail =  new Intent(Intent.ACTION_SEND);
                    sendEmail.putExtra(Intent.EXTRA_SUBJECT, "MPiP");
                    sendEmail.putExtra(Intent.EXTRA_TEXT, "send from MainActivity ");
                    sendEmail.setType("text/plain");
                    startActivity(Intent.createChooser(sendEmail, "Chose email app"));
                }
            });
            selectImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent,"Select App"), 2);
                }
            });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                String message  = data.getStringExtra("message");
                textView.setText(message);
            }
            if (resultCode == RESULT_CANCELED){
                textView.setText("Cancel Button Explicit Activity");
            }
        }else if(requestCode == 2){
            if(resultCode == RESULT_OK){
                Intent viewImage = new Intent(Intent.ACTION_VIEW);
                viewImage.setType("image/*");
                if(data == null){

                }else{
                    startActivity(Intent.createChooser(viewImage,"Choose one"));
                }

            }
        }
    }
}