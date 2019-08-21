package me.robifoxx.jfunction.commands;

import me.robifoxx.jfunction.selectors.Selector;

public class XPCommand implements ICommand {
    public enum Action {
        ADD, QUERY, SET
    }
    public enum Type {
        LEVELS, POINTS
    }

    private Selector selector;
    private int amount;
    private Action action;
    private Type type;

    public XPCommand(Selector selector, int amount, Action action) {
        this(selector, amount, action, null);
    }

    public XPCommand(Selector selector, int amount, Action action, Type type) {
        this.selector = selector;
        this.amount = amount;
        this.action = action;
        this.type = type;
    }

    @Override
    public String toString() {
        return "xp " + action.toString().toLowerCase() + " " + selector.toString() + " " + amount + (type != null ? " " + type.toString().toLowerCase() : "");
    }
}
