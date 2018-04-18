package com.inception.harmeetkaur.notessharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ContinueOptions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continue_options);
    }

    public void user_login(View view) {

        startActivity(new Intent(ContinueOptions.this , UserLoginActivity.class));

    }

    public void admin_login(View view) {

        startActivity(new Intent(ContinueOptions.this , AdminLogin.class));


    }
}
