package lpoo.pokemonascii.game;

import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.geometry.Rect;
import lpoo.pokemonascii.gui.Image;

public class Collider {
    private Rect hitbox;

    public Collider(int width, int height) {
        hitbox = new Rect(width, height);
    }

    public Collider(Image image) {
        hitbox = new Rect(image);
    }

    public static boolean collides(Position l1, Collider h1, Position l2, Collider h2) {
        Position r1 = new Position(l1.getX() + h1.getHitbox().getWidth(), l1.getY() + h1.getHitbox().getHeight());
        Position r2 = new Position(l2.getX() + h2.getHitbox().getWidth(), l2.getY() + h2.getHitbox().getHeight());

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
