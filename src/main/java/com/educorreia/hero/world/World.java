package com.educorreia.hero.world;

import com.googlecode.lanterna.graphics.TextGraphics;
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

    public void draw(TextGraphics graphics) {
        for (Wall wall : walls)
            wall.draw(graphics);

        for (Item item : items)
            item.draw(graphics);

        player.draw(graphics);
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                player.move(player.getPosition().getX(), player.getPosition().getY() - 1);
                break;
            case ArrowDown:
                player.move(player.getPosition().getX(), player.getPosition().getY() + 1);
                break;
            case ArrowLeft:
                player.move(player.getPosition().getX() - 1, player.getPosition().getY());
                break;
            case ArrowRight:
                player.move(player.getPosition().getX() + 1, player.getPosition().getY());
                break;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Element> getAllElements() {
        List<Element> elements = new ArrayList<>();

        elements.add(player);
        elements.addAll(walls);
        elements.addAll(items);

        return elements;
    }
}
