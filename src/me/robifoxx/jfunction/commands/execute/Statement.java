package me.robifoxx.jfunction.commands.execute;

import me.robifoxx.jfunction.Range;
import me.robifoxx.jfunction.commands.scoreboard.Scoreboard;
import me.robifoxx.jfunction.commands.scoreboard.ScoreboardCommand;
import me.robifoxx.jfunction.location.ILocation;
import me.robifoxx.jfunction.selectors.Selector;

public class Statement {
    private boolean negated;
    private String cmd;
    public Statement(boolean negated) {
        this.negated = negated;
    }

    public Statement() {
        this(false);
    }

    public Statement statementBlock(ILocation location, String block) {
        cmd = "block " + location.toString() + " " + block;
        return this;
    }

    public Statement statementBlocks(ILocation fromLocation, ILocation toLocation, ILocation destination, ExecuteCommand.BlocksCheck bc) {
        cmd = "blocks " + fromLocation.toString() + " " + toLocation.toString() + " " + destination.toString() + " " + bc.toString().toLowerCase();
        return this;
    }

    public Statement statementDataEntity(Selector s, String path) {
        cmd = "data entity " + s.toString() + " " + path;
        return this;
    }

    public Statement statementDataBlock(ILocation location, String path) {
        cmd = "data block " + location.toString() + " " + path;
        return this;
    }

    public Statement statementEntity(Selector s) {
        cmd = "entity " + s.toString();
        return this;
    }

    public Statement statementScore(Selector selector, String objective, Scoreboard.Comparator comparator, Selector selectorObjective, String sourceObjective) {
        cmd = "score " + selector.toString() + " " + objective + " " + comparator.toString() + " " + selectorObjective.toString() + " " + sourceObjective;
        return this;
    }

    public Statement statementScore(String name, String objective, Scoreboard.Comparator comparator, String sourceName, String sourceObjective) {
        cmd = "score " + name + " " + objective + " " + comparator.toString() + " " + sourceName + " " + sourceObjective;
        return this;
    }

    public Statement statementScore(Selector selector, String objective, Range range) {
        cmd = "score " + selector.toString() + " " + objective + " matches " + range.toString();
        return this;
    }

    public Statement statementScore(String name, String objective, Range range) {
        cmd = "score " + name + " " + objective + " matches " + range.toString();
        return this;
    }

    public Statement setNegated(boolean negated) {
        this.negated = negated;
        return this;
    }

    @Override
    public String toString() {
        return (negated ? "unless" : "if") + " " + cmd;
    }
}
