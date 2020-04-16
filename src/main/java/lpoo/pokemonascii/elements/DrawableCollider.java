package lpoo.pokemonascii.elements;

import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.geometry.Rect;
import lpoo.pokemonascii.gui.Image;

public abstract class DrawableCollider implements DrawableElement, CollidingElement {
    private Position position;
    private Image image;
    private Rect hitbox;

    public DrawableCollider(String image_name, int x, int y) {
        image = new Image(image_name);
        position = new Position(x, y);
        hitbox = new Rect(image);
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
    public Image getImage() {
        return image;
    }

    @Override
    public Rect getHitbox() {
        return hitbox;
    }
}
