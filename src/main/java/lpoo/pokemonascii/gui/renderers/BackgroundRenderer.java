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
    public boolean firstTime;

    public BackgroundRenderer(String filename, Player player) {
        background = new Sprite("background\\" + filename);
        this.player = player;
        this.firstTime = true;
    }

    public BackgroundRenderer(String filename) {
        background = new Sprite("background\\" + filename);
        this.firstTime = true;
    }

    @Override
    public void draw(TextGraphics graphics) {
        if (firstTime) {
            drawSprite(background, graphics);
            firstTime = false;
        }

        else if (player != null)
            drawSpritePortion(background, new Position(0, 0), player.getHitbox(), player.getPreviousPosition(), graphics, false);
    }
}
