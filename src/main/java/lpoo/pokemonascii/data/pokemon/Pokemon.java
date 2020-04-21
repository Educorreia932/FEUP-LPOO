package lpoo.pokemonascii.data.pokemon;

import lpoo.pokemonascii.data.Position;
import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Pokemon {
    public enum facingDirection {
        FRONT,
        BACK
    }

    private Position position;
    private String name;
    private PokemonStats stats;
    private int experience;
    private PokemonSpecies species;
    private List<PokemonMove> moves;
    private facingDirection direction;
//    String gender;

    public Pokemon(Integer pokedex_number, facingDirection direction) throws IOException, SAXException {
        species = new PokemonSpecies(pokedex_number);
        name = species.getName();
        this.direction = direction;

        switch (direction) {
            case FRONT:
                position = new Position(245, 15);
                break;
            case BACK:
                position = new Position(67, 61);
                break;
        }
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public facingDirection getFacingDirection() {
        return direction;
    }

    public int getPokedexNumber() {
        return species.getPokedexNumber();
    }

    public String getName() {
        return name;
    }
}