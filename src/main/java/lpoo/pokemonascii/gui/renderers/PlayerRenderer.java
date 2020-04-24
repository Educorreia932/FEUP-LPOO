package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayerRenderer extends Renderer {
    private Player player;

    public PlayerRenderer(Player player) {
        this.player = player;

        Image playerFront = new Image("player\\red_front");
        Image playerBack = new Image("player\\red_back");
        Image playerRight = new Image("player\\red_right");
        Image playerLeft = new Image("player\\red_left");

        sprite = new Sprite(new ArrayList<>(Arrays.asList(playerFront, playerBack, playerRight, playerLeft)));
    }

    public void draw(TextGraphics graphics) {
        sprite.setCurrentImage(player.getState().ordinal());
        drawSprite(sprite, player.getPosition(), graphics, true);
    }
}
