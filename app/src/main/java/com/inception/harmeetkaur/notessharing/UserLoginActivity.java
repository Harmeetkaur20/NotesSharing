package com.inception.harmeetkaur.notessharing;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


    }

    public void log_in(View view) {
        EditText editText = findViewById(R.id.email);
        EditText editText1 = findViewById(R.id.password);
        String email = editText.getText().toString();
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

        }
        else{
            Toast.makeText(UserLoginActivity.this , "invalid email syntax",Toast.LENGTH_SHORT).show();
            return;
        }
        String password = editText1.getText().toString();
        if (password.length()>=8 && password.length()<33)
        {

        }
        else{
            Toast.makeText(UserLoginActivity.this,"password must be between 8 to 32 characters",Toast.LENGTH_SHORT).show();
            return;
        }
        final ProgressDialog progress_bar = new ProgressDialog(UserLoginActivity.this);
        progress_bar.setTitle("please wait");
        progress_bar.setMessage("Logging in....");
        progress_bar.show();
        FirebaseAuth f_auth = FirebaseAuth.getInstance();

        OnCompleteListener<AuthResult> listener = new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progress_bar.hide();
                if (task.isSuccessful())

                {
                    Toast.makeText(UserLoginActivity.this, "done", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UserLoginActivity.this , UserHomeActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(UserLoginActivity.this, "error try again", Toast.LENGTH_SHORT).show();
                }
            }
        };


        f_auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(listener);


    }


    public void sign_up(View view) {
        Intent i = new Intent(UserLoginActivity.this ,sign_up3.class);
        startActivity(i);
    }
}