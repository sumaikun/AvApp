package com.example.jesus.avapp;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import core.WebServices.http_operations;


public class LoginServices {
    private http_operations http = new http_operations();
    private Object context;
    private HashMap<String, EditText> params;

    public void SetParams(HashMap<String, EditText> params)
    {
        this.params = params;
    }

    public LoginServices(Object context)
    {
        this.context = context;
    }

    public void test_webservice()
    {
        String response = this.http.test();
        Toast.makeText((Context) this.context,response, Toast.LENGTH_LONG).show();
    }

    public void login()
    {
        EditText username = this.params.get("username");
        EditText password = this.params.get("password");

        HashMap<String,String> login_params = new HashMap<String,String>();

        login_params.put("username",username.getText().toString());

        login_params.put("password",password.getText().toString());

        System.out.println("parametros desde concret");
        System.out.println(login_params.toString());

        String response = this.http.Login(login_params);
        Toast.makeText((Context) this.context,response, Toast.LENGTH_LONG).show();
    }
}
