package Guice;

import com.google.inject.Inject;

public class CommandService {


    private final Command command;

    @Inject
    public CommandService(Command command) {
        this.command = command;
    }


    public void execute() {
        this.command.execute();
    }
}
