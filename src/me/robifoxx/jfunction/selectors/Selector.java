package me.robifoxx.jfunction.selectors;

import me.robifoxx.jfunction.FunctionBase;
import me.robifoxx.jfunction.annotations.Function;
import me.robifoxx.jfunction.selectors.arguments.ISelectorArgument;

import java.util.ArrayList;
import java.util.List;

/**
 * Selector, such as @p and @a.
 * Should not be instentiated, and should
 * be used with SelectorBuilder, or use
 * a static selector.
 */
public class Selector {
    public static final Selector ALL = new Selector("a");
    public static final Selector RANDOM = new Selector("r");
    public static final Selector CLOSEST = new Selector("p");
    public static final Selector ENTITY = new Selector("e");
    public static final Selector EXECUTOR = new Selector("s");

    private String suffix;
    private List<String> arguments;

    private Selector(String suffix) {
        this.suffix = suffix;
        this.arguments = new ArrayList<>();
    }

    private Selector() { }

    public Selector withArgument(ISelectorArgument argument) {
        arguments.add(argument.toString());
        return this;
    }

    @Override
    public String toString() {
        String s = "";
        if(arguments.size() > 0) {
            s = "[" + String.join(",", arguments) + "]";
        }
        return "@" + suffix + s;
    }
}
