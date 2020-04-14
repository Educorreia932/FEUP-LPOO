package game;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import gui.Drawable;
import gui.Image;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;

import java.awt.Font;

import java.io.IOException;

import gui.GUI;

public class Game {
    private Screen screen;
    private GUI gui;

    public Game() throws IOException, ParserConfigurationException, SAXException {
        Font font = new Font("Fira Code Light", Font.PLAIN, 6);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);

        Terminal terminal = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(300, 100))
                .setTerminalEmulatorFontConfiguration(cfg)
                .createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        gui = new GUI(screen);
    }

    public void run() throws IOException {
        Player player = new Player("player\\red_front");
        Drawable background = new Drawable("room", 0, 0, 0,  0);

        gui.drawSprite(background);
        screen.refresh();

        while (true) {
            gui.drawSprite(background, player.getPosition(), player.getBox());

            KeyStroke pressedKey = Input.getPressedKey(screen);

            if (pressedKey.getKeyType() == KeyType.Character && pressedKey.getCharacter() == 'q')
                gui.getScreen().close();

            if (pressedKey.getKeyType() == KeyType.EOF)
                return;

            switch (pressedKey.getKeyType()) {
                case ArrowUp:
                    player.moveUp();
                    break;
                case ArrowDown:
                    player.moveDown();
                    break;
                case ArrowRight:
                    player.moveRight();
                    break;
                case ArrowLeft:
                    player.moveLeft();
                    break;
            }

            gui.drawSprite(player);
            screen.refresh();
        }
    }
}
