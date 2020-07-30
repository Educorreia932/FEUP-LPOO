package lpoo.pokemonascii.data;

public class Position {
    private int x, y;

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position up(int offset) {
        return new Position(x, y - offset);
    }

    public Position down(int offset) {
        return new Position(x, y + offset);
    }

    public Position right(int offset) {
        return new Position(x + offset, y);
    }

    public Position left(int offset) {
        return new Position(x - offset, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }
}


