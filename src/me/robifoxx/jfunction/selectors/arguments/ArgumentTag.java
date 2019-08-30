package me.robifoxx.jfunction.selectors.arguments;

/**
 * Argument to select entities of type.
 * Use me.robifoxx.jfunction.entity.EntityType
 */
public class ArgumentTag extends INegatableArgument {
    private String tag;
    public ArgumentTag(boolean negated, String tag) {
        super(negated);
        this.tag = tag;
    }

    public ArgumentTag(String tag) {
        this(false, tag);
    }

    @Override
    public String toString() {
        return "tag=" + getExtraCharacter() + tag;
    }
}
