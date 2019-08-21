package me.robifoxx.jfunction.enums;

/**
 * Represents the type of a function.
 */
public enum FunctionType {
    /**
     * Function has to be called
     * by another function or command.
     */
    SINGLE,
    /**
     * Function is repeating
     * every tick.
     */
    REPEATING,
    /**
     * Function is ran
     * when the datapack
     * starts.
     */
    START;
}
