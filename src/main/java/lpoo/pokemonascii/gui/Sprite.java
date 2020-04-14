package lpoo.pokemonascii.gui;

import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.geometry.Rect;

public class Sprite {
    private Rect box;
    private Image sprite;
    private Position position;

    public Sprite(String sprite_name, int width, int height, int x, int y) {
        this.sprite = new Image(sprite_name);
        box = new Rect(width, height);
        position = new Position(x, y);
    }

    public Image getImage() {
        return sprite;
    }

    public Rect getBox() {
        return box;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
