package me.robifoxx.jfunction.commands;

import me.robifoxx.jfunction.location.ILocation;
import me.robifoxx.jfunction.selectors.Selector;

public class TeleportCommand extends StringCommand {
    public TeleportCommand(Selector selector, Selector toSelector) {
        super("teleport " + selector.toString() + " " + toSelector.toString());
    }

    public TeleportCommand(Selector selector, ILocation location) {
        super("teleport " + selector.toString() + " " + location.toString());
    }

    public TeleportCommand(Selector selector, ILocation location, ILocation facing) {
        super("teleport " + selector.toString() + " " + location.toString() + " facing " + facing);
    }

    public TeleportCommand(Selector selector, ILocation location, String facingEntity) {
        super("teleport " + selector.toString() + " " + location.toString() + " facing entity " + facingEntity);
    }
}
