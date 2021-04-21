package lpoo.pokemonascii.gui.renderers.text;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;

import java.io.File;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;

public class CharRenderer implements Renderer {
    private Position position;
    private Sprite sprite;

    public CharRenderer(char c, Position position, String fontname) {
        this.position = position;

        if (Character.isLowerCase(c))
            sprite = new Sprite("font" + File.separator + fontname + File.separator +
                    "lower_case" + File.separator + c);

        else if (Character.isUpperCase(c))
            sprite = new Sprite("font" + File.separator + fontname + File.separator +
                    "upper_case" + File.separator + c);

        else if (Character.isDigit(c))
            sprite = new Sprite("font" + File.separator + fontname + File.separator +
                    "numbers" + File.separator + c);

        else if (!Character.isAlphabetic(c)) {
            switch (c) {
                case '/' -> sprite = new Sprite("font" + File.separator + fontname + File.separator +
                        "symbols/slash");
                case ' ' -> sprite = new Sprite("font" + File.separator + fontname + File.separator +
                        "symbols/space");
                default -> sprite = new Sprite("font" + File.separator + fontname + File.separator +
                        "symbols" + File.separator + c);
            }
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        drawSprite(sprite, position, graphics, true);
    }

    public int getWidth() {
        return sprite.getWidth();
    }
}
