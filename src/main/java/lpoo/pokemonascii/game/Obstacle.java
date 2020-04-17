package lpoo.pokemonascii.game;

import lpoo.pokemonascii.elements.CollidingElement;
import lpoo.pokemonascii.geometry.Position;

public class Obstacle implements CollidingElement {
    private Position position;
    private Collider collider;

    Obstacle(int x, int y, int width, int height) {
        position = new Position(x, y);
        collider = new Collider(width, height);
    }

    @Override
    public Collider getCollider() {
        return collider;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
