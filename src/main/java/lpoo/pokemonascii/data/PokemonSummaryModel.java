package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.pokemon.Pokemon;

public class PokemonSummaryModel {
    Pokemon pokemon;

    public PokemonSummaryModel(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
