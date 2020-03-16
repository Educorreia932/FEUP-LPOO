package com.educorreia.hero.world;

public class Weapon extends Item {
    private double damage;

    Weapon(int x, int y, int z, String character, String name, double damage) {
        super(x, y, z, character, name);
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }
}
