package Guice;

public class SimpleCommand extends Command {


    @Override
    public boolean execute() {
        System.out.println("Simple command registered and working!");
        return true;
    }

}
