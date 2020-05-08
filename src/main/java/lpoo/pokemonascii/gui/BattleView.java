package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.data.Player;
import lpoo.pokemonascii.gui.renderers.BackgroundRenderer;
import lpoo.pokemonascii.gui.renderers.menu.BattleMenuRenderer;
import lpoo.pokemonascii.gui.renderers.pokemon.PokemonInfoRenderer;
import lpoo.pokemonascii.gui.renderers.pokemon.PokemonRenderer;
import lpoo.pokemonascii.rules.BattleController;
import lpoo.pokemonascii.rules.commands.ChangedStateCommand;
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.DoNothingCommand;
import lpoo.pokemonascii.rules.commands.QuitCommand;
import lpoo.pokemonascii.rules.commands.optionsmenu.*;
import lpoo.pokemonascii.rules.state.GameState;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class BattleView {
    private Screen screen;
    private TextGraphics graphics;
    private BattleModel battle;
    private BackgroundRenderer background;
    private PokemonRenderer trainerPokemon;
    private PokemonRenderer adversaryPokemon;
    private BattleMenuRenderer battleMenu;
    private PokemonInfoRenderer trainerPokemonInfo;
    private PokemonInfoRenderer adversaryPokemonInfo;

    public BattleView(Screen screen, TextGraphics graphics, BattleModel battle) throws IOException, SAXException, ParserConfigurationException {
        this.screen = screen;
        this.graphics = graphics;
        this.battle = battle;

        background = new BackgroundRenderer("battle_background", new Player());
        battleMenu = new BattleMenuRenderer(battle.getOptions());

        trainerPokemon = new PokemonRenderer(67, 61, battle.getTrainerPokemon());
        adversaryPokemon = new PokemonRenderer(245, 15, battle.getAdversaryPokemon());

        trainerPokemonInfo = new PokemonInfoRenderer(battle.getTrainerPokemon());
        adversaryPokemonInfo = new PokemonInfoRenderer(battle.getAdversaryPokemon());
    }

    public void draw() {
        background.draw(graphics);
        battleMenu.draw(graphics);

        trainerPokemon.draw(graphics);
        adversaryPokemon.draw(graphics);

        trainerPokemonInfo.draw(graphics);
        adversaryPokemonInfo.draw(graphics);

        try {
            screen.refresh();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static KeyStroke getPressedKey(Screen screen) throws IOException {
        KeyStroke key = screen.readInput();

        return key;
    }

    public Command getNextCommand(BattleController battle)  {
        KeyStroke pressedKey = null;

        try {
            pressedKey = getPressedKey(screen);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        switch (pressedKey.getKeyType()) {
            case ArrowUp:
                return new OptionsMenuUpCommand(battle.getOptions());
            case ArrowDown:
                return new OptionsMenuDownCommand(battle.getOptions());
            case ArrowLeft:
                return new OptionsMenuLeftCommand(battle.getOptions());
            case ArrowRight:
                return new OptionsMenuRightCommand(battle.getOptions());
            case Enter:
                return new ChoseOptionCommand(battle);
            case Escape:
                return new OptionsMenuGoBackCommand(battle);
            case EOF:
                return new ChangedStateCommand(battle, GameState.Gamemode.EXIT);
            case Character:
                switch (pressedKey.getCharacter()) {
                    case 'q':
                        return new ChangedStateCommand(battle, GameState.Gamemode.EXIT);
                }
        }

        return new DoNothingCommand();
    }

    public void setOptionsMenuRenderer(BattleController.OptionsMenu optionsMenu) {
        battleMenu.setOptionsMenuRenderer(optionsMenu, battle);
    }
}
