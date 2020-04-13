package com.educorreia.hero.world;

public class Wall extends Element {
    public Wall(int x, int y, int z, String character) {
        super(x, y, z, character);
    }

    public Wall(int x, int y, int z) {
        super(x, y, z, "\u2588");
    }
}
