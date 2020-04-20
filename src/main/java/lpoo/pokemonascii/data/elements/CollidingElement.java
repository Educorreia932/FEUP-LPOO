package lpoo.pokemonascii.data.elements;

import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.Rect;

public abstract class CollidingElement extends Element {
    private Rect hitbox;

    public CollidingElement(int x, int y, int width, int height) {
        super(x, y);
        hitbox = new Rect(width, height);
    }

    public boolean collides(Position position, CollidingElement c) {
        Position l1 = this.position; // Upper left corner of this colliding element
        Position l2 = position; // Upper left corner of c
        Position r1 = new Position(l1.getX() + hitbox.getWidth(), l1.getY() + hitbox.getHeight()); // Lower right corner of this colliding element
        Position r2 = new Position(l2.getX() + c.getHitbox().getWidth(), l2.getY() + c.getHitbox().getHeight()); // Lower right corner of c

        // If one rectangle is on left side of other
        if (l1.getX() > r2.getX() || l2.getX() > r1.getX())
            return false;

        // If one rectangle is above other
        else if (l1.getY() > r2.getY() || l2.getY() > r1.getY())
            return false;

        return true;
    }

    public Rect getHitbox() {
        return hitbox;
    }
}