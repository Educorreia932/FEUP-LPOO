package lpoo.pokemonascii.gui.renderers.bar;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.gui.Sprite;
import lpoo.pokemonascii.gui.renderers.Renderer;

import static lpoo.pokemonascii.gui.Sprite.drawSprite;

public abstract class BarRenderer implements Renderer {
    protected Sprite sprite;
    protected Position position;
    protected float percentage;
    protected int barWidth;

    BarRenderer(int x, int y) {
        position = new Position(x, y);
    }

    @Override
    public void draw(TextGraphics graphics) {
        for (int i = 0; i < barWidth * percentage; i++)
            drawSprite(sprite, position.getX() + i, position.getY(), graphics);
    }
}
