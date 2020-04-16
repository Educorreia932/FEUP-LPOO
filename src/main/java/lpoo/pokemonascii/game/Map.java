package lpoo.pokemonascii.game;

import lpoo.pokemonascii.elements.CollidingElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.geometry.Rect;
import lpoo.pokemonascii.gui.Image;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Player player;
    private Image background;
    private List<CollidingElement> elements;

    Map() {
        this.background = new Image("background\\room");
        player = new Player();

        elements = new ArrayList<>();
        elements.add(new Obstacle(0, 0, 300, 19));
    }

    public void movePlayer(Position position) {
        if (canPlayerMove(position))
            player.setPosition(position);
    }

    private boolean canPlayerMove(Position position) {
        // Check if the player moves off screen borders
        if (position.getX() < 0 || position.getX() > 300 ||
            position.getY() < 0 || position.getY() > 110)
            return false;

        // Check if the player collides with anything
        return getCollidingElement(position, elements) == null;
    }

    private CollidingElement getCollidingElement(Position position, List<CollidingElement> elements) {
        for (CollidingElement c : elements)
            if (Rect.collides(position, player.getHitbox(), c.getPosition(), c.getHitbox()))
                return c;

        return null;
    }

    public Player getPlayer() {
        return player;
    }

    public Image getBackground() {
        return background;
    }
}
