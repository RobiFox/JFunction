package me.robifoxx.jfunction.selectors.arguments.location;

import me.robifoxx.jfunction.location.PositionLocation;
import me.robifoxx.jfunction.selectors.arguments.ISelectorArgument;

/**
 * Argument that selects the player
 * at that position. Works best with
 * distance.
 */
public class ArgumentLocation implements ISelectorArgument {
    private PositionLocation location;
    public ArgumentLocation(PositionLocation location) {
        this.location = location;
    }

    public PositionLocation getLocation() {
        return location;
    }

    @Override
    public String toString() {
        double x = location.getX();
        double y = location.getY();
        double z = location.getZ();
        return "x=" + x + ",y=" + y + ",z=" + z;
    }
}
