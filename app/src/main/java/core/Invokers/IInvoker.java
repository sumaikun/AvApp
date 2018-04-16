package core.Invokers;

/**
 * Created by Jesus on 11/03/2018.
 */

public interface IInvoker {
        void SetCommand(ICommand command);
        <T> T  Invoke();
}
