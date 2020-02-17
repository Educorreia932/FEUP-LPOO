import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private int x = 10;
    private int y = 10;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() {
        screen.clear();
        screen.setCharacter(x, y, new TextCharacter('X'));

        try {
            screen.refresh();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key) {
        // System.out.println(key);

        // Convert to switch case
        if (key.getKeyType() == KeyType.ArrowLeft)
            x--;

        else if (key.getKeyType() == KeyType.ArrowRight)
            x++;

        else if (key.getKeyType() == KeyType.ArrowUp)
            y--;

        else if (key.getKeyType() == KeyType.ArrowDown)
            y++;
    }

    public void run() throws IOException {
        while (true) {
            draw();

            KeyStroke key = screen.readInput();

            processKey(key);

            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
                screen.close();

            if (key.getKeyType() == KeyType.EOF)
                return;
        }
    }
}
