import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    private Screen screen;
    private TextGraphics graphics;

    public Game() throws IOException {
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);   // we don't need a cursor
        screen.startScreen();             // screens must be started
        screen.doResizeIfNecessary();     // resize screen if necessary

        graphics = screen.newTextGraphics();
    }

    public void run() throws IOException {
        while (true) {
            draw();

            KeyStroke pressedKey = screen.readInput();

            if (pressedKey.getKeyType() == KeyType.EOF)
                return;
        }
    }

    public void draw() throws IOException {
        File myObj = new File("data\\temp.txt");
        Scanner myReader = new Scanner(myObj);

        int i = 5;

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            graphics.putString(5, i, data);
            i++;
        }

        myReader.close();


        screen.refresh();
    }
}
