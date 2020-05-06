package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.Sprite;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;
import static lpoo.pokemonascii.gui.Sprite.drawSpritePortion;

public class BackgroundRenderer implements Renderer {
    private Sprite background;
    private Player player;
    private boolean firstTime;

    public BackgroundRenderer(String filename, Player player) {
        background = new Sprite("background\\" + filename);
        this.player = player;
        this.firstTime = true;
    }

    @Override
    public void draw(TextGraphics graphics) {
        if (firstTime) {
            drawSprite(background, graphics);
            firstTime = false;
        }

        else {
            drawSpritePortion(background, new Position(0, 0), player.getHitbox(), player.getPreviousPosition(), graphics, false);
        }
    }
}
