package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.options.battle.BattleOptionsMenuModel;
import lpoo.pokemonascii.data.options.fight.FightOption;
import lpoo.pokemonascii.data.options.fight.FightOptionsMenuModel;
import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.commands.*;
import lpoo.pokemonascii.rules.state.GameState;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BattleController implements Controller {
    public enum OptionsMenu {
        BATTLE,
        FIGHT
    }

    private BattleView gui;
    private BattleModel battle;
    private OptionsMenuController options;
    private boolean inBattle = true;
    private GameState.Gamemode gamemode;

    public BattleController(BattleView gui, BattleModel battle) {
        this.gui = gui;
        this.battle = battle;
        options = new OptionsMenuController(battle.getOptions());
        gamemode = GameState.Gamemode.BATTLE;
    }

    public BattleController(BattleModel battle) {
        this.battle = battle;
        this.options = new OptionsMenuController(battle.getOptions());
        gamemode = GameState.Gamemode.BATTLE;
    }

    public GameState.Gamemode start(GameState game) {
        while (gamemode == GameState.Gamemode.BATTLE) {
            gui.draw();

            Command command;

            if (battle.getCurrentTurn() == BattleModel.Turn.TRAINER) 
                command = gui.getNextCommand(this);

            else {
                command = new UsePokemonMoveCommand(this, battle.getAdversaryPokemon(), battle.getAdversaryPokemon().getMoves().get(0));
                changeTurn();
            }

            command.execute();

            if (pokemonDied())
                gamemode = GameState.Gamemode.WORLD;
        }

        return gamemode;
    }

    @Override
    public void setGamemode(GameState.Gamemode gamemode) {
        this.gamemode = gamemode;
    }

    public boolean pokemonDied() {
        return battle.getTrainerPokemon().getCurrentHealth() == 0 || battle.getAdversaryPokemon().getCurrentHealth() == 0;
    }

    public void usePokemonMove(Pokemon pokemon, PokemonMove move) {
        if (pokemon.getFacingDirection() == Pokemon.FacingDirection.BACK)
            move.execute(battle.getAdversaryPokemon());

        else if (pokemon.getFacingDirection() == Pokemon.FacingDirection.FRONT)
            move.execute(battle.getTrainerPokemon());
    }

    public OptionsMenuController getOptions() {
        return options;
    }

    public void executeOption(Option selectedOption) throws ParserConfigurationException, SAXException, IOException {
        if (battle.getOptions() instanceof BattleOptionsMenuModel)
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
                    new ChangedStateCommand(this, GameState.Gamemode.WORLD).execute();
                    break;
            }

        else if (battle.getOptions() instanceof FightOptionsMenuModel && !((FightOption) selectedOption).getMove().getName().equals("-")) {
            usePokemonMove(battle.getTrainerPokemon(), ((FightOption) selectedOption).getMove());
            setOptionsMenu();
            changeTurn();
        }
    }

    // TODO: Only working for going back
    public void setOptionsMenu() {
        battle.setOptions(new BattleOptionsMenuModel());
        options.setOptions(battle.getOptions());
        gui.setOptionsMenuRenderer(BattleController.OptionsMenu.BATTLE);
    }

    public void changeTurn() {
        if (battle.getCurrentTurn() == BattleModel.Turn.TRAINER)
            battle.setCurrentTurn(BattleModel.Turn.ADVERSARY);

        else
            battle.setCurrentTurn(BattleModel.Turn.TRAINER);
    }
}
