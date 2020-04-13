package com.educorreia.hero.world;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Item extends Element {
    String name;
    ArrayList<String> appearance;

    Item(int x, int y, int z, String character, String name) {
        super(x, y, z, character, "#FFFF00");
        this.name = name;
    }

    Item(int x, int y, int z, String character, String name, String appearanceFile) {
        super(x, y, z, character, "#FFFF00");
        this.name = name;

        try {
            appearance = readItemAppearance(appearanceFile);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ArrayList<String> readItemAppearance(String filename) throws IOException {
        String line;
        ArrayList<String> result = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\skelo\\OneDrive\\Ambiente de Trabalho\\hero\\data\\" + filename));

        while ((line = br.readLine()) != null)
            result.add(line);

        return result;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAppearance() {
        return appearance;
    }
}

