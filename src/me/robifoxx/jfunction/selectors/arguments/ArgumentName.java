package me.robifoxx.jfunction.selectors.arguments;

import me.robifoxx.jfunction.selectors.arguments.INegatableArgument;

/**
 * Argument to select entities with name.
 */
public class ArgumentName extends INegatableArgument {
    private String name;
    public ArgumentName(boolean negated, String name) {
        super(negated);
        this.name = name;
    }

    public ArgumentName(String name) {
        this(false, name);
    }

    @Override
    public String toString() {
        return "name=" + getExtraCharacter() + name;
    }
}
