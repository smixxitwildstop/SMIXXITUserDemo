package com.wildstop.smixxitdemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInScreen extends AppCompatActivity {
    private static final String TAG = "" ;
    String emailaddressString;
    String passwordString;
    String resetpasswordToken;

    //Instances Of Buttons
    private Button signinButton;
    private Button signupButton;
    private Button resetPasswordButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in_screen);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                   Intent intent = new Intent(SignInScreen.this,ProfileList.class);
                    startActivity(intent);

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    Toast.makeText(SignInScreen.this, "User Is Not Signed In", Toast.LENGTH_SHORT).show();
                }
                // ...
            }
        };

        //Initialization Of Buttons
        signinButton=(Button)findViewById(R.id.button_sign_in);
        signupButton=(Button)findViewById(R.id.button_sign_up);
        resetPasswordButton=(Button)findViewById(R.id.reset_password_sign_in);








        //Sign In Button On Click Listener
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(SignInScreen.this,ProfileList.class);
                startActivity(intent);
                //Authenticate The User

            }
        });


        //Sign Up Button On Click Listener
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Take User To Sign Up Screeen Activity
                Intent startSignUpScreenIntent = new Intent(SignInScreen.this,SignUpActivity.class);
                startActivity(startSignUpScreenIntent);
                finish();
            }
        });

        //Reset Password Button On Click Listener
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                return;
                //Allow The User To retrieve password retrieval details.

            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}
