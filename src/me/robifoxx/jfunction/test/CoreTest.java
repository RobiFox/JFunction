package me.robifoxx.jfunction.test;

import me.robifoxx.jfunction.Core;
import me.robifoxx.jfunction.FunctionBase;
import me.robifoxx.jfunction.annotations.Function;
import me.robifoxx.jfunction.commands.execute.ExecuteCommand;
import me.robifoxx.jfunction.commands.particle.ParticleCommand;
import me.robifoxx.jfunction.commands.particle.ParticleType;
import me.robifoxx.jfunction.location.PositionLocation;
import me.robifoxx.jfunction.location.RelativeLocation;
import me.robifoxx.jfunction.selectors.Selector;

public class CoreTest extends Core {
    @Override
    public void onInit() {
        registerFunction(new FunctionBase() {
            @Function(name="test")
            public void particle() {
                int a = 50;
                for(int i = 0; i < 1; i++) {
                    for(double theta = 0; theta < 2 * Math.PI; theta += 2 * Math.PI / (a * 1.0d)) {
                        ParticleCommand cmd = new ParticleCommand(ParticleType.FLAME,
                                new RelativeLocation(Math.sin(theta) * 3, 0, Math.cos(theta) * 2),
                                PositionLocation.ZERO, 0, 1);
                        addCommand(new ExecuteCommand.Builder()
                                .withAs(Selector.ALL)
                                .withAt(Selector.EXECUTOR)
                                .build(cmd));
                    }
                }
            }
        });
    }
}
