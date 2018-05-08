package com.example.jesus.avapp;
import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;

import core.WebServices.http_operations;


public class LoginServices {
    private http_operations http = new http_operations();
    private Object context;
    private HashMap<String, String> params;

    public void SetParams(HashMap<String, String> params)
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
        String response = this.http.Login(this.params);
        Toast.makeText((Context) this.context,response, Toast.LENGTH_LONG).show();
    }
}
