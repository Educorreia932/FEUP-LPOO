package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.pokemon.Pokemon;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BattleModel {
    private Pokemon trainerPokemon;
    private Pokemon adversaryPokemon;
    private OptionsMenuModel options;

    public BattleModel(int trainer_pokemon_number) throws IOException, SAXException, ParserConfigurationException {
        trainerPokemon = new Pokemon(trainer_pokemon_number, Pokemon.facingDirection.BACK);
        adversaryPokemon = new Pokemon(trainer_pokemon_number, Pokemon.facingDirection.FRONT);

        List<Option> optionList = new ArrayList<>();
        optionList.add(new Option("FIGHT"));
        optionList.add(new Option("BAG"));
        optionList.add(new Option("POKEMON"));
        optionList.add(new Option("RUN"));
        options = new OptionsMenuModel(optionList);
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
}
