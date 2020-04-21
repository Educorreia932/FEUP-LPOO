package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.gui.Sprite;

public class BackgroundRenderer extends Renderer {
    public BackgroundRenderer(String filename) {
        this.sprite = new Sprite("background\\" + filename);
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(sprite, graphics);
    }
}
