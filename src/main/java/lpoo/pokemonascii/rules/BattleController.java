package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.options.BattleOptionsMenuModel;
import lpoo.pokemonascii.data.options.FightOptionsMenuModel;
import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.QuitCommand;
import lpoo.pokemonascii.rules.state.GameState;

import javax.sound.sampled.LineUnavailableException;
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

    public void start(GameState game) throws IOException, LineUnavailableException {
        while (inBattle) {
            gui.drawBattle();

            Command command = gui.getNextCommand(this);
            command.execute();

            if (command instanceof QuitCommand){
                game.setState(null);
                inBattle = false;
            }
        }

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
                battle.setOptions(new FightOptionsMenuModel(battle.getTrainerPokemon()));
                options.setOptions(battle.getOptions());
                gui.setOptionsMenuRenderer(OptionsMenu.FIGHT);
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

    // TODO: Only working for going back
    public void setOptionsMenu() {
        battle.setOptions(new BattleOptionsMenuModel());
        options.setOptions(battle.getOptions());
        gui.setOptionsMenuRenderer(BattleController.OptionsMenu.BATTLE);
    }
}
