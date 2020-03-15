package com.educorreia.hero.world;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;

public class World {
    private ArrayList<ArrayList<ArrayList<Element>>> elements;

    private Player player;

    private int width, height;

    public World(int width, int height) {
        this.width = width;
        this.height = height;

        elements = new ArrayList<>();

        for (int z = 0; z < 2; z++) {
            ArrayList<ArrayList<Element>> addToY = new ArrayList<>();

            for (int y = 0; y < height; y++) {
                ArrayList<Element> addToX = new ArrayList<>();

                for (int x = 0; x < width; x++)
                    if (z == 0)
                        addToX.add(new Tile(x, y, ".", "#FFFFFF"));

                    else
                        addToX.add(new Tile(Integer.MAX_VALUE, Integer.MAX_VALUE, " ", "#000000"));

                addToY.add(addToX);
            }

            elements.add(addToY);
        }

        player = new Player(10, 10);

        setElement(new Item(15, 15, "w", "Weapon"), 1);

        createWalls();
    }

    public void step(KeyStroke pressedKey) {
        processInput(pressedKey);

        if (!(getElement(player.getNextPosition(), 1).getPosition().equals(player.getNextPosition()) && getElement(player.getNextPosition(), 1) instanceof Wall))
            player.setPosition(player.getNextPosition());

        player.setNextPosition(player.getPosition());
    }

    private void createWalls() {
        for (int c = 0; c < width; c++) {
            setElement(new Wall(c, 0), 1);
            setElement(new Wall(c, height - 1), 1);
        }

        for (int r = 1; r < height - 1; r++) {
            setElement(new Wall(0, r), 1);
            setElement(new Wall(width - 1, r), 1);
        }
    }

    private void processInput (KeyStroke pressedKey) {
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
            case Character:
                switch (pressedKey.getCharacter()) {
                    case 'g':
                        if (getElement(player.getPosition(), 1) instanceof Item)
                            elements.get(1).get(player.getPosition().getY()).remove(player.getPosition().getX());

                        break;
                }
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

    private void setElement(Element element, int index) {
        int x = element.getPosition().getX();
        int y = element.getPosition().getY();

        while (elements.get(index).isEmpty())
            elements.add(new ArrayList<>());

        elements.get(index).get(y).set(x, element);
    }

    public Element getElement(Position position, int index) {
        int x = position.getX();
        int y = position.getY();

        return elements.get(index).get(y).get(x);
    }

    public List<Element> getAllElements() {
        List<Element> result = new ArrayList<>();

        for (ArrayList<ArrayList<Element>> z : elements)
            for (ArrayList<Element> y : z)
                result.addAll(y);

        result.add(player);

        return result;
    }
}
