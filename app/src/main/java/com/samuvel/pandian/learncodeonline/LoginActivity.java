package com.samuvel.pandian.learncodeonline;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.samuvel.pandian.learncodeonline.customview.SpinnerImageView;

public class LoginActivity extends AppCompatActivity {
    Button mLoginButton;
    EditText mUserName, mPassword;
    TextView mSignUpView;
    SpinnerImageView mSpinnerImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        setClickListener();
    }
    private void initViews(){
        mLoginButton = findViewById(R.id.loginButton);
        mUserName = findViewById(R.id.userNameEditText);
        mPassword = findViewById(R.id.passwordEditText);
        mSpinnerImageView = findViewById(R.id.spinnerImage);
        mSignUpView = findViewById(R.id.signupView);
    }
    private void setClickListener(){
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateLogo();
            }
        });
        mSignUpView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
                finish();
            }
        });
    }
    private void animateLogo(){
        mSpinnerImageView.startAnimation();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                mSpinnerImageView.stopAnimation();
                finish();
            }
        }, 2000);
    }
}
