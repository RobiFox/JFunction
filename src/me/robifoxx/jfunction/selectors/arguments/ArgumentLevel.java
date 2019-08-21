package me.robifoxx.jfunction.selectors.arguments;

import me.robifoxx.jfunction.Range;

/**
 * Argument to select entities with level range.
 */
public class ArgumentLevel implements ISelectorArgument {
    private Range range;
    public ArgumentLevel(Range range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "level=" + range.toString();
    }
}
