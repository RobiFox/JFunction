package me.robifoxx.jfunction.selectors.arguments;

import me.robifoxx.jfunction.Range;
import me.robifoxx.jfunction.location.PositionLocation;
import me.robifoxx.jfunction.selectors.arguments.INegatableArgument;

/**
 * Argument to select entities of type.
 * Use me.robifoxx.jfunction.entity.EntityType
 */
public class ArgumentType extends INegatableArgument {
    private String entityType;
    public ArgumentType(boolean negated, String entityType) {
        super(negated);
        this.entityType = entityType;
    }

    public ArgumentType(String entityType) {
        this(false, entityType);
    }

    @Override
    public String toString() {
        return "type=" + getExtraCharacter() + entityType;
    }
}
