package lpoo.pokemonascii.data.tile;

import lpoo.pokemonascii.data.elements.CollidingElement;

public abstract class Tile extends CollidingElement {
    public Tile(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

}
