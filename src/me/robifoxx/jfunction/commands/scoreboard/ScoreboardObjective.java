package me.robifoxx.jfunction.commands.scoreboard;

import me.robifoxx.jfunction.commands.ICommand;
import me.robifoxx.jfunction.commands.StringCommand;

public class ScoreboardObjective {
    private String objective;
    ScoreboardObjective(String objective) {
        this.objective = objective;
    }

    public ICommand add(String type, String displayName) {
        return new StringCommand("scoreboard objectives add " + objective + " " + type + " " + displayName);
    }

    public ICommand add(String type) {
        return add(type, "");
    }

    public ICommand remove() {
        return new StringCommand("scoreboard objectives remove " + objective);
    }
}
