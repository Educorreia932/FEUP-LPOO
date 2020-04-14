package game;

import gui.Drawable;

public class Player extends Drawable {
    Player(String sprite_name) {
        super(sprite_name, 300, 300, 9, 10);
    }

    public void moveUp() {
        this.setPositionByOffset(0, -4);
    }

    public void moveDown() {
        this.setPositionByOffset(0, 4);
    }

    public void moveRight() {
        this.setPositionByOffset(4, 0);
    }

    public void moveLeft() {
        this.setPositionByOffset(-4, 0);
    }
}
