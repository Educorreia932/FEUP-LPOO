package com.educorreia.hero.world;

public class Player extends Creature {
    Inventory inventory;
    Weapon equippedWeapon;

    Player(int x, int y, int z) {
        super(x, y, z, "@");
        inventory = new Inventory();
    }

    public void pickupItem(Item item) {
        inventory.addItem(item);
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
}
