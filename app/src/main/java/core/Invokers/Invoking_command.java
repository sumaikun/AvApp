package core.Invokers;

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
    public void Invoke() {
        this.currentCommand.Execute();
    }


}
