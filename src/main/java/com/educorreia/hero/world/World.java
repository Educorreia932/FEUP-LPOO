package com.educorreia.hero.world;

import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class World {
    private ArrayList<ArrayList<Element>> elements;

    private List<Item> items = new ArrayList<>();
    private Player player;

    private int width, height;

    public World(int width, int height) {
        this.width = width;
        this.height = height;

        elements = new ArrayList<>(height);

        for (int i = 0; i < height; i++) {
            ArrayList<Element> toAdd = new ArrayList<>();

            for (int j = 0; j < width; j++)
                toAdd.add(new Tile(j, i, ".", "#000000"));

            elements.add(toAdd);
        }

        player = new Player(10, 10);

        setElement(new Item(15, 15, "w", "Weapon") );

        createWalls();
    }

    public void step(KeyStroke pressedKey) {
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

        if (!(getElement(player.getNextPosition()).getPosition().equals(player.getNextPosition()) && getElement(player.getNextPosition()) instanceof Wall))
            player.setPosition(player.getNextPosition());

        player.setNextPosition(player.getPosition());
    }

    private void createWalls() {
        for (int c = 0; c < width; c++) {
            setElement(new Wall(c, 0));
            setElement(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            setElement(new Wall(0, r));
            setElement(new Wall(width - 1, r));
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    private void setElement(Element element) {
        int x = element.getPosition().getX();
        int y = element.getPosition().getY();

        elements.get(y).set(x, element);
    }

    public Element getElement(Position position) {
        int x = position.getX();
        int y = position.getY();

        return elements.get(y).get(x);
    }

    public List<Element> getAllElements() {
        List<Element> result = new ArrayList<>();

        for (ArrayList<Element> array : elements)
            result.addAll(array);

        result.addAll(items);
        result.add(player);

        return result;
    }
}
