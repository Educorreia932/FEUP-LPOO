package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.elements.CollidingElement;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Player extends CollidingElement {
    private List<Pokemon> pokemons;
    private State state;

    public static final int X_MOVEMENT = 26;
    public static final int Y_MOVEMENT = 16;

    public enum State {
        FRONT,
        BACK,
        RIGHT,
        LEFT,
    }

    public Player() throws ParserConfigurationException, SAXException, IOException {
        super(111,70, 23,19);
        state = State.FRONT;
        pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(6, 100, Pokemon.FacingDirection.BACK));
        pokemons.add(new Pokemon(25, 100, Pokemon.FacingDirection.BACK));
    }

    public Position getPosition(Position.Direction direction) {
        switch (direction) {
            case UP:
                return getPosition().up(16);
            case DOWN:
                return getPosition().down(16);
            case RIGHT:
                return getPosition().right(26);
            case LEFT:
                return getPosition().left(26);
        }

        return getPosition();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }
}