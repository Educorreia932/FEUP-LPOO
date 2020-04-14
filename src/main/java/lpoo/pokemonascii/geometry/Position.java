package lpoo.pokemonascii.geometry;

public class Position {
    private int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
}
