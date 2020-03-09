import javafx.geometry.Pos;

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

/*    public void setPrevious(Position previous) {
        this.previous = previous;
    }

    public int getgCosts() {
        return 0;
    }

    public int calculategCosts(Position current) {
        return 0;
    }

    public void setgCosts(Position current) {
    }

    public void sethCosts(Position goal) {
    }

    private ArrayList<Position> calcPath(Position start, Position current) {
        ArrayList<Position> totalPath = new ArrayList<>();
        totalPath.add(current);

        return totalPath;
    }

    // https://security-consulting.icu/blog/2012/01/a-star-java/
    // https://en.wikipedia.org/wiki/A*_search_algorithm
    public ArrayList<Position> findPath(Position goal) {
        ArrayList<Position> openList = new ArrayList<>();
        ArrayList<Position> closedList = new ArrayList<>();

        Position start = this;
        openList.add(start); // Add starting node to open list

        Position current;

        while (!openList.isEmpty()) {
            current = lowestFInOpen(); // get node with lowest fCosts from openList
            closedList.add(current); // add current node to closed list
            openList.remove(current); // delete current node from open list

            if ((current.getX() == goal.getX()) && (current.getY() == goal.getY())) // found goal
                return calcPath(start, current);

            // For all adjacent nodes
            ArrayList<Position> adjacentNodes = current.getAdjacent();

            for (Position currentAdj : adjacentNodes) {
                if (!openList.contains(currentAdj)) { // Node is not in openList
                    currentAdj.setPrevious(current); // Set current node as previous for this node
                    currentAdj.sethCosts(goal); // Set h costs of this node (estimated costs to goal)
                    currentAdj.setgCosts(current); // Set g costs of this node (costs from start to this node)
                    openList.add(currentAdj); // Add node to openList
                }

                else // Node is in openList
                    if (currentAdj.getgCosts() > currentAdj.calculategCosts(current)) { // costs from current node are cheaper than previous costs
                        currentAdj.setPrevious(current); // set current node as previous for this node
                        currentAdj.setgCosts(current); // set g costs of this node (costs from start to this node)
                    }

                if (openList.isEmpty()) // No path exists
                    return new ArrayList<>(); // Return empty list
            }
        }

        return null; // Unreachable
    }

    private Position lowestFInOpen() {
        return getPosition(); // TODO: Change
    }

    public double calculateDistance(Position target) {
        return Math.sqrt(Math.pow(x - target.getX(), 2) + Math.sqrt(Math.pow(y - target.getY(), 2)));
    }*/
}
