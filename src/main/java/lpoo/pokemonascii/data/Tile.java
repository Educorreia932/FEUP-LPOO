package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.elements.Element;

public class Tile extends Element {
    private State state;

    public enum State {
        STILL
    }

    public Tile(int x, int y) {
        super(x, y);
        state = State.STILL;
    }

    public State getState() {
        return state;
    }
}
