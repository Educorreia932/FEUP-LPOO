package lpoo.pokemonascii.geometry;

import lpoo.pokemonascii.gui.Image;

public class Rect {
    private int width, height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Rect(Image image) {
        this.width = image.getWidth();
        this.height = image.getHeight();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
