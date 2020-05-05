package lpoo.pokemonascii.rules;

import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.options.battle.BattleOption;
import lpoo.pokemonascii.data.options.battle.BattleOptionsMenuModel;
import lpoo.pokemonascii.data.options.fight.FightOption;
import lpoo.pokemonascii.data.options.fight.FightOptionsMenuModel;
import lpoo.pokemonascii.data.options.Option;
import lpoo.pokemonascii.data.pokemon.Pokemon;
import lpoo.pokemonascii.data.pokemon.PokemonMove;
import lpoo.pokemonascii.gui.BattleView;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.DoNothingCommand;
import lpoo.pokemonascii.rules.commands.QuitCommand;
import lpoo.pokemonascii.rules.commands.UsePokemonMoveCommand;
import lpoo.pokemonascii.rules.state.GameState;
import org.xml.sax.SAXException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

    public BattleController(BattleModel battle) {
        this.battle = battle;
        this.options = new OptionsMenuController(battle.getOptions());
    }

    public GameState.Gamemode start(GameState game) throws IOException, LineUnavailableException, UnsupportedAudioFileException, ParserConfigurationException, SAXException {
        while (inBattle) {
            gui.draw();

            Command command = new DoNothingCommand();

            if (battle.getCurrentTurn() == BattleModel.Turn.TRAINER) {
                try {
                    command = gui.getNextCommand(this);
                }

                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else {
                command = new UsePokemonMoveCommand(this, battle.getAdversaryPokemon(), battle.getAdversaryPokemon().getMoves().get(0));
                changeTurn();
            }

            command.execute();

            if (command instanceof QuitCommand) {
                try {
                    game.setState(null);
                }

                catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
                    e.printStackTrace();
                }

                inBattle = false;
            }

            if (!inBattle || pokemonDied())
                return GameState.Gamemode.WORLD;
        }

        return GameState.Gamemode.EXIT;
    }

    public boolean pokemonDied() {
        return battle.getTrainerPokemon().getCurrentHealth() == 0 || battle.getAdversaryPokemon().getCurrentHealth() == 0;
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
                    inBattle = false;
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
