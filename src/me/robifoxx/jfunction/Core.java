package me.robifoxx.jfunction;

import me.robifoxx.jfunction.annotations.Function;
import me.robifoxx.jfunction.enums.FunctionType;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Core implements ICore {
    String nameSpace;
    File folder;
    List<String> signature;

    public Core() { }

    public void registerFunction(FunctionBase function) {
        Class<?> clazz = function.getClass();

        for(Method m : clazz.getDeclaredMethods()) {
            if(m.isAnnotationPresent(Function.class)) {
                Function f = m.getAnnotation(Function.class);
                String fileName = f.name().toLowerCase().replace(" ", "_");
                String ns = nameSpace;
                if(!f.namespace().equals("")) ns = f.namespace();
                if(f.type() == FunctionType.REPEATING) {
                    JFunction.tick.add(ns + ":" + fileName);
                } else if(f.type() == FunctionType.START) {
                    JFunction.start.add(ns + ":" + fileName);
                }
                function.toFile = new File(folder + "/" + fileName + ".mcfunction");
                System.out.println("Creating function " + fileName + ". (" + m.getName() + ")");
                System.out.println("(" + function.toFile.getPath() + ")");
                try {
                    if(!folder.exists())
                        function.toFile.getParentFile().mkdirs();
                    function.toFile.createNewFile();
                    function.writer = new BufferedWriter(new FileWriter(function.toFile));
                    for(String s : signature) {
                        function.addCommand(s);
                    }
                    m.setAccessible(true);
                    m.invoke(function);
                } catch(IOException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                } finally {
                    try {
                        if(function.writer != null) {
                            function.writer.close();
                        }
                    } catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
