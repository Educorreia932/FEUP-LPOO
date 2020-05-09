package lpoo.pokemonascii.data.options.fight;

import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.pokemon.PokemonMove;

public class FightOption implements Option {
    PokemonMove move;

    FightOption(PokemonMove move) {
        this.move = move;
    }

    public PokemonMove getMove() {
        return move;
    }

    @Override
    public String getName() {
        return move.getName().toUpperCase();
    }
}
