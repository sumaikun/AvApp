package com.example.jesus.avapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import core.Actions.verify_input_data;

public class LoginActivity extends AppCompatActivity{

    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    private int attemp_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_btn = findViewById(R.id.login_button);
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login_btn.setOnClickListener(new make_login());


    }

    private class make_login implements View.OnClickListener
    {

        @Override
        public void onClick(View view) {
            final verify_input_data verify_input_data = new verify_input_data(username, password);
        }
    }

}
