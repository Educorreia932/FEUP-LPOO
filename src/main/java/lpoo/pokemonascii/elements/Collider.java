package lpoo.pokemonascii.elements;

import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.geometry.Rect;

public abstract class Collider implements CollidingElement {
    private Position position;
    private Rect hitbox;

    public Collider(int x, int y, int width, int height) {
        position = new Position(x, y);
        hitbox = new Rect(width, height);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Rect getHitbox() {
        return hitbox;
    }
}
