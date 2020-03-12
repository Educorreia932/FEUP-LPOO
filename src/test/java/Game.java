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
    private Terminal terminal;
    private Screen screen;
    private World world;
    private TextGraphics graphics;

    private int x = 10;
    private int y = 10;

    public Game() {
        try {
            int width = 30;
            int height = 20;

            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            graphics = screen.newTextGraphics();

            graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
            graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

            world = new World();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) {

    }

    private void draw() throws IOException {
        screen.clear();
        world.draw(graphics);
        screen.refresh();
    }

    public void run() throws IOException {
        while (true) {
            draw();

            KeyStroke key = screen.readInput();

            world.processKey(key);

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                screen.close();

            if (key.getKeyType() == KeyType.EOF)
                return;
        }
    }
}
