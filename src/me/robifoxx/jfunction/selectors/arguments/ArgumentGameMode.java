package me.robifoxx.jfunction.selectors.arguments;

import me.robifoxx.jfunction.enums.GameMode;

/**
 * Argument to select entities with
 * the gamemode specified.
 */
public class ArgumentGameMode extends INegatableArgument {
    private GameMode gameMode;
    public ArgumentGameMode(boolean negated, GameMode gameMode) {
        super(negated);
        this.gameMode = gameMode;
    }

    public ArgumentGameMode(GameMode gameMode) {
        this(false, gameMode);
    }

    @Override
    public String toString() {
        return "gamemode=" + getExtraCharacter() + gameMode.toString().toLowerCase();
    }
}
