package lpoo.pokemonascii.data.options;

import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;

import java.util.ArrayList;
import java.util.List;

public class FightOptionsModel extends OptionsMenuModel {
    public FightOptionsModel(Pokemon pokemon) {
        super(createOptionList(pokemon.getMoves()));
    }

    private static List<Option> createOptionList(List<PokemonMove> pokemonMoves) {
        List<Option> optionList = new ArrayList<>();

        for (PokemonMove move : pokemonMoves) {
            if (move != null)
                optionList.add(new Option(move.getName().toUpperCase()));

            else
                optionList.add(new Option("A")); // TODO: Add - to font
        }

        return optionList;
    }
}
