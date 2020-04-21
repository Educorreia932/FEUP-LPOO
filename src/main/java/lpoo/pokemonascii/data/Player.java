package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.elements.CollidingElement;
import lpoo.pokemonascii.data.pokemon.Pokemon;

import java.util.List;

public class Player extends CollidingElement {
    private String name;
    private List<Pokemon> pokemons;
    private State state;

    public enum State {
        FRONT,
        BACK,
        RIGHT,
        LEFT,
    }

    public Player() {
        super(100,50, 0,0);
        state = State.FRONT;
    }

    public Position getPosition(Position.Direction direction) {
        switch (direction) {
            case UP:
                return getPosition().up();
            case DOWN:
                return getPosition().down();
            case RIGHT:
                return getPosition().right();
            case LEFT:
                return getPosition().left();
        }

        return getPosition();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}