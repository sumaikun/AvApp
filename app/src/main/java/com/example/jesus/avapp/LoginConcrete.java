package com.example.jesus.avapp;


import android.widget.EditText;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import core.Actions.verify_input_data;
import core.Invokers.ICommand;
import core.Invokers.Invoking_command;
import core.Invokers.current_command;
import core.Objects.ruled_EditText;


public class LoginConcrete {

    private final Object ObjectClass;

    private LoginServices services;
    private HashMap<String,ICommand> commandList = new HashMap<String,ICommand>();
    protected Invoking_command invoking = new Invoking_command();
    private ArrayList<ruled_EditText> ruled_editText = new ArrayList<ruled_EditText>();



    public LoginConcrete(Object object) throws NoSuchFieldException, IllegalAccessException {
        this.ObjectClass =  object;
        this.methods();

    }
    //Implementaciones concretas

    private void methods() throws NoSuchFieldException, IllegalAccessException {
        login_validation();
        test_webservice();
        login();
    }

    private void login_validation() throws NoSuchFieldException, IllegalAccessException {

        Object username = this.var_by_fields("username");

        ruled_EditText current_text = new ruled_EditText((EditText) username, 25, 7, null);
        this.ruled_editText.add(current_text);

        Object password = this.var_by_fields("password");

        current_text = new ruled_EditText((EditText) password, 8, 8, null);
        this.ruled_editText.add(current_text);

        final verify_input_data verify_input_data = new verify_input_data(ruled_editText);

        ICommand login_validation_command =  new current_command("verificar datos de entrada",verify_input_data,"verify");

        this.commandList.put("login_validation",login_validation_command);

    }

    private void test_webservice()
    {
        this.services = new LoginServices(this.ObjectClass);
        ICommand test_webservice =  new current_command("test webservice", this.services,"test_webservice");
        this.commandList.put("test_webservice",test_webservice);
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

    private Object var_by_fields(String varname) throws IllegalAccessException, NoSuchFieldException  {
        Field[] fields = this.ObjectClass.getClass().getDeclaredFields();
        for (Field field : fields) {
            //System.out.println(field.getName());
            if(field.getName().equals(varname))
            {
                Field cfield = this.ObjectClass.getClass().getDeclaredField(varname);
                cfield.setAccessible(true);
                Object value = field.get(this.ObjectClass);
                return value;
                //System.out.println("value of the object "+value.toString());
            }
        }
        return null;
    }

    public <T> T current_command(String key)
    {
        Object result;
        //System.out.println(this.commandList.toString());
        ICommand current_command = this.commandList.get(key);
        if(current_command == null)
        {
            result = false;
            System.out.println("Comando nulo "+key);
            return (T) result;
        }

        this.invoking.SetCommand(current_command);
        result = this.invoking.Invoke();
        return (T) result;
    }
}
