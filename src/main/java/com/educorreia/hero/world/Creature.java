package com.educorreia.hero.world;

public class Creature extends Element {
    private float health;

    Creature(int x, int y, String character) {
        super(x, y, character);
        health = 100;
    }

    public void move(int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    public float getHealth() {
        return health;
    }
}
