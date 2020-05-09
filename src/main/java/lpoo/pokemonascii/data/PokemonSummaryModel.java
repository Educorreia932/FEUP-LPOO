package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.rules.state.GameState;

public class PokemonSummaryModel {
    Pokemon pokemon;
    private GameState.Gamemode gamemode;

    public PokemonSummaryModel(Pokemon pokemon) {
        this.pokemon = pokemon;
        pokemon.setDirection(Pokemon.FacingDirection.FRONT);
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
