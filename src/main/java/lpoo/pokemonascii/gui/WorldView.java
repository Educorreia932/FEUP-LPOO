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
import lpoo.pokemonascii.data.WorldModel;
import lpoo.pokemonascii.gui.commands.*;
import lpoo.pokemonascii.gui.drawers.BackgroundDrawer;
import lpoo.pokemonascii.gui.drawers.PlayerDrawer;
import lpoo.pokemonascii.rules.WorldController;

import java.awt.*;
import java.io.IOException;

public class WorldView {
    private Screen screen;
    private TextGraphics graphics;
    private WorldModel world;
    private BackgroundDrawer backgroundDrawer;
    private PlayerDrawer playerDrawer;

    public WorldView(int width, int height, WorldModel world) throws IOException {
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

        this.world = world;

        backgroundDrawer = new BackgroundDrawer("room");
        playerDrawer = new PlayerDrawer(world.getPlayer());
    }

    public void drawWorld() throws IOException {
        screen.clear();

        backgroundDrawer.draw(graphics);
        playerDrawer.draw(graphics);

        screen.refresh();
    }

    public static KeyStroke getPressedKey(Screen screen) throws IOException {
        KeyStroke key = screen.readInput();

        return key;
    }

    public Command getNextCommand(WorldController world) throws IOException {
        KeyStroke pressedKey = getPressedKey(screen);

        switch (pressedKey.getKeyType()) {
            case ArrowUp:
                return new PlayerMoveUpCommand(world);
            case ArrowDown:
                return new PlayerMoveDownCommand(world);
            case ArrowRight:
                return new PlayerMoveRightCommand(world);
            case ArrowLeft:
                return new PlayerMoveLeftCommand(world);
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
