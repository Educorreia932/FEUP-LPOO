package lpoo.pokemonascii.pokemon;

import lpoo.pokemonascii.elements.Drawable;
import lpoo.pokemonascii.gui.Image;

import java.util.List;

public class Pokemon extends Drawable {
    private Image image;
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

    Pokemon(Integer pokedex_number, int x, int y) {
        super("pokemon_back\\" + pokedex_number.toString(), x, y);
    }
}
