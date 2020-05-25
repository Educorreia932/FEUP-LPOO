package lpoo.pokemonascii.data;

import lpoo.pokemonascii.data.options.battle.BattleOptionsMenuModel;
import lpoo.pokemonascii.data.options.OptionsMenuModel;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Random;

public class BattleModel {
    public enum Turn {
        TRAINER,
        ADVERSARY
    }

    private Pokemon trainerPokemon;
    private Pokemon adversaryPokemon;
    private OptionsMenuModel options;
    private Turn currentTurn;
    private Player player;

    public BattleModel(Player player, int pokemonNumber) throws IOException, SAXException, ParserConfigurationException {
        this.player = player;
        trainerPokemon = player.getPokemons().get(0);
        trainerPokemon.setDirection(Pokemon.FacingDirection.BACK);

        int level = new Random().nextInt(100) + 1;

        adversaryPokemon = new Pokemon(pokemonNumber, level, Pokemon.FacingDirection.FRONT);
        options = new BattleOptionsMenuModel();

        currentTurn = Turn.TRAINER;
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

    public Turn getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(Turn currentTurn) {
        this.currentTurn = currentTurn;
    }

    public Player getPlayer() {
        return player;
    }
}
