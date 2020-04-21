package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

public class CharRenderer extends Renderer {
    private char c;
    private Position position;

    public CharRenderer(char c, Position position) {
        this.c = c;
        this.position = position;
        sprite = new Sprite("font\\" + c);
    }

    @Override
    public void draw(TextGraphics graphics) {
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
                    graphics.putString(i + position.getX(), j + position.getY(), characters[j][i]);
            }
        }
    }
}
