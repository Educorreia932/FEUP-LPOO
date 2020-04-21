package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.pokemon.Pokemon;
import org.xml.sax.SAXException;

import java.io.IOException;

public class BattleModel {
    private Pokemon trainerPokemon;
    private Pokemon adversaryPokemon;

    public BattleModel(int trainer_pokemon_number) throws IOException, SAXException {
        trainerPokemon = new Pokemon(trainer_pokemon_number, Pokemon.facingDirection.BACK);
    }

    public Pokemon getTrainerPokemon() {
        return trainerPokemon;
    }
}
