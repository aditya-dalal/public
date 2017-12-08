package designPatternsNew.structural.proxy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aditya.dalal on 23/01/17.
 */
public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor commandExecutor;
    private static final List<String> restrictedCommands = Arrays.asList("rm", "useradd");

    public CommandExecutorProxy(String user, String pass) {
        if (user.equals("aditya") && pass.equals("aditya"))
            isAdmin = true;
        commandExecutor = new CommandExecutorImpl();
    }

    @Override
    public void run(String command) {
        if (isAdmin || !isRestricted(command))
            commandExecutor.run(command);
        else
            System.out.println("Not allowed to execute command: " + command);
    }

    private boolean isRestricted(String command) {
        for (String str: restrictedCommands)
            if (command.startsWith(str))
                return true;
        return false;
    }
}
