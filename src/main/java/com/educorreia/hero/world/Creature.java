package com.educorreia.hero.world;

public class Creature extends Element {
    private double health;
    private Position nextPosition;

    Creature(int x, int y, int z, String character) {
        super(x, y, z, character);
        nextPosition = new Position(getPosition());
        health = 100;
    }

    Creature(int x, int y, int z, String character, String color, double health) {
        super(x, y, z, character, color);
        nextPosition = new Position(getPosition());
        this.health = health;
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

    public double getHealth() {
        return health;
    }

    public void takeDamage(double damage) {
        health -= damage;
    }
}
