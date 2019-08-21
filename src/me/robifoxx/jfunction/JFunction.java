package me.robifoxx.jfunction;

import com.google.gson.*;
import sun.misc.IOUtils;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Main class.
 */
public class JFunction {
    public static void main(String[] args) {
        try {
            InputStream is = JFunction.class.getResourceAsStream("/function.json");
            if(is == null) {
                throw new NullPointerException("function.json file is not found.");
            }
            Scanner s = new Scanner(is).useDelimiter("\\A");
            String result = s.hasNext() ? s.next() : "";

            System.out.println("Looking for main class...");
            JsonObject json = new JsonParser().parse(result).getAsJsonObject();

            String mainClass = json.get("main").getAsString();
            if(mainClass == null) {
                throw new NullPointerException("Main class in function.json does not exist.");
            }
            Class<?> clazz = Class.forName(mainClass);

            if(clazz == null) {
                throw new NullPointerException("Main class is not found.");
            }

            String id = json.get("id").getAsString();
            if(id == null) {
                throw new NullPointerException("ID in function.json does not exist.");
            }

            String description = json.get("description").getAsString();
            if(description == null) {
                throw new NullPointerException("Description in function.json does not exist.");
            }

            String author = json.get("author").getAsString();
            if(author == null) {
                System.out.println("Author not found...");
                author = "null";
            }

            JsonArray signature = json.get("signature").getAsJsonArray();
            List<String> sign = new ArrayList<>();
            if(signature == null) {
                System.out.println("Signature not found...");
            } else {
                for(int i = 0; i < signature.size(); i++) {
                    String sg = signature.get(i).getAsString();
                    if(!sg.startsWith("#")) {
                        sg = "#" + sg;
                    }
                    sign.add(sg.replace("%author", author));
                }
            }

            String path = JFunction.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            File folder = new File(new File(path).getParentFile().getPath() + "/datapacks/" + id + "/data/" + id + "/functions");

            Core instance = (Core) clazz.newInstance();
            instance.folder = folder;
            instance.signature = sign;
            System.out.println(result);
            System.out.println("Converting functions.");
            instance.onInit();
        } catch(Exception e) {
            System.out.println("Exception occured, terminating:");
            e.printStackTrace();
        } finally {
            System.out.println("Done.");
            System.exit(0);
        }
    }
}
