package lpoo.pokemonascii.pokemon;

import lpoo.pokemonascii.elements.DrawableElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.gui.Image;

import java.io.FileNotFoundException;
import java.util.List;

public class Pokemon implements DrawableElement {
    private Position position;
    private String name;
    private int hp,
                attack,
                defense,
                sp_atk,
                sp_def,
                speed;
    private int experience;
    private PokemonSpecies species;
    private List<PokemonMove> moves;
//    String gender;

    public Pokemon(Integer pokedex_number) throws FileNotFoundException {
        species = new PokemonSpecies(pokedex_number);
        position = new Position(36, 43);
    }

    @Override
    public Image getImage() {
        return species.getImage();
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }
}
