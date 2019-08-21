package me.robifoxx.jfunction;

public interface ICore {
    /**
     * Runs, when code is compiled to .mcfunction.
     * Register functions here.
     */
    void onInit();

    /**
     * Register a function, that will be compiled.
     * @param function The function that will be registered
     */
    void registerFunction(FunctionBase function);
}
