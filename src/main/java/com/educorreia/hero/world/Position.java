package com.educorreia.hero.world;

public class Position {
    int x, y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Position(Position position) {
        x = position.getX();
        y = position.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    /**
     * @brief Changes the position by an offset both in x and y
     */
    public void changePosition(int x_offset, int y_offset) {
        x += x_offset;
        y += y_offset;
    }

    @Override
    public boolean equals(Object o) {
        Position position = (Position) o;

        return x == position.x && y == position.y;
    }

}
