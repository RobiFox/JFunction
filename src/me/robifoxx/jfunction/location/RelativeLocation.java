package me.robifoxx.jfunction.location;

/**
 * A relative coordinate to the entity.
 */
public class RelativeLocation implements ILocation {
    public static final RelativeLocation ZERO = new RelativeLocation(0, 0, 0);
    private double x, y, z;
    public RelativeLocation(double x, double y, double z) {
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
        return "~" + getX() + " ~" + getY() + " ~" + getZ();
    }
}
