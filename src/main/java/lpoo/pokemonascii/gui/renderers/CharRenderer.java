package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.Sprite;

public class CharRenderer extends Renderer {
    private Position position;

    public CharRenderer(char c, Position position) {
        this.position = position;

        if (Character.isLowerCase(c))
            sprite = new Sprite("font\\lower_case\\" + c);

        else if (Character.isUpperCase(c))
            sprite = new Sprite("font\\upper_case\\" + c);

        else if (Character.isDigit(c))
            sprite = new Sprite("font\\numbers\\" + c);
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(sprite, position, graphics, true);
    }
}
