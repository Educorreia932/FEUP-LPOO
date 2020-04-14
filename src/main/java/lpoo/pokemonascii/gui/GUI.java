package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
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

    public void drawSprite(Sprite d) {
        String[][] background_colors = d.getImage().getBackground_colors();
        String[][] foreground_colors = d.getImage().getForeground_colors();
        String[][] characters = d.getImage().getCharacters();

        for (int i = 0; i < d.getImage().getWidth(); i++) {
            for (int j = 0; j < d.getImage().getHeight(); j++) {
                // Transparency
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                if (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN))
                    graphics.putString(i + d.getPosition().getX(), j + d.getPosition().getY(), characters[j][i]);
            }
        }
    }

    public void drawSprite(Sprite d, Position position, Rect rect) {
        String[][] background_colors = d.getImage().getBackground_colors();
        String[][] foreground_colors = d.getImage().getForeground_colors();
        String[][] characters = d.getImage().getCharacters();

        for (int i = position.getX(); i < position.getX() + rect.getWidth(); i++) {
            for (int j = position.getY(); j < position.getY() + rect.getHeight(); j++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                if (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN))
                    graphics.putString(i + d.getPosition().getX(), j + d.getPosition().getY(), characters[j][i]);
            }
        }
    }
}
