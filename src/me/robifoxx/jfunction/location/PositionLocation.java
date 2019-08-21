package me.robifoxx.jfunction.location;

/**
 * An exact coordinate.
 */
public class PositionLocation implements ILocation {
    public static final PositionLocation ZERO = new PositionLocation(0, 0, 0);
    private double x, y, z;
    public PositionLocation(double x, double y, double z) {
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
        return getX() + " " + getY() + " " + getZ();
    }
}
