package com.example.jesus.avapp;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import core.Actions.verify_input_data;
import core.Invokers.ICommand;
import core.Invokers.Invoking_command;
import core.Invokers.current_command;
import core.Objects.ruled_EditText;
import core.WebServices.http_operations;

public class LoginActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static TextView attempts;
    private static Button login_btn;
    private http_operations ws = new http_operations();
    protected int attemp_counter = 5;
    protected ArrayList<ruled_EditText> ruled_editText = new ArrayList<ruled_EditText>();
    protected Invoking_command invoking_vi = new Invoking_command();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_btn = findViewById(R.id.login_button);
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);

        ruled_EditText current_text = new ruled_EditText(username, 15, 7, null);
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
            try {
                login();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void login() throws IOException {
        //System.out.println("Hacer login");
        String response = ws.test();
        Toast.makeText(LoginActivity.this,response,Toast.LENGTH_LONG).show();
    }
}
