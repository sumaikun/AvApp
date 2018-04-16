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
    private String method;

    public current_command(String description , Object ob, String smethod)
    {
        this.description = description;
        this.object = ob;
        this.method = smethod;
    }

    @Override
    public <T> T  Execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = object.getClass().getMethod(this.method, null);
        System.out.println("Tipo de retorno "+method.getReturnType());
        Object process = method.invoke(object, null);
        return (T) process;
    }


}
