package core.Invokers;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Jesus on 11/03/2018.
 */

public interface ICommand {
        <T> T  Execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

}
