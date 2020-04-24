package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.pokemon.Pokemon;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BattleModel {
    private Pokemon trainerPokemon;
    private Pokemon adversaryPokemon;

    public BattleModel(int trainer_pokemon_number) throws IOException, SAXException, ParserConfigurationException {
        trainerPokemon = new Pokemon(trainer_pokemon_number, Pokemon.facingDirection.BACK);
        adversaryPokemon = new Pokemon(trainer_pokemon_number, Pokemon.facingDirection.FRONT);
    }

    public Pokemon getTrainerPokemon() {
        return trainerPokemon;
    }

    public Pokemon getAdversaryPokemon() {
        return adversaryPokemon;
    }
}
