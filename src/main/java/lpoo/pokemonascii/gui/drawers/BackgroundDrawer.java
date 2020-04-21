package lpoo.pokemonascii.gui.drawers;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.gui.Image;
import lpoo.pokemonascii.gui.Sprite;

public class BackgroundDrawer extends Drawer {
    public BackgroundDrawer() {
        this.sprite = new Sprite("background\\room");
    }

    @Override
    public void draw(TextGraphics graphics) {
        Image image = sprite.getCurrentImage();

        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                // Transparency
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                if (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN))
                    graphics.putString(i, j, characters[j][i]);
            }
        }
    }
}
