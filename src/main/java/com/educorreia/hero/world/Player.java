package com.educorreia.hero.world;

public class Player extends Creature {
    Inventory inventory;

    Player(int x, int y, int z) {
        super(x, y, z, "@");
        inventory = new Inventory();
    }
}
