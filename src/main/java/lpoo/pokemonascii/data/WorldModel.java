package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.elements.CollidingElement;

import java.util.ArrayList;
import java.util.List;

public class WorldModel {
    private Player player;
    private List<CollidingElement> elements;

    public WorldModel() {
        player = new Player();

        elements = new ArrayList<>();
        elements.add(new Obstacle(0, 0, 300, 19));
    }

    public void setPlayerPosition(Position.Direction direction) {
        player.setPosition(player.getPosition(direction));
    }

    // Can Player Move?? Top 10 Questions Science Can't Answer
    public boolean canPlayerMove(Position.Direction direction) {
        Position position = player.getPosition(direction);

        // Check if the player moves off screen borders
        if (position.getX() < 0 || position.getX() > 300 ||
                position.getY() < 0 || position.getY() > 110)
            return false;

        // Check if the player collides with anything
        return getCollidingElement(position) == null;
    }

    public CollidingElement getCollidingElement(Position position) {
        for (CollidingElement c : elements)
            if (c.collides(position, player))
                return c;

        return null;
    }

    public Player getPlayer() {
        return player;
    }
}
