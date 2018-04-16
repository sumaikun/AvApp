package core.Invokers;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by Jesus on 11/03/2018.
 */

public class Invoking_command implements  IInvoker {

    private ICommand currentCommand;
    @Override
    public void SetCommand(ICommand command) {
        this.currentCommand = command;
    }

    @Override
    public <T> T  Invoke() {
        try {
           return  this.currentCommand.Execute();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}
