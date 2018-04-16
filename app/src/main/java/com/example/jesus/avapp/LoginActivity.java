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
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public String test;
    private static Button login_btn;
    protected int attemp_counter = 5;
    private LoginConcrete loginConcrete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.test = "prueba de metodo V2";
        setContentView(R.layout.activity_login);
        login_btn = findViewById(R.id.login_button);
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login_btn.setOnClickListener(new LoginActivity.make_login());

        try {
            loginConcrete = new LoginConcrete(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    private class make_login implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            /*if(invoking_vi.Invoke())
            {
                try {
                    login();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/
            try {
                login();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void login() throws IOException {
        System.out.println("Hacer login");
       // String response = ws.test();
        //Toast.makeText(LoginActivity.this,response,Toast.LENGTH_LONG).show();
    }

    public String getTest()
    {
        return this.test;
    }
}
