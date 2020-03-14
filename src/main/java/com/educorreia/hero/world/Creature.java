package com.educorreia.hero.world;

public class Creature extends Element {
    private float health;
    private Position nextPosition;

    Creature(int x, int y, String character) {
        super(x, y, character);
        nextPosition = new Position(getPosition());
        health = 100;
    }

    public void setNextPosition(Position position) {
        nextPosition.setX(position.getX());
        nextPosition.setY(position.getY());
    }

    public void setNextPosition(int x_offset, int y_offset) {
        nextPosition.changePosition(x_offset, y_offset);
    }

    public Position getNextPosition() {
        return nextPosition;
    }

    public float getHealth() {
        return health;
    }
}
