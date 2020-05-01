package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.options.BattleOptionsMenuModel;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BattleModel {
    private Pokemon trainerPokemon;
    private Pokemon adversaryPokemon;
    private OptionsMenuModel options;

    public BattleModel(int trainer_pokemon_number) throws IOException, SAXException, ParserConfigurationException {
        trainerPokemon = new Pokemon(trainer_pokemon_number, Pokemon.facingDirection.BACK);
        adversaryPokemon = new Pokemon(trainer_pokemon_number, Pokemon.facingDirection.FRONT);

        options = new BattleOptionsMenuModel();
    }

    public Pokemon getTrainerPokemon() {
        return trainerPokemon;
    }

    public Pokemon getAdversaryPokemon() {
        return adversaryPokemon;
    }

    public OptionsMenuModel getOptions() {
        return options;
    }

    public void setOptions(OptionsMenuModel options) {
        this.options = options;
    }

    public void setAdversaryPokemon(Pokemon pokemon) {
        adversaryPokemon = pokemon;
    }
}
