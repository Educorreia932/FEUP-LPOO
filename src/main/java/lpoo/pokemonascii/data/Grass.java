package lpoo.pokemonascii.data;

import java.util.Random;

public class Grass extends PokemonTile{
    private State state;

    public enum State {
        STILL
    }

    public Grass(int x, int y) {
        super(x, y, 26, 16);
        state = State.STILL;
    }

    public State getState() {
        return state;
    }

}
