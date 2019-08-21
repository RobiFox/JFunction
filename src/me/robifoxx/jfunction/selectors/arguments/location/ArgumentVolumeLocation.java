package me.robifoxx.jfunction.selectors.arguments.location;

import me.robifoxx.jfunction.location.PositionLocation;
import me.robifoxx.jfunction.selectors.arguments.ISelectorArgument;

/**
 * Argument that selects entities between
 * the two positions.
 */
public class ArgumentVolumeLocation extends ArgumentLocation {
    private PositionLocation toLocation;
    public ArgumentVolumeLocation(PositionLocation fromLocation, PositionLocation toLocation) {
        super(fromLocation);
        this.toLocation = toLocation;
    }

    @Override
    public String toString() {
        double x = toLocation.getX();
        double y = toLocation.getY();
        double z = toLocation.getZ();
        return super.toString() + ",dx=" + x + ",dy=" + y + ",dz=" + z;
    }
}
