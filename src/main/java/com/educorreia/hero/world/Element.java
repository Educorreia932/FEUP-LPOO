package com.educorreia.hero.world;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

// Represents an element present in the world
abstract public class Element {
    Position position;
    String character;
    String color = "#FFFFFF";

    Element(int x, int y, String character, String color) {
        position = new Position(x, y);
        this.character = character;
        this.color = color;
    }

    Element(int x, int y, String character) {
        position = new Position(x, y);
        this.character = character;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.ANSI.WHITE);
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), character);
    }

    public Position getPosition() {
        return position;
    }
}
