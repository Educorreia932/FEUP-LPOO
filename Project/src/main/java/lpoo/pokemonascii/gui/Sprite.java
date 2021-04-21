package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.Rect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sprite {
    private final static String CHROMA_GREEN = "#55ff55";

    private final List<Image> images;
    private int current = 0;

    // TODO: Replace for a variadic function
    public Sprite(List<Image> images) {
        this.images = images;
    }

    public Sprite(String filename) {
        Image image = new Image(filename);
        this.images = new ArrayList<>(Collections.singletonList(image));
    }

    public Image getCurrentImage(){
        return images.get(current);
    }

    public void setCurrentImage(int current) {
        this.current = current;
    }

    public int getWidth() {
        return getCurrentImage().getWidth();
    }

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

    public static void drawSpritePortion(Sprite sprite, Position position, Rect portion, Position portionPosition, TextGraphics graphics, boolean transparency) {
        Image image = sprite.getCurrentImage();

        String[][] background_colors = image.getBackground_colors();
        String[][] foreground_colors = image.getForeground_colors();
        String[][] characters = image.getCharacters();

        for (int i = portionPosition.getX(); i < portionPosition.getX() + portion.getWidth(); i++) {
            for (int j = portionPosition.getY(); j < portionPosition.getY() + portion.getHeight(); j++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString(background_colors[j][i]));
                graphics.setForegroundColor(TextColor.Factory.fromString(foreground_colors[j][i]));

                // Transparency
                if (!transparency || (characters[j][i] != null && !background_colors[j][i].equals(CHROMA_GREEN)))
                    graphics.putString(i + position.getX(), j + position.getY(), characters[j][i]);
            }
        }
    }

    public static void drawSprite(Sprite sprite, int x, int y, TextGraphics graphics, boolean transparency) {
        Position position = new Position(x, y);
        drawSprite(sprite, position, graphics, false);
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
