package gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class GUI {
    private final String CHROMA_GREEN = "5f5";
    private Screen screen;
    private TextGraphics graphics;

    public GUI(Screen screen) {
        this.screen = screen;
        graphics = screen.newTextGraphics();
    }

    public void drawImage(Image image, int x_offset, int y_offset) {
        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = 0; i < image.getWidth(); i++)
            for (int j = 0; j < image.getHeight(); j++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                try {
                    graphics.putString(i, j, characters[j][i]);
                }

                catch (Exception ignore) {
                }
            }
    }

    public void draw(Integer pokemon) {
//        drawImage("battle", 0, 0);
//        drawImage("pokemon_front\\" + pokemon.toString(), 170, 0);
//        drawImage("pokemon_back\\" + pokemon.toString(), 20, 33);
    }

    public Screen getScreen() {
        return screen;
    }
}
