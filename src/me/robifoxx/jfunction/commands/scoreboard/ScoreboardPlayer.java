package me.robifoxx.jfunction.commands.scoreboard;

import me.robifoxx.jfunction.commands.ICommand;
import me.robifoxx.jfunction.commands.StringCommand;
import me.robifoxx.jfunction.selectors.Selector;

public class ScoreboardPlayer {
    private String objective;
    private String name;
    ScoreboardPlayer(String objective, String name) {
        this.objective = objective;
        this.name = name;
    }

    public ICommand add(int amount) {
        return new StringCommand("scoreboard players add " + name + " " + objective + " " + amount);
    }

    public ICommand remove(int amount) {
        return new StringCommand("scoreboard players remove " + name + " " + objective + " " + amount);
    }

    public ICommand get() {
        return new StringCommand("scoreboard players get " + name + " " + objective);
    }

    public ICommand operation(Scoreboard.Operator operator, String sourceName, String sourceObjective) {
        return new StringCommand("scoreboard players operation " + name + " " + objective + " " + operator.toString() + " " + sourceName + " " + sourceObjective);
    }

    public ICommand operation(Scoreboard.Operator operator, Selector sourceSelector, String sourceObjective) {
        return operation(operator, sourceSelector.toString(), sourceObjective);
    }

    public ICommand reset() {
        return new StringCommand("scoreboard players reset " + name);
    }

    public ICommand set(int amount) {
        return new StringCommand("scoreboard players set " + name + " " + objective + " " + amount);
    }
}
