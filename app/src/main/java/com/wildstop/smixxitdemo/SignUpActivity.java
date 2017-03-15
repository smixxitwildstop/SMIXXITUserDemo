package com.wildstop.smixxitdemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "";
    String emailaddressSignup;
    String passwordSignup;
    String dateofBirthSignUp;
    String countrySignUp;
    String genderSignup;
    private FirebaseAuth mAuth;

    //Buttons
    Button completeSignUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        //Initialization Of Button
        completeSignUpButton=(Button)findViewById(R.id.completeSignUpButton);
        final EditText editTextEmail =(EditText)findViewById(R.id.editext_emailaddress_sign_up);
        final EditText editTextPassword =(EditText)findViewById(R.id.editext_password_sign_up);
        final EditText editTextBirthdate =(EditText)findViewById(R.id.editext_dateofbirth_sign_up);
        final EditText editTextCountry =(EditText)findViewById(R.id.editext_countryofbirth_sign_up);
        final EditText editTextGender =(EditText)findViewById(R.id.editext_gender_sign_up);

       
        


        //On Click Listener For Complete Sign Up Button
        completeSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String emailaddress=editTextEmail.getText().toString().toLowerCase().trim();
                 String password=editTextPassword.getText().toString().trim();
                 String birthdate=editTextBirthdate.getText().toString().toLowerCase().trim();
                 String country=editTextCountry.getText().toString().trim();
                 String gender=editTextGender.getText().toString().toLowerCase().trim();
              if (emailaddress.length()==0||password.length()==0||birthdate.length()==0||country.length()==0||gender.length()==0){
                  Toast.makeText(SignUpActivity.this, "Please Fill In All Fields", Toast.LENGTH_SHORT).show();
              }
                else if (emailaddress.length()>1&&password.length()>1&&birthdate.length()>1){
                  mAuth.createUserWithEmailAndPassword(emailaddress, password)
                          .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

                                  // If sign in fails, display a message to the user. If sign in succeeds
                                  // the auth state listener will be notified and logic to handle the
                                  // signed in user can be handled in the listener.
                                  if (!task.isSuccessful()) {
                                      Log.w(TAG, "signInWithEmail", task.getException());
                                      Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                              Toast.LENGTH_SHORT).show();
                                  }
                                  else if (task.isSuccessful()) {
                                      Toast.makeText(SignUpActivity.this, "User Created Succesfully",
                                              Toast.LENGTH_SHORT).show();
                                      Intent intent= new Intent(SignUpActivity.this,ProfileList.class);
                                      startActivity(intent);
                                  }

                                  // ...
                              }
                          });
              }
            }
        });
    }




}
