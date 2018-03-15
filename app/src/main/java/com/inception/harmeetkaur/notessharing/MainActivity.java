package com.inception.harmeetkaur.notessharing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void log_in (View view) {
        EditText editText = findViewById(R.id.email);
        EditText editText1 = findViewById(R.id.pass);
        String email = editText.getText().toString();
        String password = editText1.getText().toString();
        Intent i = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(i);
    }


    }


