package com.samuvel.pandian.learncodeonline;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.samuvel.pandian.learncodeonline.customview.SpinnerImageView;

public class SignUpActivity extends AppCompatActivity {
    Button mSignUpButton;
    LinearLayout mEditTextLayout, mSignInLayout;
    ImageView mGifImageView;
    TextView mSignIn;
    EditText mEmailEditText, mUserName, mPassword;
    SpinnerImageView mSpinnerImageView;
    boolean isEditTextLayoutVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setClickListener();
        setGifImage();
    }

    private void initViews() {
        mSignUpButton = findViewById(R.id.signUpButton);
        mSignInLayout = findViewById(R.id.singInLayout);
        mGifImageView = findViewById(R.id.gifImageView);
        mEditTextLayout = findViewById(R.id.editTextLayout);
        mEmailEditText = findViewById(R.id.emailEditText);
        mUserName = findViewById(R.id.userNameEditText);
        mPassword = findViewById(R.id.passwordEditText);
        mPassword.setTransformationMethod(new PasswordTransformationMethod());
        mSignIn = findViewById(R.id.signInView);
        mSpinnerImageView = findViewById(R.id.logoView);
    }

    private void setClickListener() {
        mSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEditTextLayoutVisible) {
                    hideGifImageView();
                    animateEditTextLayout();
                } else {
                    animateLogo();
                }
            }
        });
        mSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
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
                startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                mSpinnerImageView.stopAnimation();
                finish();
            }
        }, 2000);
    }

    private void animateEditTextLayout() {
        mEditTextLayout.setVisibility(View.VISIBLE);
        mEditTextLayout.setAlpha(0.0f);
        mEditTextLayout.animate()
                .translationY(mEditTextLayout.getHeight())
                .alpha(1.0f)
                .setDuration(700)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        isEditTextLayoutVisible = true;
                    }
                });
    }

    private void setGifImage() {
        Glide.with(this)
                .load(R.raw.lcog)
                .into(mGifImageView);
    }

    private void hideGifImageView() {
        mGifImageView.setVisibility(View.GONE);
    }
}
