package gui;

import game.Position;
import game.Rect;

public class Drawable {
    private Rect box;
    private Image sprite;
    private Position position;

    public Drawable(Image sprite, int width, int height, int x, int y) {
        this.sprite = sprite;
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

    public void setPosition(int x, int y) {
        position.setX(x);
        position.setY(y);
    }

    public void setPositionByOffset(int x_offset, int y_offset) {
        int x = position.getX();
        int y = position.getY();

        setPosition(x + x_offset, y + y_offset);
    }
}
