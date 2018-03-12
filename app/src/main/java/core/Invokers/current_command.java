package core.Invokers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import core.Actions.verify_input_data;

/**
 * Created by Jesus on 11/03/2018.
 */

public class current_command implements ICommand {
    private String description;
    private Object object;
    private String smethod;

    public current_command(String description , Object ob, String smethod)
    {
        this.description = description;
        this.object = ob;
        this.smethod = smethod;
    }

    @Override
    public void Execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = object.getClass().getMethod(this.smethod, null);
        method.invoke(object, null);
    }
}
