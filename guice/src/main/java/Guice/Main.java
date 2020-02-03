package Guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

// // https://www.spigotmc.org/threads/tutorial-spigot-plugins-dependency-injection.295218/
public class Main {

    public static void main(String[] args) {

        // A module defines the binding
        SimpleCommandModule module = new SimpleCommandModule();
        Injector injector = Guice.createInjector(module);
        CommandService commandService = injector.getInstance(CommandService.class);
        commandService.execute();

    }

}
