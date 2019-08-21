package me.robifoxx.jfunction.test;

import me.robifoxx.jfunction.FunctionBase;
import me.robifoxx.jfunction.annotations.Function;
import me.robifoxx.jfunction.enums.FunctionType;
import me.robifoxx.jfunction.commands.execute.ExecuteCommand;
import me.robifoxx.jfunction.commands.particle.ParticleCommand;
import me.robifoxx.jfunction.commands.particle.ParticleType;
import me.robifoxx.jfunction.location.PositionLocation;
import me.robifoxx.jfunction.location.RelativeLocation;
import me.robifoxx.jfunction.selectors.Selector;

public class FunctionTest extends FunctionBase {
    @Function(name="circle", type = FunctionType.REPEATING)
    public void particle() {
        for(double theta = 0; theta < 2*Math.PI; theta+=2*Math.PI/50) {
            ParticleCommand cmd = new ParticleCommand(ParticleType.FLAME,
                    new RelativeLocation(Math.sin(theta) * 2, 0, Math.cos(theta) * 2),
                    PositionLocation.ZERO, 0, 1);

            addCommand(new ExecuteCommand.Builder()
                    .withAs(Selector.ALL)
                    .withAt(Selector.EXECUTOR)
                    .build(cmd));
        }
    }
}
