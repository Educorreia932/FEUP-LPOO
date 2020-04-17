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

    public static Command getNextCommand(Game game, Screen screen) throws IOException {
        KeyStroke pressedKey = getPressedKey(screen);

        switch (pressedKey.getKeyType()) {
            case ArrowUp:
                return new PlayerMoveUpCommand(game);
            case ArrowDown:
                return new PlayerMoveDownCommand(game);
            case ArrowRight:
                return new PlayerMoveRightCommand(game);
            case ArrowLeft:
                return new PlayerMoveLeftCommand(game);
            case EOF:
                return new QuitCommand(game, screen);
            case Character:
                switch (pressedKey.getCharacter()) {
                    case 'q':
                        return new QuitCommand(game, screen);
                }
        }

        return new DoNothingCommand();
    }
}