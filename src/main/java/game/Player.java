package game;

import gui.Drawable;
import gui.Image;

public class Player extends Drawable {
    Player(Image sprite) {
        super(sprite, sprite.getWidth(), sprite.getHeight(), 10, 10);
    }

    public void moveRight() {
        int x = getPosition().getX();
        int y = getPosition().getY();

        this.setPosition(x + 5, y);
    }
}
