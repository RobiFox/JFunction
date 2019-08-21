package me.robifoxx.jfunction;

import me.robifoxx.jfunction.annotations.Function;
import me.robifoxx.jfunction.commands.ICommand;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public abstract class FunctionBase {
    File toFile;
    BufferedWriter writer;
    public void addCommand(ICommand command) {
        addCommand(command.toString());
    }

    void addCommand(String line) {
        if(!toFile.exists()) {
            try {
                toFile.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer.write(line);
            writer.newLine();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
