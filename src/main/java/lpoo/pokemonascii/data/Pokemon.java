package lpoo.pokemonascii.data;

import java.io.FileNotFoundException;
import java.util.List;

public class Pokemon {
    private Position position;
    private String name;
    private PokemonStats stats;
    private int experience;
    private PokemonSpecies species;
    private List<PokemonMove> moves;
//    String gender;

    public Pokemon(Integer pokedex_number) throws FileNotFoundException {
        position = new Position(0, 0);
        species = new PokemonSpecies(pokedex_number);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}