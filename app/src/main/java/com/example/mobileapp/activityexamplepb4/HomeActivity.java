package com.example.mobileapp.activityexamplepb4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private TextView greetingsValue, showEmailValue, showPasswordValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //
        // Call intent
        Intent incomingIntent = getIntent();
        // Get value
        String userEmail = incomingIntent.getStringExtra("email");
        String userPassword = incomingIntent.getStringExtra("password");
        // Get Value
        greetingsValue = findViewById(R.id.greetingsTextView);
        showEmailValue = findViewById(R.id.showEmailTextView);
        showPasswordValue = findViewById(R.id.showPasswordTextView);
        //Set Value
        greetingsValue.setText("Welcome to Intent!");
        showEmailValue.setText(userEmail);
        showPasswordValue.setText(userPassword);

        //Toast.makeText(this, userEmail + ", " + userPassword, Toast.LENGTH_LONG).show();
    }
}
