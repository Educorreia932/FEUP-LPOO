package com.educorreia.hero.world;

import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<Wall> walls;
    private List<Item> items = new ArrayList<>();
    private Player player;

    private int width, height;

    private List<Wall> createWalls() {
        int width = 20;
        int height = 20;

        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    public World(int width, int height) {
        player = new Player(10, 10);
        walls = createWalls();
        items.add(new Item(15, 15, "w"));
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Element> getAllElements() {
        List<Element> elements = new ArrayList<>();

        elements.addAll(walls);
        elements.addAll(items);
        elements.add(player);

        return elements;
    }

    public Player getPlayer() {
        return player;
    }

    public void step(KeyStroke pressedKey) {
        boolean canMove = true;

        switch (pressedKey.getKeyType()) {
            case ArrowUp:
                player.setNextPosition(0, -1);
                break;
            case ArrowDown:
                player.setNextPosition(0, 1);
                break;
            case ArrowRight:
                player.setNextPosition(1, 0);
                break;
            case ArrowLeft:
                player.setNextPosition(-1, 0);
                break;
        }

        for (Wall wall : walls)
            if (wall.getPosition().equals(player.getNextPosition())) {
                canMove = false;
                break;
            }

        if (canMove)
            player.setPosition(player.getNextPosition());

        player.setNextPosition(player.getPosition());
    }
}
