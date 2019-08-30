package me.robifoxx.jfunction.commands;

import me.robifoxx.jfunction.TimeUnit;
import me.robifoxx.jfunction.annotations.Function;

public class FunctionCommand extends StringCommand {
    public FunctionCommand(String function) {
        super("function " + function);
    }
}
