package lpoo.pokemonascii.data.options.fight;

import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;

import java.util.ArrayList;
import java.util.List;

public class FightOptionsMenuModel extends OptionsMenuModel {
    public FightOptionsMenuModel(Pokemon pokemon) {
        super(createOptionList(pokemon.getMoves()));
    }

    private static List<Option> createOptionList(List<PokemonMove> moves) {
        List<Option> options = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            try {
                options.add(new FightOption(moves.get(i)));
            }

            catch (IndexOutOfBoundsException e) {
                options.add(new FightOption(new PokemonMove()));
            }
        }

        return options;
    }
}
