package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

public abstract class Renderer {
    protected final static String CHROMA_GREEN = "#55ff55";
    protected Sprite sprite;

    public abstract void draw(TextGraphics graphics);

    public static void drawSprite(Sprite sprite, Position position, TextGraphics graphics, boolean transparency) {
        Image image = sprite.getCurrentImage();

        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                // Transparency
                if (!transparency || (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN)))
                    graphics.putString(i + position.getX(), j + position.getY(), characters[j][i]);
            }
        }
    }

    public static void drawSprite(Sprite sprite, int x, int y, TextGraphics graphics) {
        Position position = new Position(x, y);
        drawSprite(sprite, position, graphics, false);
    }

    public static void drawSprite(Sprite sprite, TextGraphics graphics) {
        Position position = new Position(0, 0);
        drawSprite(sprite, position, graphics, false);
    }
}
