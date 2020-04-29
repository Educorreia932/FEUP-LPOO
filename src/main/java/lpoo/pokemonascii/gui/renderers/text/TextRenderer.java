package lpoo.pokemonascii.gui.renderers.text;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.renderers.Renderer;

import java.util.ArrayList;
import java.util.List;

public class TextRenderer extends Renderer {
    List<CharRenderer> chars;
    private Position position;

    public TextRenderer(int x, int y, String s) {
        this.position = new Position(x, y);
        chars = new ArrayList<>();
        Position charPosition = position;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars.add(new CharRenderer(c, charPosition));
            charPosition = charPosition.right(chars.get(i).getWidth() + 1);
        }
    }

    @Override
    public void draw(TextGraphics graphics) {
        for (CharRenderer charRenderer : chars)
            charRenderer.draw(graphics);
    }

    public Position getPosition() {
        return position;
    }
}
