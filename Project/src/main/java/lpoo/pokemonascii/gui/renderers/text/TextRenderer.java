package lpoo.pokemonascii.gui.renderers.text;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.renderers.Renderer;

import java.util.ArrayList;
import java.util.List;

public class TextRenderer implements Renderer {
    List<CharRenderer> chars;
    private final Position position;
    private final String fontname;

    public TextRenderer(int x, int y, String text, String fontname) {
        this.position = new Position(x, y);
        this.fontname = fontname;
        chars = new ArrayList<>();
        Position charPosition = position;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            chars.add(new CharRenderer(c, charPosition, fontname));
            charPosition = charPosition.right(chars.get(i).getWidth() + 1);
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        for (CharRenderer charRenderer : chars)
            charRenderer.draw(graphics);
    }

    public void setText(String s) {
        chars = new ArrayList<>();
        Position charPosition = position;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars.add(new CharRenderer(c, charPosition, fontname));
            charPosition = charPosition.right(chars.get(i).getWidth() + 1);
        }
    }

    public void setText(int i) {
        setText(String.valueOf(i));
    }

    public Position getPosition() {
        return position;
    }
}
