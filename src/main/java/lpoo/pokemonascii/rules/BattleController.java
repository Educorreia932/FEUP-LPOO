package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.Option;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.gui.commands.Command;
import lpoo.pokemonascii.gui.commands.QuitCommand;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BattleController {
    private BattleView gui;
    private BattleModel battle;
    private OptionsMenuController options;
    private boolean inBattle = true;

    public BattleController(BattleView gui, BattleModel battle) {
        this.gui = gui;
        this.battle = battle;
        this.options = new OptionsMenuController(battle.getOptions());
    }

    public GameController.GameMode start() throws IOException, ParserConfigurationException, SAXException {
        while (inBattle) {
            gui.drawBattle();

            Command command = gui.getNextCommand(this);
            command.execute();

            if (command instanceof QuitCommand)
                return GameController.GameMode.ENDGAME;
        }

        return GameController.GameMode.WORLD;
    }

    public void usePokemonMove(PokemonMove move) {
        move.execute(battle.getAdversaryPokemon());
    }

    public OptionsMenuController getOptions() {
        return options;
    }

    public void executeOption(Option selectedOption) {
        switch (selectedOption.getName()) {
            case "FIGHT":
                break;
            case "BAG":
                break;
            case "POKEMON":
                break;
            case "RUN":
                inBattle = false;
                break;
        }
    }
}
