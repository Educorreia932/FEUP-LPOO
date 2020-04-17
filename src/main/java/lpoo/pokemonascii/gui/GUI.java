package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.elements.DrawableElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.geometry.Rect;

public class GUI {
    private final String CHROMA_GREEN = "#55ff55";
    private Screen screen;
    private TextGraphics graphics;

    public GUI(Screen screen) {
        this.screen = screen;
        graphics = screen.newTextGraphics();
    }

    public void draw(Image image, Position location, Position portion_position, Rect rect) {
        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = portion_position.getX(); i < portion_position.getX() + rect.getWidth(); i++) {
            for (int j = portion_position.getY(); j < portion_position.getY() + rect.getHeight(); j++) {
                // Transparency
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                if (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN))
                    graphics.putString(i + location.getX(), j + location.getY(), characters[j][i]);
            }
        }
    }

    public void drawElement(DrawableElement d) {
        draw(d.getImage(), d.getPosition(), new Position(0, 0), new Rect(d.getImage()));
    }

    public void drawImage(Image image) {
        draw(image, new Position(0, 0), new Position(0, 0), new Rect(image));
    }

    public void drawImagePortion(Image image, Position position, Rect rect) {
        draw(image, new Position(0, 0), position, rect);
    }
}
