package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.pokemon.Pokemon;

import java.util.List;

public class PokemonSummaryModel {
    List<Pokemon> pokemons;
    int selectedPokemon;

    public PokemonSummaryModel(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        selectedPokemon = 0;
        pokemons.forEach((pokemon -> pokemon.setDirection(Pokemon.FacingDirection.FRONT)));
    }

    public Pokemon getPokemon() {
        return pokemons.get(selectedPokemon);
    }

    public void setSelectedPokemon(int selectedPokemon) {
        this.selectedPokemon = selectedPokemon;
    }

    public int getSelectedPokemon() {
        return selectedPokemon;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }
}
