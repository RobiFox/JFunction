package me.robifoxx.jfunction.commands;

import me.robifoxx.jfunction.TimeUnit;
import me.robifoxx.jfunction.commands.json.MessageJson;
import me.robifoxx.jfunction.selectors.Selector;

public class ScheduleCommand extends StringCommand {
    public ScheduleCommand(String function, int time, TimeUnit unit) {
        super("schedule function " + function + " " + time + unit.toString());
    }

    public ScheduleCommand(String function, int time) {
        this(function, time, TimeUnit.TICKS);
    }
}
