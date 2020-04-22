package lpoo.pokemonascii.gui.renderers;

import com.googlecode.lanterna.graphics.TextGraphics;
import lpoo.pokemonascii.data.Position;

public abstract class BarRenderer extends Renderer {
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
