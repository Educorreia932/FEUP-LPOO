import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Arena arena;
    TextGraphics graphics;

    public Game() {
        try {
            int width = 30;
            int height = 20;

            Terminal terminal = new DefaultTerminalFactory().createTerminal();

            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            graphics = screen.newTextGraphics();

            graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            arena = new Arena(30, 20, new Hero(10, 10));
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        arena.moveMonsters();
        arena.retrieveCoins();
        arena.draw(graphics);
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        arena.processKey(key);
    }

    private void moveHero(Position position) {
        arena.moveHero(position);
    }

    public void run() throws IOException {
        while (true) {
            draw();

            KeyStroke key = screen.readInput();

            processKey(key);

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q' || arena.verifyMonsterCollisions())
                screen.close();

            if (key.getKeyType() == KeyType.EOF)
                return;
        }
    }
}
