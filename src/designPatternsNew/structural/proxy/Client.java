package designPatternsNew.structural.proxy;

/**
 * Created by aditya.dalal on 23/01/17.
 */
public class Client {
    public static void main(String[] args) {
        CommandExecutor executor = new CommandExecutorProxy("aditya", "abcd");
        executor.run("rm -rf *");
        executor.run("ls -l");
    }
}
