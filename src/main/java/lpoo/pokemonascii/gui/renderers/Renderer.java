package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.gui.Sprite;

public abstract class Renderer {
    protected final static String CHROMA_GREEN = "#55ff55";
    protected Sprite sprite;

    public abstract void draw(TextGraphics graphics);
}
