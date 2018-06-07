package com.example.jesus.avapp;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

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

    public boolean login() throws JSONException {

        String message = "";

        EditText username = this.params.get("username");
        EditText password = this.params.get("password");

        HashMap<String,String> login_params = new HashMap<String,String>();

        login_params.put("username",username.getText().toString());

        login_params.put("password",password.getText().toString());

        JSONObject response = this.http.Login(login_params);

        if(response.get("status") != null)
        {
            if(response.getInt("status") != 1)
            {
                message = response.getString("message");
                Toast.makeText((Context) this.context,message, Toast.LENGTH_LONG).show();
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            message = "Ocurrio un error en la conexión al servidor";
            Toast.makeText((Context) this.context,message, Toast.LENGTH_LONG).show();
            return false;
        }


    }
}
