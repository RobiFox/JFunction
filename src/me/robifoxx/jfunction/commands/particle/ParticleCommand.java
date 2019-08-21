package me.robifoxx.jfunction.commands.particle;

import me.robifoxx.jfunction.commands.ICommand;
import me.robifoxx.jfunction.commands.StringCommand;
import me.robifoxx.jfunction.location.ILocation;
import me.robifoxx.jfunction.selectors.Selector;

public class ParticleCommand extends StringCommand {
    public ParticleCommand(String particle, ILocation location, ILocation delta, double speed, int count) {
        super("particle " + particle + " " + location + " " + delta + " " + speed + " " + count);
    }

    public ParticleCommand(String particle, ILocation location, ILocation delta, double speed, int count, boolean force) {
        super("particle " + particle + " " + location + " " + delta + " " + speed + " " + count + " " + (force ? "force" : "normal"));
    }

    public ParticleCommand(String particle, ILocation location, ILocation delta, double speed, int count, boolean force, Selector s) {
        super("particle " + particle + " " + location + " " + delta + " " + speed + " " + count + " " + (force ? "force" : "normal") + " " + s.toString());
    }
}
