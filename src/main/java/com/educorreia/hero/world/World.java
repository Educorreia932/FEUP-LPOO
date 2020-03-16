package com.educorreia.hero.world;

import com.googlecode.lanterna.input.KeyStroke;

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
                        addToX.add(new Tile(x, y, z,".", "#FFFFFF"));

                    else
                        addToX.add(new Tile(Integer.MAX_VALUE, Integer.MAX_VALUE, z, " ", "#000000"));

                addToY.add(addToX);
            }

            elements.add(addToY);
        }

        player = new Player(10, 10, 1);

        setElement(new Item(15, 15, 1, "w", "Sword", "sword.txt"));
        setElement(new Monster(20, 10, 1, "z"));

        createWalls();
    }

    public void step(KeyStroke pressedKey) {
        processInput(pressedKey);

        movePlayer();
    }

    private void movePlayer() {
        Element e = getElement(player.getNextPosition());

        if (!(e.getPosition().equals(player.getNextPosition()) && (e instanceof Wall || e instanceof Monster)))
            player.setPosition(player.getNextPosition());

        if (e.getPosition().equals(player.getNextPosition()) && e instanceof Monster && player.getEquippedWeapon() != null)
            ((Monster) e).takeDamage(player.getEquippedWeapon().getDamage());

        player.setNextPosition(player.getPosition());
    }

    private void createWalls() {
        for (int c = 0; c < width; c++) {
            setElement(new Wall(c, 0, 1));
            setElement(new Wall(c, height - 1, 1));
        }

        for (int r = 1; r < height - 1; r++) {
            setElement(new Wall(0, r, 1));
            setElement(new Wall(width - 1 , r, 1));
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
                        if (getElement(player.getPosition()) instanceof Item) {
                            player.pickupItem((Item) getElement(player.getPosition()));
                            removeElement(player.getPosition());
                        }

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

    private void removeElement(Position position) {
        int x = position.getX();
        int y = position.getY();
        int z = position.getZ();

        elements.get(z).get(y).remove(x);
    }

    private void setElement(Element element) {
        int x = element.getPosition().getX();
        int y = element.getPosition().getY();
        int z = element.getPosition().getZ();

        while (elements.get(z).isEmpty())
            elements.add(new ArrayList<>());

        elements.get(z).get(y).set(x, element);
    }

    public Element getElement(Position position) {
        int x = position.getX();
        int y = position.getY();
        int z = position.getZ();

        return elements.get(z).get(y).get(x);
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
