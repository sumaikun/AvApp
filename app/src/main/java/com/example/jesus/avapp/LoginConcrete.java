package com.example.jesus.avapp;


import android.widget.EditText;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import core.Actions.verify_input_data;
import core.Invokers.ICommand;
import core.Invokers.Invoking_command;
import core.Invokers.current_command;
import core.Objects.ConcreteImplementator;
import core.Objects.ruled_EditText;


public class LoginConcrete extends ConcreteImplementator{



    private LoginServices services;
    private ArrayList<ruled_EditText> ruled_editText = new ArrayList<ruled_EditText>();



    public LoginConcrete(Object object) throws NoSuchFieldException, IllegalAccessException {
        super(object);
    }
    //Implementaciones concretas

    @Override
    public void methods() throws NoSuchFieldException, IllegalAccessException {
        login_validation();
        test_webservice();
        login();
    }

    private void login_validation() throws NoSuchFieldException, IllegalAccessException {

        Object username = this.var_by_fields("username");

        ruled_EditText current_text = new ruled_EditText((EditText) username, 25, 7, "email");
        this.ruled_editText.add(current_text);

        Object password = this.var_by_fields("password");

        current_text = new ruled_EditText((EditText) password, 16, 8, null);
        this.ruled_editText.add(current_text);

        final verify_input_data verify_input_data = new verify_input_data(ruled_editText);

        ICommand login_validation_command =  new current_command("verificar datos de entrada",verify_input_data,"verify");

        this.commandList.put("login_validation",login_validation_command);

    }

    private void login() throws NoSuchFieldException, IllegalAccessException {

        EditText username = (EditText) this.var_by_fields("username");
        EditText password = (EditText) this.var_by_fields("password");
        HashMap<String, EditText> params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
        this.services = new LoginServices(this.ObjectClass);
        this.services.SetParams(params);


        ICommand login_system =  new current_command("make login", this.services,"login");
        this.commandList.put("login_system",login_system);
    }

    private void test_webservice()
    {
        this.services = new LoginServices(this.ObjectClass);
        ICommand test_webservice =  new current_command("test webservice", this.services,"test_webservice");
        this.commandList.put("test_webservice",test_webservice);
    }


}
