package me.robifoxx.jfunction;

public enum TimeUnit {
    TICKS("t"),
    SECONDS("s"),
    DAYS("d");

    private String s;
    TimeUnit(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
