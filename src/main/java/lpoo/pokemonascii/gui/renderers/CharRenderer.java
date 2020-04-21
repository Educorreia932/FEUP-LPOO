package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.Sprite;

public class CharRenderer extends Renderer {
    private Position position;

    public CharRenderer(char c, Position position) {
        this.position = position;
        sprite = new Sprite("font\\" + c);
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(sprite, position, graphics, true);
    }
}
