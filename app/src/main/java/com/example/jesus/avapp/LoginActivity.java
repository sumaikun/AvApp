package com.example.jesus.avapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import core.Actions.verify_input_data;
import core.Invokers.ICommand;
import core.Invokers.Invoking_command;
import core.Invokers.current_command;
import core.Objects.ruled_EditText;

public class LoginActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    protected int attemp_counter = 5;
    protected ArrayList<ruled_EditText> ruled_editText;
    protected Invoking_command invoking_vi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_btn = findViewById(R.id.login_button);
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);

        ruled_EditText current_text = new ruled_EditText(username, 15, 7, "/^([^0-9]*)$/");
        this.ruled_editText.add(current_text);

        current_text = new ruled_EditText(password, 8, 8, null);
        this.ruled_editText.add(current_text);

        login_btn.setOnClickListener(new make_login());

        final verify_input_data verify_input_data = new verify_input_data(ruled_editText);

        final ICommand current_command =  new current_command("verificar datos de entrada",verify_input_data,"verify");

        invoking_vi.SetCommand(current_command);
    }

    private class make_login implements View.OnClickListener {

        @Override
        public void onClick(View view) {
                invoking_vi.Invoke();

        }
    }
}
