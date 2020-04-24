package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
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

    public BattleController(BattleView gui, BattleModel battle) {
        this.gui = gui;
        this.battle = battle;
    }

    public GameController.GameMode start() throws IOException, ParserConfigurationException, SAXException {
        while (true) {
            gui.drawBattle();

            Command command = gui.getNextCommand(this);
            command.execute();

            if (command instanceof QuitCommand)
                return GameController.GameMode.ENDGAME;

            battle.getAdversaryPokemon().takeDamage(1);
        }
    }

    public void usePokemonMove(PokemonMove move) {
        move.execute(battle.getAdversaryPokemon());
    }
}
