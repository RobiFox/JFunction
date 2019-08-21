package me.robifoxx.jfunction.selectors.arguments;

public abstract class INegatableArgument implements ISelectorArgument {
    private boolean negated;
    public INegatableArgument(boolean negated) {
        this.negated = negated;
    }
    public String getExtraCharacter() {
        return negated ? "!" : "";
    }
}
