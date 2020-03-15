package com.educorreia.hero.world;

public class Tile extends Element {
    Tile(int x, int y, int z, String character, String color) {
        super(x, y, z, character, color);
    }

    Tile(int x, int y, int z, String character) {
        super(x, y, z, character);
    }
}
