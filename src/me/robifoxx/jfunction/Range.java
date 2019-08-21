package me.robifoxx.jfunction;

import com.sun.istack.internal.Nullable;

public class Range {
    private Integer min;
    private Integer max;

    /**
     * Range between two numbers
     * @param min The minimum. Set to null, if you don't want minimum.
     * @param max The maximum. Set to null, if you don't want maximum.
     */
    public Range(@Nullable Integer min, @Nullable Integer max) {
        this.min = min;
        this.max = max;
    }

    public Range(Integer value) {
        this(value, value);
    }

    @Override
    public String toString() {
        String s = "";
        if(min != null) {
            if(min.equals(max)) {
                return String.valueOf(min);
            }
            s += min;
        }
        s += "..";
        if(max != null) {
            s +=  max;
        }
        return s;
    }
}
