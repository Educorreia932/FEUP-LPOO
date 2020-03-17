package com.educorreia.hero.world;

public class Weapon extends Item {
    private double damage;

    Weapon(int x, int y, int z, String character, String name, double damage, String appearance) {
        super(x, y, z, character, name, appearance);
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }
}
