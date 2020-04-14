package lpoo.pokemonascii.game;

import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.gui.Sprite;

public class Map {
    private Sprite background;
    private Player player;

    Map() {
        this.background = new Sprite("background\\room", 0, 0, 0,  0);
        player = new Player("player\\red_front");
    }

    public void movePlayer(Position position) {
        player.setPosition(position);
    }

    public Player getPlayer() {
        return player;
    }

    public Sprite getBackground() {
        return background;
    }
}
