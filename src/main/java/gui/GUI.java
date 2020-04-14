package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class GUI {
    private final String CHROMA_GREEN = "5f5";
    private Screen screen;
    private TextGraphics graphics;

    public GUI(Screen screen) {
        this.screen = screen;
        graphics = screen.newTextGraphics();
    }

    public void drawSprite(Drawable d) throws IOException {
        String[][] background_colors = d.getSprite().getBackground_colors();
        String[][] foreground_colors = d.getSprite().getForeground_colors();
        String[][] characters = d.getSprite().getCharacters();

        for (int i = 0; i < d.getSprite().getWidth(); i++) {
            for (int j = 0; j < d.getSprite().getHeight(); j++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                try {
                    graphics.putString(i + d.getPosition().getX(), j + d.getPosition().getY(), characters[j][i]);
                }

                catch (Exception ignore) {

                }
            }
        }

    }

    public Screen getScreen() {
        return screen;
    }
}
