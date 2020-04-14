package game;

import geometry.Position;
import gui.Drawable;

public class Map {
    private Drawable background;
    private Player player;

    Map() {
        this.background = new Drawable("room", 0, 0, 0,  0);
        player = new Player("player\\red_front");
    }

    public void movePlayer(Position position) {
        player.setPosition(position);
    }

    public Player getPlayer() {
        return player;
    }

    public Drawable getBackground() {
        return background;
    }
}
