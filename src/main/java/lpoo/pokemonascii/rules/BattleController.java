package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.Position;
import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.QuitCommand;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BattleController {
    public enum OptionsMenu {
        BATTLE,
        FIGHT
    }

    private BattleView gui;
    private BattleModel battle;
    private OptionsMenuController options;
    private boolean inBattle = true;

    public BattleController(BattleView gui, BattleModel battle) {
        this.gui = gui;
        this.battle = battle;
        this.options = new OptionsMenuController(battle.getOptions());
    }

    public GameController.GameMode start() throws IOException {
        while (inBattle) {
            gui.drawBattle();

            Command command = gui.getNextCommand(this);
            command.execute();

            if (command instanceof QuitCommand)
                return GameController.GameMode.ENDGAME;
        }

        return GameController.GameMode.WORLD;
    }

    public void usePokemonMove(Pokemon pokemon, PokemonMove move) {
        if (pokemon.getFacingDirection() == Pokemon.facingDirection.BACK)
            move.execute(battle.getAdversaryPokemon());

        else if (pokemon.getFacingDirection() == Pokemon.facingDirection.FRONT)
            move.execute(battle.getTrainerPokemon());
    }

    public OptionsMenuController getOptions() {
        return options;
    }

    public void executeOption(Option selectedOption) {
        switch (selectedOption.getName()) {
            case "FIGHT":
                changeBattleOptions(OptionsMenu.FIGHT);

                try {
                   battle.setAdversaryPokemon(new Pokemon(1, Pokemon.facingDirection.BACK));
                }

                catch (IOException | SAXException | ParserConfigurationException e) {
                    e.printStackTrace();
                }

                System.out.println(battle.getAdversaryPokemon().getPokedexNumber());

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

    public void changeBattleOptions(OptionsMenu menu) {
        battle.setOptions(menu);
    }
}
