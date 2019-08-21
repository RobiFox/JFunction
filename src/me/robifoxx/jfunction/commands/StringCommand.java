package me.robifoxx.jfunction.commands;

/**
 * Command that you can create
 * from string.
 */
public class StringCommand implements ICommand {
    private String command;
    public StringCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return command;
    }
}
