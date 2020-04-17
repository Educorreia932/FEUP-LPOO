package lpoo.pokemonascii.commands;
import lpoo.pokemonascii.game.Game;

import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class QuitCommand implements Command {
    private Game game;
    private Screen screen;

    public QuitCommand(Game game, Screen screen) {
        this.game = game;
        this.screen = screen;
    }

    @Override
    public void execute() {
        try {
            screen.close();
            game.stopRunning();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
