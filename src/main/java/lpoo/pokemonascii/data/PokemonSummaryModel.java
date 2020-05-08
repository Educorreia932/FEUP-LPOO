package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.pokemon.Pokemon;

public class PokemonSummaryModel {
    Pokemon pokemon;

    public PokemonSummaryModel(Pokemon pokemon) {
        this.pokemon = pokemon;
        pokemon.setDirection(Pokemon.FacingDirection.FRONT);
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
