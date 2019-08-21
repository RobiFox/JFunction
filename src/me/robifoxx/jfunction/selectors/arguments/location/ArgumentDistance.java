package me.robifoxx.jfunction.selectors.arguments.location;

import me.robifoxx.jfunction.Range;
import me.robifoxx.jfunction.location.PositionLocation;

/**
 * Argument to select entities with
 * the specified distance from it.
 */
public class ArgumentDistance extends ArgumentLocation {
    private Range range;
    public ArgumentDistance(double x, double y, double z, Range range) {
        super(new PositionLocation(x, y, z));
        this.range = range;
    }

    @Override
    public String toString() {
        return super.toString() + ",distance=" + range.toString();
    }
}
