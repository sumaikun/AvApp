package core.Objects;

import android.widget.EditText;

import com.example.jesus.avapp.LoginServices;

import java.lang.reflect.Field;
import java.util.HashMap;

import core.Invokers.ICommand;
import core.Invokers.Invoking_command;
import core.Invokers.current_command;

public class ConcreteImplementator {

    public Object ObjectClass;
    public HashMap<String,ICommand> commandList = new HashMap<String,ICommand>();
    public Invoking_command invoking = new Invoking_command();


    public ConcreteImplementator(Object object) throws NoSuchFieldException, IllegalAccessException {
        this.ObjectClass =  object;
        this.methods();

    }

    public void methods() throws NoSuchFieldException, IllegalAccessException {

    }

    public Object var_by_fields(String varname) throws IllegalAccessException, NoSuchFieldException  {
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
