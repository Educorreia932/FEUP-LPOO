package com.educorreia.hero.world;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

/**
 * @brief Represents an element present in the world
  */
abstract public class Element {
    private Position position;
    private String character;
    private String color = "#FFFFFF";

    Element(int x, int y, int z, String character, String color) {
        position = new Position(x, y, z);
        this.character = character;
        this.color = color;
    }

    Element(int x, int y, int z, String character) {
        position = new Position(x, y, z);
        this.character = character;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString(color));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), character);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    @Override
    public String toString() {
        return "position=" + position.getX() + ", " + position.getY() +
                ", character='" + character + '\'';
    }
}
