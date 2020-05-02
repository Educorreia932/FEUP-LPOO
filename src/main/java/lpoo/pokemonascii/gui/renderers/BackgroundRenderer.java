package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.gui.Sprite;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;

public class BackgroundRenderer implements Renderer {
    private Sprite backgorund;

    public BackgroundRenderer(String filename) {
        backgorund = new Sprite("background\\" + filename);
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(backgorund, graphics);
    }
}
