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

    public Position up() {
        return new Position(x, y - 4);
    }

    public Position down() {
        return new Position(x, y + 4);
    }

    public Position right() {
        return new Position(x + 4, y);
    }

    public Position left() {
        return new Position(x - 4, y);
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


