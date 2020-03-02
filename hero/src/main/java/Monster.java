import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import javafx.geometry.Pos;

import java.awt.*;
import java.util.ArrayList;

public class Monster extends Creature {
    Monster(int x, int y, int health) {
        super(x, y, health);
    }

    @Override
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#B22222"));
        graphics.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "m");
    }

    public Position move() {
        return getPosition(); // TODO: Change
    }

    // https://security-consulting.icu/blog/2012/01/a-star-java/
    /*public ArrayList<Position> findPath(int oldX, int oldY, int newX, int newY) {
        ArrayList<Position> openList = new ArrayList<>();
        ArrayList<Position> closedList = new ArrayList<>();
        openList.add(getPosition()); // add starting node to open list

        boolean done = false;
        Position current;

        while (!done) {
            current = lowestFInOpen(); // get node with lowest fCosts from openList
            closedList.add(current); // add current node to closed list
            openList.remove(current); // delete current node from open list

            if ((current.getX() == newX) && (current.getY() == newY)) // found goal
                return calcPath(new Position(oldX, oldY), current);

            // For all adjacent nodes
            ArrayList<Position> adjacentNodes = current.getAdjacent();

            for (int i = 0; i < adjacentNodes.size(); i++) {
                Position currentAdj = adjacentNodes.get(i);

                if (!openList.contains(currentAdj)) { // node is not in openList
                    currentAdj.setPrevious(current); // set current node as previous for this node
                    currentAdj.sethCosts(new Position(newX, newY); // set h costs of this node (estimated costs to goal)
                    currentAdj.setgCosts(current); // set g costs of this node (costs from start to this node)
                    openList.add(currentAdj); // add node to openList
                }

                else { // Node is in openList
                    if (currentAdj.getgCosts() > currentAdj.calculategCosts(current)) { // costs from current node are cheaper than previous costs
                        currentAdj.setPrevious(current); // set current node as previous for this node
                        currentAdj.setgCosts(current); // set g costs of this node (costs from start to this node)
                    }
                }
            }

            if (openList.isEmpty()) // No path exists
                return new ArrayList<>(); // Return empty list
        }
        return null; // Unreachable
    }*/
}
