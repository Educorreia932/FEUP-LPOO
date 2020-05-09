package lpoo.pokemonascii.data;

import lpoo.pokemonascii.gui.Image;

import java.util.Objects;

public class Rect {
    private int width, height;
    private Position position;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rect rect = (Rect) o;
        return width == rect.width &&
                height == rect.height;
    }

}
