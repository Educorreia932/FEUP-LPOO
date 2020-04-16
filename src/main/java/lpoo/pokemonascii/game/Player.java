package lpoo.pokemonascii.game;

import lpoo.pokemonascii.elements.CollidingElement;
import lpoo.pokemonascii.elements.DrawableElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.geometry.Rect;
import lpoo.pokemonascii.gui.Image;

public class Player implements CollidingElement, DrawableElement {
    private Position position;
    private Image image;
    private Rect hitbox;

    Player() {
        position = new Position(100, 50);
        image = new Image("player\\red_front");
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
