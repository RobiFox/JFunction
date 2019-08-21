package me.robifoxx.jfunction.commands.scoreboard;

import me.robifoxx.jfunction.selectors.Selector;

public class ScoreboardCommand {
    public ScoreboardObjective fromObjective(String objective) {
        return new ScoreboardObjective(objective);
    }

    public ScoreboardPlayer fromPlayer(String objective, String name) {
        return new ScoreboardPlayer(objective, name);
    }

    public ScoreboardPlayer fromPlayer(String objective, Selector s) {
        return new ScoreboardPlayer(objective, s.toString());
    }
}
