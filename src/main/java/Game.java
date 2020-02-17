import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Screen screen;
    private Hero hero;

    public Game() {
        try {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);

            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary

            hero = new Hero(10, 10);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    private void processKey(KeyStroke key) {
        // System.out.println(key);

        // Convert to switch case
        if (key.getKeyType() == KeyType.ArrowLeft)
            hero.moveLeft();

        if (key.getKeyType() == KeyType.ArrowRight)
            hero.moveRight();

        if (key.getKeyType() == KeyType.ArrowUp)
            hero.moveUp();

        if (key.getKeyType() == KeyType.ArrowDown)
            hero.moveDown();
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
