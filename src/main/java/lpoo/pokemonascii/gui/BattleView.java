package lpoo.pokemonascii.gui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import lpoo.pokemonascii.data.BattleModel;
import lpoo.pokemonascii.gui.commands.*;
import lpoo.pokemonascii.gui.renderers.BackgroundRenderer;
import lpoo.pokemonascii.gui.renderers.PokemonRenderer;
import lpoo.pokemonascii.gui.renderers.TextRenderer;
import lpoo.pokemonascii.rules.BattleController;

import java.awt.*;
import java.io.IOException;

public class BattleView {
    private Screen screen;
    private TextGraphics graphics;
    private BattleModel battle;
    private BackgroundRenderer backgroundRenderer;
    private PokemonRenderer pokemonRenderer;
    private TextRenderer pokemonName;

    public BattleView(int width, int height, BattleModel battle) throws IOException {
        Font font = new Font("Fira Code Light", Font.PLAIN, 6);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);

        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(width, height))
                .setTerminalEmulatorFontConfiguration(cfg)
                .createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // We don't need a cursor
        screen.startScreen();             // Screens must be started
        screen.doResizeIfNecessary();     // Resize screen if necessary

        graphics = screen.newTextGraphics();

        this.battle = battle;

        backgroundRenderer = new BackgroundRenderer("battle");
        pokemonRenderer = new PokemonRenderer(battle.getTrainerPokemon());
        pokemonName = new TextRenderer(50, 50, battle.getTrainerPokemon().getName());
    }

    public void drawBattle() throws IOException {
        screen.clear();

        backgroundRenderer.draw(graphics);
        pokemonRenderer.draw(graphics);
        pokemonName.draw(graphics);

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
            case Character:
                switch (pressedKey.getCharacter()) {
                    case 'q':
                        return new QuitCommand(screen);
                }
        }

        return new DoNothingCommand();
    }
}
