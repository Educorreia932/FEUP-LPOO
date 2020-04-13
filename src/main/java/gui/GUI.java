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

    public void drawImage(Image image, int x_offset, int y_offset) throws IOException {
        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                try {
                    graphics.putString(i + x_offset, j + y_offset, characters[j][i]);
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
