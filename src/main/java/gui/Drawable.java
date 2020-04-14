package gui;

import geometry.Position;
import geometry.Rect;

public class Drawable {
    private Rect box;
    private Image sprite;
    private Position position;

    public Drawable(String sprite_name, int width, int height, int x, int y) {
        this.sprite = new Image(sprite_name);
        box = new Rect(width, height);
        position = new Position(x, y);
    }

    public Image getSprite() {
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
