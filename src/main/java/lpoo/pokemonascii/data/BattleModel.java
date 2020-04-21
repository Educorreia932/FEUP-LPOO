package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.pokemon.Pokemon;

import java.io.FileNotFoundException;

public class BattleModel {
    private Pokemon trainerPokemon;
    private Pokemon adversaryPokemon;

    public BattleModel(int trainer_pokemon_number) throws FileNotFoundException {
        trainerPokemon = new Pokemon(trainer_pokemon_number);
    }

    public Pokemon getTrainerPokemon() {
        return trainerPokemon;
    }
}
