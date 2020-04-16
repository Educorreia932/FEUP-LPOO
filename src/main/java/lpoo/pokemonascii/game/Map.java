package lpoo.pokemonascii.game;

import lpoo.pokemonascii.elements.DrawableElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.gui.Image;

public class Map {
    private Player player;
    private Image background;

    Map() {
        this.background = new Image("background\\room");
        player = new Player();
    }

    public void movePlayer(Position position) {
        player.setPosition(position);
    }

    public Player getPlayer() {
        return player;
    }

    public Image getBackground() {
        return background;
    }
}
