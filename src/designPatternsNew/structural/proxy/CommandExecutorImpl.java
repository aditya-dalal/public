package designPatternsNew.structural.proxy;

/**
 * Created by aditya.dalal on 23/01/17.
 */
public class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void run(String command) {
        System.out.println("Running command: " + command);
    }
}
