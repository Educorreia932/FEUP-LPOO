package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.elements.Collider;
import lpoo.pokemonascii.data.elements.CollidingElement;

public class Obstacle implements CollidingElement {
    private Position position;
    private Collider collider;

    public Obstacle(int x, int y, int width, int height) {
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
