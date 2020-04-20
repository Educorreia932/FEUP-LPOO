package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Drawer {
    protected final static String CHROMA_GREEN = "#55ff55";
    protected Sprite sprite;

    public abstract void draw(TextGraphics graphics);
}
