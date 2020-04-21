package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.TextColor;
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
        Image image = sprite.getCurrentImage();

        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                // Transparency
                if (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN))
                    graphics.putString(i + player.getPosition().getX(), j + player.getPosition().getY(), characters[j][i]);
            }
        }
    }
}
