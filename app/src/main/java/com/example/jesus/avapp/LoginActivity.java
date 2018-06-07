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

    public  EditText username;
    public  EditText password;
    public  TextView attempts;
    private static Button login_btn;
    protected int attemp_counter = 5;
    private LoginConcrete loginConcrete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_btn = findViewById(R.id.login_button);
        username = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login_btn.setOnClickListener(new LoginActivity.make_login());

        try {
            this.concrete_initializer();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    private void concrete_initializer() throws NoSuchFieldException, IllegalAccessException {
        //System.out.println("Vamos a iniciar clase concreta");
        this.loginConcrete = new LoginConcrete(this);
        //System.out.println("Clase concreta iniciada");
    }

    private class make_login implements View.OnClickListener {

        @Override
        public void onClick(View view) {
                try {
                    login();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    protected void login() throws IOException {
        if(this.loginConcrete.current_command("login_validation")) {
            //System.out.println("Hacer login");
            if(this.loginConcrete.current_command("login_system"))
            {

            }
        }
       // String response = ws.test();
        //Toast.makeText(LoginActivity.this,response,Toast.LENGTH_LONG).show();
    }


}
