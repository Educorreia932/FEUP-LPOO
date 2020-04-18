package lpoo.pokemonascii.pokemon;

import lpoo.pokemonascii.elements.DrawableElement;
import lpoo.pokemonascii.geometry.Position;
import lpoo.pokemonascii.gui.Sprite;

import java.io.FileNotFoundException;
import java.util.List;

public class Pokemon implements DrawableElement {
    private Position position;
    private String name;
    private Sprite sprite;
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
        position = new Position(0, 0);
        species = new PokemonSpecies(pokedex_number);
        sprite = new Sprite("pokemon\\back\\" + pokedex_number);
    }

    @Override
    public Sprite getSprite() {
        return sprite;
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