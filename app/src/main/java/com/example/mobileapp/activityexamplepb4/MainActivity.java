package com.example.mobileapp.activityexamplepb4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText emailValue, passValue;
    private TextView showEmailTextView, showPasswordTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Declare variable
        emailValue = findViewById(R.id.emailValue);
        passValue = findViewById(R.id.passValue);
        showEmailTextView = findViewById(R.id.showEmailTextView);
        showPasswordTextView = findViewById(R.id.showPasswordTextView);
    }

    // When click button : action is here
    public void loginUserClick(View view) {
        String inputEmailValue = emailValue.getText().toString();
        String inputPassValue = passValue.getText().toString();
        if (inputEmailValue.isEmpty()) {
            emailValue.setError(getString(R.string.email_error));
        } else if (inputPassValue.isEmpty()) {
            passValue.setError(getString(R.string.pass_error));
        } else {
            /*showEmailTV.setText(inputEmail);
            showPassTV.setText(inputPass);*/
            authenticationCheck(inputEmailValue, inputPassValue);
        }
    }

    private void authenticationCheck(String inputEmailValue, String inputPassValue) {
        if (inputEmailValue.equals(Constants.User.EMAIL_ADDRESS) && inputPassValue.equals(Constants.User.PASSWORD)) {

            //Declare Explicit intent
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            // Pass value in Intent
            intent.putExtra("email", inputEmailValue);
            intent.putExtra("pass", inputPassValue);
            startActivity(intent);
        } else {
            Toast.makeText(this, getString(R.string.authentication_error), Toast.LENGTH_SHORT).show();
        }
    }
}