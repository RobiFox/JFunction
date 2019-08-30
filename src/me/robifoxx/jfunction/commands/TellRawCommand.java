package me.robifoxx.jfunction.commands;

import me.robifoxx.jfunction.commands.json.MessageJson;
import me.robifoxx.jfunction.selectors.Selector;

public class TellRawCommand extends StringCommand {
    public TellRawCommand(Selector selector, String text) {
        super("tellraw " + selector.toString() + " \"" + text + "\"");
    }

    public TellRawCommand(Selector selector, MessageJson text) {
        super("tellraw " + selector.toString() + " " + text.toString());
    }
}
