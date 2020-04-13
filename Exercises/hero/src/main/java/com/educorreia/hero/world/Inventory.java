package com.educorreia.hero.world;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<Item> items;

    Inventory() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
