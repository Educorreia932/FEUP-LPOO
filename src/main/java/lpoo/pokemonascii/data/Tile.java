package lpoo.pokemonascii.data;

import javafx.geometry.Pos;
import lpoo.pokemonascii.data.elements.CollidingElement;

public class Tile extends CollidingElement {
    public Tile(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public boolean collides(Position pos, CollidingElement c) {
        return super.collides(pos, c);
    }

    @Override
    public Rect getHitbox() {
        return super.getHitbox();
    }
}
