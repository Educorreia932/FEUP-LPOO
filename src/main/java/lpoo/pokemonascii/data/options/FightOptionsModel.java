package lpoo.pokemonascii.data.options;

import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;

import java.util.ArrayList;
import java.util.List;

public class FightOptionsModel extends OptionsMenuModel {
    public FightOptionsModel(Pokemon pokemon) {
        super(createOptionList(pokemon.getMoves()));
    }

    private static List<Option> createOptionList(List<PokemonMove> moves) {
        List<Option> options = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            try {
                options.add(new Option(moves.get(i).getName().toUpperCase()));
            }

            catch (IndexOutOfBoundsException e) {
                options.add(new Option("-"));
            }
        }

        return options;
    }
}
