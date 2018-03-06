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

    private EditText emailET, passET;
    private TextView showEmailTV, showPassTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailET = findViewById(R.id.emailValue);
        passET = findViewById(R.id.passValue);
        showEmailTV = findViewById(R.id.showEmail);
        showPassTV = findViewById(R.id.showPass);
    }


    public void loginUser(View view) {
        String inputEmail = emailET.getText().toString();
        String inputPass = passET.getText().toString();
        if(inputEmail.isEmpty()){
            emailET.setError(getString(R.string.email_error));
        }else if(inputPass.isEmpty()){
            passET.setError(getString(R.string.pass_error));
        }else{
            /*showEmailTV.setText(inputEmail);
            showPassTV.setText(inputPass);*/
            authenticateUser(inputEmail,inputPass);
        }
    }

    private void authenticateUser(String inputEmail, String inputPass) {
        if(inputEmail.equals(Constants.User.EMAIL_ADDRESS) &&
                inputPass.equals(Constants.User.PASSWORD)){

            //declare Explicit intent
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            intent.putExtra("email",inputEmail);
            intent.putExtra("pass",inputPass);
            startActivity(intent);
        }else{
            Toast.makeText(this, getString(R.string.authentication_error), Toast.LENGTH_SHORT).show();
        }
    }
}
