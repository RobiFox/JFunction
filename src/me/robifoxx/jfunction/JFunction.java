package me.robifoxx.jfunction;

import com.google.gson.*;
import sun.misc.IOUtils;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Main class.
 */
public class JFunction {
    // maybe clean up this code sometime
    static List<String> tick = new ArrayList<>();
    static List<String> start = new ArrayList<>();
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
            instance.nameSpace = id;
            System.out.println(result);
            System.out.println("Converting functions.");
            instance.onInit();

            System.out.println("Generating Tick Tag...");
            File minecraft = new File(new File(path).getParentFile().getPath() + "/datapacks/" + id + "/data/minecraft/tags/functions");
            if(!minecraft.exists()) minecraft.mkdirs();
            minecraft.createNewFile();
            if(tick.size() > 0) {
                File file = new File(minecraft.getPath() + "/tick.json");
                file.createNewFile();
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(createList(tick).toString());
                } catch(IOException ex) {
                    System.out.println("Failed to create tick tag.");
                    ex.printStackTrace();
                }
            }
            System.out.println("Generating Load Tag...");
            if(start.size() > 0) {
                File file = new File(minecraft.getPath() + "/load.json");
                file.createNewFile();
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(createList(start).toString());
                } catch(IOException ex) {
                    System.out.println("Failed to create load tag.");
                    ex.printStackTrace();
                }
            }

            System.out.println("Creating pack.mcmeta..");
            {
                File file = new File(new File(path).getParentFile().getPath() + "/datapacks/" + id + "/pack.mcmeta");
                if(!file.exists()) file.createNewFile();
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                    bw.write(new JsonParser().parse("{ \"pack\": {\"pack_format\": 1,\"description\": \"" + description + "\"}}").toString()); // TODO rewrite to normal json builder thingy
                } catch(IOException ex) {
                    System.out.println("Failed to create pack.mcmeta...");
                    ex.printStackTrace();
                }
            }
        } catch(Exception e) {
            System.out.println("Exception occured, terminating:");
            e.printStackTrace();
        } finally {
            System.out.println("Done.");
            System.exit(0);
        }
    }

    private static JsonObject createList(List<String> list) {
        JsonObject obj = new JsonObject();
        JsonArray array = new JsonArray();
        list.forEach(array::add);
        obj.add("values", array);
        return obj;
    }
}
