package game;

import gui.Drawable;
import gui.Image;

public class Player extends Drawable {
    Player(Image sprite) {
        super(sprite, sprite.getWidth(), sprite.getHeight(), 10, 10);
    }

    public void moveUp() {
        this.setPositionByOffset(0, -5);
    }

    public void moveDown() {
        this.setPositionByOffset(0, 5);
    }

    public void moveRight() {
        this.setPositionByOffset(5, 0);
    }

    public void moveLeft() {
        this.setPositionByOffset(-5, 0);
    }
}
