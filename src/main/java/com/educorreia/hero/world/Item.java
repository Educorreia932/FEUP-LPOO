package com.educorreia.hero.world;

public class Item extends Element {
    String name;

    Item(int x, int y, String character, String name) {
        super(x, y, character);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
