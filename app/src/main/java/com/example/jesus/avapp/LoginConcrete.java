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
import core.WebServices.http_operations;

public class LoginConcrete {
    //private final Class<?> Class;
    private final Object ObjectClass;
    private http_operations ws = new http_operations();
    private HashMap<String,ICommand> commandList = new HashMap<String,ICommand>();
    protected Invoking_command invoking = new Invoking_command();
    private ArrayList<EditText> ruled_editText = new ArrayList<EditText>();


    public LoginConcrete(Object object) throws NoSuchFieldException, IllegalAccessException {
        this.ObjectClass =  object;
        this.methods();

    }
    //Implementaciones concretas

    private void methods() throws NoSuchFieldException, IllegalAccessException {
        login_test_validation();
    }

    private void login_test_validation() throws IllegalAccessException, NoSuchFieldException {
        System.out.println("Got in concrete class");
        Field[] fields = this.ObjectClass.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            if(field.getName().equals("test"))
            {
                Field cfield = this.ObjectClass.getClass().getDeclaredField("test");
                cfield.setAccessible(true);
                Object value = field.get(this.ObjectClass);
                System.out.println("value of the object "+value.toString());
            }
        }


        /*ruled_EditText current_text = new ruled_EditText(username, 15, 7, null);
        this.ruled_editText.add(current_text);

        current_text = new ruled_EditText(password, 8, 8, null);
        this.ruled_editText.add(current_text);

        final verify_input_data verify_input_data = new verify_input_data(ruled_editText);

        ICommand login_test_validation_command =  new current_command("verificar datos de entrada",verify_input_data,"verify");

        this.commandList.put("login_test_validation",login_test_validation_command);*/

    }

    private void var_by_fields(Object Class)
    {

    }

    public Invoking_command current_command(String key)
    {
        ICommand current_command = this.commandList.get(key);
        this.invoking.SetCommand(current_command);
        return this.invoking;
    }
}
