import java.lang.reflect.Array;
import java.util.ArrayList;

public class Position {
    private int x;
    private int y;
    private Position previous;
    private double f, g, h;

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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null)
            return false;

        if (getClass() != o.getClass())
            return false;

        Position p = (Position) o;

        return x == p.getX() && y == p.getY();
    }

    public ArrayList<Position> getAdjacent() {
        ArrayList<Position> adjacent = new ArrayList<>();

        adjacent.add(new Position(x - 1, y + 1)); // Upper left
        adjacent.add(new Position(x, y+ 1)); // Up
        adjacent.add(new Position(x + 1, y + 1)); // Upper right
        adjacent.add(new Position(x - 1, y)); // Left
        adjacent.add(new Position(x + 1, y)); // Right
        adjacent.add(new Position(x - 1, y - 1)); // Lower left
        adjacent.add(new Position(x, y - 1)); // Down
        adjacent.add(new Position(x + 1, y - 1)); // Lower right

        return adjacent;
    }
}
