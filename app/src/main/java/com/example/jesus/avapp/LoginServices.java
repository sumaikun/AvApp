package com.example.jesus.avapp;
import android.content.Context;
import android.widget.Toast;

import core.WebServices.http_operations;


public class LoginServices {
    private http_operations http = new http_operations();
    private Object context;

    public LoginServices(Object context)
    {
        this.context = context;
    }

    public void test_webservice()
    {
        String response = this.http.test();
        Toast.makeText((Context) this.context,response, Toast.LENGTH_LONG).show();

    }
}
