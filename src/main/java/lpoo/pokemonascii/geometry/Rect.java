package lpoo.pokemonascii.geometry;

import lpoo.pokemonascii.gui.Image;

public class Rect {
    private int width, height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rect(Image image) {
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public static boolean collides(Position l1, Rect h1, Position l2, Rect h2) {
        Position r1 = new Position(l1.getX() + h1.getWidth(), l1.getY() + h1.getHeight());
        Position r2 = new Position(l2.getX() + h2.getWidth(), l2.getY() + h2.getHeight());

        // If one rectangle is on left side of other
        if (l1.getX() > r2.getX() || l2.getX() > r1.getX())
            return false;

        // If one rectangle is above other
        else if (l1.getY() > r2.getY() || l2.getY() > r1.getY())
            return false;

        return true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
