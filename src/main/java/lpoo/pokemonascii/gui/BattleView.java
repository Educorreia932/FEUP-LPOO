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
import lpoo.pokemonascii.rules.commands.Command;
import lpoo.pokemonascii.rules.commands.DoNothingCommand;
import lpoo.pokemonascii.rules.commands.QuitCommand;
import lpoo.pokemonascii.rules.commands.optionsmenu.*;
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

        trainerPokemon = new PokemonRenderer(battle.getTrainerPokemon());
        adversaryPokemon = new PokemonRenderer(battle.getAdversaryPokemon());

        trainerPokemonInfo = new PokemonInfoRenderer(battle.getTrainerPokemon());
        adversaryPokemonInfo = new PokemonInfoRenderer(battle.getAdversaryPokemon());
    }

    public void draw() throws IOException {
        background.draw(graphics);
        battleMenu.draw(graphics);

        trainerPokemon.draw(graphics);
        adversaryPokemon.draw(graphics);

        trainerPokemonInfo.draw(graphics);
        adversaryPokemonInfo.draw(graphics);

        screen.refresh();
    }

    public static KeyStroke getPressedKey(Screen screen) throws IOException {
        KeyStroke key = screen.readInput();

        return key;
    }

    public Command getNextCommand(BattleController battle) throws IOException {
        KeyStroke pressedKey = getPressedKey(screen);

        switch (pressedKey.getKeyType()) {
            case EOF:
                return new QuitCommand(screen);
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
            case Character:
                switch (pressedKey.getCharacter()) {
                    case 'q':
                        return new QuitCommand(screen);
                }
        }

        return new DoNothingCommand();
    }

    public void setOptionsMenuRenderer(BattleController.OptionsMenu optionsMenu) {
        battleMenu.setOptionsMenuRenderer(optionsMenu, battle);
    }
}
