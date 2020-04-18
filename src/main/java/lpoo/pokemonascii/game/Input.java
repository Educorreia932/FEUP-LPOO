package lpoo.pokemonascii.game;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import lpoo.pokemonascii.commands.*;

import java.io.IOException;

public abstract class Input {
    public static KeyStroke getPressedKey(Screen screen) throws IOException {
        KeyStroke key = screen.readInput();

        return key;
    }

    public static Command getNextCommand(Map map, Screen screen) throws IOException {
        KeyStroke pressedKey = getPressedKey(screen);

        switch (pressedKey.getKeyType()) {
            case ArrowUp:
                return new PlayerMoveUpCommand(map);
            case ArrowDown:
                return new PlayerMoveDownCommand(map);
            case ArrowRight:
                return new PlayerMoveRightCommand(map);
            case ArrowLeft:
                return new PlayerMoveLeftCommand(map);
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