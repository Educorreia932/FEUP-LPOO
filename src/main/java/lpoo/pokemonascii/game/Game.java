package lpoo.pokemonascii.game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import lpoo.pokemonascii.commands.Command;

import java.awt.Font;

import java.io.IOException;

import lpoo.pokemonascii.commands.QuitCommand;
import lpoo.pokemonascii.gui.GUI;

public class Game {
    private Screen screen;
    private GUI gui;
    private Map map;
    private Battle battle;

    public Game() throws IOException {
        Font font = new Font("Fira Code Light", Font.PLAIN, 6);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);

        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(300, 110))
                .setTerminalEmulatorFontConfiguration(cfg)
                .createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        gui = new GUI(screen);
        map = new Map();
        battle = new Battle(1);
    }

    public void run() throws IOException {
        while (true) {
            gui.drawImage(battle.getBackground());
            gui.drawElement(battle.getTrainerPokemon());
            Command command = Input.getNextCommand(map, screen);

            command.execute();

            if (command instanceof QuitCommand)
                break;

            screen.refresh();
        }
    }
}
