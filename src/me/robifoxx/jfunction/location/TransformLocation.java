package me.robifoxx.jfunction.location;

import me.robifoxx.jfunction.selectors.Selector;

/**
 * A relative coordinate to the entity's eye location.
 */
public class TransformLocation implements ILocation {
    public static final TransformLocation ZERO = new TransformLocation(0, 0, 0);
    private double x, y, z;
    public TransformLocation(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    @Override
    public String toString() {
        return "^" + getX() + " ^" + getY() + " ^" + getZ();
    }
}
