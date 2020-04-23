package lpoo.pokemonascii.data;

public class Grass extends Tile{
    private State state;

    public enum State {
        STILL
    }

    public Grass(int x, int y) {
        super(x, y);
        state = State.STILL;
    }

    public State getState() {
        return state;
    }
}
